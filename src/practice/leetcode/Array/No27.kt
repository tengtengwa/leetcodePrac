package practice.leetcode.Array

/**
 * 27、移除元素
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
fun main() {

}

class Solution {
    /**
     * 解法一：双指针
     * 左指针指向左边第一个元素，右指针遍历一次数组，当遇到不等于val的元素时，将右指针位置的元素赋值到左指针位置
     * 的元素，因为题目要求只需要把没有删除的元素放到左边即可，因此这里可以直接覆盖而不用管被删除的元素。
     * 时间复杂度：（n）
     * 空间：（1）
     */
//    fun removeElement(nums: IntArray, `val`: Int): Int {
//        var res = 0
//        var i = 0
//        nums.forEach {
//            if (it != `val`) {
//                nums[i++] = it
//                res++
//            }
//        }
//        return res
//    }

    /**
     * 解法二：优化的双指针
     * 解法一在数组中没有val时，左右指针都遍历了一次数组。这个解法中，左右指针加起来遍历了一遍数组，但复杂度不变
     */
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var i = 0
        var j = nums.size   //这里必须从size索引开始，否则[1],1这个case无法处理
        while (i < j) {
            if (nums[i] == `val`) {
                nums[i] = nums[--j]
            } else {
                i++
            }
        }
        return i
    }
}