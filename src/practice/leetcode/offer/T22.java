package practice.leetcode.offer;

import java.util.Stack;

public class T22 {
    public static void main(String[] args) {
        SolutionT22 s = new SolutionT22();
        boolean flag = s.IsPopOrder(new int[]{1, 2, 3, 4, 5}, new int[]{4, 3, 5, 1, 2});

    }
}

class SolutionT22 {
    public boolean IsPopOrder(int[] pushA, int[] popA) {
        if (pushA == null || popA == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int num : popA) {      //遍历出栈序列
            while (stack.empty() || stack.peek() != num) {  //如果下一个弹出元素不在栈顶，就将pushA中还没有入栈的数字压栈
                if (i == pushA.length) {    //如果当前栈中还有元素并且把所有数字都入栈了还找不到下一个弹栈数字，就不是一个弹栈序列
                    return false;
                }
                stack.push(pushA[i++]);
            }
            stack.pop();    //下一个数字是栈顶元素，直接弹出
        }
        return true;
    }
}