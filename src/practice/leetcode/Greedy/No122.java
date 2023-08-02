package practice.leetcode.Greedy;

/**
 * 122. 买卖股票的最佳时机 II
 * 给你一个整数数组prices，其中prices[i]表示某支股票第i天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有一股股票。你也可以先购买，然后在同一天出售。
 * 返回你能获得的最大利润。
 * 注意：题目要求中，每一天可以同时买入和售出
 */
public class No122 {
    public static void main(String[] args) {
        Solution122 s = new Solution122();
        int max = s.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(max);
    }
}

class Solution122 {
    /**
     * 解法一：暴力
     * dfs枚举所有可能的情况，取最大利润即可。
     * 时间复杂度：O(2^n)，空间复杂度：O(n)
     */
    private int res = 0;
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        dfs(prices, 0, 0, 0);
        return res;
    }

    /**
     * @param prices        股票价格数组
     * @param i             当前是第i+1天
     * @param status        当前持有股票/现金，1代表持有股票；0代表持有现金
     * @param curProfile    当前的利润
     */
    private void dfs(int[] prices, int i, int status, int curProfile) {
        if (i == prices.length) {
            res = Math.max(res, curProfile);
            return;
        }
        dfs(prices, i + 1, status, curProfile);
        if (status == 0) {
            dfs(prices, i + 1, 1, curProfile - prices[i]);
        } else {
            dfs(prices, i + 1, 0, curProfile + prices[i]);
        }
    }

    /**
     * 解法二：动态规划
     * 通过一个二维数组/两个一维数组来存储状态，这里用两个一维数组cash和stock来存储第i天持有股票/现金时，最大的利润
     * 持有现金/股票时，都有两种转移的状态，现金：不动/买入；股票：不动/卖出
     * 转移方程：
     * cash[i]=max(cash[i-1], price[i] - stock[i-1])
     * stock[i]=max(stock[i-1], cash[i-1] - price[i])
     * 最终cash[n-1]就是所求最大利润。
     *
     * 时间复杂度：O(n)；空间复杂度：O(n)
     * 优化：可以通过四个常亮替换两个数组以优化空间，存储第i-1天及i天时持有现金/股票时的最大利润。
     */
//    public int maxProfit(int[] prices) {
//        int res = 0;
//        if (prices.length < 2) {
//            return res;
//        }
//        int[] cash = new int[prices.length];
//        int[] stock = new int[prices.length];
//        cash[0] = 0;
//        stock[0] = -prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            cash[i] = Math.max(cash[i - 1], prices[i] + stock[i - 1]);
//            stock[i] = Math.max(stock[i - 1], cash[i - 1] - prices[i]);
//        }
//        return cash[prices.length - 1];
//    }

    /**
     * 解法三：贪心
     * 本题的一个特殊解法，只能算出最大值，但并不代表实际的交易过程。
     * 因为我们每天都可以同时进行买和卖的操作，因此，[l,r]区间贡献的利润可以分解成每一个小段：
     * P[l,r]=P[l,l+1]+P[l+1,l+2]...P[r-2,r-1]+P[r-1,r]
     * 所以我们只需要算出所有贡献大于0的区间即可使利润最大。
     * 时间复杂度：O(n)，空间复杂度：O(1)
     */
//    public int maxProfit(int[] prices) {
//        int ans = 0;
//        for (int i = 1; i < prices.length; i++) {
//            int delta = prices[i] - prices[i - 1];
//            if (delta > 0) {
//                ans += delta;
//            }
//        }
//        return ans;
//    }
}