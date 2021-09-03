package OfferSpecial;

public class No001 {
    public static void main(String[] args) {
        Solution001 s = new Solution001();
        int ans = s.divide(-12 ,2);
        System.out.println(ans);
    }
}

/**
 * 题目：整数除法
 * 给定两个整数 a 和 b ，求它们的除法的商 a/b ，要求不得使用乘号 '*'、除号 '/' 以及求余符号 '%' 。
 */
class Solution001 {
    /**
     * 位运算解法
     * 思路：先对两数取绝对值，接着通过位运算从2^31除到2^0，循环结束就可以算出商的绝对值，最后通过两个数的符号来确定商的符号。
     *
     * 时间复杂度：O(n)
     * 空间：O(1)
     */
    public int divide(int a, int b) {
        if (a == 0) return 0;
        if (b == 1) return a;
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
        //Math.abs(-2147483648)的结果还是-2147483648，因此通过这样的方式来取除数和被除数的绝对值，用long类型来存储结果
        long absA = a == Integer.MIN_VALUE ? 2147483648L : Math.abs(a);
        long absB = b == Integer.MIN_VALUE ? 2147483648L : Math.abs(b);
        int ans = 0;    //商
        for (int i = 31; i >= 0; i--) {   //符号位占一位，整型范围：-2^31 ~ 2^31-1，因此让被除数从2^31开始除
            if (absA >> i >= absB) {      //被除数的绝对值除以2的i次方如果不小于除数的绝对值，说明被除数最大能整除2的i次方
                ans += 1 << i;
                absA -= absB << i;
            }
        }
        //商ans一定是非负数，这里通过被除数和除数的异或结果来判断符号情况：小于0说明异号，结果是负的，因此是-ans；不小于0说明同号，结果是正的。
        return (a ^ b) < 0 ? -ans : ans;
    }
}