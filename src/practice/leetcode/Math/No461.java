package practice.leetcode.Math;

public class No461 {
    public static void main(String[] args) {
        Solution461 s = new Solution461();
        s.hammingDistance(1, 5);
    }
}

class Solution461 {

    /**
     * ��Ŀ���������롣��ʵ����ͳ�����������ֶ�Ӧ������λ��ͬ��λ�õ���Ŀ��
     *
     * �ⷨһ���⺯��
     * ����ʱ�䡢�ռ临�Ӷȶ�ΪO(1)
     */
    public int hammingDistance(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    /**
     * �ⷨ������λ����ͳ������1��λ��
     */
/*    public int hammingDistance(int x, int y) {
        int ans = 0;
        int xor = x ^ y;
        while (xor != 0) {
            if ((xor & 1) == 1) {
                ans++;
            }
            xor >>= 1;
        }
        return ans;
    }*/

    /**
     * �ⷨ������������������㷨���㷨�������źܸ߶ˣ�����ʵҲ����һ�д��룺
     * n&(n-1)�����д�����Ƴ�n���ұ�һλ��1
     */
/*    public int hammingDistance(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += 1;
            xor = xor & (xor - 1);
        }
        return distance;
    }*/
}