package practice.leetcode.LinkedList;

public class No92 {
    public static void main(String[] args) {
        Solution92 s = new Solution92();
        s.reverseBetween(createList(), 2, 4);

    }

    private static ListNode createList() {
        ListNode head = new ListNode(1);
        for (int i = 5; i >= 2; i--) {
            ListNode q = new ListNode(i);
            q.val = i;
            q.next = head.next;
            head.next = q;
        }
        return head;
    }
}

class Solution92 {
/*    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode start;
        ListNode end = head;
        for (int i = 1; i < n; i++) {
            if (i < m ) {
                pre = pre.next;
            }
            end = end.next;
        }
        start = pre.next;
        ListNode next = end.next;
        end.next = null;
        pre.next = reverseList(start);
        start.next = next;
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }*/


    /**
     * ��Ŀ����ת����2����ת��λ�� m �� n ��������ʹ��һ��ɨ����ɷ�ת��
     * ˼·����ת�����һ���֣�������Ҫ��¼�ĸ��ڵ㣺����ת��Χ����ʼ�ڵ�start��end������start֮ǰ�Ľڵ�l��end֮��Ľڵ�r������m����Ϊ1��
     * ��Ϊ��Ҫ��¼start֮ǰ�Ľڵ�l����˱���ʹ��һ��dummy�ƽڵ�
     */
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int i = 1;
        ListNode p = dummy;
        for (; i < m; i++) {    //�ߵ�startǰһ���ڵ�
            p = p.next;
        }
        ListNode l = p, start = p.next;
        p = p.next;             //����ѭ��������i�����1,�������p����һ���ڵ�
        for (; i < n; i++) {   //�ߵ�end�ڵ�
            p = p.next;
        }
        ListNode end = p;
        ListNode r = end.next;
        end.next = null;
        l.next = reverseList(start);    //l��nextָ�������ÿգ�����ֱ��ָ��ת��������ͷ
        start.next = r;
        return dummy.next;
    }

    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode pre = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }
}