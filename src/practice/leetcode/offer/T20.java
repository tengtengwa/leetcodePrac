package practice.leetcode.offer;

import java.util.ArrayList;

public class T20 {
    public static void main(String[] args) {
        SolutionT20 s = new SolutionT20();
        ArrayList<Integer> arr = s.printMatrix(new int[][]{
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}});
    }
}

//import java.util.ArrayList;
class SolutionT20 {
    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return ans;
        }
        printMatrixWisely(ans, 0, matrix.length - 1, 0, matrix[0].length - 1, matrix);
        return ans;
    }

    //条件比较容易写错
    private void printMatrixWisely(ArrayList<Integer> ans, int startRow, int endRow, int startCol, int endCol, int[][] matrix) {
        if (startRow < endRow && startCol < endCol) {
            for (int i = startCol; i <= endCol; i++) ans.add(matrix[startRow][i]);  //上
            for (int i = startRow + 1; i <= endRow; i++) ans.add(matrix[i][endCol]);  //右
            for (int i = endCol - 1; i >= startCol; i--) ans.add(matrix[endRow][i]);  //下
            for (int i = endRow - 1; i >= startRow + 1; i--) ans.add(matrix[i][startCol]);  //左
            printMatrixWisely(ans, startRow + 1, endRow - 1, startCol + 1, endCol - 1, matrix);
        } else if (startRow == endRow && startCol < endCol) {  //只有一横行
            for (int i = startCol; i <= endCol; i++) ans.add(matrix[startRow][i]);
        } else if (startRow < endRow && startCol == endCol) {   //只有一竖行
            for (int i = startRow; i <= endRow; i++) ans.add(matrix[i][endCol]);
        } else if (startRow == endRow && startCol == endCol) {
            ans.add(matrix[startRow][startCol]);
        }
    }
}