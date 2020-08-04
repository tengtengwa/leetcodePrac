package practice.leetcode.LinkedList;

public class No148 {
    public static void main(String[] args) {
        ListNode head = new ListNode(4), p = head;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(1);
        p = p.next;
        p.next = new ListNode(3);

        Solution148 s = new Solution148();
        s.sortList(head);
    }
}


class Solution148 {

    /**
     * ��Ŀ����������Ҫ��ʱ�临�Ӷ�ΪO(NlogN)���ռ临�Ӷ�Ϊ��������
     * <p>
     * ����һ��ʹ�õݹ���й鲢�����Զ����£���ʱ�临�Ӷ�ΪO(NlogN)��һ�����Ƕ���
     * ˼·���Ƚ�����һ��Ϊ����Ȼ����й鲢���򣬶�ǰ�����˷ֱ�ݹ�
     * <p>
     * �����������������ڵݹ��ʱ�临�ӶȲ��ǳ�������ģ�Ӧ����O(logN)����Ȼ��ͨ�������ǲ�������ĿҪ��
     */
/*    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode l1, l2;
        ListNode mid = findMid(head);
        ListNode sList = mid.next;
        mid.next = null;
        l1 = sortList(head);
        l2 = sortList(sList);
        return merge(l1, l2);
    }

    private ListNode findMid(ListNode head) {
        ListNode L = head, R = head.next;
        while (R != null && R.next != null) {
            L = L.next;
            R = R.next.next;
        }
        return L;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
//                ListNode tem = left;      �鲢�������ﲢ����Ҫ�Ͽ�����Ľڵ�
//                p.next = tem;
//                left = left.next;
//                tem.next = null;
                p.next = left;
                left = left.next;
            } else {
//                ListNode tem = right;
//                p.next = tem;
//                right = right.next;
//                tem.next = null;
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
//        if (left != null) {
//            p.next = left;
//        }
//        if (right != null) {
//            p.next = right;
//        }
        //��������ifֱ�ӿ���д��һ����Ԫ����ʽ
        p.next = left == null ? right : left;
        return dummy.next;
    }*/



    public ListNode sortList(ListNode head) {
        ListNode h, h1, h2, pre, res;
        h = head;
        int length = 0, intv = 1;
        while (h != null) {
            h = h.next;
            length++;
        }
        res = new ListNode(0);
        res.next = head;
        while (intv < length) {
            pre = res;
            h = res.next;
            while (h != null) {
                int i = intv;
                h1 = h;
                while (i > 0 && h != null) {
                    h = h.next;
                    i--;
                }
                if (i > 0) break;
                i = intv;
                h2 = h;
                while (i > 0 && h != null) {
                    h = h.next;
                    i--;
                }
                int c1 = intv, c2 = intv - i;
                while (c1 > 0 && c2 > 0) {
                    if (h1.val < h2.val) {
                        pre.next = h1;
                        h1 = h1.next;
                        c1--;
                    } else {
                        pre.next = h2;
                        h2 = h2.next;
                        c2--;
                    }
                    pre = pre.next;
                }
                pre.next = c1 == 0 ? h2 : h1;
                while (c1 > 0 || c2 > 0) {
                    pre = pre.next;
                    c1--;
                    c2--;
                }
                pre.next = h;
            }
            intv *= 2;
        }
        return res.next;
    }
}