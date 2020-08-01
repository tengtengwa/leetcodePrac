package practice.leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class No141 {
    public static void main(String[] args) {
        Solution141 s = new Solution141();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = head;
        s.hasCycle(head);
    }
}

class Solution141 {
    /**
     * ��Ŀ�����������ж������Ƿ�ɻ�
     * �ⷨһ��˫ָ��
     * ʱ�䣺O(N)���ռ�O(1)
     */
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        ListNode p = head, q = p.next;
        while (p != q) {        //ע�⣬�˳�ѭ������������ָ����ȣ������˳�whileѭ���󷵻�true
            //�ȶԿ�ָ���пգ����ƶ�����ָ�룬�����ָ�벻Ϊ�գ���ô֮ǰ�Ľڵ㶼����Ϊ�գ���˲���Ҫ�ж���ָ��
            if (q == null || q.next == null) {
                return false;
            }
            p = p.next;
            q = q.next.next;
        }
        return true;
    }

    /**
     * �ⷨ������ϣ��
     * ʹ�ù�ϣ�������нڵ�����ã�������ͬ���������������ɻ������򽫵�ǰ�ڵ�����ü����ϣ����
     */
/*    public boolean hasCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();
        while (head != null) {
            if (set.contains(head)) {
                return true;
            } else {
                set.add(head);
            }
            head = head.next;
        }
        return false;
    }*/
}