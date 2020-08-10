package practice.leetcode.Tree;

public class No208 {
    public static void main(String[] args) {
        Trie root = new Trie();
        root.insert("apple");
        boolean p1 = root.search("apple");
        boolean p2 = root.search("app");
        boolean p3 = root.startsWith("app");
        root.insert("app");
        boolean p4 = root.search("app");
        System.out.println(p4);
    }
}


/**
 * 题目：实现Trie（前缀树）
 *
 * 前缀树是一个多叉树的结构，每个节点中有一个数组，长度为Len，一般为所有可能结果的长度；还有一个isEnd记录当前节点是否是（字符串）末尾
 *
 * 时间复杂度：O(N)，N为查找的键的长度；空间：最坏为O(N*M)，即键长*每个节点的子节点数目
 */
class Trie {

    static class Node {
        Node[] next;
        boolean isEnd;
        Node() {
            next = new Node[26];
            isEnd = false;
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        Node root = this.root;
        for (char ch : word.toCharArray()) {
            if (root.next[ch - 'a'] == null) {
                root.next[ch - 'a'] = new Node();
            }
            root = root.next[ch - 'a'];
        }
        root.isEnd = true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node root = this.root;
        for (char ch : word.toCharArray()) {
            if (root.next[ch - 'a'] == null) {
                return false;
            }
            root = root.next[ch - 'a'];
        }
        return root.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node root = this.root;
        for (char ch : prefix.toCharArray()) {
            if (root.next[ch - 'a'] != null) {
                root = root.next[ch - 'a'];
            } else {
                return false;
            }
        }
        return true;
    }
}