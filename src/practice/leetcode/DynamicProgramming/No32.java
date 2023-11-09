package practice.leetcode.DynamicProgramming;

public class No32 {
    public static void main(String[] args) {
        Solution32 s = new Solution32();
        int n = s.longestValidParentheses(")()())");
        System.out.println(n);
    }
}

class Solution32 {
    /**
     * 法一：暴力：检查所有子串的合法性，来判断最长的长度
     * 时间复杂度：O(n^3)，空间复杂度：O(n)
     *
     */
/*
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    public int longestValidParentheses(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }*/


    /**
     * 法二：动态规划，时间复杂度：O(n)，空间复杂度：O(n)
     * 下面这篇题解讲的很好
     * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/dong-tai-gui-hua-si-lu-xiang-jie-c-by-zhanganan042/
     *
     * 大致思路：
     * 只有以')'结尾的序列才可能是有效序列，所以第一个条件就是当前字符为')'，
     * 数组dp中位置i的元素记录的是当前位置之前以下标为i结尾的字符的最长有效子字符串的长度。
     * 1.当前字符为')'，前一个字符为'('，此时序列为...() 则dp[i] = dp[i-1] + 2
     * 2.当前字符为')'，前一个字符为')'，此时序列为..((..))，此时需要先看对应最后一个')'的括号（即i-1-dp[i-1]位置的括号）是否是'('，不是则不是有效括号；
     * 否则dp[i]=dp[i-1]+2+dp[i-dp[i-1]-2]，dp[i-1-dp[i-1]-1]为 ((..))前有效括号长度
     *
     * 注意：因为需要判断前面的序列的最大有效括号长度，所以需要防止越界，这题很容易出错，所以一定要细心!!!
     */

    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {   //因为i从1开始的，所以只有这里不用判断越界，下面三行都需要防止越界！！！
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - 1 - dp[i - 1] - 1 >= 0 ? dp[i - 2 - dp[i - 1]] : 0);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    /**
     * 法三：用栈，但是栈中存放的不是括号字符，而是该字符的下标
     */
/*    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();            //是右括号，先将栈顶元素出栈
                if (stack.empty()) {    //出栈一个元素后如果栈为空，就将右括号入栈
                    stack.push(i);
                } else {                //否则右括号和栈顶左括号配对，此时计算有效长度
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }*/
}