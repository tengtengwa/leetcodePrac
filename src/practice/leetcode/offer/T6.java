package practice.leetcode.offer;

import java.util.HashMap;

public class T6 {
    public static void main(String[] args) {
        SolutionT6 s = new SolutionT6();
        s.buildTree(new int[]{1, 2, 4, 7, 3, 5, 6, 8}, new int[]{4, 7, 2, 1, 5, 3, 8, 6});
    }
}

/**
 * Definition for binary tree
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode(int x) { val = x; }
 * }
 */

/**力扣106中后序构造和这题前中序构造思路类似*/
class SolutionT6 {
    /*
    //递归法一，这里寻找前序某个元素需要在中序中遍历查找该元素位置，所以较慢一些
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return backTrack(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    TreeNode backTrack(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode node = new TreeNode(pre[preStart]);    //根节点
        for (int i = inStart; i <= inEnd; i++) {    //寻找前序当前元素在中序中对应的元素，所以范围是[inStart, inEnd]
            if (in[i] == pre[preStart]) {   //尤其要注意下面的边界条件！！！
                node.left = backTrack(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                node.right = backTrack(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
            }
        }
        return node;
    }*/


    /*
    //递归法二，采用哈希表存储中序遍历每个元素的下标，需要时直接通过哈希查找，避免了遍历
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    public TreeNode buildTreeHelper(int[] preorder, int pStart, int pEnd,
                                    int[] inorder, int iStart, int iEnd,
                                    HashMap<Integer, Integer> map) {
        // 到达结尾，直接返回
        if (pStart == pEnd) return null;
        // 根据 preorder 拿到根节点的值
        TreeNode root = new TreeNode(preorder[pStart]);
        // 拿到根节点在 inorder 中的位置
        int iRootIndex = map.get(root.val);
        // 左子树的数量
        int leftNum = iRootIndex - iStart;
        // 递归左子树
        root.left = buildTreeHelper(preorder, pStart + 1, pStart + 1 + leftNum, inorder, iStart, iRootIndex,map);
        // 递归右子树
        root.right = buildTreeHelper(preorder, pStart + 1 + leftNum, pEnd, inorder, iRootIndex + 1, iEnd,map);
        return root;
    }
    */

    //递归法三，这个暂时还不太理解
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, (long) Integer.MAX_VALUE + 1);
    }

    int pre = 0;
    int in = 0;

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, long stop) {
        // 找到最后一个节点，停止递归
        if (pre == preorder.length) return null;
        // 当与对应的中序序列相等时，证明已经到达了当前节点的最左节点，这时候应该停止递归
        if (inorder[in] == stop) {
            in++;
            return null;
        }

        int root_val = preorder[pre++];

        TreeNode root = new TreeNode(root_val);

        root.left = buildTreeHelper(preorder, inorder, root_val);

        root.right = buildTreeHelper(preorder, inorder, stop);
        return root;
    }

}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int x) {
        val = x;
    }
}