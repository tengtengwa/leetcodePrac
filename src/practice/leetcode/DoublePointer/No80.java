package practice.leetcode.DoublePointer;

public class No80 {
    public static void main(String[] args) {
        Solution80 s = new Solution80();
        s.removeDuplicates(new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3});

    }
}

class Solution80 {
    public int removeDuplicates(int[] nums) {
        int i = 2;
        for (int j = 2; j < nums.length; j++) {
            if (i < 2 || nums[j] > nums[i - 2]) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}