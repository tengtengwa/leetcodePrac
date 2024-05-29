package practice.leetcode.Tree;

public class No110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution110 s = new Solution110();
        System.out.println(s.isBalanced(root));
    }
}


/**
 * 110. 平衡二叉树
 * 给定一个二叉树，判断它是否是平衡二叉树
 * 平衡二叉树 是指该树所有节点的左右子树的深度相差不超过 1。
 * https://leetcode.cn/problems/balanced-binary-tree/description/
 */
class Solution110 {
    /**
     * 自底向上解法
     * 留意返回值的-1，表示该节点左右子树的高度差已经>1，是不平衡的
     * 时间复杂度：O(n)，每个节点最多遍历一次
     */
//    public boolean isBalanced(TreeNode root) {
//        return dfs(root) >= 0;
//    }
//
//    private int dfs(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int maxL = dfs(root.left);
//        int maxR = dfs(root.right);
//        if (maxL == -1 || maxR == -1 || Math.abs(maxL - maxR) > 1) {
//            return -1;
//        } else {
//            return Math.max(maxL, maxR) + 1;
//        }
//    }


    /**
     * 自顶向下
     *
     * 时间复杂度：O(n^2)，最坏情况下，二叉树退化成链表结构，对于一个节点p，它的高度是d，
     * 则height(p) 最多会被调用d次（即遍历到它的每一个祖先节点时）
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1
                    && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int mL = getHeight(root.left) + 1;
        int mR = getHeight(root.right) + 1;
        return Math.max(mL, mR);
    }
}