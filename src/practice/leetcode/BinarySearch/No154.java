package practice.leetcode.BinarySearch;

public class No154 {
}

/**
 * 思路与153类似，只是mid和right索引对应元素相等的一种情况
 */

class Solution154 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else if (nums[mid] < nums[right]) {
                right = mid;
            } else {
                right--;
            }
        }
        return nums[left];
    }
}