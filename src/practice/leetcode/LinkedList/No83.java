package practice.leetcode.LinkedList;

public class No83 {
    public static void main(String[] args) {
        Solution83 s = new Solution83();
        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(0);
//        head.next.next.next.next = new ListNode(0);
//        head.next.next.next.next.next = new ListNode(0);
        s.deleteDuplicates(head);

    }
}

class Solution83 {
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tem = head;
        do {
            if (tem.next.val == tem.val) {
                tem.next = tem.next.next;
            } else {
                tem = tem.next;
            }
        } while (tem.next != null);
        return head;
    }
}