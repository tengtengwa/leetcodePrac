package practice.leetcode.Tree;

import java.util.LinkedList;
import java.util.List;

public class No95 {
    public static void main(String[] args) {
        Solution95 s = new Solution95();
        s.generateTrees(3);
    }
}

class Solution95 {
/*    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        } else {
            return generate_trees(1, n);
        }
    }

    private LinkedList<TreeNode> generate_trees(int start, int end) {
        LinkedList<TreeNode> ans = new LinkedList<>();
        if (start > end) {
            ans.add(null);
            return ans;
        }
        for (int i = start; i <= end; i++) {
            //��Ϊÿ�����ڵ������ӽڵ�һ������ϲ����ģ������Ƚ��еݹ�
            //�ݹ���������
            LinkedList<TreeNode> left_trees = generate_trees(start, i - 1);
            LinkedList<TreeNode> right_trees = generate_trees(i + 1, end);
            for (TreeNode l : left_trees) {
                for (TreeNode r : right_trees) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = l;
                    cur.right = r;
                    ans.add(cur);
                }
            }
        }
        return ans;
    }*/

    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new LinkedList<>();
        } else {
            return generate(1, n);
        }
    }

    private List<TreeNode> generate(int start, int end) {
        List<TreeNode> ans = new LinkedList<>();
        //�ݹ���ȷ����ֹ����
        if (start > end) {
            ans.add(null);
            return ans;
        }
        for (int i = start; i <= end; i++) {
            //�ȵݹ��������
            List<TreeNode> left_trees = generate(start, i - 1);
            List<TreeNode> right_trees = generate(i + 1, end);
            for (TreeNode L : left_trees) {
                for (TreeNode R : right_trees) {
                    TreeNode cur = new TreeNode(i);
                    cur.left = L;
                    cur.right = R;
                    ans.add(cur);
                }
            }
        }
        return ans;
    }

}