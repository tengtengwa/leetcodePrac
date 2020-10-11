package practice.leetcode.String.BigInteger;

public class SubStract {
    public static void main(String[] args) {
        SolutionSubStract s = new SolutionSubStract();
        System.out.println(s.subStract("678", "99"));
    }
}

class SolutionSubStract {
    /**
     * ��Ŀ������������������������������
     * ˼·����λ���λ����������һλһλ�ؼ���
     * Ҫע���жϣ�������С�����������С���������൱�ڴ�����С��ǰ��Ӹ�����
     */
    public String subStract(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        //������ж϶���Ϊ����subTract������С
        if (len1 > len2) {
            return subTract(num1, num2);
        } else if (len1 < len2) {
            return "-" + subTract(num2, num1);
        } else {        //������������ͬ
            //String��compareTo������һ��һ���ַ��Ƚϣ������һ����ͬ���ַ��±�Ϊi���򷵻�str1[i]-str2[i]
            int compare = num1.compareTo(num2);
            if (compare == 0) {     //������ȣ���Ϊ��
                return "0";
            } else if (compare > 0) {
                return subTract(num1, num2);
            } else {
                return "-" + subTract(num2, num1);
            }
        }
    }

    private String subTract(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int borrow = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = len1 - 1, j = len2 - 1; i >= 0 || j >= 0; i--, j--) {
            //ÿ�θ���ǰ�Ĳ�Ԥ+10����֤���С�����β�ֵΪ��10+��λ������-��λ����-��һλ��λ�Ľ�λ
            int sub = 10;
            sub += i < 0 ? 0 : num1.charAt(i) - '0';
            sub -= j < 0 ? 0 : num2.charAt(j) - '0';
            sub -= borrow;
            sb.append(sub % 10);
            borrow = (sub / 10 == 0) ? 1 : 0;   //�����ֵС��10��sub/10==0����˵���н�λ������û�н�λ
        }
        sb.reverse();
        while (sb.charAt(0) == '0') {   //������λ���õ�0������999-1000=-0001
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}