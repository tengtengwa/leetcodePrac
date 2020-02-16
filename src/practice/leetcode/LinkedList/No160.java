package practice.leetcode.LinkedList;

import java.util.HashSet;

public class No160 {
    public static void main(String[] args) {
        Solution160 s = new Solution160();
        s.getIntersectionNode(new ListNode(1), new ListNode(2));
    }
}

class Solution160 {
/*    //����
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

/*    //��ϣ
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

    //˫ָ��
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode pa = headA;
        ListNode pb = headB;
        while(pa != pb) {
            pa = pa == null ? headB : pa.next;  //�����ǰָ��ָ���˵�ǰ�����β����ָ����һ������ı�ͷ
            pb = pb == null ? headA : pb.next;
        }
        return pa;  //���ָ����һ����ı�β֮��û���ཻ�ڵ㣬�ͷ���pa����null��������paָ���ཻ�ڵ㣬�Է���pa
    }
}