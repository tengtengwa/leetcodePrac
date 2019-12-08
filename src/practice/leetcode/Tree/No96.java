package practice.leetcode.Tree;

public class No96 {
    public static void main(String[] args) {
        Solution96 s = new Solution96();
        s.numTrees(5);
    }
}

class Solution96 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];
    }
}