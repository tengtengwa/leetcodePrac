package practice.leetcode.DailyQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class No820 {
    public static void main(String[] args) {
        Solution s = new Solution();
        s.minimumLengthEncoding(new String[]{"time", "me", "bell"});
    }
}

class Solution820 {
    public int minimumLengthEncoding(String[] words) {
        HashSet<String> set = new HashSet<>(Arrays.asList(words));
        for (String str : words) {
            for (int j = 1; j < str.length(); j++) {
                set.remove(str.substring(j));
            }
        }
        int ans = 0;
        for (String str : set) {
            ans += str.length() + 1;
        }
        return ans;
    }
}

class Solution {
    public int minimumLengthEncoding(String[] words) {
        TrieNode trie = new TrieNode();
        Map<TrieNode, Integer> nodes = new HashMap();

        for (int i = 0; i < words.length; ++i) {
            String word = words[i];
            TrieNode cur = trie;
            for (int j = word.length() - 1; j >= 0; --j)
                cur = cur.get(word.charAt(j));
            nodes.put(cur, i);
        }

        int ans = 0;
        for (TrieNode node: nodes.keySet()) {
            if (node.count == 0)
                ans += words[nodes.get(node)].length() + 1;
        }
        return ans;

    }
}

class TrieNode {
    TrieNode[] children;
    int count;
    TrieNode() {
        children = new TrieNode[26];
        count = 0;
    }
    public TrieNode get(char c) {
        if (children[c - 'a'] == null) {
            children[c - 'a'] = new TrieNode();
            count++;
        }
        return children[c - 'a'];
    }
}