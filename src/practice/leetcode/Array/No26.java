package practice.leetcode.Array;

/**
 * 26、删除有序数组中的重复项
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。
 * 元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 */
public class No26 {
    public static void main(String[] args) {

    }
}

/**
 * 解法：双指针
 * 前指针指向当前需要填的不重复数字的索引，后指针遍历数组，寻找下一个不重复数字。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 */
class Solution26 {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0, res = 0;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
                continue;
            }
            nums[++i] = nums[j++];
            res++;
        }
        return res + 1;
    }
}