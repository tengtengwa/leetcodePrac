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
            if (nums[mid] >= target) {      //�м�Ԫ�غ�target���ʱ��������С��Χ
                right = mid;
            } else if (nums[mid] < target) {
                left = mid + 1;
            }
        }
        if (left == nums.length) {      //���ֵ��targetС
            return -1;
        }
        return nums[left] == target ? left : -1;
    }

    private int search_right(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] <= target) {      //�м�Ԫ�غ�target���ʱ��������С��Χ
                left = mid + 1;
            } else if (nums[mid] > target) {
                right = mid;
            }
        }
        if (left == 0) {    //��Сֵ��target��
            return -1;
        }
        /**
         * ��Ϊ���Ƕ� left �ĸ��±����� left = mid + 1������˵ while ѭ������ʱ��nums[left] һ�������� target �ˣ�
         * �� nums[left-1] ������ target
         */
        return nums[left - 1] == target ? (left - 1) : -1;  //mid = left - 1
    }
}