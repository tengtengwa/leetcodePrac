package practice.leetcode.LinkedList;

public class No203 {
    public static void main(String[] args) {
        Solution203 s = new Solution203();
        ListNode head = new ListNode(-3);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(-2);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(0);
        s.removeElements(head, 0);
    }
}

class Solution203 {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null)
            return null;
        ListNode   res = removeElements(head.next,val);
        if(head.val == val)
            return res;
        else{
            head.next = res;
            return head;
        }
    }
}