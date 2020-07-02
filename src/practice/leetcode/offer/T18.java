package practice.leetcode.offer;

public class T18 {

}

class SolutionT18 {
    public boolean HasSubtree(TreeNode root1,TreeNode root2) {
        boolean result = false;
        if(root1 != null && root2 != null) {    //每一步都要小心为null的情况
            if(root1.val == root2.val)
                result = IsContainB(root1, root2);
            if(!result) result = HasSubtree(root1.left, root2);
            if(!result) result = HasSubtree(root1.right, root2);
        }

        return result;
    }

    private boolean IsContainB(TreeNode root1, TreeNode root2) {
        if(root2 == null) return true;
        if(root1 == null) return false;
        if(root1.val != root2.val) return false;
        return IsContainB(root1.left, root2.left) && IsContainB(root1.right, root2.right);
    }
}