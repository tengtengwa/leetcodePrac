package practice.leetcode.DailyQuestion;

public class No121 {
    public static void main(String[] args) {
        Solution121 s = new Solution121();
        s.maxProfit(new int[]{1,2});


    }
}

class Solution121 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int pre = prices[0];
        int cur = pre;
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= pre) {
                ans = Math.max(ans, pre - cur);
                pre = prices[i];
            } else {
                pre = prices[i];
            }
            if (prices[i] < cur) {
                cur = pre;
            }
        }
        return Math.max(ans, pre - cur);
    }
}