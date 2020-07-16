package practice.leetcode.Math;

public class No55 {
    public static void main(String[] args) {
        Solution55 s = new Solution55();
        s.canJump(new int[]{2, 4, 2, 1, 0, 2, 0});

    }
}

class Solution55 {

    /**
     * ��һ��̰��
     * ����ʱÿ�θ�����ĳ������λ�ÿ��Ե�������ұߵ�λ�ã�����������λ�ÿ��Ե���򳬹����һ��Ԫ�ص�������Ϊtrue�����Ե��
     * ���򣬵�����������λ��ʱ����false
     * ʱ�䣺O(n)���ռ䣺O(1)
     */
    public boolean canJump(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, nums[i] + i);   //��ǰλ��i���ϵ�ǰ���ߵ���������ǿ��Ե�������ұߵ�����
            }
            if (rightMost >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}











