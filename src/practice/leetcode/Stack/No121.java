package practice.leetcode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class No121 {
    public static void main(String[] args) {
        Solution121 s = new Solution121();
        s.maxProfit(new int[]{1, 2});


    }
}

class Solution121 {
    /**
     *  题目：买卖股票的最佳时机。大概题意就是找出数组中最小值和最大值的差
     *  暴力法：双循环遍历每两个元素的差值，求最大即可。时间 O(n^2)
     *
     *  方法二：下面是官方题解二，一次遍历，类似于动态规划
     *  思路：遍历过程中，边更新最小值，边计算最大利润
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int maxProfit = 0;                  //最大利润
        int min = Integer.MAX_VALUE;        //min是当前元素及以前的所有元素的“历史最小值”
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > maxProfit) {
                maxProfit = price - min;
            }
        }
        return maxProfit;
    }


    /**
     * 单调栈解法：
     */
/*    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] arr = new int[len + 1];       //数组尾部增加一个“哨兵”，防止数组元素递增的情况下答案为0
        System.arraycopy(prices, 0, arr, 0, len);
        prices = arr;

        for (int i = 0; i < prices.length; i++) {
            //如果元素递增，就直接入栈，否则将栈中前面大于当前元素的所有元素出栈
            while (!stack.isEmpty() && prices[i] <= stack.peekLast()) {
                max = Math.max(max, stack.peekLast() - stack.peekFirst());
                stack.pollLast();       //注意先更新完max再将栈顶元素出栈，避免只有一个元素的时候空指针
            }
            stack.add(prices[i]);
        }
        return max;
    }*/
}