package practice.leetcode.Math;

public class No461 {
    public static void main(String[] args) {
        Solution461 s = new Solution461();
        s.hammingDistance(1, 5);
    }
}

class Solution461 {

    /**
     * 题目：汉明距离。其实就是统计这两个数字对应二进制位不同的位置的数目。
     *
     * 解法一：库函数
     * 下面时间、空间复杂度都为O(1)
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * 解法二：移位运算统计异或后1的位数
     */
/*    public int hammingDistance(int x, int y) {
        int ans = 0;
        int xor = x ^ y;
        while (xor != 0) {
            if ((xor & 1) == 1) {
                ans++;
            }
            xor >>= 1;
        }
        return ans;
    }*/

    /**
     * 解法三：布赖恩·克尼根算法。算法名字听着很高端，但其实也就是一行代码：
     * n&(n-1)，这行代码会移除n最右边一位的1
     */
/*    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += 1;
            xor = xor & (xor - 1);
        }
        return distance;
    }*/
}