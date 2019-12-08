package practice.leetcode.DoublePointer;

public class No75 {
    public static void main(String[] args) {
        Solution75 s = new Solution75();
        s.sortColors(new int[]{1, 2, 0});
    }
}

class Solution75 {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int L = 0, R = nums.length - 1;
        for (int i = 0; i <= R; i++) {
            if (nums[i] == 0) {
                swap(nums, L, i);
                L++;
            } else if (nums[i] == 2) {
                swap(nums, R, i);
                R--;
                i--;   //因为curr左边的值已经扫描过了，所以curr要++继续扫描下一位，而与p2交换的值，curr未扫描，要停下来扫描一下，所以curr不用++。
            }
        }
    }

    private void swap(int[] nums, int l, int i) {
        int tem = nums[l];
        nums[l] = nums[i];
        nums[i] = tem;
    }
}