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
 * 题目：请实现一个函数，将一个字符串中的每个空格替换成“%20”。例如，当字符串为We Are Happy.则经过替换之后的字符串为
 * We%20Are%20Happy。
 */
class SolutionT4 {

    /**
     * 解法一，StringBuilder的replace方法底层使用System.arrayCopy方法实现的，每次替换需要将后面的所有字符复制一次，
     * 所以时间复杂度为O(n^2)
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
     * 解法二，先遍历一遍数组，计算替换后的字符长度，再通过双指针，从后向前遍历复制字符，遇到空格就把替换的字符串复制到后面，
     * 时间复杂度为O(n)
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