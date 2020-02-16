package practice.leetcode.LinkedList;

import java.util.HashSet;

public class No160 {
    public static void main(String[] args) {
        Solution160 s = new Solution160();
        s.getIntersectionNode(new ListNode(1), new ListNode(2));
    }
}

class Solution160 {
/*    //暴力
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

/*    //哈希
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

    //双指针
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