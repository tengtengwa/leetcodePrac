package designPattern

/**
 * Builder模式
 * 创建型设计模式之一，可以将复杂对象的构建和它的部件解耦，也就是将配置对象的相关方法全部抽提到Builder类中。
 * 优点：
 * 良好的封装性，能使调用者不必知道产品类内部具体的细节；
 * 建造者独立，容易进行扩展
 * 缺点：
 * 需要创建多余的Builder对象，占用更多内存
 */

class OKClients(
        private val dns: String,
        private val interpreters: List<String>
) {

    constructor(builder: Builder) : this(
            builder.dns,
            builder.interpreters)

    class Builder {
        var dns: String = ""
            private set
        val interpreters: ArrayList<String> = ArrayList()

        fun setDNS(dns: String) = apply {
            this.dns = dns
        }

        fun addInterpreters(interpreter: String) = apply {
            this.interpreters.add(interpreter)
        }
    }
}

fun main() {
    val client = OKClient.Builder()
            .setDNS("666")
            .interpreters.add("666")
}