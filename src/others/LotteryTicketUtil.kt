package others

import kotlin.random.Random

fun main() {
    val util = LotteryTicketUtil()
    util.generateShuangSeQiuList(2)
    util.generateDaLeTouStr(2)
    println("祝阁下每次买彩票都喜提一等奖~")
}

/**
 * 彩票相关工具类，用于随机生成n组大乐透/双色球号码
 * 祝你喜提一等奖~
 */
class LotteryTicketUtil {
    /**
     * 随机生成n组大乐透号码
     */
    fun generateDaLeTouStr(groupNum: Int) {
        println("generate DaLeTou list for you~")
        for (i in 0 until groupNum) {
            generateDaLeTouStr()
        }
    }

    private fun generateDaLeTouStr() {
        val blueSet = mutableSetOf<Int>()
        val orangeSet = mutableSetOf<Int>()

        while (blueSet.size < 5) {
            val num = Random.nextInt(1, 35)
            blueSet.add(num)
        }
        while (orangeSet.size < 2) {
            val num = Random.nextInt(1, 12)
            orangeSet.add(num)
        }

        printByOrder(blueSet, orangeSet)
    }

    fun generateShuangSeQiuList(groupNum: Int) {
        println("generate ShuangSeQiu list for you~")
        for (i in 0 until groupNum) {
            generateShuangSeQiuList()
        }
    }

    private fun generateShuangSeQiuList() {
        val redSet = mutableSetOf<Int>()
        val blueSet = mutableSetOf<Int>()

        while (redSet.size < 6) {
            val num = Random.nextInt(1, 33)
            redSet.add(num)
        }
        while (blueSet.size < 1) {
            val num = Random.nextInt(1, 16)
            blueSet.add(num)
        }

        printByOrder(redSet, blueSet)
    }

    private fun printByOrder(mainSet: MutableSet<Int>, subSet: MutableSet<Int>) {
        val mainList = mainSet.sorted()
        val subList = subSet.sorted()

        println("main list: $mainList;  sub list: $subList")
    }
}