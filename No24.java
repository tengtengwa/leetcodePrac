package practice.leetcode;

public class No24 {
    public static void main(String[] args) {
        Solution24 s = new Solution24();
        ListNode head = s.swapPairs(createList());
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

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

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/*
class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            ListNode p = head;
            head = head.next;
            head.next = p;
            return head;
        }
        ListNode p = head;
        ListNode q = head;
        q = q.next.next;
        head = head.next;
        head.next = p;
        p.next = q;
        while (p.next != null) {
            p = p.next;
            ListNode t = null;
            if (p.next != null) {
                t = p.next;
            }
            p.next = q;
            if (t != null) {
                q.next = t;
            }
            p = p.next.next;
        }
        return head;
    }
}*/

class Solution24 {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = head.next;
        head.next = swapPairs(p.next);
        p.next = head;
        return p;
    }
}

//2 1 4 3 6 5 7