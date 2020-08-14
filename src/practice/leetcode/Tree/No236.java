package practice.leetcode.Tree;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class No236 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        TreeNode p = root.left;
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        TreeNode q = root.right.right;

        Solution236 s = new Solution236();
        s.lowestCommonAncestor(root, p, q);
    }
}

class Solution236 {

    /**
     * ��Ŀ������������������ڵ㣬LCA��lowest common ancestor������
     *
     * �ⷨһ���ݹ�
     * ˼·��������������������������������������һ����������������
     * (lson && rson) || (root.val == p.val || root.val == q.val) && (lson || rson)
     * �����������ֱ����p��q�ڵ㣬����ڵ����p��q�ڵ㲢��������������������q��p�ڵ�
     */

/*    private TreeNode ans = null;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return ans;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean lson = dfs(root.left, p, q);
        boolean rson = dfs(root.right, p, q);
        if ((lson && rson) || (root.val == p.val || root.val == q.val) && (lson || rson)) { //����������������ڵ����LCA�ڵ�
            ans = root;
        }
        return lson || rson || (root.val == p.val || root.val == q.val);    //����ֵ����ǰ�ڵ㼰�����Ƿ����p��q�ڵ�
    }*/


    /**
     * �ⷨ����ʹ�ù�ϣ��洢���нڵ�ĸ��ڵ�
     *
     * ˼·�������ע��
     * ʱ��O(N)��ÿ���ڵ����һ�Σ��ռ䣺O(n)���Ϊ�����������ݹ鸴�Ӷ�ΪO(n)���洢ÿ���ڵ�ĸ��ڵ�Ҳ��ҪO(n)
     */
    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);                  //�ȵݹ������������������ÿ���ڵ��ֵ�����ڵ��ӳ�����ڹ�ϣ����
        while (p != null) {         //��p�ڵ���������ÿ�α�Ϊ�Լ��ĸ��ڵ㣬ͬʱ��¼���ʹ��Ľڵ�
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while (q != null) {         //��q�ڵ�������������������Ѿ����ʹ��Ľڵ㣬��ô����ڵ��������������ڵ�
            if (visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }
}