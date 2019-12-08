package practice.leetcode;

public class No23 {
    public static void main(String[] args) {

    }
}

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode(int x) { val = x; }
 * }
 */
class Solution23 {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode node = new ListNode(0);
        ListNode tem = mergeTwoList(lists[0], lists[1]);
        node.next = tem;
        for (int i = 2; i < lists.length; i++) {
            mergeTwoList(tem, lists[i]);
        }
        return node.next;
    }

    private ListNode mergeTwoList(ListNode list1, ListNode list2) {
        if (list1.next == null) {
            return list2;
        }
        if (list2.next == null) {
            return list1;
        }
        if (list1.val > list2.val) {
            list2.next = mergeTwoList(list1, list2.next);
            return list2;
        } else {
            list1.next = mergeTwoList(list1.next, list2);
            return list1;
        }
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}