package practice.leetcode.ByteDance;

import java.util.HashMap;
import java.util.Map;

public class String3 {
    public static void main(String[] args) {
        SolutionStr3 s = new SolutionStr3();
        s.checkInclusion("ab", "eidboaoo");
    }
}


class SolutionStr3 {
    /**
     * 题目：字符串的排列
     * 解法一：基于哈希表的滑动窗口
     * 时间、空间：O(n)
     */
    public boolean checkInclusion(String s1, String s2) {
        Map<Character, Integer> window = new HashMap<>();
        Map<Character, Integer> need = new HashMap<>();
        int l = 0, r = 0, len = s2.length(), match = 0;

        for (char ch : s1.toCharArray()) {
            need.put(ch, need.getOrDefault(ch, 0) + 1);
        }
        while (r < len) {
            char ch = s2.charAt(r);
            if (need.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                if (window.get(ch).equals(need.get(ch))) {
                    match++;
                }
            }
            r++;
            while (match == need.size()) {
                if (r - l == s1.length()) {
                    return true;
                }
                char left = s2.charAt(l);
                if (window.containsKey(left)) {
                    window.put(left, window.get(left) - 1);
                    if (window.get(left) < need.get(left)) {
                        match--;
                    }
                }
                l++;
            }
        }
        return false;
    }
}