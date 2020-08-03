package practice.leetcode.HashMap;

import java.util.HashMap;
import java.util.Map;

public class No146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* �������� */ );

        cache.get(2);
        cache.put(2, 6);
        cache.get(1);
        cache.put(1, 5);
        cache.put(1, 2);
        cache.get(1);
        cache.get(2);
    }
}

class LRUCache {

    /**
     * ��Ŀ��LRU����
     * �ⷨһ��ֱ��ʹ��LinkedHashMap��û��ʲô��˼
     * �ⷨ����ʹ��һ��˫�������һ��HashMap��ʵ��LinkedHashMap�Ĺ��ܣ�ע�⽫��ɾ�ڵ�ķ�����������ɡ�
     */
    class DLinkedList {
        private int key;
        private int value;
        DLinkedList pre, next;

        public DLinkedList(int key, int value) {
            this.key = key;
            this.value = value;
        }

        public DLinkedList() {}
    }

    Map<Integer, DLinkedList> cache;
    int size = 0, capacity;
    DLinkedList head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = new DLinkedList();
        tail = new DLinkedList();
        head.next = tail;
        tail.pre = head;
    }

    public int get(int key) {
        DLinkedList node = cache.get(key);
        if (node == null) {
            return -1;
        }
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        DLinkedList oldNode = cache.get(key);
        if (oldNode != null) {
            oldNode.value = value;
            moveToHead(oldNode);
        } else {    //ע�⣡���������½��ʱ����Ҫ���ǻ��������Ƿ��������
            DLinkedList newNode = new DLinkedList(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
            size++;
            if (size > capacity) {
                //�������Ƴ��������еĽڵ㣬����Ҫ����ϣ���ж�Ӧ�Ľڵ��Ƴ�������removeTail������Ҫ�����Ƴ���β���
                DLinkedList tai = removeTail();
                cache.remove(tai.key);
                size--;
            }
        }
    }

    private void addToHead(DLinkedList node) {
        //��¼ͷ����һ���ڵ�İ취��
        DLinkedList next = head.next;
        head.next = node;
        node.pre = head;
        next.pre = node;
        node.next = next;
/*        //��ʹ�ö���ռ�İ취��
        //1.�Ƚ��½��ǰ��ָ��ָ��dummy��ͷ�ڵ�
        node.pre = head;
        node.next = head.next;
        //2.�ٽ�ͷ����preָ���dummy��nextָ��ָ���½��
        head.next.pre = node;
        head.next = node;*/
    }

    private void removeNode(DLinkedList node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }

    private void moveToHead(DLinkedList node) {
        removeNode(node);
        addToHead(node);
    }

    private DLinkedList removeTail() {
        DLinkedList node = tail.pre;
        removeNode(node);
        return node;
    }
}