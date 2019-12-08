package practice.leetcode.Math;

public class No31 {
    public static void main(String[] args) {
        Solution31 s = new Solution31();
        s.nextPermutation(new int[]{1, 2, 3});

    }
}

class Solution31 {
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = i + 1;
            while (j < nums.length - 1 && nums[j + 1] > nums[i]) {
                j++;
            }
            swap(nums, i, j);
        }
        reverse(nums, i + 1);
    }

    private void reverse(int[] nums, int start) {
        int i = start, j = nums.length - 1;
        while (i < j) {
            swap(nums, i, j);
            i++;
            j--;
        }
    }

    private void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }
}