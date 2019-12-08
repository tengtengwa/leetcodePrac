package practice.leetcode.Tree;

import java.util.*;

public class No103 {
    public static void main(String[] args) {
        Solution103 s = new Solution103();
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        s.zigzagLevelOrder(root);

    }
}

class Solution103 {
    //迭代法
/*    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        int level_num;
        int level = 1;
        queue.add(root);
        while (!queue.isEmpty()) {
            level_num = queue.size();
            List<Integer> list = new LinkedList<>();
            for (int i = 0; i < level_num; i++) {
                TreeNode node = queue.remove();
                list.add(node.val);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            if (level % 2 == 0) {
                Collections.reverse(list);
            }
            ans.add(list);
            level++;
        }
        return ans;
    }*/

    //递归法
    List<List<Integer>> ans = new LinkedList<>();
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if (root == null) {
            return ans;
        }
        recursion(root, 0);
        return ans;
    }

    private void recursion(TreeNode root, int level) {
        if (ans.size() == level) {
            ans.add(new ArrayList<>());
        }
        if (level % 2 == 0) {
            ans.get(level).add(root.val);
        } else {
            //增加到list首部
            ans.get(level).add(0, root.val);
        }
        if (root.left != null) {
            recursion(root.left, level + 1);
        }
        if (root.right != null) {
            recursion(root.right, level + 1);
        }
    }
}