package practice.leetcode.BinarySearch;

public class No154 {
}

/**
 * ˼·��153���ƣ�ֻ��mid��right������ӦԪ����ȵ�һ�����
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