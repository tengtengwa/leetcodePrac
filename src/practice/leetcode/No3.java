package practice.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No3 {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.println(s.lengthOfLongestSubstring("pwwkew"));
    }
}

/*
//�ҵ����
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


/*//�Ż��Ļ�������
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

//��������
class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        int len = s.length();
        int L = 0;
        int R = 0;
        int ans = 0;
        HashSet<Character> set = new HashSet<>();
        while (L < len && R < len) {
            if (!set.contains(s.charAt(R))) {
                set.add(s.charAt(R++));         //��������һλ
                ans = Math.max(ans, R - L);     //���µ�ǰ�ִ���󳤶�
            } else {
                set.remove(s.charAt(L++));      //������ظ����ַ�����϶��ǵ�ǰλ�õ��ַ�������ߵ��ַ��ظ�������Ƴ�����������ߵ�Ԫ��
            }
        }
        return ans;
    }
}

