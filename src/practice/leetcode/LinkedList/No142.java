package practice.leetcode.LinkedList;

import java.util.HashSet;
import java.util.Set;

public class No142 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3), p = head,q;
        p.next = new ListNode(2);
        p = p.next;
        q = p;
        p.next = new ListNode(0);
        p = p.next;
        p.next = new ListNode(-4);
        p = p.next;
        p.next = q;
        Solution142 s = new Solution142();
        s.detectCycle(head);
    }
}

class Solution142 {
    /**
     * ��Ŀ��ѭ������2������ɻ��������ڽڵ�
     *
     * �ⷨһ��ʹ��˫ָ��
     * ������֪�������Ƴ���ָ���һ������ʱ�ߵĲ����ֱ�Ϊ2nb��nb��bΪ���еĽڵ������nΪδ֪����
     * �ߵ���ڽڵ���Ҫ�Ĳ�����a+nb��aΪ��ڽڵ�֮ǰ�Ľڵ������������ڵ�һ����������ָ�뻹��Ҫ��a�����ܵ�����ڽڵ�
     * ������ǽ���ָ��ָ��ͷ��㣬��ָ����ͬʱ��a������ʱ��ָ������a������ָ������a+nb�����ٴ�������ָ����ڽڵ�
     *
     */
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head, fast = slow.next;     //�����൱��fast��ʼʱ������һ��
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = head;
        slow = slow.next;       //ע�⣡������ʼʱ���fast = slow.next��������ָ�����Ҫ����һ�������������Ȼ��ѭ��
        while (slow != fast) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    /**
     * �ⷨ������ϣ��
     * ʹ�ù�ϣ����ÿ���ڵ㣬һ�α�����ֱ�����ֵ�һ���ظ��Ľڵ㣬����ڵ���ǻ����������ڽڵ�
     */
/*    public ListNode detectCycle(ListNode head) {
        Set<ListNode> set = new HashSet<>();

        ListNode node = head;
        while (node != null) {
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
            node = node.next;
        }

        return null;
    }*/
}