package practice.leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class No114 {
    public static void main(String[] args) {

    }
}

class Solution114 {
    /**
     * ��Ŀ��������չ��Ϊ��������
     * ����ⷨͦ���
     *
     * �ⷨһ��ͨ��ѭ��ÿ����������������
     * ÿ����ǰ�ڵ��������������Ƚ�����������������������Ҷ�ӽ���
     * �����������滻��������
     * ����������ÿգ��ÿպ�ǰ���ڵ�����Ųһλ����
     * ���־����ҹ��������ң����ÿ�
     *
     * ���ַ�ʽ��ʱ��ռ临�Ӷ���ͬ��ʱ�䣺O(n)���ռ䣺O(1)
     */
/*    public void flatten(TreeNode root) {
        while(root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                //������������Ϊ�յ������
                // ����һ�����������������������ұߵ�Ҷ�ӽ���
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                //�������滻������
                root.right = root.left;
                //�������ÿ�
                root.left = null;
                //��ǰ�ڵ�����Ųһ��λ��
                root = root.right;
            }
        }
    }*/


    /**
     * ����������Ϊǰ�����ʹ���������滻�������ķ�ʽ����Ҫ�����滻���������������������������ý����������ǵı���˳��Ϊ��
     * ��-> ��-> ����Ҳ�����Ե����ϵķ�����ע�ⲻ�Ǻ�����������ҡ�����
     * ����ʹ����һ����Ա����pre��������һ��Ľ���������Ϳ�������һ��ĸ��ڵ����ָ��ֱ��ָ��pre��Ȼ����ָ���ÿգ�������pre���ɡ�
     */
/*    private TreeNode pre = null;
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        flatten(root.right);
        flatten(root.left);
        root.right = pre;
        root.left = null;
        pre = root;
    }*/


    /**
     * ������������ⷨ��������������
     * ��������ⷨһ��ͨ����������������нڵ㱣����һ�������У��ٴα������飬�������ǽڵ��ָ�򼴿ɡ����ַ�����Ϊ��
     * ��������ⷨ����ʹ��ջ������������
     * �����ֵĿռ临�Ӷȶ�ΪO(n)
     */
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        TreeNode pre = null;    //��Ȼʹ��pre�ڵ㱣��ǰ�����������������һ�ֽⷨ��pre���в�ͬ
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollLast();
            if (pre != null) {          //pre��Ϊnull������Ҫ����ǰ�ڵ�cur����pre������ˣ��ǵý���ָ���ÿ�
                pre.right = cur;
                pre.left = null;
            }
            if (cur.right != null) {    //�Ƚ�������ѹջ��Ϊ������ȡ��������
                stack.add(cur.right);
            }
            if (cur.left != null) {
                stack.add(cur.left);
            }
            pre = cur;
        }
    }
}