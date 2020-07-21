package practice.leetcode.SlidingWindow;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class No3 {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        s.lengthOfLongestSubstring("abaaabcaaaabcd");

    }
}

class Solution3 {
    /**
     * 普通的滑动窗口解法，set中存放当前窗口出现的所有字符，每次遇到重复的字符，将最左边的字符移出set，
     * 左边界每次移动一位，直到当前字符和set中没有重复，右边界才向右移动。
     * 可以优化的地方在于：在出现重复字符时，左边界直接跳到和集合中重复字符的后面
     *
     */
/*    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, ans = 0;              //快慢指针
        while (j < n) {                //i<n防止出现空字符的字符串
            if (!set.contains(s.charAt(j))) {   //set中不包含当前位置字符
                set.add(s.charAt(j++));         //将当前字符加入set，并将快指针后移
                ans = Math.max(ans, j - i);     //更新无重复最长字串的最大值
            } else {                            //set中包含当前位置字符
                set.remove(s.charAt(i++));      //将该字符移除，并将慢指针后移
            }
        }
        return ans;
    }*/

    /**
     * 优化的滑动窗口
     * Map中元素的涵义为：每当当前字符和map中某个字符重复，就需要左边界跳到这个字符对应的value索引
     * 比如abcc，此时map中c的键值对：c->3，左边界就直接跳到3这个索引
     */
/*    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();      //map中存储每个不重复字符的下一个位置
        int ans = 0;
        for (int r = 0, l = 0; r < n; r++) {
            if (map.containsKey(s.charAt(r))) {         //如果map中已经包含当前字符，将窗口左边界更新
                //l跳到和当前字符重复的上一个字符的下一个位置,取max是为了防止l左移
                l = Math.max(map.get(s.charAt(r)), l);
            }
            ans = Math.max(ans, r - l + 1);        //每次循环更新最大值
            map.put(s.charAt(r), r + 1);        //此处在map中储存当前位置字符的下一个位置
        }
        return ans;
    }*/


    /**
     * 也可以使用数组来替换map，key为该字符的ASCII码，value为该ASCII码在数组中对应的元素，即不重复字符的下一个位置
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] map = new int[128];      //map中存储每个不重复字符的下一个位置
        int ans = 0;
        int l = 0, r = 0;

        for (; r < n; r++) {
            int index = s.charAt(r);
            l = Math.max(map[index], l);
            ans = Math.max(ans, r - l + 1);
            map[index] = r + 1;
        }

        return ans;
    }
}