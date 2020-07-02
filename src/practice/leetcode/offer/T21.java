package practice.leetcode.offer;

import java.util.Stack;

public class T21 {
    public static void main(String[] args) {
        SolutionT21 s = new SolutionT21();
        s.push(3);
        s.push(4);
        s.push(2);
        s.min();
        s.pop();
    }
}

class SolutionT21 {

    Stack<Integer> stack = new Stack<>();
    Stack<Integer> assStack = new Stack<>();    //����ջ

    public void push(int node) {    //ѹջԪ�����С�ڸ���ջջ��Ԫ�ؾ�ѹ�븨��ջ������ѹ��ջ����СԪ��
        stack.push(node);
        if(assStack.empty()) assStack.push(node);
        else assStack.push(node > assStack.peek() ? assStack.peek() : node);
    }

    public void pop() {
        stack.pop();
        assStack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return assStack.peek();
    }
}