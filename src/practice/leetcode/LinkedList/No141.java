package practice.leetcode.LinkedList;

public class No141 {
    public static void main(String[] args) {
        Solution141 s = new Solution141();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        s.hasCycle(head);
    }
}

class Solution141 {
    public boolean hasCycle(ListNode head) {
        boolean isCycle = false;
        while (head != null) {
            if (head.val == 947963599) {
                isCycle = true;
                break;
            } else {
                head.val = 947963599;
            }
            head = head.next;
        }
        return isCycle;
    }
}