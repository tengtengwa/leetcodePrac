package practice.leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. ��ͬ����
 * �������ö������ĸ��ڵ� p �� q ����дһ���������������������Ƿ���ͬ��
 * ����������ڽṹ����ͬ�����ҽڵ������ͬ��ֵ������Ϊ��������ͬ�ġ����������ڵ㶼Ϊnullʱ����������ͬ��
 */
public class No100 {
    public static void main(String[] args) {
        Solution100 s = new Solution100();
        TreeNode root1 = new TreeNode(1);
        root1.left = new TreeNode(2);
//        root1.right = new TreeNode(3);

        TreeNode root2 = new TreeNode(1);
        root2.right = new TreeNode(2);
//        root2.left = new TreeNode(2);

        s.isSameTree(root1, root2);

    }
}

class Solution100 {
    /**
     * �ⷨһ������
     * ע��Ը��ڵ�������ӽڵ��пռ��ɡ�
     * ʱ�临�Ӷȣ�O(min(m,n))������m��n�ֱ��������������Ľڵ�����
     * �ռ临�Ӷȣ�O(min(m,n))
     */
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (p == null && q == null) return true;
//        if (p == null || q == null ) return false;
//        if (p.val != q.val) return false;
//        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//    }

    /**
     * �ⷨ��������
     * �������������У�Ҳ������һ����
     * ʱ�䡢�ռ临�Ӷȣ�O(min(m,n))
     */
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        Queue<TreeNode> queue1 = new LinkedList<>();
        Queue<TreeNode> queue2 = new LinkedList<>();
        queue1.offer(p);
        queue2.offer(q);
        while (!queue1.isEmpty() && !queue2.isEmpty()) {
            int size1 = queue1.size(), size2 = queue2.size();
            while (size1 > 0 && size2 > 0) {
                TreeNode node1 = queue1.poll();
                TreeNode node2 = queue2.poll();
                size1--;
                size2--;
                if (node1 == null && node2 == null) continue;
                //�����������Ҳ����ʹ��||����Ϊ��һ���Ѿ��жϹ���Ϊnull�������
                if ((node1 == null ^ node2 == null) || node1.val != node2.val) return false;
                queue1.offer(node1.left);
                queue2.offer(node2.left);
                queue1.offer(node1.right);
                queue2.offer(node2.right);
            }
        }
        return true;
    }
}