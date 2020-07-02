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

/**����106�к����������ǰ������˼·����*/
class SolutionT6 {
    /*
    //�ݹ鷨һ������Ѱ��ǰ��ĳ��Ԫ����Ҫ�������б������Ҹ�Ԫ��λ�ã����Խ���һЩ
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return backTrack(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    TreeNode backTrack(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd) return null;
        TreeNode node = new TreeNode(pre[preStart]);    //���ڵ�
        for (int i = inStart; i <= inEnd; i++) {    //Ѱ��ǰ��ǰԪ���������ж�Ӧ��Ԫ�أ����Է�Χ��[inStart, inEnd]
            if (in[i] == pre[preStart]) {   //����Ҫע������ı߽�����������
                node.left = backTrack(pre, preStart + 1, preStart + i - inStart, in, inStart, i - 1);
                node.right = backTrack(pre, preStart + i - inStart + 1, preEnd, in, i + 1, inEnd);
            }
        }
        return node;
    }*/


    /*
    //�ݹ鷨�������ù�ϣ��洢�������ÿ��Ԫ�ص��±꣬��Ҫʱֱ��ͨ����ϣ���ң������˱���
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
        // �����β��ֱ�ӷ���
        if (pStart == pEnd) return null;
        // ���� preorder �õ����ڵ��ֵ
        TreeNode root = new TreeNode(preorder[pStart]);
        // �õ����ڵ��� inorder �е�λ��
        int iRootIndex = map.get(root.val);
        // ������������
        int leftNum = iRootIndex - iStart;
        // �ݹ�������
        root.left = buildTreeHelper(preorder, pStart + 1, pStart + 1 + leftNum, inorder, iStart, iRootIndex,map);
        // �ݹ�������
        root.right = buildTreeHelper(preorder, pStart + 1 + leftNum, pEnd, inorder, iRootIndex + 1, iEnd,map);
        return root;
    }
    */

    //�ݹ鷨���������ʱ����̫���
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return buildTreeHelper(preorder, inorder, (long) Integer.MAX_VALUE + 1);
    }

    int pre = 0;
    int in = 0;

    private TreeNode buildTreeHelper(int[] preorder, int[] inorder, long stop) {
        // �ҵ����һ���ڵ㣬ֹͣ�ݹ�
        if (pre == preorder.length) return null;
        // �����Ӧ�������������ʱ��֤���Ѿ������˵�ǰ�ڵ������ڵ㣬��ʱ��Ӧ��ֹͣ�ݹ�
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