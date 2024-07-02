package practice.leetcode.DynamicProgramming;

public class No152 {
    public static void main(String[] args) {
        Solution152 s = new Solution152();
        s.maxProduct(new int[]{-2, 0, -3});
    }
}

class Solution152 {
    /**
     * ��Ŀ���˻��������������飬�����п��ܻ���ָ���
     *
     * ��������ʱ���㵱ǰ���ֵ�����ϸ���
     * ��imaxΪ��ǰ���ֵ����ǰ���ֵΪ imax = max(imax * nums[i], nums[i])
     * ���ڴ��ڸ�������ô�ᵼ�����ı���С�ģ���С�ı����ġ���˻���Ҫά����ǰ��Сֵimin��imin = min(imin * nums[i], nums[i])
     * ����������ʱ��imax��imin���н����ٽ�����һ������
     * ʱ�临�Ӷȣ�O(n)���ռ�O(1)
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tem = imax;
                imax = imin;
                imin = tem;
            }
            //ע�⣡���������������ǰԪ�ص������˻�imax * nums[i]��С��imaxȡ�þ��ǵ�ǰԪ��nums[i]��iminҲ�Ƕ�Ӧ��
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }
}