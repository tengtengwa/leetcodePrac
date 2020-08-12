package practice.leetcode.DP;

public class No221 {
    public static void main(String[] args) {
        Solution221 s = new Solution221();
        s.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}
        });
    }
}

class Solution221 {
    /**
     * 题目：最大正方形，找出由‘0’、‘1’构成的字符数组中最大的正方形面积
     * 思路：两种思路都是求得最大边长，最后返回最大面积
     * <p>
     * 解法一：暴力
     * 1.遍历矩阵中的每个元素，每次遇到 1，则将该元素作为正方形的左上角；
     * 2.确定正方形的左上角后，根据左上角所在的行和列计算可能的最大正方形的边长（正方形的范围不能超出矩阵的行数和列数），
     * 在该边长范围内寻找只包含 1的最大正方形；
     * 3.每次在下方新增一行以及在右方新增一列，判断新增的行和列是否满足所有元素都是 1
     * <p>
     * 时间：O(MN*min(M,N)^2)，
     * 需要遍历整个矩阵寻找每个1,遍历矩阵的时间复杂度是 O(mn)
     * 对于每个可能的正方形，其边长不超过m和n中的最小值，需要遍历该正方形中的每个元素判断是不是只包含1，
     * 遍历正方形时间复杂度是 O(min(m,n)^2)
     * 总时间复杂度是 O(mnmin(m,n)^2)
     * <p>
     * 空间：O(1)
     */

    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    maxSide = Math.max(maxSide, 1);
                    int curMaxside = Math.min(rows - i, columns - j);
                    //从i,j开始向右下角扩张，扩张的最大行列数为curMaxside
                    for (int k = 1; k < curMaxside; k++) {
                        //判断新增的一行一列是否都为‘1’
                        boolean flag = true;
                        if (matrix[i + k][j + k] == '0') {  //判断新增的一行一列的右下角
                            break;
                        }
                        for (int m = 0; m < curMaxside; m++) {  //判断剩下的元素
                            if (matrix[i + m][j + k] == '0' || matrix[i + k][j + m] == '0') {   //注意这里元素的表示
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            maxSide = Math.max(maxSide, k + 1); //正方形每次边长扩张1
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return maxSide * maxSide;
    }

    /** 解法二：动态规划
     * dp[i,j]表示以i，j为右下角的正方形的最大边长，
     * 如果matrix[i][j]为‘1’，则dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])) + 1
     * 否则dp[i][j] = 0。最后记得返回面积！！
     *
     * 时间，空间：(M*N)
     */
/*    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;     //注意判空
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    //这里可以进行优化，开一个int[row+1][col+1]这么大的数组，从1,1开始遍历，
                    // 这样就省去了判断i == 0 || j == 0，空间换时间
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }*//* else {
                    dp[i][j] = 0;   //dp数组默认为0，可以不用这行代码
                }*//*
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max * max;   //注意返回的是面积
    }*/

    /**
     * 动态规划的优化，提交后好像时间没什么变化，额...
     */
/*    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];     //开了一个[row + 1][col + 1]的数组
        int max = 0;
        for (int i = 1; i <= row; i++) {        //注意范围：[1,row]
            for (int j = 1; j <= col; j++) {    //注意范围：[1,col]
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max * max;
    }*/
}