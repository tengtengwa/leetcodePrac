package practice.leetcode.offer;

public class T118 {

}

class SolutionT118 {
    public void Mirror(TreeNode root) {
        reflect(root);
    }

    private TreeNode reflect(TreeNode root) {
        if (root == null || (root.left == null || root.right == null)) {
            return root;
        }
        TreeNode tem = root.right;
        root.right = reflect(root.left);
        root.left = reflect(tem);
        return root;
    }
}