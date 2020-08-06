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
     * 题目：排序链表，要求时间复杂度为O(NlogN)，空间复杂度为常数级别
     *
     * 偷鸡法：遍历两次链表，第一次记录链表所有节点的值，同时进行排序（可以使用优先队列），第二次遍历时通过排好序的值修改原链表的值
     * 缺点：修改了原链表，并且空间复杂度也不是常数级
     *
     * 方法一：使用递归进行归并排序（自顶向下），时间复杂度为O(NlogN)，一看就是二分
     * 思路：三步走：快慢指针找中点，递归调用断开的两链表，合并两链表
     *
     * 这种做法的问题在于递归的时间复杂度不是常数级别的，应该是O(logN)，虽然能通过，但是不满足题目要求
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
        ListNode dummy = new ListNode(0);           //使用一个dummy节点比较香
        ListNode p = dummy;

        while (left != null && right != null) {
            if (left.val <= right.val) {
//                ListNode tem = left;      归并排序这里并不需要断开后面的节点
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
        //上面两个if直接可以写成一个三元运算式
        p.next = left == null ? right : left;
        return dummy.next;
    }*/


    /**
     * 解法二：迭代法（自底向上）
     * 思路：每次遍历时对step个节点进行排序，step从1开始，每次增加2的幂次方：1、2、4、8...
     *
     * 时间复杂度O(nlogn)，空间复杂度O(1)
     */
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;        //防止只有一个节点的情况，所以不能返回null
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
            tail = dummy;           //tail记录的是已经排好序的尾节点
            cur = dummy.next;       //当前遍历到的节点
            while (cur != null) {
                left = cur;
                right = cut(cur, step);     //切掉left后step个节点，这里cur也可以替换为left
                cur = cut(right, step);     //切掉right后step个节点
                tail.next = merge(left, right); //合并left和right并插入tail后面
                while (tail.next != null)   //tail指针后移
                    tail = tail.next;
            }
        }
        return dummy.next;
    }

    //cut方法会断掉head节点后n个节点，并返回head后第n+1个节点
    private ListNode cut(ListNode head, int n) {    //cut方法要注意进行判空
        int i = 1;
        while (i < n && head != null) {     //注意这里head不能为空的条件
            head = head.next;
            i++;
        }
        if (head == null) {     //上面循环退出后head可能为null
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
            p = p.next;     //注意！！！加入节点后将p指针后移
        }

        p.next = left == null ? right : left;
        return dummy.next;
    }
}