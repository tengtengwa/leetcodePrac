package practice.leetcode.Recursion;

import java.util.LinkedList;
import java.util.Queue;

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
     * ��Ŀ����������������������Ŀ
     * ��⣺DFS��BFS
     * ����������Լ���DFS�ⷨʹ����һ����������flag����¼���ʹ���λ�ã���Ҳ����ֱ����ԭ�����Ͻ����޸�����ʡ�ⲿ�ֵĿռ�
     *
     * ʱ�临�Ӷȣ�O(MN)������M�� N�ֱ�Ϊ������������
     * �ռ临�Ӷȣ�O(MN)���������£����������Ϊ½�أ����������������ȴﵽ MN��
     */
/*    private final int[][] path = {
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
        //�ж��Ƿ�Խ��
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length) {
            return;
        }
        //�жϵ�ǰλ���Ƿ���Ч����λ�ò���½�ػ��Ѿ����ʹ�����Ч�����أ�
        if (grid[i][j] == '0' && flag[i][j] == 1) {
            return;
        }
        flag[i][j] = 1;     //��Ǵ�λ���Ѿ����ʹ�

        for (int k = 0; k < 4; k++) {
            int r = i + path[k][0];
            int c = j + path[k][1];
            dfs(grid, r, c, flag);
        }
    }*/


    /**
     * �ٷ��Ĺ��ѽⷨ����һ����������¼�߹���λ��
     *
     * ʱ�䣺O(mn)���ռ䣺O(min(m,n))
     */
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }

        int nr = grid.length;
        int nc = grid[0].length;
        int num_islands = 0;

        for (int r = 0; r < nr; ++r) {
            for (int c = 0; c < nc; ++c) {
                //��ǰλ����½���ټ������У�ע�����ַ�
                if (grid[r][c] == '1') {
                    ++num_islands;
                    grid[r][c] = '0';   //ֱ���޸�ԭ���飬��ǰ½�ر�Ϊ����
                    //�����д洢��ǰԪ�������������е�λ�ã�Ҳ�����ڶ����з�һά������ͨ����������ֵ��¼һ�����λ�á�
                    Queue<Integer> neighbors = new LinkedList<>();
                    //ͨ����������������������������е�λ��
                    neighbors.add(r * nc + c);
                    while (!neighbors.isEmpty()) {      //���в�Ϊ�վ�һֱ��������չ
                        int id = neighbors.remove();
                        int row = id / nc;
                        int col = id % nc;
                        //�������߽粢������û�з��ʹ�����������չ
                        if (row - 1 >= 0 && grid[row - 1][col] == '1') {
                            neighbors.add((row - 1) * nc + col);
                            grid[row - 1][col] = '0';
                        }
                        //������չ
                        if (row + 1 < nr && grid[row + 1][col] == '1') {
                            neighbors.add((row + 1) * nc + col);
                            grid[row + 1][col] = '0';
                        }
                        //��
                        if (col - 1 >= 0 && grid[row][col - 1] == '1') {
                            neighbors.add(row * nc + col - 1);
                            grid[row][col - 1] = '0';
                        }
                        //��
                        if (col + 1 < nc && grid[row][col + 1] == '1') {
                            neighbors.add(row * nc + col + 1);
                            grid[row][col + 1] = '0';
                        }
                    }
                }
            }
        }

        return num_islands;
    }
}