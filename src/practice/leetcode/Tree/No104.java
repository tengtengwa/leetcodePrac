package practice.leetcode.Tree;

import java.util.*;

public class No104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.right.right = new TreeNode(7);

        Solution104 s = new Solution104();
        s.maxDepth(root);
    }
}

class Solution104 {
/*    //µÝ¹é
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int h1 = maxDepth(root.left);
        int h2 = maxDepth(root.right);
        return (h1 > h2 ? h1 : h2) + 1;
    }*/

/*    //Ò»ÐÐµÝ¹é
    public int maxDepth(TreeNode root) {
        return root == null ? 0 : Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }*/

    //µü´ú
    public int maxDepth(TreeNode root) {
        Queue<Pair> queue = new LinkedList<>();
        if (root != null) {
            queue.add(new Pair(root, 1));
        }
        int depth = 0;
        while (!queue.isEmpty()) {
            Pair curr = queue.poll();
            root = curr.getKey();
            int curr_depth = curr.getValue();
            if (root != null) {
                depth = Math.max(depth, curr_depth);
                queue.add(new Pair(root.left, curr_depth + 1));
                queue.add(new Pair(root.right, curr_depth + 1));
            }
        }
        return depth;
    }

    class Pair {
        TreeNode node;
        int height;

        public Pair(TreeNode node, int height) {
            this.node = node;
            this.height = height;
        }

        TreeNode getKey() {
            return node;
        }

        int getValue() {
            return height;
        }
    }
}