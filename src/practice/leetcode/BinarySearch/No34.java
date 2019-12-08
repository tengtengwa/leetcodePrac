package practice.leetcode.BinarySearch;

public class No34 {
    public static void main(String[] args) {
        Solution34 s = new Solution34();
        s.searchRange(new int[]{1, 2, 2, 4}, 2);

    }
}


class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int[] arr = new int[2];
        arr[0] = search_left(nums, target);
        arr[1] = search_right(nums, target);
        return arr;
    }

    private int search_left(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] >= target) {      //中间元素和target相等时，向左缩小范围
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left == nums.length) {      //最大值比target小
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    private int search_right(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {      //中间元素和target相等时，向右缩小范围
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == 0) {    //最小值比target大
            return -1;
        }
        /**
         * 因为我们对 left 的更新必须是 left = mid + 1，就是说 while 循环结束时，nums[left] 一定不等于 target 了，
         * 而 nums[left-1] 可能是 target
         */
        return nums[left - 1] == target ? (left - 1) : -1;  //mid = left - 1
    }
}