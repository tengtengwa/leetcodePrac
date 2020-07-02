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
        for (int num : popA) {      //������ջ����
            while (stack.empty() || stack.peek() != num) {  //�����һ������Ԫ�ز���ջ�����ͽ�pushA�л�û����ջ������ѹջ
                if (i == pushA.length) {    //�����ǰջ�л���Ԫ�ز��Ұ��������ֶ���ջ�˻��Ҳ�����һ����ջ���֣��Ͳ���һ����ջ����
                    return false;
                }
                stack.push(pushA[i++]);
            }
            stack.pop();    //��һ��������ջ��Ԫ�أ�ֱ�ӵ���
        }
        return true;
    }
}