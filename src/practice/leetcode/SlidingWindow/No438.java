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
     * ��Ŀ���ҵ��ַ�����������ĸ��λ��
     * �����ַ������⣬�������Ӵ�ʲô�Ļ����Ͼ��ǻ������ڽⷨ��
     *
     * �ⷨһ����ϣ��+��������
     * ˼·��ʹ��������ϣ��һ����¼p��ÿ���ַ����ֵĴ�������һ����¼��ǰ������ÿ���ַ����ֵĴ�����
     * ��map�а�����ǰ�ұ߽�ָ����ַ�ʱ������ǰ�����д��ַ����ִ���+1�����������ұ߽������ƶ���
     * �����ǰ�����������ַ����ִ������������ˣ��ͽ���whileѭ������ѭ���������ǰ���ڳ����Ƿ�Ϊp�ĳ��ȣ�����һ���⣻
     * ͬʱ��С��߽粢���ٵ�ǰ�����ַ����ִ�����
     *
     * ʱ�䣺O(n)���ռ䣺O(n)
     */
/*    public List<Integer> findAnagrams(String s, String p) {
        HashMap<Character, Integer> map = new HashMap<>();
        HashMap<Character, Integer> window = new HashMap<>();
        List<Integer> ans = new ArrayList<>();

        for (char ch : p.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);   //�Ϸ����ˣ�û�е�ǰԪ��ֵ��Ϊ0������+1
        }
        int l = 0, r = 0, match = 0;
        while (r < s.length()) {
            char ch = s.charAt(r);
            if (map.containsKey(ch)) {
                window.put(ch, window.getOrDefault(ch, 0) + 1);
                //�Ƚ�Integer��ֵͨ��compareTo��equals������ʹ��==�Ƚ�[-128~127]�����ֵ�������ΪIntegerֻ�Ỻ���������
                // ��Integer���󣬳������������Ҫ���´�������Ƚ����õ�ǰ�������
                if (window.get(ch).compareTo(map.get(ch)) == 0) {   //�����ǰ���ڸ��ַ����ִ����Ѿ��������ˣ���match+1
                    match++;
                }
            }
            r++;    //��Ϊ�����Ƚ��ұ߽������ˣ�����������㴰�ڳ���ʱ����+1
            while (match == map.size()) {   //���������ʱ��ʾ�˴����д���p����ĸ��λ��
                if (r - l == p.length()) {  //ͬʱ��������������˵����߽���ʼ�ĳ��Ⱥ�p��ͬ���ַ�����һ����ĸ��λ��
                    ans.add(l);
                }
                char leftChar = s.charAt(l);
                //����Ĳ���������������д�����߽���ַ����ͽ����ĳ��ִ���-1
                if (window.containsKey(leftChar)) {
                    window.put(leftChar, window.get(leftChar) - 1);
                    if (window.get(leftChar) < map.get(leftChar)) {     //��ǰ��������߽��ַ����ִ������㣬��match-1
                        match--;
                    }
                }
                l++;
            }
        }
        return ans;
    }*/


    /**
     * �ⷨ��������+��������
     * ʹ�����������ϣ��������Ч��
     */
/*    public List<Integer> findAnagrams(String s, String p) {
        char[] arrS = s.toCharArray();
        char[] arrP = p.toCharArray();

        // ������󷵻صĽ��
        List<Integer> ans = new ArrayList<>();

        // ����һ�� needs �������� arrP �а���Ԫ�صĸ���
        int[] needs = new int[26];
        // ����һ�� window �������������������Ƿ��� arrP �е�Ԫ�أ�����¼���ֵĸ���
        int[] window = new int[26];

        // �Ƚ� arrP �е�Ԫ�ر��浽 needs ������
        for (int i = 0; i < arrP.length; i++) {
            needs[arrP[i] - 'a'] += 1;
        }

        // ���廬�����ڵ�����
        int left = 0;
        int right = 0;

        // �Ҵ��ڿ�ʼ���������ƶ�
        while (right < arrS.length) {
            int curR = arrS[right] - 'a';
            right++;
            // ���Ҵ��ڵ�ǰ���ʵ���Ԫ�� curR ������ 1
            window[curR] += 1;

            // �� window ������ curR �� needs �����ж�ӦԪ�صĸ���Ҫ���ʱ��͸��ƶ��󴰿�ָ��
            while (window[curR] > needs[curR]) {
                int curL = arrS[left] - 'a';
                left++;
                // ���󴰿ڵ�ǰ���ʵ���Ԫ�� curL ������ 1
                window[curL] -= 1;
            }

            // ���ｫ���з���Ҫ����󴰿��������뵽�˽��ս���� List ��
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
            int curR = s.charAt(r) - 'a';   //����ʹ��curR��¼��ǰ�ұߵ������ȽϺã���Ϊ�����жϴ��ڵ�ǰ�ұ߽�Ԫ��Ҫ�õ�r
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