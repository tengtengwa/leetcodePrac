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

//��һ�ֵݹ�д��
class Solution {
    public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        return backTrack(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    TreeNode backTrack(int[] pre, int preStart, int preEnd, int[] in, int inStart, int inEnd) {
        if (preStart > preEnd || inStart > inEnd)   //�ݹ��������
            return null;
        TreeNode node = new TreeNode(pre[preStart]);    //��ǰ���ڵ�
        for (int index = inStart; index <= inEnd; index++) {    //ǰ��ǰԪ���������е��±꣬��Χ��[inStart, inEnd]
            if (in[index] == pre[preStart]) {           //���������е�Ԫ�غ͵�ǰǰ��ڵ��ֵ��Ƚ�
                //����ı߽�����������Ҫע�⣬���в����ͻ����
                //�ݹ�������ʱǰ��ķ�ΧҲ������[preStart+1, preEnd]����������������[preStart + index - inStart + 1, inEnd]
                node.left = backTrack(pre, preStart + 1, preStart + index - inStart, in, inStart, index - 1);
                node.right = backTrack(pre, preStart + index - inStart + 1, preEnd, in, index + 1, inEnd);
            }
        }
        return node;
    }
}