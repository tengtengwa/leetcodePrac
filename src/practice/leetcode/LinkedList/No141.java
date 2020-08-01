package practice.leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

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
    /**
     * 题目：环形链表，判断链表是否成环
     * 解法一：双指针
     * 时间：O(N)，空间O(1)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p = head, q = p.next;
        while (p != q) {        //注意，退出循环的条件是两指针相等，所以退出while循环后返回true
            //先对快指针判空，再移动两个指针，如果快指针不为空，那么之前的节点都不会为空，因此不需要判断慢指针
            if (q == null || q.next == null) {
                return false;
            }
            p = p.next;
            q = q.next.next;
        }
        return true;
    }

    /**
     * 解法二：哈希表
     * 使用哈希表保存所有节点的引用，遇到相同的引用则表明链表成环，否则将当前节点的引用加入哈希表中
     */
/*    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }*/
}