package practice.leetcode.DynamicProgramming;

public class No70 {
    public static void main(String[] args) {
        Solution70 s = new Solution70();
        s.climbStairs(5);

    }
}

class Solution70 {
/*    public int climbStairs(int n) {
        int[] arr = new int[n + 1];
        return climb(0, n, arr);
    }

    private int climb(int i, int n, int[] arr) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        arr[i] = climb(i + 1, n, arr) + climb(i + 2, n, arr);
        return arr[i];
    }*/

    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}