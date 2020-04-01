package practice.leetcode.DailyQuestion;

public class No206 {
    public static void main(String[] args) {
        Solution206 s = new Solution206();
        ListNode head = new ListNode(1);
        for (int i = 5; i >= 2; i--) {
            ListNode node = new ListNode(i);
            node.next = head.next;
            head.next = node;
        }
        s.reverseList(head);

    }
}

class Solution206 {
/*    //�ݹ�ⷨ�������롣�Ӻ���ǰÿ�θı�һ���ڵ��ָ��
    public ListNode reverseList(ListNode head) {
        //�ݹ���ֹ�����ǵ�ǰΪ�գ�������һ���ڵ�Ϊ��
        if (head == null || head.next == null) {
            return head;
        }
        //�ݹ鵽���ʱ�������cur�������һ���ڵ�
        ListNode cur = reverseList(head.next);
        //��������� 1->2->3->4->5����ô��ʱ��cur����5
        //��head��4��head����һ����5������һ���ǿ�
        //����head.next.next ����5->4
        head.next.next = head;
        //��ֹ����ѭ������Ҫ��head.next����Ϊ�գ�������ÿղ�������һ��ݹ�ÿ�ζ�ֻ�������ڵ�
        head.next = null;
        //ÿ��ݹ麯��������cur��Ҳ�������һ���ڵ�
        return cur;
    }*/

    //�����ⷨ����ǰ����ÿ�θı�һ���ڵ��ָ��
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextHead = curr.next;
            curr.next = pre;
            pre = curr;
            curr = nextHead;
        }
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}