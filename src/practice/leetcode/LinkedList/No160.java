package practice.leetcode.LinkedList;

import java.util.HashSet;

public class No160 {
    public static void main(String[] args) {
        Solution160 s = new Solution160();
        s.getIntersectionNode(new ListNode(1), new ListNode(2));
    }
}

class Solution160 {
    /**
     * 题目：相交链表。
     * 找到两个单链表相交的起始节点，也就是两个链表的最近公共父节点
     */

    /**
     * 解法一：暴力
     * 思路：对于链表A中每个节点，我们遍历链表B，寻找是否有同一个节点。一旦找到相同的节点直接返回。
     *
     * 时间：O(mn)、空间：O(1)。最坏的情况为两链表相交的节点为最顶层的节点。
     */
/*
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pa = headA;
        ListNode pb;
        while(pa != null) {
            pb = headB;
            while(pb != null) {
                if(pa == pb) {
                    return pa;
                } else {
                    pb = pb.next;
                }
            }
            pa = pa.next;
        }
        return null;
    }*/


    /**
     * 解法二：哈希表
     * 思路：遍历一次链表A，将每个节点加入哈希表。再遍历一次链表B，如果表中有相同的节点，则当前节点就是相交的起始节点
     *
     * 时间：O(n+m)，空间：O(m)或O(n)
     */
/*
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        HashSet<ListNode> set = new HashSet<>();
        ListNode pa = headA;
        ListNode pb = headB;
        while(pa != null) {
            if(!set.contains(pa)) {
                set.add(pa);
            } else {
                pa = pa.next;
            }
        }
        while(pb != null) {
            if(set.contains(pb)) {
                return pb;
            } else {
                pb = pb.next;
            }
        }
        return null;
    }*/

    /**
     * 解法三：双指针
     * 思路：起初两个指针pA和pB分别指向A、B链表，两者同时开始向后依次遍历。当pA遍历到A的表尾时，将其指向链表B；类似的，
     * 当pB遍历到B的表尾时，将其指向链表A。后面继续遍历的过程中，pA和pB必定相遇在两链表相交的最近公共父节点。
     * 证明：设A链表中，相交的起始节点之前的长度为a，B链表中，相交的起始节点之前的长度为b，两者的公共部分长度为c。因为以
     * 上面的方式来遍历时，两个指针从开始到相交走过的距离都是a+c+b，因此必定相交与相交的最近公共父节点
     *
     * 时间：O(m+n)，空间：O(1)
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pa = headA;
        ListNode pb = headB;
        while(pa != pb) {
            pa = pa == null ? headB : pa.next;  //如果当前指针指向了当前链表表尾，则指向另一个链表的表头
            pb = pb == null ? headA : pb.next;
        }
        return pa;  //如果指向另一个表的表尾之后都没有相交节点，就返回pa（即null）；否则pa指向相交节点，仍返回pa
    }
}