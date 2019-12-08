package practice.leetcode.String;

import java.util.*;

public class No30 {
    public static void main(String[] args) {
//        Solution30 s = new Solution30();
//        s.findSubstring("wordgoodgoodgoodbestword", new String[]{"word", "good", "best", "word"});
    }
}

class Solution30 {
    //Ê±¼ä³¬ÏÞ
/*    List<String> strings = new ArrayList<>();
    HashSet<String> set = new HashSet<>(strings);
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return res;
        }
        List<String> strs = new ArrayList<>(Arrays.asList(words));
        backTrack(strs, words, 0);
        for (String list : set) {
            int index = 0;
            String str = String.join("", list);
            while ((index = s.indexOf(str, index)) != -1) {
                if (!res.contains(index)) {
                    res.add(index);
                    index += str.length();
                }
            }
        }
        return res;
    }

    private void backTrack(List<String> list, String[] words, int index) {
        if (index >= words.length) {
            strings.add(String.join("", list));
        } else {
            for (int i = index; i < words.length; i++) {
                Collections.swap(list, index, i);
                backTrack(list, words, index + 1);
                Collections.swap(list, index, i);
            }
        }
    }*/
}