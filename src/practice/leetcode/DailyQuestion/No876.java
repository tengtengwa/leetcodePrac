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
        while (fast.next != null) {         //fastָ����нڵ�
            if (fast.next.next != null) {   //��ָ������ٻ��������ڵ�
                fast = fast.next.next;
                low = low.next;
            //����ֻʣһ���ڵ��û�нڵ��ˣ�lowָ���Ѿ������м䡣������ʱlow.nextΪ�м��һ���ڵ㣻ż����ʱlow.nextΪ�м������ĺ���һ��
            } else {
                break;
            }
        }
        return low.next;
    }
}