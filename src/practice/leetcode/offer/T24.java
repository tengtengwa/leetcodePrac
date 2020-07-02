package practice.leetcode.offer;

import java.util.Stack;

public class T24 {
    public static void main(String[] args) {
        SolutionT24 s = new SolutionT24();
        boolean flag = s.VerifySquenceOfBST(new int[]{1, 3, 2, 6, 5});
        System.out.println();
    }
}

class SolutionT24 {

    /**
     * 递归法
     * 时间复杂度 O(N^2) ： 每次调用 recur(i,j)recur(i,j) 减去一个根节点，因此递归占用 O(N) ；最差情况下（即当树退化为链表），
     * 每轮递归都需遍历树所有节点，占用 O(N)。
     * 空间复杂度 O(N) ： 最差情况下（即当树退化为链表），递归深度将达到 N 。
     */

/*    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length <= 0) {
            return false;
        }
        return VerifySquence(sequence, 0, sequence.length - 1);
    }

    private boolean VerifySquence(int[] sequence, int start, int end) {
        if (start >= end) {
            return true;
        }
        int left = start;       //通过left指针遍历一次，如果本次序列满足条件left必==end，否则跳出循环返回false
        while (sequence[left] < sequence[end]) left++;
        int right = left;
        while (sequence[left] > sequence[end]) left++;  //注意这里是sequence[left]
        //下面判断本次结果并进行递归左右子树
        return left == end && VerifySquence(sequence, start, left - 1) && VerifySquence(sequence, right, end - 1);
    }*/


    /**
     * 单调栈法：
     * 后序遍历的逆序是：root->right->left，这里从左到右逐渐递增（遍历完右子树），一旦遇到一个比栈顶元素小的数就进入了左子树
     * 此时更新root节点，继续遍历左子树
     * 时间复杂度：O（N）每个节点进出栈，2n的复杂度，N的级别
     * 空间复杂度：O（N），栈的深度最深为N，此时是一个递增的链表
     */
    public boolean VerifySquenceOfBST(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;       //初始化为虚拟的根节点，此时整个数组的节点相当于都是左子树的节点
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;   //左子树节点都必须小于root，否则不满足二叉排序树定义
            while (!stack.isEmpty() && stack.peek() > postorder[i]) //当栈顶元素大于前一个元素，说明当前元素是左子树的根节点
                root = stack.pop(); //寻找栈中大于左子树且最小的节点，这个就是左子树直接连接的根节点
            stack.add(postorder[i]);
        }
        return true;
    }
}