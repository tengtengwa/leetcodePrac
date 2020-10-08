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
     * 题目：合并二叉树
     *
     * 解法一：DFS（递归）
     * 题目要求将两棵树合并为一个新的二叉树，对应到题解中就是每层新创建了一个节点。
     * 遍历到任意一个节点只有三种情况：
     * 1.两个树当前节点都不为空
     * 2.两个树当前节点都为空
     * 3.两个树当前节点有一个为空
     * 如果本次递归第一或第二个树当前节点为空，就返回给上一层另一个数的当前节点；
     * 否则创建一个新结点，值为两个节点的和，它的左右子树为下一层递归的结果。
     * 最后返回当前层合并后（创建）的节点
     *
     * 时间、空间：O(min(m,n))，m、n分别为两个二叉树的节点个数
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

//        如果没有这个要求就可以将两棵树合并到t1或t2
//        t1.val += t2.val;
//        t1.left = mergeTrees(t1.left, t2.left);
//        t1.right = mergeTrees(t1.right, t2.right);
//        return t1;
    }*/


    /**
     * 解法二：BFS，也就是使用队列进行层序遍历
     * 思路：使用三个队列分别存储两个树当前节点求和后的新结点、第一个和第二个树当前的节点；每次从三个队列取出一个节点，根据左右节点
     * 的情况进行同样的处理：
     * 1.如果两个原始二叉树的左子节点都不为空，则合并后的二叉树的左子节点的值为两个原始二叉树的左子节点的值之和，
     * 在创建合并后的二叉树的左子节点之后，将每个二叉树中的左子节点都加入相应的队列；
     * 2.如果两个原始二叉树的左子节点有一个为空，即有一个原始二叉树的左子树为空，则合并后的二叉树的左子树即为另一个原始二叉树的左子树，
     * 此时也不需要对非空左子树继续遍历，因此不需要将左子节点加入队列。
     * 对于右子节点和右子树，处理方法与左子节点和左子树相同。
     *
     * 时间、空间：O(min(m,n))，m、n分别为两个二叉树的节点个数
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