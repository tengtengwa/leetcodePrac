package practice.leetcode.LinkedList;

public class No82 {
    public static void main(String[] args) {
        Solution82 s = new Solution82();
        ListNode head = new ListNode(-3);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(-2);
        head.next.next.next = new ListNode(0);
        head.next.next.next.next = new ListNode(0);
        head.next.next.next.next.next = new ListNode(0);
//        head.next.next.next.next.next.next = new ListNode(5);
        s.deleteDuplicates(head);

    }
}

class Solution82 {
/*    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        int num = head.val;
        ListNode tem = head;
        ListNode pre = dummy;
        while (tem != null) {
            while ((tem != null ? tem.next : null) != null && tem.next.val == num) {
                while (tem.next != null && tem.next.val == num) {
                    tem = tem.next;
                }
                tem = tem.next;
                if (tem != null) {
                    num = tem.val;
                }
            }
            pre.next = tem;
            pre = tem;

            if (tem != null) {
                tem = tem.next;
                if (tem != null) {
                    num = tem.val;
                }
            }
        }
        return dummy.next;
    }*/

    public ListNode deleteDuplicates(ListNode head) {
        // 1.base cases
        if (head == null || head.next == null) return head;

        // 2.哑节点,快慢指针
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = head;

        // 3.1 fast 遍历链表,让fast 去嗅探不相等元素
        while (fast != null)
        {
            if (fast.val != (fast.next != null ? fast.next.val : Integer.MAX_VALUE)) {
                // 3.2 slow.next == fast --> slow 与 fast 之间没有重复元素，slow 动。
                if (slow.next == fast)     //   3.2 & 3.3
                {
                    slow = fast;
                // 3.3 slow.next != fast --> slow 与 fast 之间存在重复元素，让slow指向的元素跳过这些重复元素，slow 不动。
                } else {
                    slow.next = fast.next;
                }
            }
            fast = fast.next;
        }

        return dummy.next;
    }
}