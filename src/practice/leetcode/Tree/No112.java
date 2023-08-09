package practice.leetcode.Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 112. ·���ܺ�
 * ����������ĸ��ڵ� root ��һ����ʾĿ��͵����� targetSum ���жϸ������Ƿ���� ���ڵ㵽Ҷ�ӽڵ� ��·����
 * ����·�������нڵ�ֵ��ӵ���Ŀ��� targetSum ��������ڣ����� true �����򣬷��� false ��
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
 * �ⷨһ��DFS
 * ע����Ŀ��û��˵ÿ���ڵ��ֵ�Ƿ�Ϊ�������Բ���ͨ�����ڵ㵽��ǰ�ڵ��curSum>target�ͽ��м�֦���ټ��������ӽڵ㡣
 * Ҳ����˵�����������Ҷ�ӽ��ſ����жϵ�ǰ·����!=target��
 * ʱ�临�Ӷȣ�O(N)��NΪ�ڵ������ռ临�Ӷȣ�O(H)��HΪ���ĸ߶ȣ�������Ϊ����ʱ�˻���ΪN��ƽ��ΪlogN
 */
class Solution112 {
//    public boolean hasPathSum(TreeNode root, int sum) {
//        if (root == null) {
//            return false;
//        }
//        if (root.left == null && root.right == null) {
//            return sum == root.val;
//        }
//        //����Ƚ�����ؽ���һ�εݹ��target��ΪcurSum-��ǰ�ڵ��val
//        return hasPathSum(root.left, sum - root.val) || hasPathSum(root.right, sum - root.val);
//    }

    /**
     * �ⷨ����BFS
     * ʱ�临�Ӷȣ�O(N)���ռ临�Ӷȣ�O(N)��NΪ�ڵ�����
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
                //ע��������curSum != targetSumʱ����ֱ��return������continue����Ϊ��Ҫ�ж϶�����������Ҷ�ӽ��
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
