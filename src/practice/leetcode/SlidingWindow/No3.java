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
    //��������
/*    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, ans = 0;              //����ָ��
        while (i < n && j < n) {
            if (!set.contains(s.charAt(j))) {   //set�в�������ǰλ���ַ�
                set.add(s.charAt(j++));         //����ǰ�ַ�����set��������ָ�����
                ans = Math.max(ans, j - i);     //�������ظ���ִ������ֵ
            } else {                            //set�а�����ǰλ���ַ�
                set.remove(s.charAt(i++));      //�����ַ��Ƴ���������ָ�����
            }
        }
        return ans;
    }*/

    //�Ż��Ļ�������
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();
        int ans = 0;
        for (int j = 0, i = 0; j < n; j++) {
            if (map.containsKey(s.charAt(j))) {
                //i�����͵�ǰ�ַ��ظ�����һ���ַ�����һ��λ��,ȡmax��Ϊ�˷�ֹi����
                i = Math.max(map.get(s.charAt(j)), i);
            }
            ans = Math.max(ans, j - i + 1);	//ÿ��ѭ���������ֵ
            map.put(s.charAt(j), j + 1);        //�˴���map�д��浱ǰλ���ַ�����һ��λ��
        }
        return ans;
    }
}