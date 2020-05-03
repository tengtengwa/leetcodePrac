package practice.leetcode.Tree;

import java.util.HashMap;

public class No105 {
    public static void main(String[] args) {
        Solution105 s = new Solution105();
        TreeNode root = s.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
    }
}

class Solution105 {
/*     int preIndex = 0;
    int[] preOrder;
    int[] inOrder;
    HashMap<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length) {
            return null;
        }
        preOrder = preorder;
        inOrder = inorder;
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return build(0, inorder.length - 1);
    }

    private TreeNode build(int start, int end) {
        if (start > end) {
            return null;
        }
        int cur_Node = preOrder[preIndex];  //当前节点的值
        preIndex++;
        TreeNode node = new TreeNode(cur_Node);
        int index = map.get(cur_Node);
        node.left = build(start, index - 1);
        node.right = build(index + 1, end);
        return node;
    }*/


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, (long) Integer.MAX_VALUE + 1);
    }

    int pre = 0;
    int in = 0;

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, long stop) {
        //到达末尾返回 null
        if (pre == preorder.length) {
            return null;
        }
        //到达停止点返回 null
        //当前停止点已经用了，in 后移
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        int root_val = preorder[pre++];
        TreeNode root = new TreeNode(root_val);
        //左子树的停止点是当前的根节点
        root.left = buildTreeHelper(preorder, inorder, root_val);
        //右子树的停止点是当前树的停止点
        root.right = buildTreeHelper(preorder, inorder, stop);
        return root;
    }
}

//另一种递归写法
class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return backTrack(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    TreeNode backTrack(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)   //递归结束条件
            return null;
        TreeNode node = new TreeNode(pre[preStart]);    //当前根节点
        for (int index = inStart; index <= inEnd; index++) {    //前序当前元素在中序中的下标，范围是[inStart, inEnd]
            if (in[index] == pre[preStart]) {           //遍历中序中的元素和当前前序节点的值相比较
                //下面的边界条件尤其需要注意，稍有不慎就会出错
                //递归左子树时前序的范围也可以是[preStart+1, preEnd]，但右子树必须是[preStart + index - inStart + 1, inEnd]
                node.left = backTrack(pre, preStart + 1, preStart + index - inStart, in, inStart, index - 1);
                node.right = backTrack(pre, preStart + index - inStart + 1, preEnd, in, index + 1, inEnd);
            }
        }
        return node;
    }
}