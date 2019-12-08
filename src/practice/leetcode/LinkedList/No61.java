package practice.leetcode.LinkedList;


public class No61 {
    public static void main(String[] args) {
        Solution61 s = new Solution61();
        s.rotateRight(createList(), 6);

    }
    private static ListNode createList() {
        ListNode head = new ListNode(1);
        for (int i = 5; i >= 2; i--) {
            ListNode q = new ListNode(i);
            q.val = i;
            q.next = head.next;
            head.next = q;
        }
        return head;
    }
}

class Solution61 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode p = head;
        int n = 1;
        while (p.next != null) {
            n++;
            p = p.next;
        }
        p.next = head;
        int tail_index = n - k % n - 1;     //新链表表尾元素下标
        ListNode newTail = head;
        while (tail_index != 0) {
            newTail = newTail.next;
            tail_index--;
        }
        ListNode newHead = newTail.next;
        newTail.next = null;
        return newHead;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}