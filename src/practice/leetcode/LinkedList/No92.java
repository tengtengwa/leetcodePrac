package practice.leetcode.LinkedList;

public class No92 {
    public static void main(String[] args) {
        Solution92 s = new Solution92();
        s.reverseBetween(createList(), 2, 4);

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

class Solution92 {
/*    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode start;
        ListNode end = head;
        for (int i = 1; i < n; i++) {
            if (i < m ) {
                pre = pre.next;
            }
            end = end.next;
        }
        start = pre.next;
        ListNode next = end.next;
        end.next = null;
        pre.next = reverseList(start);
        start.next = next;
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }*/


    /**
     * 题目：反转链表2。反转从位置 m 到 n 的链表。请使用一趟扫描完成反转。
     * 思路：反转链表的一部分，这样需要记录四个节点：待反转范围的起始节点start和end，还有start之前的节点l，end之后的节点r；题中m可能为1，
     * 因为需要记录start之前的节点l，因此必须使用一个dummy哑节点
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int i = 1;
        ListNode p = dummy;
        for (; i < m; i++) {    //走到start前一个节点
            p = p.next;
        }
        ListNode l = p, start = p.next;
        p = p.next;             //上面循环结束后i多加了1,因此这里p后移一个节点
        for (; i < n; i++) {   //走到end节点
            p = p.next;
        }
        ListNode end = p;
        ListNode r = end.next;
        end.next = null;
        l.next = reverseList(start);    //l的next指针无需置空，这里直接指向反转后的链表表头
        start.next = r;
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }
}