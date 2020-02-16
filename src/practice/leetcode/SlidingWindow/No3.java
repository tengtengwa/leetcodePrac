package practice.leetcode.SlidingWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class No3 {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        s.lengthOfLongestSubstring("abcdca");

    }
}

class Solution3 {
    //滑动窗口
/*    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, ans = 0;              //快慢指针
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {   //set中不包含当前位置字符
                set.add(s.charAt(j++));         //将当前字符加入set，并将快指针后移
                ans = Math.max(ans, j - i);     //更新无重复最长字串的最大值
            } else {                            //set中包含当前位置字符
                set.remove(s.charAt(i++));      //将该字符移除，并将慢指针后移
            }
        }
        return ans;
    }*/

    //优化的滑动窗口
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                //i跳到和当前字符重复的上一个字符的下一个位置,取max是为了防止i左移
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);	//每次循环更新最大值
            map.put(s.charAt(j), j + 1);        //此处在map中储存当前位置字符和下一个位置
        }
        return ans;
    }
}