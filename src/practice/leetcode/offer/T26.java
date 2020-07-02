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
     * �ⷨһ��ʹ�ù�ϣ����һ���½�ԭ��������нڵ㲢��nextָ�����ӣ�ͬʱ��¼ԭ����ÿ���ڵ㵽�½�����ÿ���ڵ��ӳ�䣻
     * �ڶ����ٸ��½���������randomָ�롣
     * ʱ�临�Ӷȣ�O��n�����ռ临�Ӷȣ�O��n��
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
            //����ʹ�ù�ϣ��������Ż�����Ȼÿ��Ҫ����ԭ�����ҵ���ǰ�ڵ�randomָ����ָ�ڵ㣨ʱ�临�Ӷ�Ϊn^2��
            if (phead.random != null) { //���ԭ����ǰ�ڵ���randomָ�룬��ͨ����ϣ���ҵ�randomָ����ָ�ڵ㲢���ø�������ǰ�ڵ�
                p.random = map.get(phead.random);
            }
            phead = phead.next;
            p = p.next;
        }
        return res;
    }*/

    /**
     * ������������ڲ�ʹ�ø����ռ�������ʵ��O(n)��ʱ��Ч�ʡ�
     * ��һ�������ƽڵ㣺��ԭʼ���������ڵ� N����Ϊ�½ڵ�N',�ٰ�N'���ӵ� N�ĺ��档
     * �����ԭʼ����ΪA->B->C->D ���ƹ���ΪA->A'->B->B'->C->C'->D->D'
     * �ڶ���:ȷ��ÿ�������ڵ�N'��randomָ��ָ��
     * ��Ȼ�����ԭʼ�����ϵĽڵ� N ��randomָ��ָ��ڵ�S,������Ӧ�ĸ��ƽڵ�N'��randomָ��ָ��ڵ�S�ĸ��ƽڵ�S',Ҳ���ǵ�ǰ�ڵ�S����һ���ڵ㡣
     * ������:������������ֳ���������,������λ�õĽڵ�������������ԭʼ����,��ż��λ�õĽڵ������������Ǹ��Ƴ���������
     * ע�⣬��ʱ�ڵõ����������ͬʱ����Ҫ���ǽ�ԭ��������и�ԭ��
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
        p.next = null;  //����������ԭ����ĩβ����һ���ڵ㣬��Ҫɾȥ
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