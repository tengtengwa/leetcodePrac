package practice.leetcode.String.BigInteger;

public class No43 {
    public static void main(String[] args) {
        Solution43 s = new Solution43();
        s.multiply("123", "456");
    }
}

class Solution43 {
    /**
     * ��Ŀ���ַ�����ˣ�����������
     * ������⣺https://leetcode-cn.com/problems/multiply-strings/solution/you-hua-ban-shu-shi-da-bai-994-by-breezean/
     *
     * �ⷨһ����ͨ��ʽ�����ڶ����ַ�����ÿһλ�ֱ����һ���ַ������˷�������Щ��ȫ����Ӽ�Ϊ���ս�������˴�����ӣ��������Ҳ�͸Ҹҵ���
     */
/*    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {     //��0ֱ�ӷ���0
            return "0";
        }
        String ans = "";
        int carry = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder tem = new StringBuilder();        //tem�洢��ǰһ�γ˻��Ľ��
            //ע�ⲹ��
            for (int k = 0; k < num2.length() - 1 - i; k++) {
                tem.append('0');
            }
            int y = num2.charAt(i) - '0';       //char������תΪintҪ��ȥ�ַ�'0'
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {    //��ѭ���ǵð����Ľ�λ����
                int x = j < 0 ? 0 : num1.charAt(j) - '0';
                int sum = (x * y + carry) % 10;
                tem.append(sum);
                carry = (x * y + carry) / 10;
            }
            ans = addString(ans, tem.reverse().toString());     //��ǰһ�γ˻��Ľ���Ƿ���
        }
        return ans;
    }

    private String addString(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';   //����ע��char������תΪint��д��
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            sb.append(sum);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }*/

    /**
     * �ⷨ�����Ż���ʽ
     * ���㷨��ͨ���������ʱ������ĳλ�뱻����ĳλ��ˣ�����������λ�õĹ�������ɡ�Ҳ����ֱ�ӽ�ÿ�εĽ���ݴ浽�����У�����
     * ͨ����Ӧλ�õ����͹��ɼ�������
     * ���� num1 λ��ΪM�������� num2 λ��ΪN�� num1 x num2 ��� res �����λ��Ϊ M+N
     * num1[i] x num2[j] �Ľ��Ϊ tmp(λ��Ϊ��λ��"0x","xy"����ʽ)�����һλλ�� res[i+j]���ڶ�λλ�� res[i+j+1]��
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {     //��0ֱ�ӷ���0
            return "0";
        }
        int[] ans = new int[num1.length() + num2.length()];
        for (int i = num2.length() - 1; i >= 0; i--) {
            int x = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int y = num1.charAt(j) - '0';
                int sum = ans[i + j + 1] + x * y;
                ans[i + j + 1] = sum % 10;  //�����λ
                ans[i + j] += sum / 10;     //��λ��Ҫ����λ����ȥ��ע�������+=
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            if (i == 0 && ans[i] == 0) {    //���˵���һλ��0������10*10=[0100]
                continue;
            }
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}








