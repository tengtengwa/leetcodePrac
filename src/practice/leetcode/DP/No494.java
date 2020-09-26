package practice.leetcode.DP;

public class No494 {
    public static void main(String[] args) {
        Solution494 s = new Solution494();
        s.findTargetSumWays(new int[]{1, 2, 3, 4, 5}, 3);
    }
}

class Solution494 {
    /**
     * 题目：目标和
     * 给定一个非负整数数组和一个目标数S，现有+和-两个符号，返回可以使最终数组和为目标数 S 的所有添加符号的方法数。
     *
     * 解法一：暴力递归，枚举每种情况。
     * 时间：O(2^(n))，n是数组的长度，因为每个元素都有+-两种情况
     * 空间：O(n)，栈空间的递归深度
     */

    /**
     * 解法二：dp
     * 假设P是正子集，N是负子集 例如： 假设nums = [1, 2, 3, 4, 5]，target = 3，一个可能的解决方案是+1-2+3-4+5 = 3 这里正子集P = [1, 3, 5]和负子集N = [2, 4]
     * 上面正子集的和sum(p)-负子集的和sum(n)就是目标和S，下面通过这个式子将其转换为子集求和问题：
     *      			  sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     *                        2 * sum(P) = target + sum(nums)
     * 这样原来的问题就转化为一个求子集的和问题： 找到nums的一个子集 P，使得sum( P ) = (target + sum(nums)) / 2，
     * 从上面最后个式子，可看出 target+sum(nums) 为偶数
     *
     * 时间：
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //目标和S+sum是奇数或数组中所有元素的和<目标和，这两种情况无解，直接返回0
        if (((sum + S) & 1) == 1 || S > sum) {
            return 0;
        }
        int subSum = (S + sum) >> 1;    //转换为求数组中和为subSum的子集的数量
        //dp[i]表示和为i的子集的数量，则状态转移方程为dp[j]+=dp[j-nums[i]]，
        // （和为当前子集数量加上 j-当前元素nums[i]的子集数量）
        int[] dp = new int[subSum + 1];     //多开一个元素，下标直接对应
        dp[0] = 1;
        for (int num : nums) {     //外层循环遍历数组中每个元素
            for (int j = subSum; j >= 0; j--) { //内层循环更新dp数组中，注意！这里只能逆序遍历，因为之前的i-num状态已经被新状态覆盖
                if (dp[j] != 0 && j + num <= subSum) {
                    dp[j + num] += dp[j];
                }
            }
        }
        /*
        上面双循环写成这样也是一样的
        for(int num : nums) {
            for(int i = subSum; i >= num; i--) {    //从逆序更新一维数组，i>=num防止越界
                dp[i] += dp[i-num];
            }
        }
        * */
        return dp[subSum];
    }
}