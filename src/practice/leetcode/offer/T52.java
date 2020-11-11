package practice.leetcode.offer;

public class T52 {
    public static void main(String[] args) {
        ListNode mid = new ListNode(8);
        mid.next = new ListNode(4);
        mid.next.next = new ListNode(5);
        ListNode up = new ListNode(4);
        up.next = new ListNode(1);
        up.next.next = mid;
        ListNode down = new ListNode(5);
        down.next = new ListNode(0);
        down.next.next = new ListNode(1);
        down.next.next.next = mid;

        SolutionT52 s = new SolutionT52();
        s.getIntersectionNode(up, down);
    }
}

class SolutionT52 {
    /**
     * ��Ŀ����������ĵ�һ�������ڵ�
     *
     * ˼·������ʹ������ָ�� node1��node2 �ֱ�ָ���������� headA��headB ��ͷ��㣬Ȼ��ͬʱ�ֱ����������
     * �� node1 �������� headA ��ĩβʱ�����¶�λ������ headB ��ͷ��㣻�� node2 �������� headB ��ĩβʱ��
     * ���¶�λ������ headA ��ͷ��㡣
     * ����������������ʱ����ָ��Ľ����ǵ�һ��������㡣
     */
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            p1 = p1 == null ? headB : p1.next;
            p2 = p2 == null ? headA : p2.next;
        }
        return p1;
    }

/*    public View findParent(View view1, View view2) {
        View v1 = view1, v2 = view2;
        while (v1 != v2) {
            if (v1 instanceof DecorView) {
                v1 = view2;
            } else {
                v1 = v1.getParent();
            }
            if (v2 instanceof DecorView) {
                v2 = view2;
            } else {
                v2 = v2.getParent();
            }
        }
        return v1;
    }*/
}