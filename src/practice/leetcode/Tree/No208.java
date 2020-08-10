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
 * ��Ŀ��ʵ��Trie��ǰ׺����
 *
 * ǰ׺����һ��������Ľṹ��ÿ���ڵ�����һ�����飬����ΪLen��һ��Ϊ���п��ܽ���ĳ��ȣ�����һ��isEnd��¼��ǰ�ڵ��Ƿ��ǣ��ַ�����ĩβ
 *
 * ʱ�临�Ӷȣ�O(N)��NΪ���ҵļ��ĳ��ȣ��ռ䣺�ΪO(N*M)��������*ÿ���ڵ���ӽڵ���Ŀ
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