package practice.leetcode.DailyQuestion;

public class No876 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        for (int i = 6; i >= 2; i--) {
            ListNode node = new ListNode(i);
            node.next = head.next;
            head.next = node;
        }
        Solution876 s = new Solution876();
        s.middleNode(head);
    }
}

class Solution876 {
    public ListNode middleNode(ListNode head) {
        if (head.next == null) {
            return head;
        }
        if (head.next.next == null) {
            return head.next;
        }
        ListNode low = head;
        ListNode fast = head.next;
        while (fast.next != null) {         //fast指针后还有节点
            if (fast.next.next != null) {   //快指针后至少还有两个节点
                fast = fast.next.next;
                low = low.next;
            //后面只剩一个节点或没有节点了，low指针已经到达中间。奇数个时low.next为中间的一个节点；偶数个时low.next为中间两个的后面一个
            } else {
                break;
            }
        }
        return low.next;
    }
}