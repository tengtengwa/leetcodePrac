package practice.leetcode.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class O9 {
    public static void main(String[] args) {
        CQueue queue = new CQueue();
        queue.appendTail(1);
        queue.appendTail(2);
        queue.appendTail(3);
        queue.deleteHead();
        queue.appendTail(4);
        queue.deleteHead();
        queue.deleteHead();
        queue.deleteHead();
    }
}

/**
 * 题目：用两个栈实现一个队列
 *
 * 思路：放入元素的时候正常放入栈1。当删除队列头结点时，如果栈2为空，则先将栈1的元素全部出栈并加入栈2,这样后面再要删除头结点时就先从
 * 栈2中出栈元素即可。如果栈2栈1都为空，则此时队列中没有元素。
 *
 * 时间：O(1)。对于插入和删除操作，时间复杂度均为O(1)。插入不多说，对于删除操作，虽然看起来是O(n)的时间复杂度，
 * 但是仔细考虑下每个元素只会「至多被插入和弹出 stack2 一次」，因此均摊下来每个元素被删除的时间复杂度仍为O(1)。
 *
 * 空间：O(n)
 */
class CQueue {
    private Deque<Integer> stack1;

    private Deque<Integer> stack2;

    public CQueue() {
        stack1 = new LinkedList<>();

        stack2 = new LinkedList<>();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if (stack2.isEmpty()) {                 //先看栈2是否为空，栈2的出栈顺序就是队列的出队顺序
            if (!stack1.isEmpty()) {            //栈2无元素，再将栈1中所有元素倒入栈2。
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            } else {                            //如果栈2也没有元素，则队列中就没有元素。
                return -1;
            }
        }
        return stack2.pop();
    }
}