package practice.OfferSpecial;

public class No002 {
    public static void main(String[] args) {
        Solution002 s = new Solution002();
        String ans = s.addBinary("1010", "1011");
        System.out.println(ans);
    }
}

/**
 * ��Ŀ�������Ƽӷ�
 * �������� 01 �ַ��� a �� b ����������ǵĺͣ����Զ������ַ�������ʽ�����
 * ����Ϊ �ǿ� �ַ�����ֻ�������� 1 �� 0��
 */
class Solution002 {
    /**
     * ˼·���ڱ����Ĺ����У�ͨ���������ַ�ת���������󣬾�ת��ɴ�����ӵ�˼·������������ת����ת�����ַ�������
     *
     * ʱ�临�Ӷȣ�O(n)
     * �ռ临�Ӷȣ�O(1)
     */
    public String addBinary(String a, String b) {
        //�����ң�index��0��������������������ұߵ����λ��ʼ������ӣ�����Ҫע����������������ʼ�±�
        int i = a.length() - 1;
        int j = b.length() - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();     //����Ҳ����ʹ��һ��char���飬���ת��String���ͺ����subString��������

        while (i >= 0 || j >= 0) {
            int curA = i >= 0 ? a.charAt(i--) - '0' : 0;
            int curB = j >= 0 ? b.charAt(j--) - '0' : 0;
            int sum = curA + curB + carry;
            carry = sum >= 2 ? 1 : 0;
            sb.append(sum & 1);     //sum % n �ȼ��� sum & (n-1)��λ�������ȡģ���Ч��
        }
        //ע�⴦�����һ����λ
        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
}