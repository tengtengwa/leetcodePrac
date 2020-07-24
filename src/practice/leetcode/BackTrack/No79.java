package practice.leetcode.BackTrack;

public class No79 {
    public static void main(String[] args) {
        Solution79 s = new Solution79();
        s.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "ABCCE");

    }
}

class Solution79 {
/*    boolean[][] flag;
    int row, col;
    int[][] next = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    char[][] board;
    String word;

    public boolean exist(char[][] board, String word) {
        this.row = board.length;
        this.col = board[0].length;
        this.board = board;
        this.word = word;
        flag = new boolean[row][col];

        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (backTrack(0, i, j)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean backTrack(int start, int r, int c) {
        if (start == word.length() - 1) {
            return board[r][c] == word.charAt(start);
        }
        if (board[r][c] == word.charAt(start)) {
            flag[r][c] = true;
            for (int i = 0; i < 4; i++) {
                int newX = r + next[i][0];
                int newY = c + next[i][1];
                if (isValid(newX, newY) && backTrack(start + 1, newX, newY)) {
                    return true;
                }
            }
            flag[r][c] = false;
        }
        return false;
    }

    private boolean isValid(int r, int c) {
        return r >= 0 && r < row && c >= 0 && c < col && !flag[r][c];
    }*/

    /**
     * 回溯函数写成下面这样也是可以的，这样不需要整那些类变量
     */

    public boolean exist(char[][] board, String word) {
        int row = board.length, col = board[0].length;
        boolean[][] flag = new boolean[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (dfs(board, word, i, j, 0, flag)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col, int start, boolean[][] flag) {
        if (board[row][col] == word.charAt(start)) {        //当前字符相等在往下寻找，否则直接返回false
            flag[row][col] = true;                          //当前字符相同，标记位置为true，在此字符的基础上向四个方向寻找
            if (start == word.length() - 1) {               //由于上面已经判断过两字符相同，所以只要是最后一个字符就找到了最终答案
                return true;
            }
            if (row - 1 >= 0 && !flag[row - 1][col]) {      //向上
                if (dfs(board, word, row - 1, col, start + 1, flag)) {
                    return true;
                }
            }
            if (col + 1 < board[0].length && !flag[row][col + 1]) {     //向右
                if (dfs(board, word, row, col + 1, start + 1, flag)) {
                    return true;
                }
            }
            if (row + 1 < board.length && !flag[row + 1][col]) {        //向下
                if (dfs(board, word, row + 1, col, start + 1, flag)) {
                    return true;
                }
            }
            if (col - 1 >= 0 && !flag[row][col - 1]) {                  //向左
                if (dfs(board, word, row, col - 1, start + 1, flag)) {
                    return true;
                }
            }
            flag[row][col] = false;                     //向四个方向寻找完后会返回上一层，记得将标记位置换回来
        }
        return false;
    }
}