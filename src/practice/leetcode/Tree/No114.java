package practice.leetcode.Tree;

import java.util.ArrayDeque;
import java.util.Deque;

public class No114 {
    public static void main(String[] args) {

    }
}

class Solution114 {
    /**
     * 题目：二叉树展开为链表（链表）
     * 这题解法挺多的
     *
     * 解法一：通过循环每次向右子树遍历，
     * 每当当前节点有左子树，就先将右子树挂在左子树的最右叶子结点后，
     * 再用左子树替换右子树，
     * 最后将左子树置空，置空后当前根节点向右挪一位即可
     * 三字经：右挂左，左替右，左置空
     *
     * 两种方式的时间空间复杂度相同，时间：O(n)，空间：O(1)
     */
/*    public void flatten(TreeNode root) {
        while(root != null) {
            if (root.left == null) {
                root = root.right;
            } else {
                //遇到左子树不为空的情况了
                // 步骤一：将右子树挂在左子树最右边的叶子结点后
                TreeNode pre = root.left;
                while (pre.right != null) {
                    pre = pre.right;
                }
                pre.right = root.right;
                //左子树替换右子树
                root.right = root.left;
                //左子树置空
                root.left = null;
                //当前节点向右挪一个位置
                root = root.right;
            }
        }
    }*/


    /**
     * 方法二：因为前序遍历使用左子树替换右子树的方式，需要将被替换的所有右子树都保存起来，不好解决。因此我们的遍历顺序为：
     * 右-> 左-> 根，也就是自底向上的方法。注意不是后序遍历的左、右、根。
     * 而且使用了一个成员变量pre来保存上一层的结果，这样就可以在这一层的根节点的右指针直接指向pre，然后将左指针置空，最后更新pre即可。
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
     * 两种先序遍历解法，都是自上向下
     * 先序遍历解法一：通过先序遍历，将所有节点保存在一个数组中，再次遍历数组，调整它们节点的指向即可。这种方法最为简单
     * 先序遍历解法二：使用栈来保存右子树
     * 这两种的空间复杂度都为O(n)
     */
    public void flatten(TreeNode root) {
        if (root == null)
            return;
        Deque<TreeNode> stack = new ArrayDeque<>();
        stack.add(root);
        TreeNode pre = null;    //依然使用pre节点保存前面的正序结果，和上面一种解法的pre稍有不同
        while (!stack.isEmpty()) {
            TreeNode cur = stack.pollLast();
            if (pre != null) {          //pre不为null，就需要将当前节点cur加入pre链表后了，记得将左指针置空
                pre.right = cur;
                pre.left = null;
            }
            if (cur.right != null) {    //先将右子树压栈，为的是先取出左子树
                stack.add(cur.right);
            }
            if (cur.left != null) {
                stack.add(cur.left);
            }
            pre = cur;
        }
    }
}