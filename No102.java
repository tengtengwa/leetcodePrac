package practice.leetcode.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No102 {
    public static void main(String[] args) {
        Solution102 s = new Solution102();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        s.levelOrder(root);
    }
}

class Solution102 {
/*    //递归法
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return lists;
        }
        helper(root, 0);
        return lists;
    }

    private void helper(TreeNode root, int level) {
        if (lists.size() == level) {
            lists.add(new ArrayList<>());
        }
        lists.get(level).add(root.val);
        if (root.left != null) {
            helper(root.left, level + 1);
        }
        if (root.right != null) {
            helper(root.right, level + 1);
        }
    }*/

    //迭代法（非递归）
    List<List<Integer>> lists = new ArrayList<>();
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return lists;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            lists.add(new ArrayList<>());
            int level_len = queue.size();
            for (int i = 0; i < level_len; i++) {
                TreeNode node = queue.remove();
                lists.get(level).add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            level++;
        }
        return lists;
    }

}