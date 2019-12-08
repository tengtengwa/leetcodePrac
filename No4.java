package practice.leetcode;

import java.util.Arrays;

public class No4 {
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        int[] nums1 = {1, 2};
        int[] nums2 = {3, 4};

        System.out.println(s.findMedianSortedArrays(nums1, nums2));
    }
}

class Solution4 {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int[] nums = Arrays.copyOf(nums1, nums1.length + nums2.length);
        System.arraycopy(nums2, 0, nums, nums1.length, nums2.length);
        Arrays.sort(nums);
        if (nums.length % 2 == 1) {
            return nums[(nums.length - 1) / 2] / 1.0;
        } else {
            return (nums[nums.length / 2] + nums[nums.length / 2 - 1]) / 2.0;
        }
    }
}