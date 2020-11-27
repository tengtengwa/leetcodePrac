package practice.leetcode.LinkedList;

public class No25 {
    public static void main(String[] args) {
        Solution25 s = new Solution25();
        ListNode head = s.reverseKGroup(createList(), 3);
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

class Solution25 {
    /**
     * 题目：k个一组反转链表
     * k 是一个正整数，它的值小于或等于链表的长度。如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。
     */

    /**
     * 解法一：迭代
     * 需要注意的就是在反转之前要保存子链表的前后指针，并且在调整指针的时候尤其要注意。
     *
     * 时间：O(n)，空间：O(1)
     */
/*    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, next, curTail = pre, curHead = head;
        while (curHead != null) {
            for (int i = 0; i < k; i++) {
                if (curTail != null) {
                    curTail = curTail.next;
                }
            }
            if (curTail == null) {      //如果末尾的这些节点不足k个，则直接返回链表
                return dummy.next;
            }
            next = curTail.next;        //保存子链表后一个节点
            curTail.next = null;        //断开子链表的next引用
            curHead = reverseList(curHead);     //保存反转后子链表的头结点
            curTail = pre.next;         //反转子链表后，pre指向的下一个节点就是子链表的尾结点

            pre.next = curHead;
            curTail.next = next;
            pre = curTail;
            curHead = pre.next;
        }
        return dummy.next;
    }
    */


    /**
     * 解法二：递归
     *
     * 时间复杂度、空间复杂度：O(n)
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        for (int i = 1; i < k; i++) {       //由于没有使用dummy节点，所以这里向后移动了k-1个节点
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        if (tail == null) {         //这里需要对第k个节点特判，否则会空指针
            return head;
        }
        ListNode next = tail.next;  //next指向第k+1个节点
        tail.next = null;
        ListNode curHead = reverseList(head);
        head.next = reverseKGroup(next, k);
        return curHead;
    }

    /**
     * @param head 子链表的头结点
     * @return 返回值是子链表反转后的头结点
     */
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }
}