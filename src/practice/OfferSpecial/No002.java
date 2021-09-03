package practice.OfferSpecial;

public class No002 {
    public static void main(String[] args) {
        Solution002 s = new Solution002();
        String ans = s.addBinary("1010", "1011");
        System.out.println(ans);
    }
}

/**
 * 题目：二进制加法
 * 给定两个 01 字符串 a 和 b ，请计算它们的和，并以二进制字符串的形式输出。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 */
class Solution002 {
    /**
     * 思路：在遍历的过程中，通过减法把字符转换成整数后，就转变成大数相加的思路。最后把整数反转后再转换成字符串即可
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public String addBinary(String a, String b) {
        //从左到右，index从0依次增大；因此如果想从最右边的最低位开始两数相加，就需要注意这里两个数的起始下标
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();     //这里也可以使用一个char数组，最后转成String类型后调用subString方法即可

        while (i >= 0 || j >= 0) {
            int curA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int curB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = curA + curB + carry;
            carry = sum >= 2 ? 1 : 0;
            sb.append(sum & 1);     //sum % n 等价于 sum & (n-1)，位运算替代取模提高效率
        }
        //注意处理最后一个进位
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}