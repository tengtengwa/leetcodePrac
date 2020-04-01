package practice.leetcode.DailyQuestion;

public class No892 {
    public static void main(String[] args) {
        Solution892 s = new Solution892();
        s.surfaceArea(new int[][]{
                {1, 2},
                {3, 4}});

    }
}

class Solution892 {
    public int surfaceArea(int[][] grid) {
        int sumBlock = 0;   //总正方体个数
        int sumHide = 0;    //重合的面数的一半
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j + 1 != grid[0].length) {
                    sumHide += Math.min(grid[i][j], grid[i][j + 1]);    //纵向相邻两块重合面
                }
                if (i + 1 != grid.length) {
                    sumHide += Math.min(grid[i][j], grid[i + 1][j]);    //横向相邻两块重合面
                }
                sumBlock += grid[i][j];             //总块数
                sumHide += grid[i][j] != 0 ? grid[i][j] - 1 : 0;
            }
        }

        return sumBlock * 6 - sumHide * 2;
    }
}