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
     * 题目：两个链表的第一个公共节点
     *
     * 思路：我们使用两个指针 node1，node2 分别指向两个链表 headA，headB 的头结点，然后同时分别逐结点遍历，
     * 当 node1 到达链表 headA 的末尾时，重新定位到链表 headB 的头结点；当 node2 到达链表 headB 的末尾时，
     * 重新定位到链表 headA 的头结点。
     * 这样，当它们相遇时，所指向的结点就是第一个公共结点。
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