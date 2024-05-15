package practice.leetcode.DP;

import java.util.Arrays;

public class No213 {
    public static void main(String[] args) {
        Solution213 s = new Solution213();
        s.rob(new int[]{1, 2, 3});
    }
}

/**
 * <a href="https://leetcode.cn/problems/house-robber-ii/">213. 打家劫舍 II</a>
 */
class Solution213 {
    /**
     * 解法：动态规划
     * 根据题意，可以写出转移方程：dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
     * 值得一提的是，这道题目第一个元素和最后一个元素不能同时选择。也就是说，我们需要进行两次dp，两次的索引分别为
     * [0,n-1)和[1,n)，可以通过数组拷贝简化两次遍历的代码。
     * 时间复杂度：O(n)，空间复杂度：O(n)
     */
    public int rob(int[] nums) {
        if (nums.length == 1) return nums[0];
        if (nums.length == 2) return Math.max(nums[0], nums[1]);
        int n = nums.length;
        return Math.max(
                getMax(Arrays.copyOfRange(nums, 0, n - 1)),
                getMax(Arrays.copyOfRange(nums, 1, n)));
    }

    private int getMax(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[n - 1];
    }
}