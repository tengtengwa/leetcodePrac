package practice.leetcode.DoublePointer;

public class No75 {
    public static void main(String[] args) {
        Solution75 s = new Solution75();
        s.sortColors(new int[]{1, 2, 0});
    }
}

class Solution75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int L = 0, R = nums.length - 1;
        for (int i = 0; i <= R; i++) {
            if (nums[i] == 0) {
                swap(nums, L, i);
                L++;
            } else if (nums[i] == 2) {
                swap(nums, R, i);
                R--;
                i--;   //��Ϊcurr��ߵ�ֵ�Ѿ�ɨ����ˣ�����currҪ++����ɨ����һλ������p2������ֵ��currδɨ�裬Ҫͣ����ɨ��һ�£�����curr����++��
            }
        }
    }

    private void swap(int[] nums, int l, int i) {
        int tem = nums[l];
        nums[l] = nums[i];
        nums[i] = tem;
    }
}