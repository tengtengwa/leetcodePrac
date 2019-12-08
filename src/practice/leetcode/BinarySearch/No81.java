package practice.leetcode.BinarySearch;

public class No81 {
    public static void main(String[] args) {
        Solution81 s = new Solution81();
        s.search(new int[]{1, 3, 1, 1, 1}, 3);

    }
}

class Solution81 {
    public boolean search(int[] nums, int target) {
        int len = nums.length;
        int left = 0, right = len - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return true;
            }
            if (nums[mid] < nums[right]) {      //ÓÒ°ë²¿·ÖÓÐÐò
                if (target == nums[right]) {
                    return true;
                }
                if (nums[mid] < target && target < nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else if (nums[mid] > nums[right]) {
                if (target == nums[left]) {
                    return true;
                }
                if (nums[left] < target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                right--;
            }
        }
        return false;
    }
}