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
     * �ݹ�ⷨ
     * ˼·�����ڶ������е�һ���ڵ㣬�ýڵ�����·����ȡ���ڸýڵ��ֵ��ýڵ�������ӽڵ�������ֵ��
     * ����ӽڵ�������ֵΪ���������ýڵ�����·���ͣ����򲻼���ýڵ�����·���͡�
     *
     * ��Ҫע����ǣ���ǰ������·����=root.val+left.maxSum+right.maxSum���������������������·����Ϊ����
     * ����ǰ����Ϊ��һ�����������������ص���root.val+max(left.maxSum, right.maxSum)����Ϊ�ϲ��ڵ�ǰ��ֻ����һ��·
     *
     */
    private int max = Integer.MIN_VALUE;        //��ֹֻ��һ��ֵΪ�����ĸ��ڵ�
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
        value = root.val + lSum + rSum;     //���㵱ǰ������ֵ��������max
        if (value > max) {
            max = value;
        }
        return root.val + Math.max(lSum, rSum);     //������һ��һ����֧������
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}