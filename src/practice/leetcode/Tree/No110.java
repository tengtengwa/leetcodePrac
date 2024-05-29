package practice.leetcode.Tree;

public class No110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);

        Solution110 s = new Solution110();
        System.out.println(s.isBalanced(root));
    }
}


/**
 * 110. ƽ�������
 * ����һ�����������ж����Ƿ���ƽ�������
 * ƽ������� ��ָ�������нڵ��������������������� 1��
 * https://leetcode.cn/problems/balanced-binary-tree/description/
 */
class Solution110 {
    /**
     * �Ե����Ͻⷨ
     * ���ⷵ��ֵ��-1����ʾ�ýڵ����������ĸ߶Ȳ��Ѿ�>1���ǲ�ƽ���
     * ʱ�临�Ӷȣ�O(n)��ÿ���ڵ�������һ��
     */
//    public boolean isBalanced(TreeNode root) {
//        return dfs(root) >= 0;
//    }
//
//    private int dfs(TreeNode root) {
//        if (root == null) {
//            return 0;
//        }
//        int maxL = dfs(root.left);
//        int maxR = dfs(root.right);
//        if (maxL == -1 || maxR == -1 || Math.abs(maxL - maxR) > 1) {
//            return -1;
//        } else {
//            return Math.max(maxL, maxR) + 1;
//        }
//    }


    /**
     * �Զ�����
     *
     * ʱ�临�Ӷȣ�O(n^2)�������£��������˻�������ṹ������һ���ڵ�p�����ĸ߶���d��
     * ��height(p) ���ᱻ����d�Σ�������������ÿһ�����Ƚڵ�ʱ��
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(getHeight(root.left) - getHeight(root.right)) <= 1
                    && isBalanced(root.left) && isBalanced(root.right);
        }
    }

    private int getHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int mL = getHeight(root.left) + 1;
        int mR = getHeight(root.right) + 1;
        return Math.max(mL, mR);
    }
}