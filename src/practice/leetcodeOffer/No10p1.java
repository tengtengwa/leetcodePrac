package practice.leetcodeOffer;

public class No10p1 {
    public static void main(String[] args) {

    }
}


class Solution10p1 {
    /**
     * ��Ŀ��쳲��������У�F(0) = 0,   F(1) = 1��F(N) = F(N - 1) + F(N - 2), ���� 0<=N<100��
     * ����Ҫȡģ 1e9+7��1000000007����������ʼ���Ϊ��1000000008���뷵�� 1��
     */

    /**
     * �ⷨһ������ݹ飬��ʱ
     * ʱ�䣺O(2^n)���ռ䣺O(1)
     */
/*    public int fib(int n) {
        if (n == 0) return 0;
        else if (n == 1) return 1;
        else {
            return fib(n - 1) + fib(n - 2);
        }
    }*/

    /**
     * �ⷨ������̬�滮�����仯�ݹ飩��ʹ��һ����������¼֮ǰ�����f(n-1)��f(n-2)
     * ʱ�䣬�ռ䣺O(n)
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
     * �ⷨ������̬�滮
     * ʱ�䣺O(n)���ռ䣺O(1)
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