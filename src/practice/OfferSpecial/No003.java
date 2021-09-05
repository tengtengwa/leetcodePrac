package practice.OfferSpecial;

import java.util.Arrays;

public class No003 {
    public static void main(String[] args) {
        Solution003 s = new Solution003();
        String ansStr = Arrays.toString(s.countBits(6));
        System.out.println(ansStr);
    }
}

/**
 * ��Ŀ��ǰ n �����ֶ������� 1 �ĸ���
 * ����һ���Ǹ����� n ������� 0 �� n ֮���ÿ�����ֵĶ����Ʊ�ʾ�� 1 �ĸ����������һ�����顣
 */
class Solution003 {
    /**
     * �ⷨ��������ż������
     * һ������n��n/2��������������1�ĸ����Ĺ�ϵ��n��1�ĸ��� = n/2��1�ĸ���+1��
     * һ��ż��n��n/2��������������1�ĸ����Ĺ�ϵ��n��1�ĸ��� = n/2��1�ĸ�����
     *
     * ʱ�临�Ӷȣ�O(n)���ռ临�Ӷȣ�O(1)��������������飩
     */
    public int[] countBits(int n) {
        int[] ans = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            if ((i & 1) == 0) {
                ans[i] = ans[i >> 1];
            } else {
                ans[i] = ans[i >> 1] + 1;
            }
        }
        return ans;
    }
}