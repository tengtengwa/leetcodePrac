package practice.OfferSpecial;

import java.util.Arrays;

public class No003 {
    public static void main(String[] args) {
        Solution003 s = new Solution003();
        String ansStr = Arrays.toString(s.countBits(6));
        System.out.println(ansStr);
    }
}

/**
 * 题目：前 n 个数字二进制中 1 的个数
 * 给定一个非负整数 n ，请计算 0 到 n 之间的每个数字的二进制表示中 1 的个数，并输出一个数组。
 */
class Solution003 {
    /**
     * 解法：根据奇偶数性质
     * 一个奇数n和n/2两个数二进制中1的个数的关系：n中1的个数 = n/2中1的个数+1；
     * 一个偶数n和n/2两个数二进制中1的个数的关系：n中1的个数 = n/2中1的个数；
     *
     * 时间复杂度：O(n)；空间复杂度：O(1)（不包含输出数组）
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if ((i & 1) == 0) {
                ans[i] = ans[i >> 1];
            } else {
                ans[i] = ans[i >> 1] + 1;
            }
        }
        return ans;
    }
}