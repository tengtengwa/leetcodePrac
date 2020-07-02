package practice.leetcode.offer;

import java.util.Stack;

public class T19 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(6);
        root.left.left.left = new TreeNode(5);
        root.left.left.left.left = new TreeNode(4);
        SolutionT19 s = new SolutionT19();
        s.Mirror(root);
        System.out.println();
    }
}

/**
 * 思路：先交换根节点，再遍历左右子节点并交换
 */
class SolutionT19 {
    /**
     * 一。递归法
     */
/*    public void Mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {    //注意递归终止条件
            return;
        }
        TreeNode tem = root.right;
        root.right = root.left;
        root.left = tem;
        if (root.left != null) {    //遍历左子树前先判断是否左子树是否为null，防止空指针
            Mirror(root.left);
        }
        if (root.right != null) {   //右子树同理
            Mirror(root.right);
        }
    }*/

    /**
     * 二。用栈迭代
     */
    public void Mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {    //注意递归终止条件
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            TreeNode tem = node.right;
            node.right = node.left;
            node.left = tem;
            if (node.left != null) {    //遍历左子树前先判断是否左子树是否为null，防止空指针
                stack.push(node.left);
            }
            if (node.right != null) {   //右子树同理
                stack.push(node.right);
            }
        }
    }
}