package practice.leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 100. 相同的树
 * 给你两棵二叉树的根节点 p 和 q ，编写一个函数来检验这两棵树是否相同。
 * 如果两个树在结构上相同，并且节点具有相同的值，则认为它们是相同的。两个树根节点都为null时，两个树相同。
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
     * 解法一：深搜
     * 注意对根节点和左右子节点判空即可。
     * 时间复杂度：O(min(m,n))，其中m和n分别是两个二叉树的节点数；
     * 空间复杂度：O(min(m,n))
     */
//    public boolean isSameTree(TreeNode p, TreeNode q) {
//        if (p == null && q == null) return true;
//        if (p == null || q == null ) return false;
//        if (p.val != q.val) return false;
//        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
//    }

    /**
     * 解法二：广搜
     * 可以用两个队列，也可以用一个。
     * 时间、空间复杂度：O(min(m,n))
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
                //巧用异或，这里也可以使用||，因为上一行已经判断过都为null的情况了
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