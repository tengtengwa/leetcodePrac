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
        int cur_Node = preOrder[preIndex];  //��ǰ�ڵ��ֵ
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
        //����ĩβ���� null
        if (pre == preorder.length) {
            return null;
        }
        //����ֹͣ�㷵�� null
        //��ǰֹͣ���Ѿ����ˣ�in ����
        if (inorder[in] == stop) {
            in++;
            return null;
        }
        int root_val = preorder[pre++];
        TreeNode root = new TreeNode(root_val);
        //��������ֹͣ���ǵ�ǰ�ĸ��ڵ�
        root.left = buildTreeHelper(preorder, inorder, root_val);
        //��������ֹͣ���ǵ�ǰ����ֹͣ��
        root.right = buildTreeHelper(preorder, inorder, stop);
        return root;
    }
}