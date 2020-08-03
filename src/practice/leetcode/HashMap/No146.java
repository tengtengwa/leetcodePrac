package practice.leetcode.HashMap;

import java.util.HashMap;
import java.util.Map;

public class No146 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );

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
     * 题目：LRU缓存
     * 解法一：直接使用LinkedHashMap，没有什么意思
     * 解法二：使用一个双向链表和一个HashMap来实现LinkedHashMap的功能，注意将增删节点的方法抽出来即可。
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
        } else {    //注意！！！放入新结点时，需要考虑缓存数量是否大于容量
            DLinkedList newNode = new DLinkedList(key, value);
            addToHead(newNode);
            cache.put(key, newNode);
            size++;
            if (size > capacity) {
                //！！！移除完链表中的节点，还需要将哈希表中对应的节点移除，所以removeTail方法需要返回移除的尾结点
                DLinkedList tai = removeTail();
                cache.remove(tai.key);
                size--;
            }
        }
    }

    private void addToHead(DLinkedList node) {
        //记录头结点后一个节点的办法：
        DLinkedList next = head.next;
        head.next = node;
        node.pre = head;
        next.pre = node;
        node.next = next;
/*        //不使用额外空间的办法：
        //1.先将新结点前后指针指向dummy和头节点
        node.pre = head;
        node.next = head.next;
        //2.再将头结点的pre指针和dummy的next指针指向新结点
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