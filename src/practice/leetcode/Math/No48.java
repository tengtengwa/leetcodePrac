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
 *   ����һ���Ƚ�����ת�ã��ٽ�ÿһ��Ԫ�ط�ת��ʱ�䣺O(N^2)���ռ�O(1)
 */

class SolutionNo48 {
    public void rotate(int[][] matrix) {
        int len = matrix.length;
        //�Ƚ�����ת�ã���i,jλ�õ�Ԫ�غ�j,iλ�õĽ���
        for (int i = 0; i < len; i++) {     //��ת������������
            for (int j = i; j < len; j++) {
                if (i == j) continue;
                swap(matrix, i, j, j, i);     //��ת��Ϊ��
            }
        }
        //�ٽ�ÿһ�е�Ԫ�ط�ת
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