package practice.leetcode.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No236 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        TreeNode p = root.left;
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode q = root.right.right;

        Solution236 s = new Solution236();
        s.lowestCommonAncestor(root, p, q);
    }
}

class Solution236 {

    /**
     * 题目：二叉树的最近公共节点，LCA（lowest common ancestor）问题
     *
     * 解法一：递归
     * 思路：后序遍历二叉树，符合条件的最近公共祖先一定满足如下条件：
     * (lson && rson) || (root.val == p.val || root.val == q.val) && (lson || rson)
     * 即左右子树分别包含p和q节点，或根节点就是p或q节点并且左子树或右子树中有q或p节点
     */

/*    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || (root.val == p.val || root.val == q.val) && (lson || rson)) { //满足这个条件，根节点就是LCA节点
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);    //返回值代表当前节点及子树是否包含p或q节点
    }*/


    /**
     * 解法二：使用哈希表存储所有节点的父节点
     *
     * 思路如下面的注释
     * 时间O(N)，每个节点访问一次；空间：O(n)，最坏为链表的情况，递归复杂度为O(n)，存储每个节点的父节点也需要O(n)
     */
    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);                  //先递归遍历整个二叉树，将每个节点的值到父节点的映射存放在哈希表中
        while (p != null) {         //从p节点向上跳，每次变为自己的父节点，同时记录访问过的节点
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {         //从q节点向上跳，如果遇到了已经访问过的节点，那么这个节点就是最近公共父节点
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }
}