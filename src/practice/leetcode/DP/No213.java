package practice.leetcode.DP;

import java.util.Arrays;

public class No213 {
    public static void main(String[] args) {
        Solution213 s = new Solution213();
        s.rob(new int[]{1, 2, 3});
    }
}

/**
 * <a href="https://leetcode.cn/problems/house-robber-ii/">213. ��ҽ��� II</a>
 */
class Solution213 {
    /**
     * �ⷨ����̬�滮
     * �������⣬����д��ת�Ʒ��̣�dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
     * ֵ��һ����ǣ������Ŀ��һ��Ԫ�غ����һ��Ԫ�ز���ͬʱѡ��Ҳ����˵��������Ҫ��������dp�����ε������ֱ�Ϊ
     * [0,n-1)��[1,n)������ͨ�����鿽�������α����Ĵ��롣
     * ʱ�临�Ӷȣ�O(n)���ռ临�Ӷȣ�O(n)
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