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
     * �ݹ鷨
     * ʱ�临�Ӷ� O(N^2) �� ÿ�ε��� recur(i,j)recur(i,j) ��ȥһ�����ڵ㣬��˵ݹ�ռ�� O(N) ���������£��������˻�Ϊ������
     * ÿ�ֵݹ鶼����������нڵ㣬ռ�� O(N)��
     * �ռ临�Ӷ� O(N) �� �������£��������˻�Ϊ�������ݹ���Ƚ��ﵽ N ��
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
        int left = start;       //ͨ��leftָ�����һ�Σ��������������������left��==end����������ѭ������false
        while (sequence[left] < sequence[end]) left++;
        int right = left;
        while (sequence[left] > sequence[end]) left++;  //ע��������sequence[left]
        //�����жϱ��ν�������еݹ���������
        return left == end && VerifySquence(sequence, start, left - 1) && VerifySquence(sequence, right, end - 1);
    }*/


    /**
     * ����ջ����
     * ��������������ǣ�root->right->left������������𽥵���������������������һ������һ����ջ��Ԫ��С�����ͽ�����������
     * ��ʱ����root�ڵ㣬��������������
     * ʱ�临�Ӷȣ�O��N��ÿ���ڵ����ջ��2n�ĸ��Ӷȣ�N�ļ���
     * �ռ临�Ӷȣ�O��N����ջ���������ΪN����ʱ��һ������������
     */
    public boolean VerifySquenceOfBST(int[] postorder) {
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;       //��ʼ��Ϊ����ĸ��ڵ㣬��ʱ��������Ľڵ��൱�ڶ����������Ľڵ�
        for (int i = postorder.length - 1; i >= 0; i--) {
            if (postorder[i] > root) return false;   //�������ڵ㶼����С��root�����������������������
            while (!stack.isEmpty() && stack.peek() > postorder[i]) //��ջ��Ԫ�ش���ǰһ��Ԫ�أ�˵����ǰԪ�����������ĸ��ڵ�
                root = stack.pop(); //Ѱ��ջ�д�������������С�Ľڵ㣬�������������ֱ�����ӵĸ��ڵ�
            stack.add(postorder[i]);
        }
        return true;
    }
}