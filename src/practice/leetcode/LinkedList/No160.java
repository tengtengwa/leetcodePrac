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
     * ��Ŀ���ཻ����
     * �ҵ������������ཻ����ʼ�ڵ㣬Ҳ�����������������������ڵ�
     */

    /**
     * �ⷨһ������
     * ˼·����������A��ÿ���ڵ㣬���Ǳ�������B��Ѱ���Ƿ���ͬһ���ڵ㡣һ���ҵ���ͬ�Ľڵ�ֱ�ӷ��ء�
     *
     * ʱ�䣺O(mn)���ռ䣺O(1)��������Ϊ�������ཻ�Ľڵ�Ϊ���Ľڵ㡣
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
     * �ⷨ������ϣ��
     * ˼·������һ������A����ÿ���ڵ�����ϣ���ٱ���һ������B�������������ͬ�Ľڵ㣬��ǰ�ڵ�����ཻ����ʼ�ڵ�
     *
     * ʱ�䣺O(n+m)���ռ䣺O(m)��O(n)
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
     * �ⷨ����˫ָ��
     * ˼·���������ָ��pA��pB�ֱ�ָ��A��B��������ͬʱ��ʼ������α�������pA������A�ı�βʱ������ָ������B�����Ƶģ�
     * ��pB������B�ı�βʱ������ָ������A��������������Ĺ����У�pA��pB�ض��������������ཻ������������ڵ㡣
     * ֤������A�����У��ཻ����ʼ�ڵ�֮ǰ�ĳ���Ϊa��B�����У��ཻ����ʼ�ڵ�֮ǰ�ĳ���Ϊb�����ߵĹ������ֳ���Ϊc����Ϊ��
     * ����ķ�ʽ������ʱ������ָ��ӿ�ʼ���ཻ�߹��ľ��붼��a+c+b����˱ض��ཻ���ཻ������������ڵ�
     *
     * ʱ�䣺O(m+n)���ռ䣺O(1)
     */
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