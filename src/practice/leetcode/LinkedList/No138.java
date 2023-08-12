package practice.leetcode.LinkedList;

import java.util.HashMap;
import java.util.Map;

public class No138 {

}

/**
 * 138. ���ƴ����ָ�������
 * ����һ������Ϊ n ������ÿ���ڵ����һ���������ӵ����ָ�� random ����ָ�����ָ�������е��κνڵ��սڵ㡣
 * �����������������
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
     * �ⷨһ����ϣ��
     * ������ѵ����ڿ�������ڵ��е�randomָ�롣
     * 1.������������ͬʱͨ����ϣ���¼ԭ����ڵ㵽������ڵ��ӳ�䡣
     * 2.�ٱ���һ��ԭ�������ǿ����õ�ԭ����randomָ��ָ��Ľ�㣬ͨ����ϣ���õ�����ڵ��Ӧ��������ڵ㡣
     * ʱ�临�Ӷȣ�O(n)���ռ临�Ӷȣ�O(n)
     */
//    public Node copyRandomList(Node head) {
//        if (head == null) return null;
//        //ԭ����Node -> ������Node ��ӳ��
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
     * ����ⷨ�����ϣ��˼·�������һ����ֻ��д���˵ݹ顣
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
     * �ⷨ��������+�ڵ���
     * ���ַ���������A->B->C���ΪA->A'->B->B'->C->C'��X'��ʾ����X�ڵ㹹����½ڵ㡣
     * ����A��randomָ��B����ôA'��randomָ��ľ���B.next����A'ΪA.next��Ҳ����˵A.next.random=A.random.next
     * �����ͽ����randomָ������⣬����������ֻ��Ҫ��������Ϊ�������������ɡ�
     * ʱ�临�Ӷ�O(n)���ռ临�Ӷȣ�O(1)
     */
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        Node p = head;
        //��һ������ÿ��ԭ�ڵ���洴��һ���½ڵ�
        //1->1'->2->2'->3->3'
        while (p != null) {
            Node newNode = new Node(p.val);
            newNode.next = p.next;
            p.next = newNode;
            p = newNode.next;
        }
        p = head;
        //�ڶ����������½ڵ������ڵ�
        while (p != null) {
            if (p.random != null) {
                p.next.random = p.random.next;
            }
            p = p.next.next;
        }
        Node dummy = new Node(-1);
        p = head;
        Node cur = dummy;
        //���������������������
        while (p != null) {
            cur.next = p.next;
            cur = cur.next;
            p.next = cur.next;
            p = p.next;
        }
        return dummy.next;
    }
}