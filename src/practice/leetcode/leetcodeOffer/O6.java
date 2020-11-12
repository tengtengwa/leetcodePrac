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
     * 题目：从尾到头打印链表。
     * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
     */

    /**
     * 解法一：递归
     * 思路：先遍历一次链表，获取它的长度并创建相应大小的数组；接着对链表进行递归，从最底层向上返回的同时将每个节点的值存储到数组中即可。
     *
     * 时间、空间：O(n)
     */
/*    public int[] reversePrint(ListNode head) {
        int len = getLength(head);
        int[] arr = new int[len];
        reversePrintHelper(head, arr, len - 1);     //注意这里的起始索引
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
        reversePrintHelper(head.next, arr, index - 1);      //每向下走一层，索引-1，这样到底层时索引就是0
        arr[index] = head.val;
    }*/


    /**
     * 解法二：栈
     * 思路：先遍历一次链表，将每个节点的值入栈，并计算链表长度，接着创建相应大小的数组。最后从栈中取出每个元素加入数组即可。
     *
     * 时间、空间：O(n)
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