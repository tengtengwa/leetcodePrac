package practice.leetcode.LinkedList;

public class No25 {
    public static void main(String[] args) {
        Solution25 s = new Solution25();
        ListNode head = s.reverseKGroup(createList(), 3);
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }

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

class Solution25 {
    /**
     * ��Ŀ��k��һ�鷴ת����
     * k ��һ��������������ֵС�ڻ��������ĳ��ȡ�����ڵ��������� k ������������ô�뽫���ʣ��Ľڵ㱣��ԭ��˳��
     */

    /**
     * �ⷨһ������
     * ��Ҫע��ľ����ڷ�ת֮ǰҪ�����������ǰ��ָ�룬�����ڵ���ָ���ʱ������Ҫע�⡣
     *
     * ʱ�䣺O(n)���ռ䣺O(1)
     */
/*    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy, next, curTail = pre, curHead = head;
        while (curHead != null) {
            for (int i = 0; i < k; i++) {
                if (curTail != null) {
                    curTail = curTail.next;
                }
            }
            if (curTail == null) {      //���ĩβ����Щ�ڵ㲻��k������ֱ�ӷ�������
                return dummy.next;
            }
            next = curTail.next;        //�����������һ���ڵ�
            curTail.next = null;        //�Ͽ��������next����
            curHead = reverseList(curHead);     //���淴ת���������ͷ���
            curTail = pre.next;         //��ת�������preָ�����һ���ڵ�����������β���

            pre.next = curHead;
            curTail.next = next;
            pre = curTail;
            curHead = pre.next;
        }
        return dummy.next;
    }
    */


    /**
     * �ⷨ�����ݹ�
     *
     * ʱ�临�Ӷȡ��ռ临�Ӷȣ�O(n)
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode tail = head;
        for (int i = 1; i < k; i++) {       //����û��ʹ��dummy�ڵ㣬������������ƶ���k-1���ڵ�
            if (tail == null) {
                return head;
            }
            tail = tail.next;
        }
        if (tail == null) {         //������Ҫ�Ե�k���ڵ����У�������ָ��
            return head;
        }
        ListNode next = tail.next;  //nextָ���k+1���ڵ�
        tail.next = null;
        ListNode curHead = reverseList(head);
        head.next = reverseKGroup(next, k);
        return curHead;
    }

    /**
     * @param head �������ͷ���
     * @return ����ֵ��������ת���ͷ���
     */
    private ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode pre = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return pre;
    }
}