package practice.leetcode.offer;

public class T10 {
    public static void main(String[] args) {
        SolutionT10 s = new SolutionT10();
        s.NumberOf1(11);
    }
}

class SolutionT10 {
    public int NumberOf1(int n) {
        int num = 0;
        if (n == 0) return 0;
        else {
            while (n != 0) {
                num++;
                n = n & (n - 1);    //这个位运算会将最低位的1变为0
            }
        }
        return num;
    }
}

/**
 * 相关题目：
 * 1、用一条语句判断一个整数是不是2的整数次方。
 *
 * 一个整数如果是2的整数次方，那么它的二进制表示有且只有一位是1，而其他所有位都是0。
 * 根据前面的分析，使用上面的与运算 n=n&(n-1)，这个整数中唯一的1就会变成0；
 *
 * 2、输入两个整数m和n,计算需要改变m的二进制表示中的多少位才能得到n。比如10的二进制表示为1010，13的二进制为1101，
 * 需要改变1010中的3位才能得到1101。
 *
 * 我们可以求这两个数的异或，再统计异或结果中1的个数
 *
 */