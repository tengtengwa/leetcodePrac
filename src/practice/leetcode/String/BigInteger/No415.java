package practice.leetcode.String.BigInteger;

public class No415 {
    public static void main(String[] args) {
        Solution415 s = new Solution415();
        s.addStrings("12345", "98765");
    }
}

class Solution415 {
    /**
     * 题目：字符串相加，经典大数相加
     * 思路：低位对齐，高位空的补零，从右向左一位一位相加即可
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';   //为空补零，三元运算符防止越界访问
            int y = j < 0 ? 0 : num2.charAt(j) - '0';   //同上
            int sum = (x + y + carry) % 10;
            sb.append(sum);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}