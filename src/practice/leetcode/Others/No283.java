package practice.leetcode.Others;

public class No283 {
    public static void main(String[] args) {

    }
}

class Solution283 {
    /**
     * ��Ŀ���ƶ��㣬������������0�Ƶ�����ĩβ����������Ԫ�����λ�ò���
     *
     * �ⷨһ���½�һ�����飬�ڱ�����������ʱ������Ԫ��һ���������½������У�ʱ�䡢�ռ䣺O(n)
     * �ⷨ����ʹ��һ��ָ��left��¼��ǰ���һ������Ԫ�ص�λ�ã���һ�α���ʱ����һ������Ԫ�ؾͷŵ�left��λ�ò���leftָ����һ��λ�ã�
     * ֮��left���������Ԫ�ض���Ϊ0���ɡ�
     * ʱ�䣺O(n)���ռ䣺O(1)
     */
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[left++] = nums[i];
            }
        }
        for (int j = left; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}