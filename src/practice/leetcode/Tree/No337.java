package practice.leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class No337 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(1);
//        root.right = new TreeNode(5);
        root.left.left = new TreeNode(2);
//        root.left.right = new TreeNode(3);
//        root.right.right = new TreeNode(1);
        root.left.left.left = new TreeNode(3);

        Solution337 s = new Solution337();
        s.rob(root);
    }
}

class Solution337 {
    /**
     * 题目：打家劫舍2，和打家劫舍1类似，只不过数据结构从数组变成了二叉树
     * <p>
     * 解法：树形dp，我们采用 后序遍历+dp 的方式来解决。和打家劫舍1类似，每个节点都有偷和不偷两种状态，
     * 偷当前节点：当前节点的左右子树都不能再偷；不偷当前节点：左右子树偷和不偷都可以，选较大者
     */
    public int rob(TreeNode root) {
        int[] arr = dfs(root);
        return Math.max(arr[0], arr[1]);
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);

        int[] dp = new int[2];          //每个节点新建一个dp数组保存状态，并且会返回给上一层
        //不偷当前节点，下面的代码其实包含了四种情况：左偷、左不偷；右偷、右不偷。
        // 但是左右两边只能各自选一种，所以两边取两类情况较大的相加
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //偷当前节点，dp[1]也表示以当前节点为根节点的子树能偷到的最多的钱
        dp[1] = left[0] + right[0] + root.val;
        return dp;
    }
}