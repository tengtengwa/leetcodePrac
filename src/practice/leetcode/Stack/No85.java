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
     *暴力法跳过，过于复杂。
     * 解法一：单调栈法，解法源自84题单调栈解法。
     * 思路就是：每次遍历每一行元素，动态更新一个数组，这个数组记录的是这行每个元素从底部开始的最大高度，这就将这个复杂问题转为了84题这个
     * 求一维数组代表的所有矩形的最大高度了
     * 时间：O(NM)，N代表二位数组行数，M代表84题中单调栈解法处理每一行的时间。空间：N(M)，申请了一个二位数组列数长度的数组
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
     * 解法二：动态规划
     * 思路：维护三个数组，left、right，分别记录当前索引的矩形向左、右能扩展到的索引，height记录该索引矩形的高度
     *
     * 时间：
     */
    public int maximalRectangle(char[][] matrix) {
        if (matrix.length == 0) return 0;
        int m = matrix.length;
        int n = matrix[0].length;

        int[] left = new int[n];        //left数组元素记录的是每一行当前索引的矩形最左边第一个有0的索引+1
        int[] right = new int[n];       //记录每一行当前索引的矩形最右边第一个0，没有减1，为了计算时候方便
        //以上也就是说，索引i开始扩展的矩形左右扩展范围为 [left[i], right[i])，即right数组元素比能达到的右边界大1
        int[] height = new int[n];      //记录每一行矩形的高度

        Arrays.fill(right, n); // initialize right as the rightmost boundary possible

        int maxarea = 0;
        for (int i = 0; i < m; i++) {
            int cur_left = 0, cur_right = n;
            // update right
            for (int j = n - 1; j >= 0; j--) {
                if (matrix[i][j] == '1')
                    right[j] = Math.min(right[j], cur_right);   //cur_right是我们遇到的最左边的0的序号，注意这里求的是较小的索引
                else {
                    right[j] = n; //这行和下面left[j] = 0，就像下面更新高度height[j] = 0一样，遇见0就要进行重置，否则会影响后面行的结果
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
             * 下面三个循环的顺序遍历可以写到一个循环里，就像上面这个for循环一样
             */
/*            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    height[j]++;
                }
                else height[j] = 0;
            }
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1')
                    //cur_left是我们遇到的最右边的0的序号加1，
                    // 注意这里是求left[j]和cur_left较大的，即此索引的矩形最左边界取决于本行和上一行此索引能达到的最左值
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