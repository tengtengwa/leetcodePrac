package practice.leetcode;

public class No35 {
    public static void main(String[] args) {

    }
}

class Solution35 {
    public int searchInsert(int[] nums, int target) {
        int index = 0;
        int i = 0;
        for (; i < nums.length; i++) {
            if (target <= nums[i]) {
                index = i;
                return index;
            }
        }
        if (i == nums.length) {
            return i;
        }
        return index;
    }
}