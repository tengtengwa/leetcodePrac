package practice.leetcode.offer;

public class T56_1 {
    public static void main(String[] args) {
        SolutionT56_1 s = new SolutionT56_1();
        s.singleNumbers(new int[]{0, 1, 1, 6});
    }
}

class SolutionT56_1 {
    /**
     * 题目：给定一个整形数组，其中除了两个数字外其他的数字都出现了两次，找出这两个只出现一次的数，
     * 要求时间复杂度是O(n)，空间复杂度是O(1)。
     * 题目要求了时间空间复杂度，因此暴力法、哈希表解法直接pass
     * <p>
     * 解法：位运算
     * 思路：先对数组中所有数进行异或运算，最终的结果就是这两个只出现一次的数的异或；
     * 接着通过diff &= -diff找出这两个数最后不同的一位（其实就是两个数与运算后最低位的1），通过这一位就可以区分出这两个出现一次的数了
     * 再有，下面这种方法也可以找出这两个数最后不同的一位mask
     * int mask=1;
     * while((k & mask) == 0) { //k为所有元素的异或
     *     mask <<= 1;
     * }
     */
    public int[] singleNumbers(int[] nums) {
        int diff = 0;
        int[] ans = new int[2];

        for (int num : nums) {
            diff ^= num;
        }
        //k&=-k可以找出这两个出现一次的数最后不同的一位
        //例如num1:1111，num2:1001，mask=num1^num2:0110，mask&=-mask：0110&=1010（负数通过补码运算）=0010
        diff &= -diff;
        for (int num : nums) {
            //下面使用^=，出现两次的数相当于没有进行过异或；而出现一次的数通过判断最后不同的一位加入了不同的索引中。
            if ((diff & num) == 0) {    //这有个小坑，==优先级比&高，所以这里两个数与运算必须带括号
                ans[0] ^= num;
            } else {
                ans[1] ^= num;
            }
        }
        return ans;
    }
}