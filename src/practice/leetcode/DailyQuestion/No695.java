package practice.leetcode.DailyQuestion;

public class No695 {
    public static void main(String[] args) {
        Solution695 s = new Solution695();
        s.maxAreaOfIsland(new int[][]{
                {0, 1, 0},
                {1, 1, 1},
        });
    }
}

class Solution695 {
    public int maxAreaOfIsland(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                ans = Math.max(ans, dfs(grid, i, j));
            }
        }
        return ans;
    }

    private int[][] arr = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private int dfs(int[][] grid, int i, int j) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == 0) {
            return 0;
        }
        grid[i][j] = 0;
        int area = 1;
        for (int[] xArr : arr) {
            area += dfs(grid, i + xArr[0], j + xArr[1]);
        }
        return area;
    }
}