package practice.leetcode;

/*
public class No21 {
    public static void main(String[] args) {
        Solution21 s = new Solution21();
        ListNode node = s.mergeTwoLists(null, createList2());
        while (node != null) {
            System.out.print(node.val + " ");
            node = node.next;
        }

    }
    private static ListNode createList1() {
        ListNode head = new ListNode(1);
        for (int i = 5; i >= 2; i--) {
            ListNode q = new ListNode(i);
            q.val = i;
            q.next = head.next;
            head.next = q;
        }
        return head;
    }
    private static ListNode createList2() {
        ListNode head = new ListNode(0);
        for (int i = 5; i >= 6; i--) {
            ListNode q = new ListNode(i);
            q.val = i;
            q.next = head.next;
            head.next = q;
        }
        return head;
    }
}

*/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 *//*


*/
/*class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        if (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                dummy.next = l2;
                l2 = l2.next;
            } else {
                dummy.next = l1;
                l1 = l1.next;
            }
        } else {
            if (l1 != null) {
                dummy.next = l1;
                l1 = l1.next;
            }
            if (l2 != null) {
                dummy.next = l2;
                l2 = l2.next;
            }
        }
        ListNode t = dummy.next;
        while (l1 != null && l2 != null) {
            if (l1.val >= l2.val) {
                t.next = l2;
                t = t.next;
                l2 = l2.next;
            } else {
                t.next = l1;
                t = t.next;
                l1 = l1.next;
            }
        }
        while (l1 != null) {
            t.next = l1;
            t = t.next;
            l1 = l1.next;
        }
        while (l2 != null) {
            t.next = l2;
            t = t.next;
            l2 = l2.next;
        }
        return dummy.next;
    }
}*//*


class Solution21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null) {
            return l2;
        }
        if(l2 == null) {
            return l1;
        }

        if(l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);       //递归调用有点意思
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}*/