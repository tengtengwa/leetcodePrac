package practice.leetcode.Tree;

public class No106 {
    public static void main(String[] args) {
        Solution106 s = new Solution106();
        TreeNode root = s.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }
}

/**
 * 由二叉树的中后序遍历构造二叉树
 */

class Solution106 {
    int in;
    int post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //因为后序遍历是每个根节点构建完左右子树后从上个根节点的右子树返回，因此需要从右向左遍历后序数组
        post = postorder.length - 1;
        in = inorder.length - 1;
        return build(inorder, postorder, (long) Integer.MAX_VALUE + 1);
    }

    private TreeNode build(int[] inorder, int[] postorder, long stop) {
        if (post == -1) {
            return null;
        }
        if (inorder[in] == stop) {
            in--;
            return null;
        }
        int root_val = postorder[post--];
        TreeNode root = new TreeNode(root_val);
        //先构建右子树，右子树的停止点是当前的根节点
        root.right = build(inorder, postorder, root_val);
        //左子树的停止点是当前树的停止点
        root.left = build(inorder, postorder, stop);
        return root;
    }
}