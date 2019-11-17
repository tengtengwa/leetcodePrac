package practice.leetcode.Dynamic;

public class No64 {
    public static void main(String[] args) {
        Solution64 s = new Solution64();
        s.minPathSum(new int[][]{
                {1, 2, 5},
                {3, 2, 1}});
    }
}

class Solution64 {
    //法一：暴力递归
/*    public int minPathSum(int[][] grid) {
        return Recursion(grid, 0, 0);
    }

    private int Recursion(int[][] grid, int x, int y) {
        if (x == grid.length || y == grid[0].length) {
            return Integer.MAX_VALUE;
        }
        if (x == grid.length - 1 && y == grid[0].length - 1) {
            return grid[x][y];
        }
        return grid[x][y] + Math.min(Recursion(grid, x + 1, y), Recursion(grid, x, y + 1));
    }*/

    //法二：二维动态规划
    public int minPathSum(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        for (int i = R - 1; i >= 0; i--) {
            for (int j = C - 1; j >= 0; j--) {
                if (j + 1 > C - 1 && i + 1 > R - 1) {
                    continue;
                }
                if (j + 1 > C - 1) {
                    grid[i][j] = grid[i][j] + grid[i + 1][j];
                    continue;
                }
                if (i + 1 > R - 1) {
                    grid[i][j] = grid[i][j] + grid[i][j + 1];
                    continue;
                }
                grid[i][j] = grid[i][j] + Math.min(grid[i][j + 1], grid[i + 1][j]);
            }
        }
        return grid[0][0];
    }
}