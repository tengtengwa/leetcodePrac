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
 * ��Ŀ��������ջʵ��һ������
 *
 * ˼·������Ԫ�ص�ʱ����������ջ1����ɾ������ͷ���ʱ�����ջ2Ϊ�գ����Ƚ�ջ1��Ԫ��ȫ����ջ������ջ2,����������Ҫɾ��ͷ���ʱ���ȴ�
 * ջ2�г�ջԪ�ؼ��ɡ����ջ2ջ1��Ϊ�գ����ʱ������û��Ԫ�ء�
 *
 * ʱ�䣺O(1)�����ڲ����ɾ��������ʱ�临�ӶȾ�ΪO(1)�����벻��˵������ɾ����������Ȼ��������O(n)��ʱ�临�Ӷȣ�
 * ������ϸ������ÿ��Ԫ��ֻ�ᡸ���౻����͵��� stack2 һ�Ρ�����˾�̯����ÿ��Ԫ�ر�ɾ����ʱ�临�Ӷ���ΪO(1)��
 *
 * �ռ䣺O(n)
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
        if (stack2.isEmpty()) {                 //�ȿ�ջ2�Ƿ�Ϊ�գ�ջ2�ĳ�ջ˳����Ƕ��еĳ���˳��
            if (!stack1.isEmpty()) {            //ջ2��Ԫ�أ��ٽ�ջ1������Ԫ�ص���ջ2��
                while (!stack1.isEmpty()) {
                    stack2.push(stack1.pop());
                }
            } else {                            //���ջ2Ҳû��Ԫ�أ�������о�û��Ԫ�ء�
                return -1;
            }
        }
        return stack2.pop();
    }
}