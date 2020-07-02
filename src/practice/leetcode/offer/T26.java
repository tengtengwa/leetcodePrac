package practice.leetcode.offer;

import java.util.HashMap;
import java.util.Map;

public class T26 {
    public static void main(String[] args) {
        Node head = new Node(1);
        Node p = head;
        for (int i = 2; i <= 5; i++) {
            p.next = new Node(i);
            p = p.next;
        }
        head.random = head.next.next;
        head.next.random = head.next.next.next;
        SolutionT26 s = new SolutionT26();
        Node node = s.copyRandomList(head);
        System.out.println();
    }
}

class SolutionT26 {
    /**
     * 解法一：使用哈希表，第一次新建原链表的所有节点并用next指针连接，同时记录原链表每个节点到新建链表每个节点的映射；
     * 第二次再给新建链表设置random指针。
     * 时间复杂度：O（n），空间复杂度：O（n）
     */
/*    public Node copyRandomList(Node head) {
        Map<Node,Node> map = new HashMap<>();
        Node res = new Node(head.val);
        Node phead = head;
        map.put(head, res);
        Node p = res;
        while (phead.next != null) {
            p.next = new Node(phead.next.val);
            p = p.next;
            phead = phead.next;
            map.put(phead, p);
        }
        phead = head;
        p = res;
        while (phead != null) {
            //下面使用哈希表进行了优化，不然每次要变量原链表找到当前节点random指针所指节点（时间复杂度为n^2）
            if (phead.random != null) { //如果原链表当前节点有random指针，就通过哈希表找到random指针所指节点并设置给新链表当前节点
                p.random = map.get(phead.random);
            }
            phead = phead.next;
            p = p.next;
        }
        return res;
    }*/

    /**
     * 解决方案二：在不使用辅助空间的情况下实现O(n)的时问效率。
     * 第一步：复制节点：将原始链表的任意节点 N复制为新节点N',再把N'连接到 N的后面。
     * 即如果原始链表为A->B->C->D 则复制过后为A->A'->B->B'->C->C'->D->D'
     * 第二步:确定每个新增节点N'的random指针指向
     * 显然，如果原始链表上的节点 N 的random指针指向节点S,则它对应的复制节点N'的random指针指向节点S的复制节点S',也就是当前节点S的下一个节点。
     * 第三步:把这个长链表拆分成两个链表,把奇数位置的节点连接起来就是原始链表,把偶数位置的节点连接起来就是复制出来的链表。
     * 注意，此时在得到复制链表的同时，不要忘记将原有链表进行复原。
     */
    public Node copyRandomList(Node head) {
        if (head == null) return null;
        copyList(head);
        copyRandom(head);
        return build(head);
    }

    private void copyList(Node head) {
        Node p = head;
        while (p != null) {
            Node node = new Node(p.val);
            Node next = p.next;
            p.next = node;
            node.next = next;
            p = next;
        }
    }

    private void copyRandom(Node head) {
        Node p = head;
        Node q;
        while (p != null) {
            q = p.next;
            if (p.random != null) {
                q.random = p.random.next;
            }
            p = p.next.next;
        }
    }

    private Node build(Node head) {
        Node p = head;
        Node q = p.next;
        Node res = q;
        while (p.next.next != null) {
            p.next = q.next;
            p = q.next;
            q.next = p.next;
            q = p.next;
        }
        p.next = null;  //上面操作完后原链表末尾多了一个节点，需要删去
        return res;
    }

}

class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}