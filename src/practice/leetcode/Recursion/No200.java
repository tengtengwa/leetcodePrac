package practice.leetcode.Recursion;

public class No200 {
    public static void main(String[] args) {
        Solution200 s = new Solution200();
        s.numIslands(new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        });
    }
}

class Solution200 {
    /**
     * 题目：岛屿数量，经典搜索题目
     * 题解：DFS、BFS
     * 下面这个我自己的DFS解法使用了一个辅助数组flag来记录访问过的位置，但也可以直接在原数组上进行修改来节省这部分的空间
     *
     * 时间复杂度：O(MN)，其中M和 N分别为行数和列数。
     * 空间复杂度：O(MN)，在最坏情况下，整个网格均为陆地，深度优先搜索的深度达到 MN。
     */
    private final int[][] path = {
            {0, 1},
            {1, 0},
            {0, -1},
            {-1, 0}
    };

    public int numIslands(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int[][] flag = new int[row][col];
        int ans = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1' && flag[i][j] == 0) {
                    dfs(grid, i, j, flag);
                    ans++;
                }
            }
        }
        return ans;
    }

    private void dfs(char[][] grid, int i, int j, int[][] flag) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        if (grid[i][j] == '1' && flag[i][j] == 0) {
            flag[i][j] = 1;
        } else {
            return;
        }
        for (int k = 0; k < 4; k++) {
            int r = i + path[k][0];
            int c = j + path[k][1];
            dfs(grid, r, c, flag);
        }
    }


    /**
     * 官方的广搜解法，用一个队列来记录走过的位置
     */
/*    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';
                    Queue<Integer> neighbors = new LinkedList<>();
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        if (row - 1 >= 0 && grid[row-1][col] == '1') {
                            neighbors.add((row-1) * nc + col);
                            grid[row-1][col] = '0';
                        }
                        if (row + 1 < nr && grid[row+1][col] == '1') {
                            neighbors.add((row+1) * nc + col);
                            grid[row+1][col] = '0';
                        }
                        if (col - 1 >= 0 && grid[row][col-1] == '1') {
                            neighbors.add(row * nc + col-1);
                            grid[row][col-1] = '0';
                        }
                        if (col + 1 < nc && grid[row][col+1] == '1') {
                            neighbors.add(row * nc + col+1);
                            grid[row][col+1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }*/
}