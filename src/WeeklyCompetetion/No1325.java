package WeeklyCompetetion;

public class No1325 {
    public static void main(String[] args) {
        Solution1325 s = new Solution1325();
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(2);
        root.right.left = new TreeNode(2);
        root.right.right = new TreeNode(4);
        TreeNode node = s.removeLeafNodes(root, 2);

    }
}

class Solution1325 {
/*    public TreeNode removeLeafNodes(TreeNode root, int target) {
        TreeNode dummy = new TreeNode(0);
        if (root != null) {
            dummy.left = root;
            backtrack(dummy, target);
        }
        return dummy.left;
    }

    private void backtrack(TreeNode root, int target) {
        if (root.left != null) {
            backtrack(root.left, target);
        }
        if (root.left != null && root.left.left == null && root.left.right == null && root.left.val == target) {
            root.left = null;
        }
        if (root.right != null) {
            backtrack(root.right, target);
        }
        if (root.right != null && root.right.left == null && root.right.right == null && root.right.val == target) {
            root.right = null;
        }
    }*/

    public TreeNode removeLeafNodes(TreeNode root, int target) {
        if (root==null) return null;
        root.left = removeLeafNodes(root.left, target);
        root.right = removeLeafNodes(root.right, target);
        if (root.val == target && root.left == null && root.right == null) return null;
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}
