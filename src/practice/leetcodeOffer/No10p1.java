package practice.leetcodeOffer;

public class No10p1 {
    public static void main(String[] args) {

    }
}


class Solution10p1 {
    /**
     * 题目：斐波那契数列，F(0) = 0,   F(1) = 1，F(N) = F(N - 1) + F(N - 2), 其中 0<=N<100，
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     */

    /**
     * 解法一：经典递归，超时
     * 时间：O(2^n)，空间：O(1)
     */
/*    public int fib(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else {
            return fib(n - 1) + fib(n - 2);
        }
    }*/

    /**
     * 解法二：动态规划（记忆化递归），使用一个数组来记录之前计算的f(n-1)和f(n-2)
     * 时间，空间：O(n)
     */
    public int fib(int n) {
        int[] dp = new int[n + 1];

        if (n == 0) return 0;
        else if (n == 1) return 1;

        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = (dp[i - 1] + dp[i - 2]) % 1000000007;
        }
        return dp[n];
    }

    /**
     * 解法三：动态规划
     * 时间：O(n)，空间：O(1)
     */
/*    public int fib(int n) {
        int first = 0, second = 1, cur = 0;

        if (n == 0) return 0;
        else if (n == 1) return 1;
        for (int i = 2; i <= n; i++) {
            cur = (first + second) % 1000000007;
            first = second;
            second = cur;
        }
        return cur % 1000000007;
    }*/
}