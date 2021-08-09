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
 * ��Ŀ����������������ؽ�������
 *
 * ����ĳ��������ǰ���������������Ľ�����빹���ö���������������ڵ㡣
 * ע�⣺���������ǰ���������������Ľ���ж������ظ������֡�!!!    �������û�д������������������ַ�������Ч
 */
class Solution7 {
    /**
     * �ⷨһ���ݹ�
     * ˼·��ÿһ�α���ʱ����ͨ���������ȷ����ǰ���ڵ㣬��ͨ�����ڵ�����������е�λ����ȷ�����������ķ�Χ����˾Ϳ���ȷ����һ��ݹ�ʱ���������ķ�Χ��
     * ���Ŷ����������ֱ�ݹ鼴�ɡ�
     *
     * ʱ�䣺O(n)��n�ǽڵ����
     * �ռ临�Ӷȣ�O(n)���ݹ�ʱջ�����h<��ϣ����ռ�洢�ռ�n�����ƽ���ռ临�Ӷ�ΪO(n)
     */
    //��������е�Ԫ��->index��ӳ��
    /*Map<Integer, Integer> map = new HashMap<>();

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        //�����������������������Ԫ�صķ�Χ��ע�ⲻҪԽ��
        return buildTreeInner(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }

    public TreeNode buildTreeInner(int[] preorder, int[] inorder, int preStartIndex, int preEndIndex, int inStartIndex, int inEndIndex) {
        if (preStartIndex > preEndIndex) {      //��ǰ����ķ�Χ���Ǳ��εݹ�����ķ�Χ��һ��Ԫ�ص����Ҳ��Ҫ���б��������ע�ⲻҪ���Ⱥ�
            return null;
        }
        TreeNode root = new TreeNode(preorder[preStartIndex]);  //�ȴ�����ǰ�ĸ��ڵ�
        int midIndex = map.get(preorder[preStartIndex]);        //ȷ����������е�ǰ���ڵ���±�
        int leftNum = midIndex - inStartIndex;
        //ע����һ�α����������ķ�Χ����һ��ݹ��������ķ�Χ�����������������ķ�Χ
        root.left = buildTreeInner(preorder, inorder, preStartIndex + 1, preStartIndex + leftNum, inStartIndex, leftNum - 1);
        //������Ҳͬ��Ҫע�ⷶΧ
        root.right = buildTreeInner(preorder, inorder, preStartIndex + 1 + leftNum, preEndIndex, midIndex + 1, inEndIndex);
        return root;
    }*/


    /**
     * �ⷨ��������
     * ˼·��ͨ��ջ����������ĸ�����ڵ㣬�ڱ����Ĺ����и����ض�����ȷ��������ڵ�ķ�Χ��ͬʱ�����������������������ڵ���ټ����������������൱�ڵݹ���һ�㣩��
     * ֱ��������ɼ���
     *
     * ʱ�䣺���ռ�O(n)
     */
    //���򣺸������ң�     �����󡢸�����
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        Deque<TreeNode> stack = new LinkedList<>();     //ջ����ʱ�����������и�����ڵ�
        stack.push(root);
        int inorderIndex = 0;
        for (int i = 1; i < preorder.length; i++) {
            int preorderVal = preorder[i];
            TreeNode node = stack.peek();       //��ǰջ��Ԫ�ؾ��ǵ�ǰ�ĸ��ڵ�
            //���������㣬��˵�������������[������]���������ˣ�Ҳ����˵��ǰ�����������������������±꣬��������������������������Ԫ��ѹջ
            if (node.val != inorder[inorderIndex]) {
                node.left = new TreeNode(preorderVal);
                stack.push(node.left);
            } else {
                //����node.val == inorder[inorderIndex]ʱ��˵����ǰ�����������±ꣻ��ջ�е�ǰ�ĸ�����Ԫ��ȫ����ջ��������������Ԫ��ѹջ��Ϊ��ǰ���ڵ㣬��������
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