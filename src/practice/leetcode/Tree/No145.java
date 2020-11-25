package practice.leetcode.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No145 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(5);

        Solution145 s = new Solution145();
        s.postorderTraversal(root);
    }
}

class Solution145 {
    /**
     * 题目：二叉树的后序遍历
     */

    /**
     * 解法一：递归，敢敢单单
     * 时间、空间：O(n)，空间复杂度平均O(logn)，最坏为链表的情况，为O(n)
     */
/*    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode cur, List<Integer> ans) {
        if (cur == null) {
            return;
        }
        dfs(cur.left, ans);
        dfs((cur.right), ans);
        ans.add(cur.val);
    }*/

    /**
     * 解法二：迭代
     * 时间、空间：O(n)，空间平均O(logn)，最坏为链表的情况，为O(n)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null, cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //从上面while循环中出来，就说明当前节点没有左子节点了
            cur = stack.pop();
            //pre节点的作用就是在从右子节点返回当前节点时，防止再次走向右子节点
            if (cur.right == null || cur.right == pre) {
                ans.add(cur.val);
                pre = cur;
                cur = null;     //cur节点置为null，防止在上面第二个while循环再次向左子节点走
            } else {        //右子节点不为null，并且它没有被访问过，再次将cur这个根节点压栈，并访问右子节点
                stack.push(cur);
                cur = cur.right;
            }
        }
        return ans;
    }
}