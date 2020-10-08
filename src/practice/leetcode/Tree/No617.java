package practice.leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

public class No617 {
    public static void main(String[] args) {
        Solution617 s = new Solution617();
        TreeNode t1 = new TreeNode(1);
        t1.left = new TreeNode(3);
        t1.right = new TreeNode(2);
        t1.left.left = new TreeNode(5);
        TreeNode t2 = new TreeNode(2);
        t2.left = new TreeNode(1);
        t2.right = new TreeNode(3);
        t2.left.right = new TreeNode(4);
        t2.right.right = new TreeNode(7);
        s.mergeTrees(t1, t2);
    }
}

class Solution617 {
    /**
     * ��Ŀ���ϲ�������
     *
     * �ⷨһ��DFS���ݹ飩
     * ��ĿҪ���������ϲ�Ϊһ���µĶ���������Ӧ������о���ÿ���´�����һ���ڵ㡣
     * ����������һ���ڵ�ֻ�����������
     * 1.��������ǰ�ڵ㶼��Ϊ��
     * 2.��������ǰ�ڵ㶼Ϊ��
     * 3.��������ǰ�ڵ���һ��Ϊ��
     * ������εݹ��һ��ڶ�������ǰ�ڵ�Ϊ�գ��ͷ��ظ���һ����һ�����ĵ�ǰ�ڵ㣻
     * ���򴴽�һ���½�㣬ֵΪ�����ڵ�ĺͣ�������������Ϊ��һ��ݹ�Ľ����
     * ��󷵻ص�ǰ��ϲ��󣨴������Ľڵ�
     *
     * ʱ�䡢�ռ䣺O(min(m,n))��m��n�ֱ�Ϊ�����������Ľڵ����
     */
/*    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode merged = new TreeNode(t1.val + t2.val);
        merged.left = mergeTrees(t1.left, t2.left);
        merged.right = mergeTrees(t1.right, t2.right);
        return merged;

//        ���û�����Ҫ��Ϳ��Խ��������ϲ���t1��t2
//        t1.val += t2.val;
//        t1.left = mergeTrees(t1.left, t2.left);
//        t1.right = mergeTrees(t1.right, t2.right);
//        return t1;
    }*/


    /**
     * �ⷨ����BFS��Ҳ����ʹ�ö��н��в������
     * ˼·��ʹ���������зֱ�洢��������ǰ�ڵ���ͺ���½�㡢��һ���͵ڶ�������ǰ�Ľڵ㣻ÿ�δ���������ȡ��һ���ڵ㣬�������ҽڵ�
     * ���������ͬ���Ĵ���
     * 1.�������ԭʼ�����������ӽڵ㶼��Ϊ�գ���ϲ���Ķ����������ӽڵ��ֵΪ����ԭʼ�����������ӽڵ��ֵ֮�ͣ�
     * �ڴ����ϲ���Ķ����������ӽڵ�֮�󣬽�ÿ���������е����ӽڵ㶼������Ӧ�Ķ��У�
     * 2.�������ԭʼ�����������ӽڵ���һ��Ϊ�գ�����һ��ԭʼ��������������Ϊ�գ���ϲ���Ķ���������������Ϊ��һ��ԭʼ����������������
     * ��ʱҲ����Ҫ�Էǿ�������������������˲���Ҫ�����ӽڵ������С�
     * �������ӽڵ���������������������ӽڵ����������ͬ��
     *
     * ʱ�䡢�ռ䣺O(min(m,n))��m��n�ֱ�Ϊ�����������Ľڵ����
     */
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null) {
            return t2;
        }
        if (t2 == null) {
            return t1;
        }
        TreeNode root = new TreeNode(t1.val + t2.val);
        Queue<TreeNode> queue = new LinkedList<>();
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue.offer(root);
        queue1.offer(t1);
        queue2.offer(t2);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode node1 = queue1.poll(), node2 = queue2.poll();
            TreeNode left1 = node1.left, left2 = node2.left, right1 = node1.right, right2 = node2.right;
            if (left1 != null || left2 != null) {
                if (left1 != null && left2 != null) {
                    TreeNode left = new TreeNode(left1.val + left2.val);
                    node.left = left;
                    queue.offer(left);
                    queue1.offer(left1);
                    queue2.offer(left2);
                } else if (left1 != null) {
                    node.left = left1;
                } else if (left2 != null) {
                    node.left = left2;
                }
            }
            if (right1 != null || right2 != null) {
                if (right1 != null && right2 != null) {
                    TreeNode right = new TreeNode(right1.val + right2.val);
                    node.right = right;
                    queue.offer(right);
                    queue1.offer(right1);
                    queue2.offer(right2);
                } else if (right1 != null) {
                    node.right = right1;
                } else if (right2 != null) {
                    node.right = right2;
                }
            }
        }
        return root;
    }
}