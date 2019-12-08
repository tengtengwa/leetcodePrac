package practice.leetcode.LinkedList;

public class No86 {
    public static void main(String[] args) {
        Solution86 s = new Solution86();
        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);
        s.partition(head, 3);

    }
}

class Solution86 {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode list = new ListNode(0);        //list链表储存所有大于等于x的节点
        ListNode p1 = list;     //指向p1的指针
        ListNode dummy = new ListNode(0);
        dummy.next = head;                      //head中储存所有小于x的节点
        ListNode p = dummy;     //p为慢指针
        ListNode q = head;      //q为快指针
        while (q != null) {
            if (q.val < x) {
                p = q;
                q = q.next;
            } else {
                ListNode tem = q;
                q = q.next;
                p.next = q;
                tem.next = null;
                p1.next = tem;
                p1 = p1.next;
            }
        }
        p.next = list.next;
        return dummy.next;
    }
}