package practice.leetcode;

public class No26 {
    public static void main(String[] args) {
        Solution26 s = new Solution26();
        s.removeDuplicates(new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4});

    }
}

class Solution26 {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }
}