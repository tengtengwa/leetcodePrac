package practice.leetcode.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No144 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(5);

        Solution144 s = new Solution144();
        s.preorderTraversal(root);
    }
}

class Solution144 {
    /**
     * 题目：二叉树前序遍历
     */

    /**
     * 解法一：递归
     * 时间、空间：O(n)。平均空间复杂度为O(logn)，最坏为链表的情况，是O(n)
     */
/*    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode cur, List<Integer> list) {
        if (cur != null) {
            list.add(cur.val);
            dfs(cur.left, list);
            dfs(cur.right, list);
        }
    }*/


    /**
     * 解法二：迭代
     * 思路：显示维护一个栈，在当前节点不为空时先一直向左子节点遍历，直到最左边的叶子结点。此时将栈中一个节点出栈，这个就是它的父节点
     * 我们让当前节点指向这个父节点的右子节点，然后继续重复之前的步骤，直到栈为空并且当前节点为null。
     *
     * 时间、空间：O(n)。平均空间复杂度为O(logn)，最坏为链表的情况，是O(n)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                ans.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return ans;
    }
}