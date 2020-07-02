package practice.leetcode.Math;

public class No48 {
    public static void main(String[] args) {
        SolutionNo48 s = new SolutionNo48();
        int[][] arr = new int[][]{
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        s.rotate(arr);
        System.out.println(arr);
    }
}

/**
 *   [1,2,3],   [7,4,1],
 *   [4,5,6],   [8,5,2],
 *   [7,8,9]    [9,6,3]
 *
 *   方法一：先将矩阵转置，再将每一行元素反转。时间：O(N^2)，空间O(1)
 */

class SolutionNo48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        //先将矩阵转置，即i,j位置的元素和j,i位置的交换
        for (int i = 0; i < len; i++) {     //旋转次数（层数）
            for (int j = i; j < len; j++) {
                if (i == j) continue;
                swap(matrix, i, j, j, i);     //上转换为右
            }
        }
        //再将每一行的元素反转
        for (int k = 0; k < len; k++) {
            for (int i = 0, j = len - 1; i < j; i++, j--) {
                swap(matrix, k, i, k, j);
            }
        }
    }

    private void swap(int[][] matrix, int x1, int y1, int x2, int y2) {
        int tem = matrix[x1][y1];
        matrix[x1][y1] = matrix[x2][y2];
        matrix[x2][y2] = tem;
    }
}