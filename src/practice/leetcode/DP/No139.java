package practice.leetcode.DP;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class No139 {
    public static void main(String[] args) {
        Solution139 s = new Solution139();
        List<String> words = new ArrayList<>();
        words.add("leet");
        words.add("code");
        s.wordBreak("leetcode", words);
    }
}

class Solution139 {
    /**
     * �ⷨһ�������������˼������
     * �ü�����ÿ�����ʳ���ƥ�䵱ǰ������ͷ��s�����ַ�����ƥ��ɹ������ƥ�������Ӵ�������������һ���ᳬʱ
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        if (s.length() == 0) {
            return true;
        }
        for (String word : wordDict) {
            if (s.startsWith(word)) {
                if (wordBreak(s.substring(word.length()), wordDict)) {
                    return true;
                }
            }
        }
        return false;
    }


    /**
     * �ⷨ������̬�滮
     * dp["onetwothreefour"] = dp["onetwothree"��һ��] && �ж�һ��"four"
     * dp["onetwothreefour"] = dp["onetwothre"��һ��] && �ж�һ��"efour"
     * ʱ�䣺O(n^2)���ռ䣺O(n)
     */
/*    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {    //dp[i]��ʾs���Ӵ�s[0:i-1]�ܷ񱻲�ֳ����ɸ��ֵ��г��ֵĵ��ʣ�ע�ⷶΧ[1:len]
            for (int j = 0; j < i; j++) {   //�ڲ�ѭ����j��Ϊ0~i-1�ķָ���
                if (dp[j] && set.contains(s.substring(j, i))) { //dp[j]�ж�s[0:j-1]�������жϼ������Ƿ����s[j:i-1]
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }*/

}