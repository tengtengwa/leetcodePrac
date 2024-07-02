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
    //��BindViewע������Ե��ⲿ���� -> ClassDesc
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
     * �ж�Element�Ƿ���Ч������
     *
     * BindViewֻ�ܱ�ע�ֶ�.
     * BindView���ܱ�ע�ӿ��е��ֶ�, ֻ�ܱ�ע���е��ֶ�.
     * BindView���ܱ�ע�������е��ֶ�.
     * BindView���ܱ�ע��private, static����final���ε��ֶ�
     * BindView��ע�ֶ��������������Activity������.
     * BindView��ע���ֶα�����View������
     */
    private fun isValid(element: Element): Boolean {
        if (element !is VariableElement) {
            logError("ֻ�ܱ�ע�ֶ�")
            return false
        }
        val enclosingElement = element.enclosingElement
        if (enclosingElement.kind != ElementKind.CLASS) {
            logError("ֻ�ܱ�ע���е��ֶ�")
            return false
        }
        if (enclosingElement.modifiers.contains(Modifier.ABSTRACT)) {
            logError("���ܱ�ע�������е��ֶ�")
            return false
        }
        val modifiers = element.modifiers
        if (modifiers.contains(Modifier.PRIVATE) || modifiers.contains(Modifier.STATIC) ||
            modifiers.contains(Modifier.FINAL)) {
            logError("����ע�����Բ��ܱ�private��static����final����")
            return false
        }
        if (!isSubType(enclosingElement.asType(), TYPE_ACTIVITY)) {
            logError("${element.simpleName}������Activity������")
            return false
        }
        if (!isSubType(element.asType(), TYPE_VIEW)) {
            logError("����ע�ֶα�����View������")
            return false
        }
        return true
    }

    private fun processAnnotation(element: Element) {
        //VariableElement�����Ի򷽷�������
        val variableElement = element as VariableElement
        //TypeElement�����ӿڵ�����
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
     * ͨ��ȫ·�����жϴ����TypeMirror��������Ƿ���name������
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
        messager.printMessage(Diagnostic.Kind.ERROR, "process annotation error��$msg")
    }

    private fun logNote(msg: String) {
        messager.printMessage(Diagnostic.Kind.NOTE, "logNote��$msg")
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
                //kotlin��$������һ�������������Ҫת��
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
