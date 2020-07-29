package practice.leetcode.Math;

public class No136 {
    public static void main(String[] args) {
        Solution136 s = new Solution136();
        s.singleNumber(new int[]{1, 2, 3, 2, 3});
    }
}

class Solution136 {
    /**
     * ��Ŀ����������ֻ����һ�ε�Ԫ��
     * �ⷨһ������˫ѭ����O(n^2)
     * �ⷨ����ʹ��һ��set��������ų��ֹ�һ�ε�Ԫ�أ�����һ�����飬����set��û�е�Ԫ�ؾͼ���set������ɾ��set����Ӧ��Ԫ�أ�
     * ���ʣ��һ��Ԫ�ؾ���ֻ����һ�ε�Ԫ��
     *
     * �ⷨ����λ����
     * һ�α�����������Ԫ�ؽ���������㣬��Ϊ�����������ʣ�
     * 1.�����ɣ�a ^ b ^ c <=> a ^ c ^ b
     * 2.�κ�����0���Ϊ�κ��� 0 ^ n => n
     * 3.��ͬ�������Ϊ0: n ^ n => 0
     * ��Ϊֻ��һ��Ԫ�س��ֹ�һ�Σ��������г������ε�Ԫ��������ض�Ϊ0���������Ԫ�����Ľ�������Ǹ����ֹ�һ�ε�Ԫ��
     */
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}