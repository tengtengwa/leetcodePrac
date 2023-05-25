package practice.OfferSpecial;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class No005 {
    public static void main(String[] args) {
        Solution005 s = new Solution005();
        System.out.println(s.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
    }
}

/**
 * 题目：单词长度的最大乘积
 * 给定一个字符串数组words，请计算当两个字符串 words[i] 和 words[j] 不包含相同字符时，它们长度的乘积的最大值。
 * 假设字符串中只包含英语的小写字母。如果没有不包含相同字符的一对字符串，返回 0。
 *
 * 示例 2:
 *
 * 输入: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * 输出: 4
 * 解释: 这两个单词为 "ab", "cd"。
 *
 *
 * 示例 3:
 *
 * 输入: words = ["a","aa","aaa","aaaa"]
 * 输出: 0
 * 解释: 不存在这样的两个单词。
 */
class Solution005 {
    public int maxProduct(String[] words) {
        Queue<String> queue = new PriorityQueue<>((o1, o2) -> o1.length() - o2.length());
        for (int i = 0; i < words.length; i++) {
            int j = i + 1;
            for (; j < words.length; j++) {
                if (words[i].contains(words[j])) {
                    break;
                }
            }
            if (j == words.length) {
                queue.add(words[i]);
            }
        }
        switch (queue.size()) {
            case 0:
                return 0;
            case 2:
                return queue.remove().length() * queue.remove().length();
        }
        return 0;
    }
}