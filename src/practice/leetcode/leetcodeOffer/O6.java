package practice.leetcode.leetcodeOffer;


import java.util.LinkedList;

public class O6 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(2);

        SolutionO6 s = new SolutionO6();
        s.reversePrint(head);
    }
}

class SolutionO6 {
    /**
     * ��Ŀ����β��ͷ��ӡ����
     * ����һ�������ͷ�ڵ㣬��β��ͷ����������ÿ���ڵ��ֵ�������鷵�أ���
     */

    /**
     * �ⷨһ���ݹ�
     * ˼·���ȱ���һ��������ȡ���ĳ��Ȳ�������Ӧ��С�����飻���Ŷ�������еݹ飬����ײ����Ϸ��ص�ͬʱ��ÿ���ڵ��ֵ�洢�������м��ɡ�
     *
     * ʱ�䡢�ռ䣺O(n)
     */
/*    public int[] reversePrint(ListNode head) {
        int len = getLength(head);
        int[] arr = new int[len];
        reversePrintHelper(head, arr, len - 1);     //ע���������ʼ����
        return arr;
    }

    private int getLength(ListNode head) {
        int len = 0;
        while (head != null) {
            len++;
            head = head.next;
        }
        return len;
    }

    private void reversePrintHelper(ListNode head, int[] arr, int index) {
        if (head == null) {
            return;
        }
        reversePrintHelper(head.next, arr, index - 1);      //ÿ������һ�㣬����-1���������ײ�ʱ��������0
        arr[index] = head.val;
    }*/


    /**
     * �ⷨ����ջ
     * ˼·���ȱ���һ��������ÿ���ڵ��ֵ��ջ�������������ȣ����Ŵ�����Ӧ��С�����顣����ջ��ȡ��ÿ��Ԫ�ؼ������鼴�ɡ�
     *
     * ʱ�䡢�ռ䣺O(n)
     */
    public int[] reversePrint(ListNode head) {
        LinkedList<Integer> stack = new LinkedList<>();
        int len = 0;
        while (head != null) {
            stack.addLast(head.val);
            head = head.next;
            len++;
        }
        int[] arr = new int[len];
        for (int i = 0; i < len; i++) {
            arr[i] = stack.pollLast();
        }
        return arr;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}