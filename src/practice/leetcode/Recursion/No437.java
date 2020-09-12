package practice.leetcode.Recursion;

import java.util.HashMap;

public class No437 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        Solution437 s = new Solution437();
        s.pathSum(root, 8);
    }
}

class Solution437 {
    /**
     * 题目：路径总和3，找出二叉树中路径中数值等于给定sum的个数，路径方向只能向下（只能从父节点到子节点）
     *
     * 解法一：DFS，树的先序遍历，使用一个数组记录当前路径从上到下所有节点的值，每次递归从当前节点向上寻找（就是从数组中
     * 当前指向的节点向左一个个加）
     *
     * 时间复杂度：遍历n个节点，为每个节点计算以当前节点为路径终点的所有路径和，平均路径长度是logn，所以平均时间复杂度是O(nlogn)
     */
/*    int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        dfs(root, sum, new int[1000], 0);
        return ans;
    }

    private void dfs(TreeNode root, int sum, int[] arr, int size) {
        if (root == null) {
            return;
        }
        int tem = root.val;
        if (tem == sum) {       //如果当前节点的值就等于sum，路径数量+1
            ans++;
        }
        for (int i = size - 1; i >= 0; i--) {   //数组从后向前遍历，向上追溯；索引size-1就是当前节点的父节点，
            tem += arr[i];
            if (tem == sum) {
                ans++;
            }
        }
        //数组当前最后一个元素置为当前节点的值，下一层的左右子节点向上追溯时就会沿着父节点向上追溯
        arr[size] = root.val;
        dfs(root.left, sum, arr, size + 1);
        dfs(root.right, sum, arr, size + 1);
    }*/

    /**
     * 解法二：回溯+哈希表
     * 通过哈希表记录当前从根节点到当前节点的所有路径长度，每次递归时通过map.containsKey(curSum - sum)判断当前路径中
     * 是否存在长度为sum的子路径；向下递归时在哈希表中给当前长度和的路径数量+1，回溯时-1并返回当前层长度为sum的路径数
     *
     * 时间：O(n)，所有节点都被遍历了一次
     */
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);      //防止遇到curSum==sum的情况
        return helper(root, sum, 0, map);
    }

    private int helper(TreeNode root, int sum, int curSum, HashMap<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        curSum += root.val;     //curSum为根节点到当前节点的路径和
        if (map.containsKey(curSum - sum)) {
            res += map.get(curSum - sum);
        }
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);   //根节点到当前节点长度的路径数量+1
        res += helper(root.left, sum, curSum, map);
        res += helper(root.right, sum, curSum, map);
        map.put(curSum, map.getOrDefault(curSum, 0) - 1);   //回溯，路径数-1
        return res;
    }
}