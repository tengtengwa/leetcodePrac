package practice.leetcode.Tree;

import java.util.LinkedList;

public class No98 {
    public static void main(String[] args) {
        Solution98 s = new Solution98();
        TreeNode root = new TreeNode(1);
//        root.left = new TreeNode(-1);
        root.right = new TreeNode(2);
        root.right.right = new TreeNode(3);
        s.isValidBST(root);

    }
}

class Solution98 {
/*    public boolean isValidBST(TreeNode root) {
        return isValid(root,null,null);
    }

    private boolean isValid(TreeNode root, Integer lower, Integer upper) {
        if (root == null) {
            return true;
        }
        int val = root.val;
        if (lower != null && lower >= val) {
            return false;
        }
        if (upper != null && upper <= val) {
            return false;
        }

        if (!isValid(root.left, lower, val)) {
            return false;
        }
        if (!isValid(root.right, val, upper)) {
            return false;
        }
        return true;
    }*/

    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> uppers = new LinkedList<>();
    LinkedList<Integer> lowers = new LinkedList<>();

    public boolean isValidBST(TreeNode root) {
        Integer lower = null, upper = null, val;
        update(root, lower, upper);
        while (!stack.isEmpty()) {
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();
            if (root == null) {
                continue;
            }
            val = root.val;
            if (lower != null && lower >= val) {
                return false;
            }
            if (upper != null && upper <= val) {
                return false;
            }
            update(root.left, lower, val);
            update(root.right, val, upper);
        }
        return true;
    }

    private void update(TreeNode root, Integer lower, Integer upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }
}