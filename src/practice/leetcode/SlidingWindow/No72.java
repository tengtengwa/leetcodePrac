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
     * �������� �������ַ���xxx������С�Ӵ�����һ�����Ҫʹ�û�����������ġ��������ڣ�˵���˾���˫ָ�룬û�ж�ô�ߴ��ϡ�
     * ��������˼·��
     * 1.���������ұ߽�ʹ������������ֱ�����ڰ�����T������Ԫ�أ���ʱneed������Ԫ�ص�������С�ڵ���0�����ֵ���Ч�ַ���С��0����ЧԪ�ض�Ϊ0��
     * ��ͬʱneedCntҲ��0
     * 2.������С��߽�ʹ����������С��ֱ������һ�����������Ԫ��A����ʱ��¼���ȸ��½��
     * 3.��߽�����һ��λ�ã���ʼѰ����һ�����������Ļ�������
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
        for (char ch : t.toCharArray()) {       //�����д���ַ���t�������ַ����ִ���
            need[ch]++;
        }
        while (r < s.length()) {                //�����������Ǵ���û�л���ȥ
            if (need[s.charAt(r)] > 0) {        //���s������r���ַ�������t�У�Ϊ��Ч�ַ�����ʱneedCount-1
                needCount--;
            }
            need[s.charAt(r)]--;        //�����Ƿ�����Ч�ַ���need�ж�Ӧ�Ĵ���������١�������������߽�ʱ��Ч�ַ�������ʹneedCount+1
            while (needCount == 0) {
                if (r - l < min) {      //t���ַ�ȫ�������ڴ��ڵķ�Χ���ˣ���ʱ����min�ʹ��ַ����Ŀ�ʼ����
                    start = l;
                    min = r - l;
                }
                need[s.charAt(l)]++;    //��Ч�ַ�+1���Ȼ>0����������needCount��+1��s�г��ֵ���Ч�ַ�+1���Ȼ<=0
                if (need[s.charAt(l)] > 0) {
                    needCount++;
                }
                l++;                    //�����Ƿ�����Ч�ַ�����߽綼+1
            }
            r++;
        }
        return start == -1 ? "" : s.substring(start, start + min + 1);  //ע��,���substring����ȡ�ķ�ΧΪ[left,right)
    }
}