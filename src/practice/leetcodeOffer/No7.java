package practice.leetcodeOffer;


import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class No7 {
    public static void main(String[] args) {
        Solution7 s = new Solution7();
        s.buildTree(new int[]{3, 9, 6, 20, 15, 7}, new int[]{6, 9, 3, 15, 20, 7});
    }
}

/**
 * 题目：（先中序遍历）重建二叉树
 *
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * 注意：假设输入的前序遍历和中序遍历的结果中都不含重复的数字。!!!    此题如果没有此限制条件则下面两种方法都无效
 */
class Solution7 {
    /**
     * 解法一：递归
     * 思路：每一次遍历时，先通过先序遍历确定当前根节点，再通过根节点在中序遍历中的位置来确定左右子树的范围，因此就可以确定下一层递归时左右子树的范围。
     * 接着对左右子树分别递归即可。
     *
     * 时间：O(n)，n是节点个数
     * 空间复杂度：O(n)，递归时栈的深度h<哈希表所占存储空间n，因此平均空间复杂度为O(n)
     */
    //中序遍历中的元素->index的映射
    /*Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        //下面参数是先序和中序遍历中元素的范围，注意不要越界
        return buildTreeInner(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTreeInner(int[] preorder, int[] inorder, int preStartIndex, int preEndIndex, int inStartIndex, int inEndIndex) {
        if (preStartIndex > preEndIndex) {      //当前先序的范围就是本次递归遍历的范围，一个元素的情况也需要进行遍历，因此注意不要带等号
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStartIndex]);  //先创建当前的根节点
        int midIndex = map.get(preorder[preStartIndex]);        //确定中序遍历中当前根节点的下标
        int leftNum = midIndex - inStartIndex;
        //注意下一次遍历左子树的范围，下一层递归的先中序的范围都是数组中左子树的范围
        root.left = buildTreeInner(preorder, inorder, preStartIndex + 1, preStartIndex + leftNum, inStartIndex, leftNum - 1);
        //右子树也同样要注意范围
        root.right = buildTreeInner(preorder, inorder, preStartIndex + 1 + leftNum, preEndIndex, midIndex + 1, inEndIndex);
        return root;
    }*/


    /**
     * 解法二：迭代
     * 思路：通过栈来保存先序的根、左节点，在遍历的过程中根据特定条件确定根、左节点的范围，同时构建二叉树；遍历完根、左节点后再继续遍历右子树（相当于递归下一层），
     * 直到遍历完成即可
     *
     * 时间：、空间O(n)
     */
    //先序：根、左、右；     中序：左、根、右
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();     //栈中暂时存放先序遍历中根、左节点
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();       //当前栈顶元素就是当前的根节点
            //此条件满足，则说明先序和中序中[根、左]的数对上了，也就是说当前遍历到了先序中右子树的下标，否则还是在左子树；将此左子树元素压栈
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                //满足node.val == inorder[inorderIndex]时，说明当前是右子树的下标；将栈中当前的根、左元素全部出栈，并将此右子树元素压栈作为当前根节点，继续遍历
                while (!stack.isEmpty() && stack.peek().val == inorder[inorderIndex]) {
                    node = stack.pop();
                    inorderIndex++;
                }
                node.right = new TreeNode(preorderVal);
                stack.push(node.right);
            }
        }
        return root;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}