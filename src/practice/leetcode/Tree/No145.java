package practice.leetcode.Tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class No145 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(5);

        Solution145 s = new Solution145();
        s.postorderTraversal(root);
    }
}

class Solution145 {
    /**
     * ��Ŀ���������ĺ������
     */

    /**
     * �ⷨһ���ݹ飬�Ҹҵ���
     * ʱ�䡢�ռ䣺O(n)���ռ临�Ӷ�ƽ��O(logn)���Ϊ����������ΪO(n)
     */
/*    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode cur, List<Integer> ans) {
        if (cur == null) {
            return;
        }
        dfs(cur.left, ans);
        dfs((cur.right), ans);
        ans.add(cur.val);
    }*/

    /**
     * �ⷨ��������
     * ʱ�䡢�ռ䣺O(n)���ռ�ƽ��O(logn)���Ϊ����������ΪO(n)
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode pre = null, cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            //������whileѭ���г�������˵����ǰ�ڵ�û�����ӽڵ���
            cur = stack.pop();
            //pre�ڵ�����þ����ڴ����ӽڵ㷵�ص�ǰ�ڵ�ʱ����ֹ�ٴ��������ӽڵ�
            if (cur.right == null || cur.right == pre) {
                ans.add(cur.val);
                pre = cur;
                cur = null;     //cur�ڵ���Ϊnull����ֹ������ڶ���whileѭ���ٴ������ӽڵ���
            } else {        //���ӽڵ㲻Ϊnull��������û�б����ʹ����ٴν�cur������ڵ�ѹջ�����������ӽڵ�
                stack.push(cur);
                cur = cur.right;
            }
        }
        return ans;
    }
}