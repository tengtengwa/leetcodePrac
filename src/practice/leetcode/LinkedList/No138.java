package practice.leetcode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class No138 {

}

/**
 * 138. 复制带随机指针的链表
 * 给你一个长度为 n 的链表，每个节点包含一个额外增加的随机指针 random ，该指针可以指向链表中的任何节点或空节点。
 * 构造这个链表的深拷贝。
 */
class Solution138 {
    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    /**
     * 解法一：哈希表
     * 这题的难点在于拷贝链表节点中的random指针。
     * 1.创建出新链表，同时通过哈希表记录原链表节点到新链表节点的映射。
     * 2.再遍历一次原链表，我们可以拿到原链表random指针指向的结点，通过哈希表拿到这个节点对应的新链表节点。
     * 时间复杂度：O(n)，空间复杂度：O(n)
     */
//    public Node copyRandomList(Node head) {
//        if (head == null) return null;
//        //原链表Node -> 新链表Node 的映射
//        Map<Node, Node> map = new HashMap<>();
//        Node pre = new Node(-1);
//        Node p = head;
//        Node q = pre;
//        while (p != null) {
//            Node cur = new Node(p.val);
//            map.put(p, cur);
//            q.next = cur;
//            q = q.next;
//            p = p.next;
//        }
//        p = head;
//        q = pre.next;
//        while (p != null) {
//            q.random = map.get(p.random);
//            p = p.next;
//            q = q.next;
//        }
//        return pre.next;
//    }

    /**
     * 这个解法还算哈希表，思路和上面的一样，只是写成了递归。
     */
//    Map<Node, Node> map = new HashMap<>();
//    public Node copyRandomList(Node head) {
//        if (head == null) return null;
//        if (!map.containsKey(head)) {
//            Node newHead = new Node(head.val);
//            map.put(head, newHead);
//            newHead.next = copyRandomList(head.next);
//            newHead.random = map.get(head.random);
//            return newHead;
//        }
//        return null;
//    }

    /**
     * 解法二：迭代+节点拆分
     * 这种方法将链表A->B->C拆分为A->A'->B->B'->C->C'，X'表示根据X节点构造的新节点。
     * 假设A的random指向B，那么A'的random指向的就是B.next，而A'为A.next，也就是说A.next.random=A.random.next
     * 这样就解决了random指针的问题，接下来我们只需要将链表拆分为新老两个链表即可。
     * 时间复杂度O(n)，空间复杂度：O(1)
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        //第一步，在每个原节点后面创建一个新节点
        //1->1'->2->2'->3->3'
        while (p != null) {
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }
        p = head;
        //第二步，设置新节点的随机节点
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        Node dummy = new Node(-1);
        p = head;
        Node cur = dummy;
        //第三步，将两个链表分离
        while (p != null) {
            cur.next = p.next;
            cur = cur.next;
            p.next = cur.next;
            p = p.next;
        }
        return dummy.next;
    }
}