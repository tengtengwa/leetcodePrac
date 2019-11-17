package practice.leetcode;

public class No29 {
    public static void main(String[] args) {
        Solution29 s = new Solution29();
        s.divide(Integer.MIN_VALUE, -1);

    }
}

class Solution29 {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        boolean negative;
        negative = (dividend ^ divisor) < 0;
        //全部取正，方便后续计算
        long t = Math.abs((long) dividend);
        long d = Math.abs((long) divisor);
        int result = 0;
        for (int i = 31; i >= 0; i--) {
            //除数*(2^i)小于等于被除数
            if ((t >> i) >= d) {
                result += 1 << i;       //位移运算：左边的树移位右边数的位数
                t -= d << i;
            }
        }
        return negative ? -result : result;
    }
}