package practice.leetcode.SlidingWindow;

import java.util.HashMap;
import java.util.Map;

public class No72 {
    public static void main(String[] args) {
        Solution72 s = new Solution72();
        s.minWindow("ADOBECODEBANC", "ABC");
    }
}


class Solution72 {
    /**
     * 看到类似 “两个字符串xxx，求最小子串”，一般就是要使用滑动窗口来解的。滑动窗口，说白了就是双指针，没有多么高大上。
     * 这道题大致思路：
     * 1.不断增加右边界使滑动窗口增大，直到窗口包含了T的所有元素，此时need中所有元素的数量都小于等于0（出现的无效字符都小于0，有效元素都为0）
     * ，同时needCnt也是0
     * 2.不断缩小左边界使滑动窗口缩小，直到碰到一个必须包含的元素A，此时记录长度更新结果
     * 3.左边界左移一个位置，开始寻找下一个满足条件的滑动窗口
     */
    public String minWindow(String s, String t) {
        if (s == null || s.equals("") || t == null || t.equals("") || s.length() < t.length()) {
            return "";
        }
        int min = Integer.MAX_VALUE;
        int start = -1;
        int needCount = t.length();
        int l = 0, r = 0;
        int[] need = new int[128];
        for (char ch : t.toCharArray()) {       //数组中存放字符串t的所有字符出现次数
            need[ch]++;
        }
        while (r < s.length()) {                //结束条件就是窗口没有滑出去
            if (need[s.charAt(r)] > 0) {        //如果s中索引r的字符出现在t中，为有效字符，此时needCount-1
                needCount--;
            }
            need[s.charAt(r)]--;        //无论是否是有效字符，need中对应的次数都会减少。在下面收缩左边界时无效字符并不会使needCount+1
            while (needCount == 0) {
                if (r - l < min) {      //t中字符全部出现在窗口的范围中了，此时更新min和此字符串的开始索引
                    start = l;
                    min = r - l;
                }
                need[s.charAt(l)]++;    //有效字符+1后必然>0，所以下面needCount会+1；s中出现的无效字符+1后必然<=0
                if (need[s.charAt(l)] > 0) {
                    needCount++;
                }
                l++;                    //无论是否是有效字符，左边界都+1
            }
            r++;
        }
        return start == -1 ? "" : s.substring(start, start + min + 1);  //注意,最后substring方法取的范围为[left,right)
    }
}