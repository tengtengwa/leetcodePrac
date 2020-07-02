package practice.leetcode.offer;

import java.util.Arrays;

public class T4 {
    public static void main(String[] args) {
        SolutionT4 s = new SolutionT4();
        String str = s.replaceSpace(new StringBuffer("hello world"));
        int len = str.length();
    }
}

/**
 * ��Ŀ����ʵ��һ����������һ���ַ����е�ÿ���ո��滻�ɡ�%20�������磬���ַ���ΪWe Are Happy.�򾭹��滻֮����ַ���Ϊ
 * We%20Are%20Happy��
 */
class SolutionT4 {

    /**
     * �ⷨһ��StringBuilder��replace�����ײ�ʹ��System.arrayCopy����ʵ�ֵģ�ÿ���滻��Ҫ������������ַ�����һ�Σ�
     * ����ʱ�临�Ӷ�ΪO(n^2)
     */
/*    public String replaceSpace(StringBuffer str) {
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == ' ') {
                str.replace(i, i + 1, "%20");
            }
        }
        return str.toString();
    }*/

    /**
     * �ⷨ�����ȱ���һ�����飬�����滻����ַ����ȣ���ͨ��˫ָ�룬�Ӻ���ǰ���������ַ��������ո�Ͱ��滻���ַ������Ƶ����棬
     * ʱ�临�Ӷ�ΪO(n)
     */
    public String replaceSpace(StringBuffer str) {
        int blank = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                blank++;
            }
        }
        int len = str.length() + (blank << 1);
        int front = str.length() - 1;
        int back = len - 1;
        char[] arr = new char[len];
        while (front >= 0) {
            if (str.charAt(front) != ' ') {
                arr[back--] = str.charAt(front);
            } else {
                arr[back--] = '0';
                arr[back--] = '2';
                arr[back--] = '%';
            }
            front--;
        }
        return Arrays.toString(arr);
    }
}