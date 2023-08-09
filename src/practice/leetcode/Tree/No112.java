package practice.leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112. 路径总和
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，
 * 这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 */
public class No112 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(4);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(11);
        root.left.left.left = new TreeNode(7);
        root.left.left.right = new TreeNode(2);
        root.right.left = new TreeNode(13);
        root.right.right = new TreeNode(4);
        root.right.right.right = new TreeNode(1);

        Solution112 s = new Solution112();
        boolean has = s.hasPathSum(root, 22);
        System.out.println(has);
    }
}

/**
 * 解法一：DFS
 * 注意题目中没有说每个节点的值是否为正，所以不能通过根节点到当前节点的curSum>target就进行剪枝不再继续遍历子节点。
 * 也就是说，必须遍历到叶子结点才可以判断当前路径和!=target。
 * 时间复杂度：O(N)，N为节点数；空间复杂度：O(H)，H为树的高度，当数形为链表时退化最差，为N，平均为logN
 */
class Solution112 {
//    public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null) {
//            return false;
//        }
//        if (root.left == null && root.right == null) {
//            return sum == root.val;
//        }
//        //这里比较巧妙地将下一次递归的target置为curSum-当前节点的val
//        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
//    }

    /**
     * 解法二：BFS
     * 时间复杂度：O(N)，空间复杂度：O(N)，N为节点数量
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.add(new Pair(root, root.val));
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode cur = pair.first;
                int curSum = pair.second;
                if (cur.left != null) {
                    queue.offer(new Pair<>(cur.left, curSum + cur.left.val));
                }
                if (cur.right != null) {
                    queue.offer(new Pair<>(cur.right, curSum + cur.right.val));
                }
                //注意这里在curSum != targetSum时不能直接return，而是continue，因为需要判断队列中其他的叶子结点
                if (cur.left == null && cur.right == null && curSum == targetSum) {
                    return true;
                }
            }
        }
        return false;
    }

    private class Pair<K, V> {
        K first;
        V second;

        Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }
    }
}
