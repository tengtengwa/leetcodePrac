package practice.leetcode.Greedy;

public class No122 {
    public static void main(String[] args) {
        Solution122 s = new Solution122();
        s.maxProfit(new int[]{5, 4, 3, 2, 6});
    }
}

class Solution122 {
    public int maxProfit(int[] prices) {
        int ans = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                ans += prices[i] - prices[i - 1];
            }
        }
        return ans;
    }
}