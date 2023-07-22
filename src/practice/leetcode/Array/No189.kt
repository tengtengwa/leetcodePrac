package practice.leetcode.Array;

/**
 * 189. 轮转数组
 * 给定一个整数数组 nums，将数组中的元素向右轮转 k 个位置，其中 k 是非负数。
 */
fun main() {
    val s = Solution189()
    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    s.rotate(arr, 3)
    arr.forEach {
        print("$it ")
    }
}

class Solution189 {
    /**
     * 解法一：借助新数组
     * 遍历一遍原数组，计算出每个元素移动后的索引，将其放入新数组。完成后将结果拷贝回原数组即可
     * 时间：O(n)
     * 空间：O(n)
     */
//    fun rotate(nums: IntArray, k: Int): Unit {
//        val res = IntArray(nums.size)
//        nums.forEachIndexed { i, it ->
//            val index = (i + k) % nums.size
//            res[index] = it
//        }
//        nums.forEachIndexed { i, _ ->
//            nums[i] = res[i]
//        }
//    }

    /**
     * 解法二：三次翻转
     * [1,2,3,4,5,6,7] k=3， [5,6,7,1,2,3,4]
     * 通过观察数组翻转前后的结果，我们发现，只要将翻转后的[0, (k%n)-1]和[k%n, n-1]的
     * 两个子数组分别翻转一次，就得到了原数组的翻转数组，接着将整个数组翻转一次即可。
     * 时间：O(n)
     * 空间：O(1)
     */
//    fun rotate(nums: IntArray, k: Int): Unit {
//        val n = nums.size
//        reverseArray(nums, 0, n - 1)
//        reverseArray(nums, 0, (k % n) - 1)
//        reverseArray(nums, k % n, nums.size - 1)
//    }
//
//    private fun reverseArray(arr: IntArray, l: Int, r: Int) {
//        var start = l
//        var end = r
//        while (start < end) {
//            val tem: Int = arr[start]
//            arr[start++] = arr[end]
//            arr[end--] = tem
//        }
//    }

    /**
     * 解法三：环状替换
     * 在解法一的基础上做了改进，不再使用O(n)的空间。方法一中使用额外数组的原因在于：如果我们直接将每个数字放至
     * 它最后的位置，这样被放置位置的元素会被覆盖从而丢失。
     * 我们使用一个tem变量储存上一次移动到最终位置后的元素。但当我们返回初始位置0的时候，可能还有一部分元素
     * 没有遍历到，此时需要从下一个位置的数继续以k step遍历更新元素位置。
     * 计从某个索引开始，以k step遍历数组直到返回初始索引一次为1圈，则我们需要进行上述过程gcd(n,k)圈，
     * n为数组长度，gcd为两数的最大公约数
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    fun rotate(nums: IntArray, k: Int): Unit {
        val count = gcd(nums.size, k)
        val n = nums.size
        for (i in 0 until count) {
            var cur = i
            var pre = nums[cur]
            do {
                val next = (cur + k) % n
                //注意，这里要交换上一次记录的元素pre和下一个位置的元素nums[next]
                val tem = nums[next]
                nums[next] = pre
                pre = tem
                cur = next
            } while (cur != i)
        }
    }

    private fun gcd(x: Int, y: Int): Int {
        return if (y > 0) gcd(y, x % y) else x
    }
}