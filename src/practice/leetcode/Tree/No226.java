package practice.leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class No226 {
    public static void main(String[] args) {


    }
}


class Solution226 {
    /**
     * 题目：反转二叉树
     *
     * 解法一：递归，先左先右都可以
     * 时间、空间：O(n)
     */
/*    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }*/

    /**
     * 解法二：迭代
     *
     * 开始的时候，只有根节点在这个队列里面。只要这个队列不空，就一直从队列中出队节点，然后互换这个节点的左右孩子节点，
     * 接着再把孩子节点入队到队列，对于其中的空节点不需要加入队列。最终队列一定会空，这时候所有节点的孩子节点都被互换过了，
     * 直接返回最初的根节点就可以了。
     *
     * 时间、空间：O(n)
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode tem = cur.left;
            cur.left = cur.right;
            cur.right = tem;
            if (cur.left!=null) queue.add(cur.left);
            if (cur.right!=null) queue.add(cur.right);
        }
        return root;
    }
}