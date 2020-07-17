package practice.leetcode.DP;

public class No72 {
    public static void main(String[] args) {
        Solution72 s = new Solution72();
        s.minDistance("horse", "ros");
    }
}

class Solution72 {
    /**
     * 法一：动态规划
     * 时间：O（mn），空间：O(mn)
     */
/*    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n * m == 0) {           //通过乘法巧妙的替换了两个if语句
            return n + m;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {      //第一个词竖着排列在第一列，所以列为0
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {      //第二个词横着排列在第一行，所以行为0
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int left_down = dp[i - 1][j - 1];
                int left = dp[i][j - 1] + 1;
                int down = dp[i - 1][j] + 1;
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {   //注意这里，不要越界
                    left_down += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return dp[n][m];
    }*/


    /**
     * 法二：回溯，自顶向下法
     * 时间，空间应该还都是 O(mn)
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        return minDistanceRecursive(word1.toCharArray(), word2.toCharArray(), n, m, dp);
    }

    private int minDistanceRecursive(char[] word1, char[] word2, int n, int m, int[][] dp) {
        int count;
        if (dp[n][m] != 0) {    //剪枝
            return dp[n][m];
        }
        if (n * m == 0) {       //有一个字符串长度为零
            count = n + m;
        } else if (word1[n - 1] == word2[m - 1]) {      //两个字符串结尾相等，结果就和左下角的编辑距离相等
            count = minDistanceRecursive(word1, word2, n - 1, m - 1, dp);
        } else {                //两个字符串结尾不相等
            int insert = minDistanceRecursive(word1, word2, n, m - 1, dp);
            int delete = minDistanceRecursive(word1, word2, n - 1, m, dp);
            int replace = minDistanceRecursive(word1, word2, n - 1, m - 1, dp);
            count = Math.min(insert, Math.min(delete, replace)) + 1;
        }
        dp[n][m] = count;
        return count;
    }
}