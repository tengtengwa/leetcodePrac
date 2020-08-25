package practice.leetcode.Math;

public class No338 {
    public static void main(String[] args) {
        Solution338 s = new Solution338();
        s.countBits(9);
    }
}

class Solution338 {
    /**
     * 题目：比特位计数，
     * 给定一个非负整数 num。对于 [0,num]范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。
     *
     * 解法一：pop count，我这个解法和官方解法一思路相同，都是依靠一个位运算：n&(n-1)。这个位运算会将n的最低位的1变成0，
     * 这样就可以统计n中1的个数了
     *
     * 时间：O(nk)，这里的k应该代表每个整数x中1的位数；空间：O(n)，一个输出数组
     */
/*    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int n = 0;
            int tem = i;
            while (tem > 0) {
                tem = tem & (tem - 1);
                n++;
            }
            ans[i] = n;
        }
        return ans;
    }*/

    /**
     * 解法二：dp+最低有效位
     * <p>
     * 观察x和 x'=x/2的关系：
     * x = (1001011101)2 =(605)10
     * x′= (100101110)2  =(302)10
     * 可以发现x'与x只有一位不同，这是因为x'可以看做x移除最低有效位的结果。这样，我们就有了下面的状态转移函数：
     * P(x)=P(x/2)+(x mod 2)    P(x)表示x中1的位数
     *
     * 时间、空间：O(n)
     */
/*    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            //如果一个数x%2==1，表明这个数最低位一定是1(2^0)，因为其他较高的位都表示2^1以上。
            // 因此可以使用x&1来判断x的最低位是否是1，也就是说 x&1 <==> x%2
            ans[i] = ans[i >> 1] + (i & 1);     //当前数字i中1的位数为i/2中1的位数+x&1
        return ans;
    }*/

    /**
     * 解法三：dp+最后设置位
     * 思路：和解法一思想类似，状态转移方程：P(x) = P(x&(x-1)) + 1
     * 从dp数组中寻找 [i&(i-1)] 这个数中1的位数，因为它和i中1的位数相差了1，所以给前者+1就是dp[i]
     *
     * 时间、空间：O(n)
     * 方法一中每个数需要通过位运算循环计算1的位数，而这个解法直接从dp数组中寻找
     */
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }
}