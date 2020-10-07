package practice.leetcode.Tree;

public class No617 {
    public static void main(String[] args) {
        Solution617 s = new Solution617();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);
        s.mergeTrees(t1, t2);
    }
}

class Solution617 {
    /**
     * 题目：合并二叉树
     *
     * 解法一：DFS（递归）
     * 题目要求将两棵树合并为一个新的二叉树，对应到题解中就是每层新创建了一个节点。
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;

//        如果没有这个要求就可以将两棵树合并到t1或t2
//        t1.val += t2.val;
//        t1.left = mergeTrees(t1.left, t2.left);
//        t1.right = mergeTrees(t1.right, t2.right);
//        return t1;
    }
}