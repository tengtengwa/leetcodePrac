package practice.leetcode.BinarySearch;

public class No33 {
    public static void main(String[] args) {
        Solution33 s = new Solution33();
        s.search(new int[]{3, 1}, 1);
    }
}

class Solution33 {
/*    public int search(int[] nums, int target) {
        //因为此处减一了，left+right为奇数时会向左偏移。所以下面判断哪部分有序只能用nums[right]和nums[mid]的大小关系判断
        int L = 0, R = nums.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > nums[R]) {       //左半边有序,判断target是否在左半部分
                if (nums[L] <= target && target < nums[mid]) {      //如果target的大小在nums[L,mid)区间内，将区间缩小为[L,mid-1]
                    R = mid - 1;
                } else {                                            //target小于nums[L]或大于等于nums[mid]，将区间缩小为[mid+1,R]
                    L = mid + 1;
                }
            } else if (nums[mid] <= nums[R]) {      //右半边有序，判断是否在右半部分
                if (nums[mid] < target && target <= nums[R]) {      //target的大小在nums(mid,R]区间内，将区间缩小为[mid+1,R]
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }
        }
        return -1;
    }*/

    public int search(int[] nums, int target) {
        //因为此处减一了，left+right为奇数时会向左偏移。所以下面判断哪部分有序只能用nums[right]和nums[mid]的大小关系判断
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[right] < nums[mid]) {    //左半部分有序
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {        //右半部分有序
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}