package practice.leetcode.ByteDance.LinkedList;

public class O25 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(2);
        l1.next.next = new ListNode(4);
        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);
        SolutionO25 s = new SolutionO25();
        s.mergeTwoLists(l1, l2);
    }
}

class SolutionO25 {
    /**
     * 题目：合并两个有序链表（升序）
     */
    /**
     * 递归解法
     * 时间、空间：O(m+n)，m、n为两个链表的长度
     */
/*    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //在递归退到当前层时返回较小的节点
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;          //注意在这里返回当前节点，当前层l1指向的节点较小
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;          //注意在这里返回当前节点，当前层l2指向的节点较小
        }
    }*/


    /**
     * 迭代解法
     * 思路：使用一个哑节点，每次选择两个链表表头当前较小的节点插入新链表后
     * 时间：O(m+n)，空间：O(1)
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1), p = dummy;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                p.next = l1;
                l1 = l1.next;
            } else {
                p.next = l2;
                l2 = l2.next;
            }
            p = p.next;
        }
        //下面两个if可以精简为一个三元运算符：p.next = (l1 != null ? l1 : l2)
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return dummy.next;
    }
}