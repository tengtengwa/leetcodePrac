package practice.leetcode.offer;

import java.util.Stack;

public class T27 {
    public static void main(String[] args) {

    }
}

class SolutionT27 {
    public TreeNode Convert(TreeNode root) {
        if (root == null) {
            return root;
        }
        if (root.left != null) {
            root.left.right = root.left;
        }
        if (root.right != null) {
            root = root.right;
        }
        return root;
    }
}

