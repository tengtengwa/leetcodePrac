package practice.leetcode.DoublePointer;

public class no27 {
    public static void main(String[] args) {
        int[] nums = {3, 2, 2, 3};
        Solution27 s = new Solution27();
        s.removeElement(nums, 3);
    }
}

class Solution27 {
/*    public int removeElement(int[] nums, int val) {
        int i = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] != val) {
                nums[i] = nums[j];
                i++;
            }
        }
        return i;
    }    */

    public int removeElement(int[] nums, int val) {
        int n = nums.length;
        int i = 0;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return i;
    }
}