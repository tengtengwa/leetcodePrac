package practice.leetcode.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class No155 {
    public static void main(String[] args) {


    }
}

/**
 * 题目：最小栈，要求getMin方法时间复杂度为O(1)，数据结构用栈、list、链表等都可以
 * 解法一：使用辅助栈
 * <p>
 * 时间：O(1)，空间O(N)
 * <p>
 * 不使用辅助栈：-inf 3 3 2 2 1 5 6
 * public void push(int x) {
 * if(min >= x){        //放入更小的值x时，先将次小值min入栈，再放入当前最小值
 * stack.push(min);
 * min = x;
 * }
 * stack.push(x);
 * }
 * <p>
 * public void pop() {
 * if(stack.pop() == min){  //将最小值出栈时，后面一个元素就是次小值，将当前最小值更新为次小值
 * min = stack.pop();
 * }
 * }
 */
/*class MinStack {

    Deque<Integer> stack;
    Deque<Integer> assistStack;


    public MinStack() {
        stack = new ArrayDeque<>();
        assistStack = new ArrayDeque<>();
        assistStack.add(Integer.MIN_VALUE);
    }

    public void push(int x) {
        stack.add(x);
        if (stack.size() != 1) {
            assistStack.add(Math.min(x, assistStack.peekLast()));
        } else {
            assistStack.add(x);
        }
    }

    public void pop() {
        stack.removeLast();
        assistStack.removeLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int getMin() {
        return assistStack.peekLast();
    }
}*/


/**
 * 解法二：建立单链表
 *
 * O(N)、O(1)
 * 每个节点的最小值min代表当前节点到链表表尾的所有节点的最小值，相当于维护了一个min值单调递减的链表，
 * 所以元素出栈后，getMin返回的还是当前最小值
 */
class MinStack {

    Node head;

    public MinStack() {
    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(x, head.min), head);    //newNode -> head，head为当前头结点
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
    }

    static class Node {
        int val;
        int min;
        Node next;

        public Node(int val, int min) {
            this(val, min, null);
        }

        public Node(int val, int min, Node next) {
            this.val = val;
            this.min = min;
            this.next = next;
        }
    }
}