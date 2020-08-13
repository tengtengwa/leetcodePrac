package practice.leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class No226 {
    public static void main(String[] args) {


    }
}


class Solution226 {
    /**
     * ��Ŀ����ת������
     *
     * �ⷨһ���ݹ飬�������Ҷ�����
     * ʱ�䡢�ռ䣺O(n)
     */
/*    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }*/

    /**
     * �ⷨ��������
     *
     * ��ʼ��ʱ��ֻ�и��ڵ�������������档ֻҪ������в��գ���һֱ�Ӷ����г��ӽڵ㣬Ȼ�󻥻�����ڵ�����Һ��ӽڵ㣬
     * �����ٰѺ��ӽڵ���ӵ����У��������еĿսڵ㲻��Ҫ������С����ն���һ����գ���ʱ�����нڵ�ĺ��ӽڵ㶼���������ˣ�
     * ֱ�ӷ�������ĸ��ڵ�Ϳ����ˡ�
     *
     * ʱ�䡢�ռ䣺O(n)
     */
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            TreeNode tem = cur.left;
            cur.left = cur.right;
            cur.right = tem;
            if (cur.left!=null) queue.add(cur.left);
            if (cur.right!=null) queue.add(cur.right);
        }
        return root;
    }
}