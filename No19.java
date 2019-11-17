package practice.leetcode;

public class No19 {
    public static void main(String[] args) {
        Solution19 s = new Solution19();
        ListNode p = s.removeNthFromEnd(createList(), 1);
        while (p != null) {
            System.out.print(p.val + " ");
            p = p.next;
        }
    }

    private static ListNode createList() {
        ListNode head = new ListNode(1);
        for (int i = 1; i >= 1; i--) {
            ListNode q = new ListNode(i);
            q.val = i;
            q.next = head.next;
            head.next = q;
        }
        return head;
    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode first = dummy;
        ListNode second = dummy;
        int num = n;
        while (num != -1) {
            num--;
            first = first.next;
        }
        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return dummy.next;
    }
}

/*
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}*/
