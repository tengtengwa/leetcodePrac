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
    public ListNode reverseBetween(ListNode head, int m, int n) {
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
    }
}