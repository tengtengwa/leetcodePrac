package practice.leetcode.DailyQuestion;

import java.util.LinkedList;
import java.util.Queue;

public class No225 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.top();
        stack.empty();
    }
}

class MyStack {

    private Queue<Integer> queue;

    /** Initialize your data structure here. */
    public MyStack() {
        queue = new LinkedList<>();
    }

    /** Push element x onto stack. */
    public void push(int x) {
        queue.add(x);
    }

    /** Removes the element on top of the stack and returns that element. */
    //链表表尾相当于栈顶，pop将栈顶出栈
    public int pop() {
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
        return queue.poll();
    }

    /** Get the top element. */
    public int top() {
        for (int i = 0; i < queue.size() - 1; i++) {
            queue.add(queue.poll());
        }
        int ans = queue.poll();
        queue.add(ans);
        return ans;
    }

    /** Returns whether the stack is empty. */
    public boolean empty() {
        return queue.size() == 0;
    }
}
