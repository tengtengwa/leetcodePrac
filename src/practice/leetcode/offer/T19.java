package practice.leetcode.offer;

import java.util.Stack;

public class T19 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(7);
        root.left.left = new TreeNode(6);
        root.left.left.left = new TreeNode(5);
        root.left.left.left.left = new TreeNode(4);
        SolutionT19 s = new SolutionT19();
        s.Mirror(root);
        System.out.println();
    }
}

/**
 * ˼·���Ƚ������ڵ㣬�ٱ��������ӽڵ㲢����
 */
class SolutionT19 {
    /**
     * һ���ݹ鷨
     */
/*    public void Mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {    //ע��ݹ���ֹ����
            return;
        }
        TreeNode tem = root.right;
        root.right = root.left;
        root.left = tem;
        if (root.left != null) {    //����������ǰ���ж��Ƿ��������Ƿ�Ϊnull����ֹ��ָ��
            Mirror(root.left);
        }
        if (root.right != null) {   //������ͬ��
            Mirror(root.right);
        }
    }*/

    /**
     * ������ջ����
     */
    public void Mirror(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {    //ע��ݹ���ֹ����
            return;
        }
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            TreeNode tem = node.right;
            node.right = node.left;
            node.left = tem;
            if (node.left != null) {    //����������ǰ���ж��Ƿ��������Ƿ�Ϊnull����ֹ��ָ��
                stack.push(node.left);
            }
            if (node.right != null) {   //������ͬ��
                stack.push(node.right);
            }
        }
    }
}