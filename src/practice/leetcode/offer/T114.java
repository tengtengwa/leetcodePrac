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
     /**递归法从后往前，最后返回头节点*/
    /*
    public ListNode ReverseList(ListNode head) {
        return reverse(head);
    }

    private ListNode reverse(ListNode head) {
        if (head == null || head.next == null)  //注意这里的条件，下面返回head
            return head;
        ListNode p = reverse(head.next);        //p记录本次递归结果，head在p的上一次递归
        head.next.next = head;                  //成环
        head.next = null;   //再断环，调整节点顺序。上上层减少最后一个节点，所以上层再进行head.next.next = head;这句时head.next.next为null
        return p;
    }*/

    /**迭代从前往后，最后返回尾节点*/
    public ListNode ReverseList(ListNode head) {
        ListNode pre = null;    //注意，pre从头一个元素前一个位置开始
        ListNode cur = head;
        while (cur != null) {
            ListNode nextTem = cur.next;    //先记录后面一个元素
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