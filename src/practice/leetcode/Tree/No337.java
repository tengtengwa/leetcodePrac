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
     * ��Ŀ����ҽ���2���ʹ�ҽ���1���ƣ�ֻ�������ݽṹ���������˶�����
     * <p>
     * �ⷨ������dp�����ǲ��� �������+dp �ķ�ʽ��������ʹ�ҽ���1���ƣ�ÿ���ڵ㶼��͵�Ͳ�͵����״̬��
     * ͵��ǰ�ڵ㣺��ǰ�ڵ������������������͵����͵��ǰ�ڵ㣺��������͵�Ͳ�͵�����ԣ�ѡ�ϴ���
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

        int[] dp = new int[2];          //ÿ���ڵ��½�һ��dp���鱣��״̬�����һ᷵�ظ���һ��
        //��͵��ǰ�ڵ㣬����Ĵ�����ʵ�����������������͵����͵����͵���Ҳ�͵��
        // ������������ֻ�ܸ���ѡһ�֣���������ȡ��������ϴ�����
        dp[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        //͵��ǰ�ڵ㣬dp[1]Ҳ��ʾ�Ե�ǰ�ڵ�Ϊ���ڵ��������͵��������Ǯ
        dp[1] = left[0] + right[0] + root.val;
        return dp;
    }
}