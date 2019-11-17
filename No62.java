package practice.leetcode.Dynamic;

import java.util.Arrays;

public class No62 {
    public static void main(String[] args) {
        Solution62 s = new Solution62();
        s.uniquePaths(51, 9);

    }
}

class Solution62 {
/*    //��ǰ��״ֻ̬����һ�е�״̬��ͬһ����ߵ�״̬�йء���������ֻ��Ҫά����һ�е����飬�͵�ǰ�е�����
    public int uniquePaths(int m, int n) {
        int[] pre = new int[n];
        int[] cur = new int[n];
        Arrays.fill(pre, 1);
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] = cur[j - 1] + pre[j];
            }
            pre = cur.clone();
        }
        return pre[n - 1];
    }*/

    public int uniquePaths(int m, int n) {
        int[] cur = new int[n];
        Arrays.fill(cur, 1);
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                cur[j] += cur[j - 1];
            }
        }
        return cur[n - 1];
    }
}