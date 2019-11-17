package practice.leetcode;

import java.util.Arrays;

public class No16 {
    public static void main(String[] args) {
        Solution16 s = new Solution16();
        s.threeSumClosest(new int[]{1, 1, 1, 1}, 0);
    }
}

class Solution16 {
    public int threeSumClosest(int[] nums, int target) {
        if (nums.length == 3) {
            return nums[0] + nums[1] + nums[2];
        }
        Arrays.sort(nums);
        int len = nums.length;
        int min = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < len; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == target) {
                    return target;
                }
                if (Math.abs(target - sum) < Math.abs(target - min)) {
                    min = sum;
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                }
                if (sum - target > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return min;
    }
}