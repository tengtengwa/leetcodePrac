package practice.leetcode.offer;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class T23 {
    public static void main(String[] args) {
        SolutionT23 s = new SolutionT23();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        s.PrintFromTopToBottom(root);
    }
}

class SolutionT23 {
    public ArrayList<Integer> PrintFromTopToBottom(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        ArrayList<Integer> ans = new ArrayList<>();
        if (root == null) return ans;
        queue.add(root);
        while (queue.size() != 0) {
            TreeNode node = queue.poll();
            ans.add(node.val);
            if (node.left != null) queue.offer(node.left);
            if (node.right != null) queue.offer(node.right);
        }
        return ans;
    }
}
