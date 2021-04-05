package practice.leetcodeOffer;

public class No4 {
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        boolean isFind = s.findNumberIn2DArray(new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 17);
        System.out.println(isFind);
    }
}

class Solution4 {
    /**
     * 题目：二维数组中的查找，给定一个二维数组，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序，找出指定的数
     *
     * 解法一：暴力法。双重for循环，一个一个元素的寻找
     * 时间：O(n^2)，空间：O(1)
     */

    /**
     * 解法二：线性查找，利用二维数组每行从左到右递增以及每列从上到下递增的特点，当访问到一个元素时，可以排除数组中的部分元素。
     * 可以从左下角或者右上角第一个元素开始寻找，下面是从左下角第一个元素开始的解法。
     *
     * 时间：O(n)，空间：O(1)
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length - 1, col = 0;
        while (row >= 0 && col < matrix[0].length) {
            int cur = matrix[row][col];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}