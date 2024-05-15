package practice.leetcode.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class No402 {
    public static void main(String[] args) {
        Solution402 s = new Solution402();
        System.out.println(s.removeKdigits("112", 1));
        System.out.println(s.removeKdigits("1234567890", 9));
    }
}

/**
 * 移掉 K 位数字
 * 给你一个以字符串表示的非负整数 num 和一个整数 k ，移除这个数中的 k 位数字，使得剩下的数字最小。
 * 请你以字符串形式返回这个最小的数字。
 */
class Solution402 {
    /**
     * 思路：贪心+单调栈
     * <a href="https://blog.csdn.net/qfc_128220/article/details/127407642?spm=1001.2014.3001.5502">csdn</a>
     * <a href="https://leetcode.cn/problems/remove-k-digits/solutions/484940/yi-diao-kwei-shu-zi-by-leetcode-solution/">leetcode</a>
     *
     */
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";  //特判：n个字符，删除n个，直接返回0
        Deque<Character> stack = new LinkedList<>();
        int remain = num.length() - k;  //移除k个字符后剩下的字符数量
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            //当k>0并且当前元素小于栈顶元素时，移除栈顶元素，直到栈顶元素<=当前元素，即数字"递增"
            //例如：[1234567890]，k=9时，当ch是0时，k为几就需要移除栈顶几个数
            while (stack.size() > 0 && k > 0 && stack.peek() > ch) {
                k--;
                stack.pop();
            }
            stack.push(ch); //当前字符压栈
        }
        //栈中元素递增，但还有需要移除的字符，则直接在栈顶移除最大的字符
        //例如：[112]，k=1，此时stack.size为3，remain为2，需要移除栈顶的2
        while (stack.size() > remain) {
            stack.pop();
        }
        //移除所有的前导0
        while (stack.getLast() == '0' && stack.size() > 1) stack.removeLast();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.removeLast());
        return sb.toString();
    }
}