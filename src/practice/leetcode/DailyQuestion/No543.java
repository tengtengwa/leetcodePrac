package practice.leetcode.DailyQuestion;

public class No543 {
    public static void main(String[] args) {


    }
}

class Solution543 {
    int ans = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        getD(root);
        return ans;
    }

    private int getD(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int L = getD(root.left);
        int R = getD(root.right);
        ans = Math.max(ans, L + R + 1);
        return L + R + 1;
    }
}


class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}