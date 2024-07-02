package apt

import com.squareup.javapoet.ClassName
import com.squareup.javapoet.JavaFile
import com.squareup.javapoet.MethodSpec
import com.squareup.javapoet.TypeName
import com.squareup.javapoet.TypeSpec
import java.io.IOException
import javax.annotation.processing.*
import javax.lang.model.SourceVersion
import javax.lang.model.element.*
import javax.lang.model.type.TypeMirror
import javax.lang.model.util.Elements
import javax.lang.model.util.Types
import javax.tools.Diagnostic

class TTBindingProcessor : AbstractProcessor() {
    private lateinit var filer: Filer
    private lateinit var elements: Elements
    private lateinit var types: Types
    private lateinit var messager: Messager
    //被BindView注解的属性的外部类名 -> ClassDesc
    private val cache = mutableMapOf<String, ClassDesc>()

    companion object {
        const val TYPE_ACTIVITY = "apt.Activity"
        const val TYPE_VIEW = "apt.View"
    }

    override fun init(processingEnv: ProcessingEnvironment) {
        super.init(processingEnv)
        processingEnv.let {
            filer = it.filer
            elements = it.elementUtils
            types = it.typeUtils
            messager = it.messager
        }
    }

    override fun getSupportedAnnotationTypes(): MutableSet<String> {
        return mutableSetOf(BindView::javaClass.name)
    }

    override fun getSupportedSourceVersion(): SourceVersion {
        return SourceVersion.latestSupported()
    }

    override fun process(annotations: MutableSet<out TypeElement>, roundEnv: RoundEnvironment): Boolean {
        logNote("process start")
        roundEnv.getElementsAnnotatedWith(BindView::class.java).forEach {
            if (!isValid(it)) {
                return true
            }
            processAnnotation(it)
        }
        logNote("process end")
        generateFileAndCode()
        return true
    }

    /**
     * 判断Element是否有效，规则：
     *
     * BindView只能标注字段.
     * BindView不能标注接口中的字段, 只能标注类中的字段.
     * BindView不能标注抽象类中的字段.
     * BindView不能标注被private, static或者final修饰的字段
     * BindView标注字段所属的类必须是Activity的子类.
     * BindView标注的字段必须是View的子类
     */
    private fun isValid(element: Element): Boolean {
        if (element !is VariableElement) {
            logError("只能标注字段")
            return false
        }
        val enclosingElement = element.enclosingElement
        if (enclosingElement.kind != ElementKind.CLASS) {
            logError("只能标注类中的字段")
            return false
        }
        if (enclosingElement.modifiers.contains(Modifier.ABSTRACT)) {
            logError("不能标注抽象类中的字段")
            return false
        }
        val modifiers = element.modifiers
        if (modifiers.contains(Modifier.PRIVATE) || modifiers.contains(Modifier.STATIC) ||
            modifiers.contains(Modifier.FINAL)) {
            logError("被标注的属性不能被private、static或者final修饰")
            return false
        }
        if (!isSubType(enclosingElement.asType(), TYPE_ACTIVITY)) {
            logError("${element.simpleName}必须是Activity的子类")
            return false
        }
        if (!isSubType(element.asType(), TYPE_VIEW)) {
            logError("被标注字段必须是View的子类")
            return false
        }
        return true
    }

    private fun processAnnotation(element: Element) {
        //VariableElement是属性或方法的描述
        val variableElement = element as VariableElement
        //TypeElement是类或接口的描述
        val enclosingElement = variableElement.enclosingElement as TypeElement
        val className = enclosingElement.qualifiedName.toString()
        val pkgName = elements.getPackageOf(element)?.toString() ?: ""
        val classDesc = cache[className]

        classDesc?.addField(FieldDesc(variableElement)) ?:
        cache.put(className, ClassDesc(pkgName, className, enclosingElement))
    }

    private fun generateFileAndCode() {
        try {
            cache.values.forEach {
                it.generateCode().writeTo(filer)
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }
    }

    /**
     * 通过全路径名判断传入的TypeMirror代表的类是否是name的子类
     */
    private fun isSubType(tm: TypeMirror?, name: String): Boolean {
        var isSubType = false
        var curTm = tm
        while (curTm != null) {
            if (tm.toString() == name) {
                isSubType = true
                break
            } else {
                val superElement = (types.asElement(tm) as? TypeElement) ?: break
                curTm = superElement.superclass
            }
        }
        return isSubType
    }

    private fun logError(msg: String) {
        messager.printMessage(Diagnostic.Kind.ERROR, "process annotation error：$msg")
    }

    private fun logNote(msg: String) {
        messager.printMessage(Diagnostic.Kind.NOTE, "logNote：$msg")
    }

    class ClassDesc(private val pkgName: String, private val className: String,
                    private val typeElement: TypeElement) {

        private val fieldList = mutableListOf<FieldDesc>()

        fun addField(fieldDesc: FieldDesc) {
            fieldList.add(fieldDesc)
        }

        fun generateCode(): JavaFile {
            val clsName = "${className}\$ViewBinding"
            val methodSpecBuilder = MethodSpec.constructorBuilder()
                .addModifiers(Modifier.PUBLIC)
                .addParameter(TypeName.get(typeElement.asType()), "activity")
                .addParameter(ClassName.get(View::class.java), "view")
                .beginControlFlow("if (activity == null)")
                .addStatement("return")
                .endControlFlow()
            fieldList.forEach {
                //kotlin的$符号是一个运算符，这里要转义
                methodSpecBuilder.addStatement("activity.\$N = view.findViewById(\$L)", it.fieldName, it.id)
            }
            val typeSpec = TypeSpec.classBuilder(clsName)
                .addModifiers(Modifier.PUBLIC)
                .addMethod(methodSpecBuilder.build())
                .build()
            return JavaFile.builder(pkgName, typeSpec).build()
        }
    }

    class FieldDesc(variableElement: VariableElement) {
        var id: Int = variableElement.getAnnotation(BindView::class.java).id
        var fieldName: String = variableElement.simpleName.toString()
    }
}
