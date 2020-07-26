package practice.leetcode.Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class No85 {
    public static void main(String[] args) {
        Solution85 s = new Solution85();
        s.maximalRectangle(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '0', '0', '1', '0'}
        });
    }
}

class Solution85 {

    /**
     *���������������ڸ��ӡ�
     * �ⷨһ������ջ�����ⷨԴ��84�ⵥ��ջ�ⷨ��
     * ˼·���ǣ�ÿ�α���ÿһ��Ԫ�أ���̬����һ�����飬��������¼��������ÿ��Ԫ�شӵײ���ʼ�����߶ȣ���ͽ������������תΪ��84�����
     * ��һά�����������о��ε����߶���
     * ʱ�䣺O(NM)��N�����λ����������M����84���е���ջ�ⷨ����ÿһ�е�ʱ�䡣�ռ䣺N(M)��������һ����λ�����������ȵ�����
     */
    /*public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        int max = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[] arr = new int[n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[j] = matrix[i][j] == '1' ? arr[j] += 1 : 0;
            }
            max = Math.max(max, largestRectangleArea(arr));
        }
        return max;
    }

    private int largestRectangleArea(int[] heigths) {
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int len = heigths.length;
        int[] arr = new int[len + 2];
        System.arraycopy(heigths, 0, arr, 1, len);
        len += 2;
        stack.add(0);

        for (int i = 1; i < len; i++) {
            while (arr[stack.peekLast()] > arr[i]) {
                int heigth = arr[stack.pollLast()];
                int width = i - stack.peekLast() - 1;
                max = Math.max(max, heigth * width);
            }
            stack.add(i);
        }
        return max;
    }*/

    /**
     * �ⷨ������̬�滮
     * ˼·��ά���������飬left��right���ֱ��¼��ǰ�����ľ�������������չ����������height��¼���������εĸ߶�
     *
     * ʱ�䣺
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n];        //left����Ԫ�ؼ�¼����ÿһ�е�ǰ�����ľ�������ߵ�һ����0������+1
        int[] right = new int[n];       //��¼ÿһ�е�ǰ�����ľ������ұߵ�һ��0��û�м�1��Ϊ�˼���ʱ�򷽱�
        //����Ҳ����˵������i��ʼ��չ�ľ���������չ��ΧΪ [left[i], right[i])����right����Ԫ�ر��ܴﵽ���ұ߽��1
        int[] height = new int[n];      //��¼ÿһ�о��εĸ߶�

        Arrays.fill(right, n); // initialize right as the rightmost boundary possible

        int maxarea = 0;
        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            // update right
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1')
                    right[j] = Math.min(right[j], cur_right);   //cur_right����������������ߵ�0����ţ�ע����������ǽ�С������
                else {
                    right[j] = n; //���к�����left[j] = 0������������¸߶�height[j] = 0һ��������0��Ҫ�������ã������Ӱ������еĽ��
                    cur_right = j;
                }
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                    left[j] = Math.max(left[j], cur_left);
                }
                else {
                    height[j] = 0;
                    left[j] = 0;
                    cur_left = j + 1;
                }
                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
            }

            /**
             * ��������ѭ����˳���������д��һ��ѭ��������������forѭ��һ��
             */
/*            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                }
                else height[j] = 0;
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    //cur_left���������������ұߵ�0����ż�1��
                    // ע����������left[j]��cur_left�ϴ�ģ����������ľ�������߽�ȡ���ڱ��к���һ�д������ܴﵽ������ֵ
                {
                    left[j] = Math.max(left[j], cur_left);
                }
                else {
                    left[j] = 0;
                    cur_left = j + 1;
                }
            }
            for (int j = 0; j < n; j++) {
                maxarea = Math.max(maxarea, (right[j] - left[j]) * height[j]);
            }*/
        }
        return maxarea;
    }
}