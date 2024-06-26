package practice.leetcode.DoublePointer;

import java.util.HashSet;

public class No3 {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
    }
}

/*
//我的题解
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        if ("".equals(s)) {
            return 0;
        }
        if (s.length() == 1) {
            return 1;
        }
        Stack<Character> stack = new Stack<>();
        int max = 0;
        int i = 0;
        int t = 0;
        for (; i < s.length();) {
            char ch = s.charAt(i);
            if (!stack.contains(ch)) {
                stack.push(ch);
                i++;
            } else {
                if (stack.size() > max) {
                    max = stack.size();
                }
                stack.clear();
                i = ++t;
//                stack.push(s.charAt(i));
            }
        }
        if (stack.size() != 0) {
            if (stack.size() > max) {
                max = stack.size();
            }
        }
        return max;
    }
}*/


/*//优化的滑动窗口
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int end = 0, start = 0; end < n; end++) {
            char alpha = s.charAt(end);
            if (map.containsKey(alpha)) {
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}*/

//滑动窗口
// 借助于一个大小可变的滑动窗口。
// 当窗口中不存在重复字符时，窗口的右边界向右滑动（增加窗口中的字符数），如果窗口中存在重复字符，则将窗口的左边界向右滑动，减少窗口中的字符数。
// 并且，每次增加新的字符时，都与当前最长子串的长度进行比较，保留二者的大者。
// 当窗口的右边界抵达字符串的末尾时，遍历结束，返回保存的最长子串的长度。滑动窗口可以采用集合进行表示。
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int L = 0;
        int R = 0;
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        while (L < len && R < len) {
            if (!set.contains(s.charAt(R))) {
                set.add(s.charAt(R++));         //窗口右移一位
                ans = Math.max(ans, R - L);     //更新当前字串最大长度
            } else {
                set.remove(s.charAt(L++));      //如果有重复的字符，则肯定是当前位置的字符和最左边的字符重复，因此移除集合中最左边的元素
            }
        }
        return ans;
    }
}

