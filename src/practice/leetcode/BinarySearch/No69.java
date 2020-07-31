package practice.leetcode.BinarySearch;

public class No69 {
    public static void main(String[] args) {
        Solution69 s = new Solution69();
        s.mySqrt(5);
    }
}

class Solution69 {
    /**
     * 题目：求一个非负整数x的平方根，不能使用库函数sqrt
     * 解法一：数学方法进行换底，使用其他数学函数
     * x^(1/2) = (e^lnx)^(1/2) = e^(1/2lnx)，这样就可以使用exp和log方法来计算了（log函数仅能计算以e为底的对数）
     *
     * 而指数函数和对数函数的参数和返回值均为浮点数，因此运算过程中会存在误差。例如当 x = 2147395600时，e^(1/2lnx)
     * 的计算结果与正确值 46340相差 10^(-11)，这样在对结果取整数部分时，会得到 46339这个错误的结果。
     *
     * 时间、空间近似为O(1)
     */
/*    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;   //验证是否有误差
    }*/

    /**
     * 解法二：二分查找
     * 思路：因为x的平方根的整数部分ans是满足k^2<=x的最大k值，因此可以使用二分查找来在0~max(k)之间不断选择中间点，向max(k)
     * “无限”靠拢，最终求得ans
     * 时间：O(logx)，空间O(1)
     */
    public int mySqrt(int x) {
        int L = 0, R = x, ans = -1;
        while (L <= R) {                    //注意！条件必须是L<=R，
            int mid = L + (R - L) / 2;      //注意，这里是R-L，即当前范围[L,R]的一半，所以L加上(R - L) / 2
            if ((long) mid * mid <= x) {    //这里最好将mid的平方转为long，否则可能会整型溢出
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }
}