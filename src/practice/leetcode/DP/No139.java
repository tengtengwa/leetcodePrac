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
     * 解法一：暴力，和深捜思想类似
     * 用集合中每个单词尝试匹配当前索引开头的s的子字符串，匹配成功则继续匹配后面的子串，但用例中有一个会超时
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
     * 解法二：动态规划
     * dp["onetwothreefour"] = dp["onetwothree"这一段] && 判断一下"four"
     * dp["onetwothreefour"] = dp["onetwothre"这一段] && 判断一下"efour"
     * 时间：O(n^2)，空间：O(n)
     */
/*    public boolean wordBreak(String s, List<String> wordDict) {
        Set<String> set = new HashSet<>(wordDict);
        int len = s.length();
        boolean[] dp = new boolean[len + 1];
        dp[0] = true;

        for (int i = 1; i <= len; i++) {    //dp[i]表示s的子串s[0:i-1]能否被拆分成若干个字典中出现的单词，注意范围[1:len]
            for (int j = 0; j < i; j++) {   //内层循环，j作为0~i-1的分隔点
                if (dp[j] && set.contains(s.substring(j, i))) { //dp[j]判断s[0:j-1]，后面判断集合中是否包含s[j:i-1]
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[len];
    }*/

}