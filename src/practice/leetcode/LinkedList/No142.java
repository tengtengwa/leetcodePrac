package practice.leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class No142 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3), p = head,q;
        p.next = new ListNode(2);
        p = p.next;
        q = p;
        p.next = new ListNode(0);
        p = p.next;
        p.next = new ListNode(-4);
        p = p.next;
        p.next = q;
        Solution142 s = new Solution142();
        s.detectCycle(head);
    }
}

class Solution142 {
    /**
     * 题目：循环链表2，即求成环链表的入口节点
     *
     * 解法一：使用双指针
     * 根据已知条件，推出两指针第一次相遇时走的步数分别为2nb、nb（b为环中的节点个数，n为未知数）
     * 走到入口节点需要的步数：a+nb（a为入口节点之前的节点个数），因此在第一次相遇后，慢指针还需要走a步才能到达入口节点
     * 因此我们将快指针指向头结点，两指针再同时走a步，此时快指针走了a步，慢指针走了a+nb步，再次相遇并指向入口节点
     *
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = slow.next;     //这里相当于fast开始时多走了一步
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        slow = slow.next;       //注意！！！开始时如果fast = slow.next，这里慢指针就需要先走一步，否则下面必然死循环
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * 解法二：哈希表
     * 使用哈希表保存每个节点，一次遍历，直到出现第一个重复的节点，这个节点就是环形链表的入口节点
     */
/*    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        ListNode node = head;
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
            node = node.next;
        }

        return null;
    }*/
}