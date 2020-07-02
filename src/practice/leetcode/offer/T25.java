package practice.leetcode.offer;

import java.util.ArrayList;

public class T25 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(12);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        SolutionT25 s = new SolutionT25();
        ArrayList<ArrayList<Integer>> ans = s.FindPath(root, 22);
        System.out.println(ans);
    }
}

class SolutionT25 {
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (root == null || root.val > target) {
            return ans;
        }
        ArrayList<Integer> tem = new ArrayList<>();
        tem.add(root.val);
        findAllPath(root, ans, tem, target, root.val);
        return ans;
    }

    private void findAllPath(TreeNode root, ArrayList<ArrayList<Integer>> ans, ArrayList<Integer> tem, int target, int cur) {
        if (cur == target && root.left == null && root.right == null) {
            ans.add(new ArrayList<>(tem));
            tem.remove(tem.size() - 1);
            return;
        }
        if (root.left != null) {
            tem.add(root.left.val);
            findAllPath(root.left, ans, tem, target, cur + root.left.val);
        }
        if (root.right != null) {
            tem.add(root.right.val);
            findAllPath(root.right, ans, tem, target, cur + root.right.val);
        }
        tem.remove(tem.size() - 1);
    }
}