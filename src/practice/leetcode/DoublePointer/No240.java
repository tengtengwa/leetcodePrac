package practice.leetcode.DoublePointer;

public class No240 {
}

class Solution240 {

    /**
     * 题目：搜索二位矩阵2
     * 搜索 m x n 矩阵 matrix 中的一个目标值 target。该矩阵具有以下特性：
     * 每行的元素从左到右升序排列。每列的元素从上到下升序排列。返回矩阵中是否存在这个target
     *
     * 解法一：暴力双循环，O(mn)
     *
     * 解法二：自己的缩减区间解法
     */
    /*public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int rowStart = -1, rowEnd = -1, colStart = -1, colEnd = -1;
        boolean R = false, C = false;

        //缩减行
        for (int i = 0; i < row; i++) {
            if (target < matrix[i][0]) {    //target小于这行第一个元素，说明target不在这行，更新缩减后的结束行
                break;
            } else if (target == matrix[i][0] || target == matrix[i][col - 1]) {    //target是两边元素之一
                return true;
            } else if (target < matrix[i][col - 1] && !R) {
                //走到这里，说明target在行首和行尾元素大小之间，第一次走到这里时更新缩减后的起始行
                rowStart = i;
                R = true;
            }
            rowEnd = i;
        }
        //缩减列，和上面同理
        for (int i = 0; i < col; i++) {
            if (target < matrix[0][i]) {
                break;
            } else if (target == matrix[0][i] || target == matrix[row - 1][i]) {
                return true;
            } else if (target < matrix[row - 1][i] && !C) {
                colStart = i;
                C = true;
            }
            colEnd = i;
        }
        //起始行起始列在上面都未更新，说明target不存在
        if (rowStart == -1 || colStart == -1) {
            return false;
        }
        for (int i = rowStart; i <= rowEnd; i++) {
            if (binarySearch(matrix, target, colStart, colEnd, i)) {    //这里使用二分和线性搜索效率差别不大
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[][] arr, int target, int i, int j, int row) {
        int left = i, right = j;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[row][mid] == target) {
                return true;
            } else if (arr[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }*/


    /**
     * 解法三：我愿称之为究级无敌炸裂双指针解法
     * 从左下角元素（四个角的元素都可以）开始，每次循环根据情况向上或向右缩减一行
     *
     * 时间复杂度：O(n+m)。空间：O(1)
     * 时间复杂度分析的关键是注意到在每次迭代（我们不返回 true）时，行或列都会精确地递减/递增一次。由于行只能减少m次，
     * 而列只能增加n次，因此在导致 while 循环终止之前，循环不能运行超过n+m次。因为所有其他的工作都是常数，
     * 所以总的时间复杂度在矩阵维数之和中是线性的。
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            //每次循环中row--或col++都相当于缩减一行或一列
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}