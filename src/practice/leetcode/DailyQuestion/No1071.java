package practice.leetcode.DailyQuestion;

public class No1071 {
    public static void main(String[] args) {
        Solution1071 s = new Solution1071();
        System.out.println(s.gcdOfStrings("ABCABC", "ABC"));
    }
}

class Solution1071 {
    public String gcdOfStrings(String str1, String str2) {
        //��� str1 �� str2 ƴ�Ӻ���� str2�� str1 ƴ���������ַ�����ע��ƴ��˳��ͬ������ôһ�����ڷ����������ַ��� X�����򲻴���
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str2.substring(0, gcd(str1.length(), str2.length()));
    }

    //gcd�����Լ����ע�����д������Ҫ�ǻ�
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}