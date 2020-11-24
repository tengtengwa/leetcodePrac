package practice.leetcode.Tree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No144 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
//        root.left.right = new TreeNode(5);
//        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(5);

        Solution144 s = new Solution144();
        s.preorderTraversal(root);
    }
}

class Solution144 {
    /**
     * ��Ŀ��������ǰ�����
     */

    /**
     * �ⷨһ���ݹ�
     * ʱ�䡢�ռ䣺O(n)��ƽ���ռ临�Ӷ�ΪO(logn)���Ϊ������������O(n)
     */
/*    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        dfs(root, ans);
        return ans;
    }

    private void dfs(TreeNode cur, List<Integer> list) {
        if (cur != null) {
            list.add(cur.val);
            dfs(cur.left, list);
            dfs(cur.right, list);
        }
    }*/


    /**
     * �ⷨ��������
     * ˼·����ʾά��һ��ջ���ڵ�ǰ�ڵ㲻Ϊ��ʱ��һֱ�����ӽڵ������ֱ������ߵ�Ҷ�ӽ�㡣��ʱ��ջ��һ���ڵ��ջ������������ĸ��ڵ�
     * �����õ�ǰ�ڵ�ָ��������ڵ�����ӽڵ㣬Ȼ������ظ�֮ǰ�Ĳ��裬ֱ��ջΪ�ղ��ҵ�ǰ�ڵ�Ϊnull��
     *
     * ʱ�䡢�ռ䣺O(n)��ƽ���ռ临�Ӷ�ΪO(logn)���Ϊ������������O(n)
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        TreeNode cur = root;
        while (!stack.isEmpty() || cur != null) {
            while (cur != null) {
                ans.add(cur.val);
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            cur = cur.right;
        }
        return ans;
    }
}