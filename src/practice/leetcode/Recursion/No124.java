package practice.leetcode.Recursion;

public class No124 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        root.left = new TreeNode(11);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution124 s = new Solution124();
        s.maxPathSum(root);
    }
}

class Solution124 {
    /**
     * 递归解法
     * 思路：对于二叉树中的一个节点，该节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值。
     * 如果子节点的最大贡献值为正，则计入该节点的最大路径和，否则不计入该节点的最大路径和。
     *
     * 需要注意的是：当前层的最大路径和=root.val+left.maxSum+right.maxSum，（假设左右子树的最大路径和为正）
     * 而当前层作为上一层的左或右子树，返回的是root.val+max(left.maxSum, right.maxSum)，因为上层在当前层只能走一条路
     *
     */
    private int max = Integer.MIN_VALUE;        //防止只有一个值为负数的根节点
    public int maxPathSum(TreeNode root) {
        recursion(root);
        return max;
    }

    private int recursion(TreeNode root) {
        int value;
        int lSum = 0, rSum = 0;
        if (root.left != null) {
            lSum = recursion(root.left);
            if (lSum < 0) {
                lSum = 0;
            }
        }
        if (root.right != null) {
            rSum = recursion(root.right);
            if (rSum < 0) {
                rSum = 0;
            }
        }
        value = root.val + lSum + rSum;     //计算当前层的最大值，并更新max
        if (value > max) {
            max = value;
        }
        return root.val + Math.max(lSum, rSum);     //返回上一层一条分支的最大和
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}