package practice.leetcode.String;

public class No5 {
    public static void main(String[] args) {
        Solution5 s = new Solution5();
        System.out.println(s.longestPalindrome("abccba"));

    }
}

class Solution5 {
    /**
     * 题目：最长回文子串
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     */

    /**
     * 解法一：dp
     * 思路：从长度为1的子串依次向长度较长的子串进行转移。状态转移方程：P(i,j)=P(i+1,j-1) && (Si==Sj)
     *
     * 时间、空间：O(n^2)
     */
/*    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        //l记录当前子串从索引i开始（不包括第i个字符），后面字符的长度。也就是说当前子串的长度为l+1
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {   //i记录子串的其实索引
                int j = i + l;                  //j记录子串的结尾字符索引
                if (l == 0) {                   //子串长度为1，是回文
                    dp[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (l == 1) {               //子串长度为2，如果两个字符相等，则是回文
                        dp[i][j] = b;
                    } else {                    //长度大于2，是回文的条件：P(i,j)=P(i+1,j-1) && (Si==Sj)
                        dp[i][j] = (b && dp[i + 1][j - 1]);
                    }
                }
                if (dp[i][j] && l + 1 > ans.length()) {     //如果当前子串长度（l+1）大于之前的最长长度，则更新ans子串
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }*/

    /**
     * 解法二：中心扩展算法
     * 遍历一遍字符，每次从中间一个或两个字符开始向两边进行扩展，同时记录当前最长回文的起始和结束索引
     */
    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) {
            return "";
        }
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expendFromCenter(s, i, i);
            int len2 = expendFromCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (end - start < len) {
                //这里必须是len-1，如果是"cbbd"，假设此时i是1，则len1为1，len2为2，len为2。如果不给len-1，则起始下标计算错误。
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);     //end+1
    }

    /**
     * 计算字符串s从s[i:j]为中心开始扩展后的最长子串的长度。如果j==i（中间一个字符），则最小长度为1；如果j==i+1（中间两个字符），
     * 则最小长度为0
     *
     * @param s 所给字符串
     * @return 扩展后的最长子串的长度
     */
    private int expendFromCenter(String s, int i, int j) {
        while (i >= 0 && j < s.length() && (s.charAt(i) == s.charAt(j))) {
            i--;
            j++;
        }
        return j - i - 1;       //注意！这里计算长度要-1
    }
}