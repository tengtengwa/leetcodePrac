package practice.leetcode.Math;

public class No55 {
    public static void main(String[] args) {
        Solution55 s = new Solution55();
        s.canJump(new int[]{2, 4, 2, 1, 0, 2, 0});

    }
}

class Solution55 {

    /**
     * 法一：贪心
     * 遍历时每次更新在某个索引位置可以到达的最右边的位置，如果这个最右位置可以到达或超过最后一个元素的索引就为true，可以到达；
     * 否则，当遍历完所有位置时返回false
     * 时间：O(n)，空间：O(1)
     */
    public boolean canJump(int[] nums) {
        int rightMost = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= rightMost) {
                rightMost = Math.max(rightMost, nums[i] + i);   //当前位置i加上当前能走的最大步数就是可以到达的最右边的索引
            }
            if (rightMost >= nums.length - 1) {
                return true;
            }
        }
        return false;
    }
}











