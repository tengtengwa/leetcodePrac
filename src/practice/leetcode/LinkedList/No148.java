package practice.leetcode.LinkedList;

public class No148 {
    public static void main(String[] args) {
        ListNode head = new ListNode(-1), p = head;
        p.next = new ListNode(5);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);
        p = p.next;
        p.next = new ListNode(0);

        Solution148 s = new Solution148();
        s.sortList(head);
    }
}


class Solution148 {

    /**
     * ��Ŀ����������Ҫ��ʱ�临�Ӷ�ΪO(NlogN)���ռ临�Ӷ�Ϊ��������
     *
     * ͵��������������������һ�μ�¼�������нڵ��ֵ��ͬʱ�������򣨿���ʹ�����ȶ��У����ڶ��α���ʱͨ���ź����ֵ�޸�ԭ�����ֵ
     * ȱ�㣺�޸���ԭ�������ҿռ临�Ӷ�Ҳ���ǳ�����
     *
     * ����һ��ʹ�õݹ���й鲢�����Զ����£���ʱ�临�Ӷ�ΪO(NlogN)��һ�����Ƕ���
     * ˼·�������ߣ�����ָ�����е㣬�ݹ���öϿ����������ϲ�������
     *
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
        ListNode dummy = new ListNode(0);           //ʹ��һ��dummy�ڵ�Ƚ���
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


    /**
     * �ⷨ�������������Ե����ϣ�
     * ˼·��ÿ�α���ʱ��step���ڵ��������step��1��ʼ��ÿ������2���ݴη���1��2��4��8...
     *
     * ʱ�临�Ӷ�O(nlogn)���ռ临�Ӷ�O(1)
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;        //��ֹֻ��һ���ڵ����������Բ��ܷ���null
        }
        int len = 1;
        ListNode p = head;
        while (p.next != null) {
            p = p.next;
            len++;
        }
        ListNode tail, left, right, cur, dummy = new ListNode(-1);
        dummy.next = head;
        for (int step = 1; step < len; step <<= 1) {
            tail = dummy;           //tail��¼�����Ѿ��ź����β�ڵ�
            cur = dummy.next;       //��ǰ�������Ľڵ�
            while (cur != null) {
                left = cur;
                right = cut(cur, step);     //�е�left��step���ڵ㣬����curҲ�����滻Ϊleft
                cur = cut(right, step);     //�е�right��step���ڵ�
                tail.next = merge(left, right); //�ϲ�left��right������tail����
                while (tail.next != null)   //tailָ�����
                    tail = tail.next;
            }
        }
        return dummy.next;
    }

    //cut������ϵ�head�ڵ��n���ڵ㣬������head���n+1���ڵ�
    private ListNode cut(ListNode head, int n) {    //cut����Ҫע������п�
        int i = 1;
        while (i < n && head != null) {     //ע������head����Ϊ�յ�����
            head = head.next;
            i++;
        }
        if (head == null) {     //����ѭ���˳���head����Ϊnull
            return null;
        }
        ListNode ans = head.next;
        head.next = null;
        return ans;
    }

    private ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;     //ע�⣡��������ڵ��pָ�����
        }

        p.next = left == null ? right : left;
        return dummy.next;
    }
}