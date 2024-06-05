import kotlin.random.Random

fun main() {
    val n = 2 // 生成n组号码
    println("生成的大乐透号码：")
    for (i in 1..n) {
        println("第${i}组：${generateLotteryNumbers(35, 5, 12, 2)}")
    }

    println("\n生成的双色球号码：")
    for (i in 1..n) {
        println("第${i}组：${generateLotteryNumbers(33, 6, 16, 1)}")
    }
}

/**
 * 生成一组大乐透/双色球号码
 * @param totalReds     红球总数
 * @param redsToPick    选择红球的数量
 * @param totalBlues    蓝球总数
 * @param bluesToPick   选择蓝球的数量
 */
fun generateLotteryNumbers(totalReds: Int, redsToPick: Int, totalBlues: Int, bluesToPick: Int): String {
    val reds = (1..totalReds).toMutableList()
    val blues = (1..totalBlues).toMutableList()

    val pickedReds = mutableListOf<Int>()
    val pickedBlues = mutableListOf<Int>()

    // 随机选择红球
    repeat(redsToPick) {
        pickedReds.add(reds.removeAt(Random.nextInt(reds.size)))
    }
    pickedReds.sort()

    // 随机选择蓝球
    repeat(bluesToPick) {
        pickedBlues.add(blues.removeAt(Random.nextInt(blues.size)))
    }
    pickedBlues.sort()

    // 将选中的号码转换为字符串
    val redsString = pickedReds.joinToString(separator = ", ")
    val bluesString = pickedBlues.joinToString(separator = ", ")

    return "红球：$redsString 蓝球：$bluesString"
}
