import kotlin.random.Random

fun main() {
    val n = 2 // ����n�����
    println("���ɵĴ���͸���룺")
    for (i in 1..n) {
        println("��${i}�飺${generateLotteryNumbers(35, 5, 12, 2)}")
    }

    println("\n���ɵ�˫ɫ����룺")
    for (i in 1..n) {
        println("��${i}�飺${generateLotteryNumbers(33, 6, 16, 1)}")
    }
}

/**
 * ����һ�����͸/˫ɫ�����
 * @param totalReds     ��������
 * @param redsToPick    ѡ����������
 * @param totalBlues    ��������
 * @param bluesToPick   ѡ�����������
 */
fun generateLotteryNumbers(totalReds: Int, redsToPick: Int, totalBlues: Int, bluesToPick: Int): String {
    val reds = (1..totalReds).toMutableList()
    val blues = (1..totalBlues).toMutableList()

    val pickedReds = mutableListOf<Int>()
    val pickedBlues = mutableListOf<Int>()

    // ���ѡ�����
    repeat(redsToPick) {
        pickedReds.add(reds.removeAt(Random.nextInt(reds.size)))
    }
    pickedReds.sort()

    // ���ѡ������
    repeat(bluesToPick) {
        pickedBlues.add(blues.removeAt(Random.nextInt(blues.size)))
    }
    pickedBlues.sort()

    // ��ѡ�еĺ���ת��Ϊ�ַ���
    val redsString = pickedReds.joinToString(separator = ", ")
    val bluesString = pickedBlues.joinToString(separator = ", ")

    return "����$redsString ����$bluesString"
}
