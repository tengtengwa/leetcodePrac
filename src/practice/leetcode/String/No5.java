package practice.leetcode.String;

public class No5 {
    public static void main(String[] args) {
        Solution5 s = new Solution5();
        System.out.println(s.longestPalindrome("abccba"));

    }
}

class Solution5 {
    /**
     * ��Ŀ��������Ӵ�
     * ����һ���ַ��� s���ҵ� s ����Ļ����Ӵ�������Լ��� s ����󳤶�Ϊ 1000��
     */

    /**
     * �ⷨһ��dp
     * ˼·���ӳ���Ϊ1���Ӵ������򳤶Ƚϳ����Ӵ�����ת�ơ�״̬ת�Ʒ��̣�P(i,j)=P(i+1,j-1) && (Si==Sj)
     *
     * ʱ�䡢�ռ䣺O(n^2)
     */
/*    public String longestPalindrome(String s) {
        int n = s.length();
        boolean[][] dp = new boolean[n][n];
        String ans = "";
        //l��¼��ǰ�Ӵ�������i��ʼ����������i���ַ����������ַ��ĳ��ȡ�Ҳ����˵��ǰ�Ӵ��ĳ���Ϊl+1
        for (int l = 0; l < n; l++) {
            for (int i = 0; i + l < n; i++) {   //i��¼�Ӵ�����ʵ����
                int j = i + l;                  //j��¼�Ӵ��Ľ�β�ַ�����
                if (l == 0) {                   //�Ӵ�����Ϊ1���ǻ���
                    dp[i][j] = true;
                } else {
                    boolean b = s.charAt(i) == s.charAt(j);
                    if (l == 1) {               //�Ӵ�����Ϊ2����������ַ���ȣ����ǻ���
                        dp[i][j] = b;
                    } else {                    //���ȴ���2���ǻ��ĵ�������P(i,j)=P(i+1,j-1) && (Si==Sj)
                        dp[i][j] = (b && dp[i + 1][j - 1]);
                    }
                }
                if (dp[i][j] && l + 1 > ans.length()) {     //�����ǰ�Ӵ����ȣ�l+1������֮ǰ������ȣ������ans�Ӵ�
                    ans = s.substring(i, i + l + 1);
                }
            }
        }
        return ans;
    }*/

    /**
     * �ⷨ����������չ�㷨
     * ����һ���ַ���ÿ�δ��м�һ���������ַ���ʼ�����߽�����չ��ͬʱ��¼��ǰ����ĵ���ʼ�ͽ�������
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
                //���������len-1�������"cbbd"�������ʱi��1����len1Ϊ1��len2Ϊ2��lenΪ2���������len-1������ʼ�±�������
                start = i - ((len - 1) / 2);
                end = i + (len / 2);
            }
        }
        return s.substring(start, end + 1);     //end+1
    }

    /**
     * �����ַ���s��s[i:j]Ϊ���Ŀ�ʼ��չ�����Ӵ��ĳ��ȡ����j==i���м�һ���ַ���������С����Ϊ1�����j==i+1���м������ַ�����
     * ����С����Ϊ0
     *
     * @param s �����ַ���
     * @return ��չ�����Ӵ��ĳ���
     */
    private int expendFromCenter(String s, int i, int j) {
        while (i >= 0 && j < s.length() && (s.charAt(i) == s.charAt(j))) {
            i--;
            j++;
        }
        return j - i - 1;       //ע�⣡������㳤��Ҫ-1
    }
}