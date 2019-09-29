package practice.leetcode;

public class No2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        ListNode l1 = new ListNode(5);
        ListNode l2 = new ListNode(5);
        ListNode p = l1;
        ListNode q = l2;
        p.next = new ListNode(8);
//        p = p.next;
//        p.next = new ListNode(3);
//
        q.next = new ListNode(2);
//        q = q.next;
//        q.next = new ListNode(4);
        ListNode l3 = s.addTwoNumbers(l1, l2);
        ListNode t = l3;
        while (t != null) {
            System.out.print(t.val);
            t = t.next;
        }
    }
}

/*class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode l3 = new ListNode(0);
        ListNode p = l1;
        ListNode q = l2;
        ListNode t = l3;
        int jinwei = 0;
        while (p != null && q != null) {
            if (jinwei + p.val + q.val < 10) {
                t.val = p.val + q.val + jinwei;
                jinwei = 0;
            } else {
                t.val = p.val + q.val + jinwei - 10;
                jinwei = 1;
            }
            p = p.next;
            q = q.next;
            if (p != null && q != null) {
                t.next = new ListNode(0);
                t = t.next;
            }
        }
        while (p != null) {
            t.next = new ListNode(0);
            t = t.next;
            if (jinwei + p.val < 10) {
                t.val = p.val + jinwei;
                jinwei = 0;
            } else {
                t.val = p.val + jinwei - 10;
                jinwei = 1;
            }
            p = p.next;
        }
        while (q != null) {
            t.next = new ListNode(0);
            t = t.next;
            if (jinwei + q.val < 10) {
                t.val = q.val + jinwei;
                jinwei = 0;
            } else {
                t.val = q.val + jinwei - 10;
                jinwei = 1;
            }
            q = q.next;
        }
        if (jinwei == 1) {
            t.next = new ListNode(1);
        }
        return l3;
    }
}*/


/*class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummyHead = new ListNode(0);
        ListNode p = l1, q = l2, curr = dummyHead;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = carry + x + y;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            if (p != null) p = p.next;
            if (q != null) q = q.next;
        }
        if (carry > 0) {
            curr.next = new ListNode(carry);
        }
        return dummyHead.next;
    }
}*/

class Solution2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode curr = head;
        ListNode p = l1;
        ListNode q = l2;
        int carry = 0;
        while (p != null || q != null) {
            int x = (p != null) ? p.val : 0;
            int y = (q != null) ? q.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.next = new ListNode(sum % 10);
            curr = curr.next;
            p = p.next;
            q = q.next;

        }
        if (carry != 0) {
            curr.next = new ListNode(carry);
        }

        return head.next;
    }
}

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}