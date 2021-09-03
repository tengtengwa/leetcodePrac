package OfferSpecial;

public class No001 {
    public static void main(String[] args) {
        Solution001 s = new Solution001();
        int ans = s.divide(-12 ,2);
        System.out.println(ans);
    }
}

/**
 * ��Ŀ����������
 * ������������ a �� b �������ǵĳ������� a/b ��Ҫ�󲻵�ʹ�ó˺� '*'������ '/' �Լ�������� '%' ��
 */
class Solution001 {
    /**
     * λ����ⷨ
     * ˼·���ȶ�����ȡ����ֵ������ͨ��λ�����2^31����2^0��ѭ�������Ϳ�������̵ľ���ֵ�����ͨ���������ķ�����ȷ���̵ķ��š�
     *
     * ʱ�临�Ӷȣ�O(n)
     * �ռ䣺O(1)
     */
    public int divide(int a, int b) {
        if (a == 0) return 0;
        if (b == 1) return a;
        if (a == Integer.MIN_VALUE && b == -1) return Integer.MAX_VALUE;
        //Math.abs(-2147483648)�Ľ������-2147483648�����ͨ�������ķ�ʽ��ȡ�����ͱ������ľ���ֵ����long�������洢���
        long absA = a == Integer.MIN_VALUE ? 2147483648L : Math.abs(a);
        long absB = b == Integer.MIN_VALUE ? 2147483648L : Math.abs(b);
        int ans = 0;    //��
        for (int i = 31; i >= 0; i--) {   //����λռһλ�����ͷ�Χ��-2^31 ~ 2^31-1������ñ�������2^31��ʼ��
            if (absA >> i >= absB) {      //�������ľ���ֵ����2��i�η������С�ڳ����ľ���ֵ��˵�����������������2��i�η�
                ans += 1 << i;
                absA -= absB << i;
            }
        }
        //��ansһ���ǷǸ���������ͨ���������ͳ�������������жϷ��������С��0˵����ţ�����Ǹ��ģ������-ans����С��0˵��ͬ�ţ���������ġ�
        return (a ^ b) < 0 ? -ans : ans;
    }
}