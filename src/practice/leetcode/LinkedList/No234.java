package practice.leetcode.LinkedList;

import java.util.ArrayList;

public class No234 {
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
//        head.next.next = new ListNode(2);
//        head.next.next.next = new ListNode(1);
        Solution234 s = new Solution234();
        s.isPalindrome(head);
    }
}

class Solution234 {
    /**
     * ��Ŀ�������������ж�һ�������Ƿ�Ϊ��������
     * ���ף�
     * ���ܷ��� O(n) ʱ�临�ӶȺ� O(1) �ռ临�ӶȽ�����⣿
     */

    /**
     * �ⷨһ����ֵ���Ƶ������ʹ��˫ָ��
     * ˼·���ȱ���һ������������ÿ���ڵ�����洢���б��У�Ҳ����ʹ�����飩������ͨ��˫ָ�����ж��Ƿ��ǻ���
     * <p>
     * ʱ�䡢�ռ䣺O(n)
     */
/*    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int len = list.size();
        //������м����������жϣ��Ƚ��鷳�����׳���
//        int m = (len >> 1) - 1, j = m + 1;
//        if (len % 2 == 1) {
//            j = m + 2;
//        }
//        for (int i = m; i >= 0 && j < len; i--, j++) {
//            if (!list.get(i).equals(list.get(j))) {
//                return false;
//            }
//        }
//        return true;

        //������������м����жϣ������׳���
        int i = 0, j = len - 1;
        while (i < j) {
            if (!list.get(i).equals(list.get(j))) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }*/


    /**
     * �ⷨ����˫ָ��
     * ˼·���ȱ�����������ҵ������е㣬������ǰ��λ���η�ת�󣬴����������ͷ��ʼ�����Ƚϣ�����в�ֵͬ�Ľڵ㣬���ǻ��ģ������ǻ��ġ�
     *
     * ʱ�䣺O(n)���ռ䣺O(1)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        //�����ָ��һ��ʼָ��ڶ����ڵ㣬���ҽڵ�����Ϊ����������ָ��ĺ�һ���ڵ�Ϊ�м�ĵ����ڵ㣻
        //�����ָ��һ��ʼָ���һ���ڵ㣬���ҽڵ�����Ϊ����������ָ��ָ����Ǹ��ڵ�����м�ĵ����ڵ㡣
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        next = reverseList(next);
        slow = head;
        //ע����������ָ��һ��ʼָ���һ���ڵ㣬�����Ҫʹ�ú��ε�ָ�����жϣ����һ��ʼָ��ڶ����ڵ㣬���Ҫʹ��ǰ��ε�ָ�롣
        //Ҳ�����ý϶̵��ǰ�������ָ�룬�������ֿ�ָ�롣
        while (next != null) {
            if (slow.val != next.val) {
                return false;
            }
            slow = slow.next;
            next = next.next;
        }
        return true;
    }

    private ListNode reverseList(ListNode head) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}