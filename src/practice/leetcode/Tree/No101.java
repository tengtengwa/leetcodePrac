package practice.leetcode.Tree;

public class No101 {
    public static void main(String[] args) {
        Solution101 s = new Solution101();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        s.isSymmetric(root);

    }
}

class Solution101 {
    public boolean isSymmetric(TreeNode root) {
        return backTrack(root, root);       //ֻ���жϵ�ǰ�������ж��²��п��ܳ��ֿ�ָ��
    }

    private boolean backTrack(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && backTrack(left.left, right.right) && backTrack(left.right, right.left);
    }
}