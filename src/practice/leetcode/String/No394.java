package practice.leetcode.String;

import java.util.*;

public class No394 {
    public static void main(String[] args) {
        Solution394 s = new Solution394();
        s.decodeString("3[a2[c]]");
        //"3[z]2[2[y]pq4[2[jk]e1[f]]]ef"
    }
}

class Solution394 {
    /**
     * 题目字符串解码：给定一个经过编码的字符串，返回它解码后的字符串。
     * <p>
     * 解法一：栈
     * 利用栈来解，栈中存储String类型的元素，所以数字需要进行转换
     * 1.遇到字母或'['直接入栈；
     * 2.因为测试用例中有次数上百的，所以遇到数字需要向后继续寻找数字，并将它们转换为一个String并入栈；
     * 3.遇到']'时进行出栈，直到出现'['。需要注意的是出栈后的所有字符串顺序是颠倒的，所以需要使用一个列表将它们反转（不能用SB，
     * 因为每个String中字符的顺序是正确的，只是这些元素的顺序是反的）；而且遇到'['时需要将它出栈
     * <p>
     * 时间、空间：O(S)，记解码后得出的字符串长度为S
     */
/*    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        int index = 0;

        while (index < s.length()) {    //因为遇到数字时需要继续向后遍历，所以不能使用增强for循环
            char ch = s.charAt(index);
            //遇到数字，继续向后遍历，将这个数整个转换为一个String
            if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                while (Character.isDigit(s.charAt(index))) {
                    sb.append(s.charAt(index++));
                }
                stack.add(sb.toString());
            } else if (ch == '[' || Character.isLetter(ch)) {   //'['和字母直接入栈
                stack.add(String.valueOf(ch));
                index++;
            } else {        //遇到']'
                //将上一个'['之前的所有字符串存入一个list并反转它们的顺序（注意不能用StringBuilder）
                List<String> temlist = new LinkedList<>();
                while (!stack.peekLast().equals("[")) {
                    temlist.add(stack.pollLast());
                }
                Collections.reverse(temlist);
                stack.pollLast();       //去除左括号！
                //左括号前必是重复次数
                int time = Integer.parseInt(stack.pollLast());
                StringBuilder tem = new StringBuilder();
                //这个方法将list中反转顺序后的所有元素拼接成一个String
                String curStr = getString(temlist);
                while (time > 0) {
                    --time;
                    tem.append(curStr);
                }
                stack.add(tem.toString());
                index++;
            }
        }

//        StringBuilder sb = new StringBuilder();
//        for (String str : stack) {
//            sb.append(str);
//        }
//        return sb.toString();
        //以上代码可以使用下面的方法替换
        return String.join("", stack);
    }

    private String getString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }*/


    /**
     * 解法二：递归
     * 思路：
     * 1.遇到数字，解析当前k[]，我们可以先解析出一个数字，然后解析到了左括号，递归向下解析后面的内容，遇到对应的右括号就返回；
     * 解析当前k[]后继续递归解析后面的字符
     * 2.遇到字母，直接解析当前这个字母，然后递归向下解析这个字母后面的内容。
     */
    int index = 0;
    String str;

    public String decodeString(String s) {
        str = s;
        return getString();
    }

    private String getString() {
        //递归先考虑退出条件
        if (index == str.length() || str.charAt(index) == ']') {
            return "";
        }

        char ch = str.charAt(index);
        String ret = "";

        //遇到了数字，解析当前k[]到ret
        if (Character.isDigit(ch)) {
            int time = getTime();
            ++index;    //过滤左括号
            String next = getString();  //递归解析后面的字符
            ++index;    //过滤右括号
            while (time > 0) {
                ret += next;
                --time;
            }
        } else if (Character.isLetter(ch)) {    //当前字符是字母，只解析当前字符为String
            ret = String.valueOf(ch);
            index++;
        }
        return ret + getString();   //继续解析后面的字符
    }

    private int getTime() {
        int time = 0;
        while (Character.isDigit(str.charAt(index))) {
            time = time * 10 + str.charAt(index++) - '0';   //要么这样计算次数，要么调用parseInt方法
        }
        return time;
    }
}