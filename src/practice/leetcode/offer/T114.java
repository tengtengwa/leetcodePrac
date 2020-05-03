package practice.leetcode.offer;

public class T114 {
    public static void main(String[] args) {
        SolutionT114 s = new SolutionT114();
        ListNode head = new ListNode(1);
        ListNode p = head;
        for (int i = 2; i <= 5; i++) {
            p.next = new ListNode(i);
            p = p.next;
        }
        ListNode q = s.ReverseList(head);
        System.out.println(q);
    }
}

class SolutionT114 {
     /**�ݹ鷨�Ӻ���ǰ����󷵻�ͷ�ڵ�*/
    /*
    public ListNode ReverseList(ListNode head) {
        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)  //ע����������������淵��head
            return head;
        ListNode p = reverse(head.next);        //p��¼���εݹ�����head��p����һ�εݹ�
        head.next.next = head;                  //�ɻ�
        head.next = null;   //�ٶϻ��������ڵ�˳�����ϲ�������һ���ڵ㣬�����ϲ��ٽ���head.next.next = head;���ʱhead.next.nextΪnull
        return p;
    }*/

    /**������ǰ������󷵻�β�ڵ�*/
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;    //ע�⣬pre��ͷһ��Ԫ��ǰһ��λ�ÿ�ʼ
        ListNode cur = head;
        while (cur != null) {
            ListNode nextTem = cur.next;    //�ȼ�¼����һ��Ԫ��
            cur.next = pre;
            pre = cur;
            cur = nextTem;
        }
        return pre;
    }
}

class ListNode {
    int val;
    ListNode next = null;

    ListNode(int val) {
        this.val = val;
    }
}