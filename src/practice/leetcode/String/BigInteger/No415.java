package practice.leetcode.String.BigInteger;

public class No415 {
    public static void main(String[] args) {
        Solution415 s = new Solution415();
        s.addStrings("12345", "98765");
    }
}

class Solution415 {
    /**
     * ��Ŀ���ַ�����ӣ�����������
     * ˼·����λ���룬��λ�յĲ��㣬��������һλһλ��Ӽ���
     */
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';   //Ϊ�ղ��㣬��Ԫ�������ֹԽ�����
            int y = j < 0 ? 0 : num2.charAt(j) - '0';   //ͬ��
            int sum = (x + y + carry) % 10;
            sb.append(sum);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }
}