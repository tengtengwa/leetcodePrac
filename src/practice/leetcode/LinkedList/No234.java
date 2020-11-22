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
     * 题目：回文链表。请判断一个链表是否为回文链表。
     * 进阶：
     * 你能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？
     */

    /**
     * 解法一：将值复制到数组后使用双指针
     * 思路：先遍历一次链表，将链表每个节点的数存储到列表中（也可以使用数组）。接着通过双指针来判断是否是回文
     * <p>
     * 时间、空间：O(n)
     */
/*    public boolean isPalindrome(ListNode head) {
        ArrayList<Integer> list = new ArrayList<>();
        while (head != null) {
            list.add(head.val);
            head = head.next;
        }
        int len = list.size();
        //下面从中间向两边来判断，比较麻烦还容易出错
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

        //下面从两边向中间来判断，不容易出错
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
     * 解法二：双指针
     * 思路：先遍历半个链表，找到链表中点，将链表前半段或后半段反转后，从两段链表表头开始遍历比较，如果有不同值的节点，则不是回文；否则是回文。
     *
     * 时间：O(n)，空间：O(1)
     */
    public boolean isPalindrome(ListNode head) {
        if (head == null) {
            return true;
        }
        //如果快指针一开始指向第二个节点，并且节点数量为奇数，则慢指针的后一个节点为中间的单个节点；
        //如果快指针一开始指向第一个节点，并且节点数量为奇数，则慢指针指向的那个节点就是中间的单个节点。
        ListNode slow = head, fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode next = slow.next;
        slow.next = null;
        next = reverseList(next);
        slow = head;
        //注意这里，如果快指针一开始指向第一个节点，这里就要使用后半段的指针来判断；如果一开始指向第二个节点，则就要使用前半段的指针。
        //也就是用较短的那半段链表的指针，否则会出现空指针。
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