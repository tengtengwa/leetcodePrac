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
 * ��Ŀ���ö���ʵ��ջ
 * ʹ�ö���ʵ��ջ�����в�����
 * push(x) -- Ԫ�� x ��ջ
 * pop() -- �Ƴ�ջ��Ԫ��
 * top() -- ��ȡջ��Ԫ��
 * empty() -- ����ջ�Ƿ�Ϊ��
 *
 */

/**
 * �ⷨһ������������ʵ��ջ
 * ˼·����ҪҪ��֤��Ԫ����Ӻ����Ԫ����������ġ�����ʵ��˼·�����ڽ�Ԫ����ջʱ���Ƚ�Ԫ�����2���ٽ���1������Ԫ�����2�����Ž���
 * ��1��2���ɱ�֤�������������Ԫ�ء�
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
 * �ⷨ����ʹ��һ��ջ
 *
 * ˼·��ͬ�������ʱ�������ֽš����Ƚ���ǰԪ����ӣ��ٽ�ǰ������Ԫ��������ӣ������ͱ�֤��ǰ�������������Ԫ����
 *
 * ʱ�䡢�ռ䣺O(n)
 */
class MyStack {

    private Queue<Integer> queue;

    //Initialize your data structure here.
    public MyStack() {
        queue = new LinkedList<>();
    }


    //Push element x onto stack.
    public void push(int x) {
        int num = queue.size();             //ע���ȼ�¼��ǰ������Ԫ������
        queue.offer(x);                     //�ٽ���ǰԪ�����
        for (int i = 0; i < num; i++) {     //���潫ǰ���Ԫ���������
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