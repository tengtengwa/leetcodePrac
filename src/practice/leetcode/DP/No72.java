package practice.leetcode.DP;

public class No72 {
    public static void main(String[] args) {
        Solution72 s = new Solution72();
        s.minDistance("horse", "ros");
    }
}

class Solution72 {
    /**
     * ��һ����̬�滮
     * ʱ�䣺O��mn�����ռ䣺O(mn)
     */
/*    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n * m == 0) {           //ͨ���˷�������滻������if���
            return n + m;
        }
        int[][] dp = new int[n + 1][m + 1];
        for (int i = 0; i <= n; i++) {      //��һ�������������ڵ�һ�У�������Ϊ0
            dp[i][0] = i;
        }
        for (int i = 0; i <= m; i++) {      //�ڶ����ʺ��������ڵ�һ�У�������Ϊ0
            dp[0][i] = i;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                int left_down = dp[i - 1][j - 1];
                int left = dp[i][j - 1] + 1;
                int down = dp[i - 1][j] + 1;
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {   //ע�������ҪԽ��
                    left_down += 1;
                }
                dp[i][j] = Math.min(left, Math.min(down, left_down));
            }
        }
        return dp[n][m];
    }*/


    /**
     * ���������ݣ��Զ����·�
     * ʱ�䣬�ռ�Ӧ�û����� O(mn)
     */
    public int minDistance(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        int[][] dp = new int[n + 1][m + 1];
        return minDistanceRecursive(word1.toCharArray(), word2.toCharArray(), n, m, dp);
    }

    private int minDistanceRecursive(char[] word1, char[] word2, int n, int m, int[][] dp) {
        int count;
        if (dp[n][m] != 0) {    //��֦
            return dp[n][m];
        }
        if (n * m == 0) {       //��һ���ַ�������Ϊ��
            count = n + m;
        } else if (word1[n - 1] == word2[m - 1]) {      //�����ַ�����β��ȣ�����ͺ����½ǵı༭�������
            count = minDistanceRecursive(word1, word2, n - 1, m - 1, dp);
        } else {                //�����ַ�����β�����
            int insert = minDistanceRecursive(word1, word2, n, m - 1, dp);
            int delete = minDistanceRecursive(word1, word2, n - 1, m, dp);
            int replace = minDistanceRecursive(word1, word2, n - 1, m - 1, dp);
            count = Math.min(insert, Math.min(delete, replace)) + 1;
        }
        dp[n][m] = count;
        return count;
    }
}