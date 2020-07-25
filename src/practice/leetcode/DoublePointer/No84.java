package practice.leetcode.DoublePointer;

import java.util.ArrayDeque;
import java.util.Deque;

public class No84 {
    public static void main(String[] args) {
        Solution84 s = new Solution84();
        s.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }
}

class Solution84 {
    /**
     * ����˼·��
     * ���ȣ�Ҫ���ҵ��� i λ����������ʲô��
     * ����iΪ���ģ������ҵ�һ��С�� heights[i] ��λ�� left_i�������ҵ�һ��С���� heights[i] ��λ�� right_i��
     * ��������Ϊ heights[i] * (right_i - left_i -1)
     *
     * �ⷨһ��������
     * ����ö����ÿ������Ϊ�߶ȵ������ε������ÿ������������ɢ���ҳ��˴�����������������ֵ��
     * ʱ�䣺O(n^2)    �ռ䣺O(1)
     */
/*    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            while (left - 1 >= 0 && heights[left - 1] >= heights[i]) {
                left--;
            }
            int rigth = i;
            while (rigth + 1 < heights.length && heights[rigth + 1] >= heights[i]) {
                rigth++;
            }
            max = Math.max(max, heights[i] * (rigth - left + 1));
        }
        return max;
    }*/

    /**
     * �ⷨ��������ջ��������һ��ջ���������һ�α���
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
     * ˼·��ά��һ������ջ��ջ�д洢Ԫ�ص��±ꡣ����������Ԫ�ؾ���ջ���������ͨ����ջȷ��ǰ��һЩ���εĿ�Ⱥ������
     * ʱ�䣺O(N) = �ռ�
     */


/*    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            //��Ϊջ�д洢���±꣬�������淲���漰�Ƚ�����Ԫ�صģ�����ֱ��ͨ��ջ��Ԫ�����Ƚ�
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {    //�Ƚ�Ԫ��
                int heigth = heights[stack.pollLast()];     //��ջ��ȡ�����±�ת��ΪԪ�ض�Ӧ�ľ��θ߶�
                while (!stack.isEmpty() && heights[stack.peekLast()] == heigth) {
                    stack.pollLast();
                }
                //������������������󣬾�˵���ҵ���һ������Ԫ�ر���С�ľ��Σ������Ϳ��������ȣ�����������
                int width;
                if (stack.isEmpty()) {
                    width = i;          //ջ���ˣ�˵��i-1��Ӧ�ľ��ǿ�ȡ���Ϊ������0��ʼ������ǰ��Ԫ�ظ�����ʵ��i-1+1����i���ǿ�ȡ�
                } else {
                    width = i - stack.peekLast() - 1;       //ע�⣬���������м���˶��٣�����Ҫ-1
                }
                max = Math.max(max, heigth * width);
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                stack.pollLast();
            }
            int width;
            if (stack.isEmpty()) {
                width = len;    //��˵��heightΪ��ǰ���Ԫ�صĸ߶ȣ����Կ��ֱ�Ӷ�Ӧ���鳤��
            } else {
                width = len - stack.peekLast() - 1;     //��Ҫע��-1
            }
            max = Math.max(max, height * width);
        }
        return max;
    }*/


    /**
     * �ⷨ�����Ż������������߷ֱ����һ���߶�С��1��Ԫ����Ϊ ���ڱ������Ӷ�����ջΪ�յ��ж�
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] arr = new int[len + 2];
        System.arraycopy(heights, 0, arr, 1, len);
        len += 2;
        arr[0] = 0;
        arr[len - 1] = 0;
        stack.add(0);       //����ջ�з��������һ��Ԫ��0

        //��ԭ����ĵ�һ��Ԫ�ؿ�ʼ��������Ϊ���һ��Ԫ�غ͵�һ����ȣ��������ջ�ض���Ϊ�գ�����������ⷨ���п�
        for (int i = 1; i < len; i++) {
            while (arr[i] < arr[stack.peekLast()]) {    //ÿ���ҵ�������С��ջ����Ԫ�أ��͸���һ�����ֵ
                int heigth = arr[stack.pollLast()];
                int width = i - stack.peekLast() - 1;
                max = Math.max(max, heigth * width);
            }
            stack.add(i);
        }
        return max;
    }
}