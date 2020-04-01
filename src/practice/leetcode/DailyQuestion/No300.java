package practice.leetcode.DailyQuestion;

public class No300 {
    public static void main(String[] args) {
        Solution300 s = new Solution300();
        s.lengthOfLIS(new int[]{4, 3, 2, 1});
    }
}

class Solution300 {

    //动态规划，状态转移公式：dp[i] = Max(dp[j])+1，(0=<j<i,num[i]>num[j])
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len == 0 || len == 1) {
            return len;
        }
        int ans = 0;
        int[] dp = new int[len];
        dp[0] = 1;
        for (int i = 1; i < len; i++) {
            int n = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    n = Math.max(n, dp[j]);
                }
            }
            dp[i] = n + 1;
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}