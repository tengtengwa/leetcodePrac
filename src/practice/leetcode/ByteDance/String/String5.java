package practice.leetcode.ByteDance.String;

import java.util.*;

public class String5 {
    public static void main(String[] args) {
        SolutionString5 s = new SolutionString5();
        s.reverseWords("the sky is blue");
    }
}

class SolutionString5 {
    /**
     * ��Ŀ����ת�ַ�����ĵ��ʡ�Ҳ���Ƿ�ת�ַ��������е��ʵ�˳��
     * ���磺
     * ���룺"the sky is blue"     "  hello world!  "
     * �����"blue is sky the"     "world! hello"
     * �����ַ���������ǰ����ߺ����������Ŀո񣬵��Ƿ�ת����ַ����ܰ�����
     *
     * �ⷨһ��ʹ����������
     * 1.ʹ�� split ���ַ������ո�ָ���ַ������飻
     * 2.ʹ�� reverse ���ַ���������з�ת��
     * 3.ʹ�� join �������ַ�������ƴ��һ���ַ�����
     * ʱ�䡢�ռ䣺O(n)
     */
/*    public String reverseWords(String s) {
        // ��ȥ��ͷ��ĩβ�Ŀհ��ַ�
        s = s.trim();
        // ����ƥ�������Ŀհ��ַ���Ϊ�ָ����ָ�
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }*/

    /**
     * �ⷨ�������б�д����ʵ��
     * ˼·���Ӻ���ǰ����һ���ַ�����ÿ����һ�����ʣ��ͽ����ŵ�StringBuilderĩβ��
     * ʱ�䡢�ռ䣺O(n)
     */
/*    public String reverseWords(String s) {
        s = " " + s;
        int len = s.length();
        boolean isWord = false;
        int start = len - 1, end = len - 1;
        StringBuilder sb = new StringBuilder();

        while (start >= 0) {
            if (!isWord && s.charAt(start) == ' ') {    //��û�������ַ���start��end��ǰ��1
                start--;
                end--;
                continue;
            } else if (isWord && s.charAt(start) == ' ') {  //end��֮ǰ�ǵ��ʣ����ҵ�ǰλ���ǵ�ǰ��������ĸǰһ��λ�õĿո�
                isWord = false;
                sb.append(s, start + 1, end + 1);   //����ַ���ǰ��û�пո񣬷�ת���һ�����ʾͻ���һ����ĸ��
                sb.append(' ');
                end = start;
                continue;
            }
            //�����������������Ҳ����˵��ǰλ�����ַ������������˵��ʡ�end��¼����ĩβ��ĸλ�ã�start��ʼ��ǰ�ƶ�
            start--;
            isWord = true;
        }
        return sb.toString().trim();    //������Ŀո�
    }*/


    /**
     * �ⷨ����ʹ��˫�˶��н�ÿ������ѹ���ͷ���ٽ�����תΪ�ַ������ɡ�
     */
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        // ȥ���ַ�����ͷ�Ŀհ��ַ�
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // ȥ���ַ���ĩβ�Ŀհ��ַ�
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // ������ push �����е�ͷ��
                d.offerFirst(word.toString());
                word.setLength(0);
            } else if (c != ' ') {
                word.append(c);
            }
            ++left;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }
}