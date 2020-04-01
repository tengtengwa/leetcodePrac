package practice.leetcode.DailyQuestion;

public class No206 {
    public static void main(String[] args) {
        Solution206 s = new Solution206();
        ListNode head = new ListNode(1);
        for (int i = 5; i >= 2; i--) {
            ListNode node = new ListNode(i);
            node.next = head.next;
            head.next = node;
        }
        s.reverseList(head);

    }
}

class Solution206 {
/*    //递归解法，不好想。从后向前每次改变一个节点的指向
    public ListNode reverseList(ListNode head) {
        //递归终止条件是当前为空，或者下一个节点为空
        if (head == null || head.next == null) {
            return head;
        }
        //递归到最后时，这里的cur就是最后一个节点
        ListNode cur = reverseList(head.next);
        //如果链表是 1->2->3->4->5，那么此时的cur就是5
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        //防止链表循环，需要将head.next设置为空，这里的置空操作让上一层递归每次都只有两个节点
        head.next = null;
        //每层递归函数都返回cur，也就是最后一个节点
        return cur;
    }*/

    //迭代解法：从前往后每次改变一个节点的指向
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextHead = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextHead;
        }
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}