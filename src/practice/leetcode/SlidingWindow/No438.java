package practice.leetcode.SlidingWindow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class No438 {
    public static void main(String[] args) {
        Solution438 s = new Solution438();
        s.findAnagrams("cbaebabacd", "abc");
    }
}

class Solution438 {
    /**
     * 题目：找到字符串中所有字母异位词
     * 遇到字符串的题，尤其是子串什么的基本上就是滑动窗口解法了
     *
     * 解法一：哈希表+滑动窗口
     * 思路：使用两个哈希表，一个记录p中每种字符出现的次数，另一个记录当前窗口中每种字符出现的次数。
     * 当map中包含当前右边界指向的字符时，将当前窗口中此字符出现次数+1，并将窗口右边界向右移动；
     * 如果当前窗口中所有字符出现次数都“够”了，就进入while循环，此循环中如果当前窗口长度是否为p的长度，就是一个解；
     * 同时缩小左边界并减少当前窗口字符出现次数。
     *
     * 时间：O(n)，空间：O(n)
     */
/*    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);   //老方法了，没有当前元素值就为0，否则+1
        }
        int l = 0, r = 0, match = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                //比较Integer的值通过compareTo或equals方法，使用==比较[-128~127]以外的值会出错，因为Integer只会缓存这个区间
                // 的Integer对象，超出这个区间需要重新创建对象比较引用当前不相等了
                if (window.get(ch).compareTo(map.get(ch)) == 0) {   //如果当前窗口该字符出现次数已经“够”了，将match+1
                    match++;
                }
            }
            r++;    //因为这里先将右边界右移了，所以下面计算窗口长度时不用+1
            while (match == map.size()) {   //满足此条件时表示此窗口中存在p的字母异位词
                if (r - l == p.length()) {  //同时满足这两个条件说明左边界起始的长度和p相同的字符串是一个字母异位词
                    ans.add(l);
                }
                char leftChar = s.charAt(l);
                //下面的操作就是如果窗口中存在左边界的字符，就将它的出现次数-1
                if (window.containsKey(leftChar)) {
                    window.put(leftChar, window.get(leftChar) - 1);
                    if (window.get(leftChar) < map.get(leftChar)) {     //当前窗口中左边界字符出现次数不足，将match-1
                        match--;
                    }
                }
                l++;
            }
        }
        return ans;
    }*/


    /**
     * 解法二：数组+滑动窗口
     * 使用数组替代哈希表以提升效率
     */
/*    public List<Integer> findAnagrams(String s, String p) {
        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();

        // 接收最后返回的结果
        List<Integer> ans = new ArrayList<>();

        // 定义一个 needs 数组来看 arrP 中包含元素的个数
        int[] needs = new int[26];
        // 定义一个 window 数组来看滑动窗口中是否有 arrP 中的元素，并记录出现的个数
        int[] window = new int[26];

        // 先将 arrP 中的元素保存到 needs 数组中
        for (int i = 0; i < arrP.length; i++) {
            needs[arrP[i] - 'a'] += 1;
        }

        // 定义滑动窗口的两端
        int left = 0;
        int right = 0;

        // 右窗口开始不断向右移动
        while (right < arrS.length) {
            int curR = arrS[right] - 'a';
            right++;
            // 将右窗口当前访问到的元素 curR 个数加 1
            window[curR] += 1;

            // 当 window 数组中 curR 比 needs 数组中对应元素的个数要多的时候就该移动左窗口指针
            while (window[curR] > needs[curR]) {
                int curL = arrS[left] - 'a';
                left++;
                // 将左窗口当前访问到的元素 curL 个数减 1
                window[curL] -= 1;
            }

            // 这里将所有符合要求的左窗口索引放入到了接收结果的 List 中
            if (right - left == arrP.length) {
                ans.add(left);
            }
        }
        return ans;
    }*/


    public List<Integer> findAnagrams(String s, String p) {
        int[] needs = new int[26];
        int[] window = new int[26];
        List<Integer> ans = new ArrayList<>();

        for (int i = 0; i < p.length(); i++) {
            needs[p.charAt(i) - 'a']++;
        }
        int l = 0, r = 0;
        while (r < s.length()) {
            int curR = s.charAt(r) - 'a';   //这里使用curR记录当前右边的索引比较好，因为下面判断窗口当前右边界元素要用到r
            window[curR]++;
            r++;
            while (window[curR] > needs[curR]) {
                window[s.charAt(l) - 'a']--;
                l++;
            }
            if (r - l == p.length()) {
                ans.add(l);
            }
        }
        return ans;
    }
}