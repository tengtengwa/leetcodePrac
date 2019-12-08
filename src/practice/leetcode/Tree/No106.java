package practice.leetcode.Tree;

public class No106 {
    public static void main(String[] args) {
        Solution106 s = new Solution106();
        TreeNode root = s.buildTree(new int[]{9, 3, 15, 20, 7}, new int[]{9, 15, 7, 20, 3});
    }
}

/**
 * �ɶ��������к���������������
 */

class Solution106 {
    int in;
    int post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        //��Ϊ���������ÿ�����ڵ㹹����������������ϸ����ڵ�����������أ������Ҫ�������������������
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
        //�ȹ�������������������ֹͣ���ǵ�ǰ�ĸ��ڵ�
        root.right = build(inorder, postorder, root_val);
        //��������ֹͣ���ǵ�ǰ����ֹͣ��
        root.left = build(inorder, postorder, stop);
        return root;
    }
}