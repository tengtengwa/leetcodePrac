package practice.leetcode.Tree;

import java.util.*;

public class No107 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(5);

        Solution107 s = new Solution107();
        s.levelOrderBottom(root);
    }
}


class Solution107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            //遍历当前层
            res.add(new ArrayList<>());
            //当前层的元素个数
            int level_len = queue.size();
            for (int i = 0; i < level_len; i++) {
                TreeNode node = queue.remove();
                //在当前层的list中添加元素
                res.get(level).add(node.val);
                //将当前层的孩子节点入队,在下一层遍历
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
            //进入下一层
            level++;
        }
        Collections.reverse(res);
        return res;
    }
}