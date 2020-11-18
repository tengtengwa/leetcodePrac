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
     * ��Ŀ���ϲ�����������������
     */
    /**
     * �ݹ�ⷨ
     * ʱ�䡢�ռ䣺O(m+n)��m��nΪ��������ĳ���
     */
/*    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        //�ڵݹ��˵���ǰ��ʱ���ؽ�С�Ľڵ�
        if (l1.val <= l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;          //ע�������ﷵ�ص�ǰ�ڵ㣬��ǰ��l1ָ��Ľڵ��С
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;          //ע�������ﷵ�ص�ǰ�ڵ㣬��ǰ��l2ָ��Ľڵ��С
        }
    }*/


    /**
     * �����ⷨ
     * ˼·��ʹ��һ���ƽڵ㣬ÿ��ѡ�����������ͷ��ǰ��С�Ľڵ�����������
     * ʱ�䣺O(m+n)���ռ䣺O(1)
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
        //��������if���Ծ���Ϊһ����Ԫ�������p.next = (l1 != null ? l1 : l2)
        if (l1 != null) {
            p.next = l1;
        }
        if (l2 != null) {
            p.next = l2;
        }
        return dummy.next;
    }
}