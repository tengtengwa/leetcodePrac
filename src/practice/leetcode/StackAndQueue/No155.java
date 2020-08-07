package practice.leetcode.StackAndQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class No155 {
    public static void main(String[] args) {


    }
}

/**
 * ��Ŀ����Сջ��Ҫ��getMin����ʱ�临�Ӷ�ΪO(1)�����ݽṹ��ջ��list������ȶ�����
 * �ⷨһ��ʹ�ø���ջ
 * <p>
 * ʱ�䣺O(1)���ռ�O(N)
 * <p>
 * ��ʹ�ø���ջ��-inf 3 3 2 2 1 5 6
 * public void push(int x) {
 * if(min >= x){        //�����С��ֵxʱ���Ƚ���Сֵmin��ջ���ٷ��뵱ǰ��Сֵ
 * stack.push(min);
 * min = x;
 * }
 * stack.push(x);
 * }
 * <p>
 * public void pop() {
 * if(stack.pop() == min){  //����Сֵ��ջʱ������һ��Ԫ�ؾ��Ǵ�Сֵ������ǰ��Сֵ����Ϊ��Сֵ
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
 * �ⷨ��������������
 *
 * O(N)��O(1)
 * ÿ���ڵ����Сֵmin����ǰ�ڵ㵽�����β�����нڵ����Сֵ���൱��ά����һ��minֵ�����ݼ�������
 * ����Ԫ�س�ջ��getMin���صĻ��ǵ�ǰ��Сֵ
 */
class MinStack {

    Node head;

    public MinStack() {
    }

    public void push(int x) {
        if (head == null) {
            head = new Node(x, x);
        } else {
            head = new Node(x, Math.min(x, head.min), head);    //newNode -> head��headΪ��ǰͷ���
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