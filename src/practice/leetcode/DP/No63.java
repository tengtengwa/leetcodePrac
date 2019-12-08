package practice.leetcode.DP;

public class No63 {
    public static void main(String[] args) {
        Solution63 solution63 = new Solution63();
        solution63.uniquePathsWithObstacles(new int[][]{{0, 1}});

    }
}

class Solution63 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int R = obstacleGrid.length;        //二维数组行数
        int C = obstacleGrid[0].length;     //列数
        if (obstacleGrid[0][0] == 1) {
            return 0;
        }
        obstacleGrid[0][0] = 1;
        for (int i = 1; i < C; i++) {
            if (obstacleGrid[0][i] == 1) {
                obstacleGrid[0][i] = 0;
            } else {
                obstacleGrid[0][i] = obstacleGrid[0][i - 1];
            }
        }
        for (int j = 1; j < R; j++) {
            if (obstacleGrid[j][0] == 1) {
                obstacleGrid[j][0] = 0;
            } else {
                obstacleGrid[j][0] = obstacleGrid[j - 1][0];
            }
        }
        for (int i = 1; i < R; i++) {
            for (int j = 1; j < C; j++) {
                if (obstacleGrid[i][j] != 1) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                } else {
                    obstacleGrid[i][j] = 0;
                }
            }
        }
        return obstacleGrid[R - 1][C - 1];
    }
}