package practice.leetcode.DynamicProgramming;

public class No309 {
    public static void main(String[] args) {
        Solution309 s = new Solution309();
        s.maxProfit(new int[]{1, 2, 3, 0, 2});
    }
}

class Solution309 {
    /**
     * 题目：最佳买股票时机含冷冻期
     * <p>
     * 描述：给定一个整数数组，其中第i个元素代表了第i天的股票价格
     * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
     * 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
     * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
     * <p>
     * 解法：dp
     * <p>
     * 思路：我们用一个二维数组来记录到该天的累计最大收益，每天有三种不同的状态：
     * <p>
     * 1.我们目前持有一支股票，对应的「累计最大收益」记为 f[i][0]
     * <p>
     * 2.我们目前不持有任何股票，并且处于冷冻期中，对应的「累计最大收益」记为 f[i][1]
     * <p>
     * 3.我们目前不持有任何股票，并且不处于冷冻期中，对应的「累计最大收益」记为 f[i][2]
     * <p>
     * 时间、空间：O(n)
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 0) {
            return 0;
        }
        int[][] dp = new int[len][3];
        //初始化第一天的三种状态下的最大收益
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;

        for (int i = 1; i < len; i++) {
            //今天是状态1，昨天可以有两种状态：昨天本就是状态1；昨天是状态3，今天买了股票
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][2] - prices[i]);
            //今天是状态2，昨天只能是状态3并且[今天]卖了股票，注意卖的是今天的！！！
            dp[i][1] = dp[i - 1][0] + prices[i];
            //今天是状态3，昨天可能的状态：本就是状态3；昨天是状态2
            dp[i][2] = Math.max(dp[i - 1][1], dp[i - 1][2]);
        }
        //最后一天的最大收益是最后一天三种状况取最大，但最后一天还持有股票没有意义，因此最后一天的最大收益在后两种状态取最大即可
        return Math.max(dp[len - 1][1], dp[len - 1][2]);
    }

    /**
     * 上面dp解法的空间优化，使用三个变量来保存当前的状态而不是使用一个3n大小的数组
     * 时间：O(n)，空间：O(1)
     */
/*    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len <= 0) {
            return 0;
        }
        int s1 = -prices[0];
        int s2 = 0;
        int s3 = 0;

        for (int i = 1; i < len; i++) {
            //用三个临时变量保存今天的状态
            int ns1 = Math.max(s1, s3 - prices[i]);
            int ns2 = s1 + prices[i];
            int ns3 = Math.max(s2, s3);
            //将当前状态更新为今天的状态
            s1 = ns1;
            s2 = ns2;
            s3 = ns3;
        }
        return Math.max(s2, s3);
    }*/
}