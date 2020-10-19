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
     * 题目：翻转字符串里的单词。也就是反转字符串中所有单词的顺序
     * 例如：
     * 输入："the sky is blue"     "  hello world!  "
     * 输出："blue is sky the"     "world! hello"
     * 输入字符串可以在前面或者后面包含多余的空格，但是反转后的字符不能包括。
     *
     * 解法一：使用语言特性
     * 1.使用 split 将字符串按空格分割成字符串数组；
     * 2.使用 reverse 将字符串数组进行反转；
     * 3.使用 join 方法将字符串数组拼成一个字符串。
     * 时间、空间：O(n)
     */
/*    public String reverseWords(String s) {
        // 除去开头和末尾的空白字符
        s = s.trim();
        // 正则匹配连续的空白字符作为分隔符分割
        List<String> wordList = Arrays.asList(s.split("\\s+"));
        Collections.reverse(wordList);
        return String.join(" ", wordList);
    }*/

    /**
     * 解法二：自行编写函数实现
     * 思路：从后向前遍历一次字符串，每遇到一个单词，就将它放到StringBuilder末尾。
     * 时间、空间：O(n)
     */
/*    public String reverseWords(String s) {
        s = " " + s;
        int len = s.length();
        boolean isWord = false;
        int start = len - 1, end = len - 1;
        StringBuilder sb = new StringBuilder();

        while (start >= 0) {
            if (!isWord && s.charAt(start) == ' ') {    //还没有遇到字符，start和end向前进1
                start--;
                end--;
                continue;
            } else if (isWord && s.charAt(start) == ' ') {  //end及之前是单词，并且当前位置是当前单词首字母前一个位置的空格
                isWord = false;
                sb.append(s, start + 1, end + 1);   //如果字符串前面没有空格，反转后第一个单词就会少一个字母。
                sb.append(' ');
                end = start;
                continue;
            }
            //不是上面两种情况，也就是说当前位置是字符，表明遇到了单词。end记录单词末尾字母位置，start开始向前移动
            start--;
            isWord = true;
        }
        return sb.toString().trim();    //清除最后的空格
    }*/


    /**
     * 解法三：使用双端队列将每个单词压入队头，再将队列转为字符串即可。
     */
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        // 去掉字符串开头的空白字符
        while (left <= right && s.charAt(left) == ' ') {
            ++left;
        }

        // 去掉字符串末尾的空白字符
        while (left <= right && s.charAt(right) == ' ') {
            --right;
        }

        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while (left <= right) {
            char c = s.charAt(left);
            if ((word.length() != 0) && (c == ' ')) {
                // 将单词 push 到队列的头部
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