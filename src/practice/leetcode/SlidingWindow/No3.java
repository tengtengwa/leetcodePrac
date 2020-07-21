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
     * ��ͨ�Ļ������ڽⷨ��set�д�ŵ�ǰ���ڳ��ֵ������ַ���ÿ�������ظ����ַ���������ߵ��ַ��Ƴ�set��
     * ��߽�ÿ���ƶ�һλ��ֱ����ǰ�ַ���set��û���ظ����ұ߽�������ƶ���
     * �����Ż��ĵط����ڣ��ڳ����ظ��ַ�ʱ����߽�ֱ�������ͼ������ظ��ַ��ĺ���
     *
     */
/*    public int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int i = 0, j = 0, ans = 0;              //����ָ��
        while (j < n) {                //i<n��ֹ���ֿ��ַ����ַ���
            if (!set.contains(s.charAt(j))) {   //set�в�������ǰλ���ַ�
                set.add(s.charAt(j++));         //����ǰ�ַ�����set��������ָ�����
                ans = Math.max(ans, j - i);     //�������ظ���ִ������ֵ
            } else {                            //set�а�����ǰλ���ַ�
                set.remove(s.charAt(i++));      //�����ַ��Ƴ���������ָ�����
            }
        }
        return ans;
    }*/

    /**
     * �Ż��Ļ�������
     * Map��Ԫ�صĺ���Ϊ��ÿ����ǰ�ַ���map��ĳ���ַ��ظ�������Ҫ��߽���������ַ���Ӧ��value����
     * ����abcc����ʱmap��c�ļ�ֵ�ԣ�c->3����߽��ֱ������3�������
     */
/*    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        HashMap<Character, Integer> map = new HashMap<>();      //map�д洢ÿ�����ظ��ַ�����һ��λ��
        int ans = 0;
        for (int r = 0, l = 0; r < n; r++) {
            if (map.containsKey(s.charAt(r))) {         //���map���Ѿ�������ǰ�ַ�����������߽����
                //l�����͵�ǰ�ַ��ظ�����һ���ַ�����һ��λ��,ȡmax��Ϊ�˷�ֹl����
                l = Math.max(map.get(s.charAt(r)), l);
            }
            ans = Math.max(ans, r - l + 1);        //ÿ��ѭ���������ֵ
            map.put(s.charAt(r), r + 1);        //�˴���map�д��浱ǰλ���ַ�����һ��λ��
        }
        return ans;
    }*/


    /**
     * Ҳ����ʹ���������滻map��keyΪ���ַ���ASCII�룬valueΪ��ASCII���������ж�Ӧ��Ԫ�أ������ظ��ַ�����һ��λ��
     */
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int[] map = new int[128];      //map�д洢ÿ�����ظ��ַ�����һ��λ��
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