package practice.leetcode.StackAndQueue;

import java.util.LinkedList;
import java.util.Queue;

public class No225 {
    public static void main(String[] args) {
        MyStack stack = new MyStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.pop();
        stack.push(4);
        stack.top();
    }
}


/**
 * 题目：用队列实现栈
 * 使用队列实现栈的下列操作：
 * push(x) -- 元素 x 入栈
 * pop() -- 移除栈顶元素
 * top() -- 获取栈顶元素
 * empty() -- 返回栈是否为空
 *
 */

/**
 * 解法一：用两个队列实现栈
 * 思路：主要要保证将元素入队后队首元素是最后加入的。所以实现思路就是在将元素入栈时，先将元素入队2，再将队1中所有元素入队2，接着交换
 * 队1队2即可保证队首是最后加入的元素。
 */
/*class MyStack {

    private Queue<Integer> queue1;

    private Queue<Integer> queue2;

    //Initialize your data structure here.
    public MyStack() {
        queue1 = new LinkedList<>();

        queue2 = new LinkedList<>();
    }

    //Push element x onto stack.
    public void push(int x) {
        queue2.offer(x);
        while (!queue1.isEmpty()) {
            queue2.offer(queue1.poll());
        }
        Queue<Integer> tem = queue1;
        queue1 = queue2;
        queue2 = tem;
    }

    //Removes the element on top of the stack and returns that element.
    public int pop() {
        return queue1.poll();
    }

    //Get the top element.
    public int top() {
        return queue1.peek();
    }

    //Returns whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty();
    }
}*/

/**
 * 解法二：使用一个栈
 *
 * 思路：同样在入队时候“做做手脚”。先将当前元素入队，再将前面所有元素重新入队，这样就保证当前队首是最后加入的元素了
 *
 * 时间、空间：O(n)
 */
class MyStack {

    private Queue<Integer> queue;

    //Initialize your data structure here.
    public MyStack() {
        queue = new LinkedList<>();
    }


    //Push element x onto stack.
    public void push(int x) {
        int num = queue.size();             //注意先记录当前队列中元素数量
        queue.offer(x);                     //再将当前元素入队
        for (int i = 0; i < num; i++) {     //下面将前面的元素重新入队
            queue.offer(queue.poll());
        }
    }

    //Removes the element on top of the stack and returns that element.
    public int pop() {
        return queue.poll();
    }

    //Get the top element.
    public int top() {
        return queue.peek();
    }

    //Returns whether the stack is empty.
    public boolean empty() {
        return queue.isEmpty();
    }
}