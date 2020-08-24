package practice.leetcode.DP;

public class No198 {
    public static void main(String[] args) {


    }
}

class Solution198 {
    /**
     * 题目：打家劫舍，给定一个数组，不能选取相邻的元素，求能取到的最大值
     * 一道easy的动态规划...
     *
     * 解法：动态规划，借助dp数组保存每个位置i能取到的最大值
     * 状态转移方程：dp[i] = max(dp[i-2]+nums[i], dp[i-1])
     * 时间、空间：O(N)
     */
/*    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //只有一间房屋，只能偷这间
        dp[0] = nums[0];
        //有两间房屋，因为不能偷相邻的房屋，所以选择两者之中较大的偷
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            //每个位置（房屋）有偷和不偷两种状态。偷了：dp[i]=dp[i - 2] + nums[i]，不偷：dp[i]=dp[i - 1]
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }*/

    /**
     * 不使用dp数组记录每个状态，一个位置的状态只和前两个位置的状态有关，所以我们只需要记录这两个位置的状态即可
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            int tem = second;                           //先用tem记录前一个位置的状态
            second = Math.max(first + nums[i], second); //更新second为当前位置的状态
            first = tem;                                //将前两个位置的状态更新为前一个位置的状态
        }
        return second;
    }
}