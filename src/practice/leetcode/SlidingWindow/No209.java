package practice.leetcode.SlidingWindow;

/**
 * 209. 长度最小的子数组
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * 找出该数组中满足其和 ≥ target 的长度最小的连续子数组[numsl, numsl+1, ..., numsr-1, numsr],并返回其长度。
 * 如果不存在符合条件的子数组，返回0
 */
public class No209 {

}

class Solution209 {
    /**
     * 解法一：暴力
     * 枚举所有子数组的组合，判断子数组的和，并求得最小子数组长度。
     * 时间复杂度：O(n^2)；空间复杂度：O(1)
     */

    /**
     * 解法二：滑动窗口
     * 其实也可以理解为双指针。解法就是通过双指针维护一个[l,r]的窗口以及窗口中子数组的和curSum；
     * 当窗口中子数组和小于target时，右指针右移；否则左指针右移，同时更新子数组的最短长度。
     * 时间复杂度：O(n)，空间复杂度：O(1)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, min = Integer.MAX_VALUE, curSum = 0;
        while (r < nums.length) {
            while (curSum < target && r < nums.length) {
                curSum += nums[r++];
            }
            while (curSum >= target && l < r) {
                curSum -= nums[l++];
                min = Math.min(min, r - l + 1);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
