package practice.leetcodeOffer;

public class No12 {
    public static void main(String[] args) {
        Solution12 s = new Solution12();
        boolean exist = s.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "ABCCED");
        System.out.println(exist);
    }
}

class Solution12 {
    /**
     * 题目：矩阵中的路径。
     * 给定一个二维数组，寻找数组中是否有指定字符串，有则返回true，没有返回false。单词必须按照字母顺序，通过相邻的单元格内的字母构成，
     * 其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
     */
    /**
     * 解法：DFS
     * 思路：和经典的深搜思路基本一致，但是这个题目搜索的字符串需要按照字母排序，因此需要记录当前字符。
     * 还要注意的一点是，需要通过剪枝来减少已经访问的路径和当前不可能的路径；并且在当前搜索完成返回前将记录的路径复原
     *
     * 时间：O(n^2*3^k)（k为字符串长度），空间：O(n)
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (dfs(board, row, col, 0, words)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, int curIndex, char[] word) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word[curIndex]) {
            return false;
        }
        if (curIndex == word.length - 1) {  //已经搜索完字符串，直接返回true
            return true;
        }
        board[row][col] = '￥';  //记录当前走过的路径，题目没有说不能修改数组，可以直接在原数组中修改
        boolean res = dfs(board, row, col - 1, curIndex + 1, word) || dfs(board, row - 1, col, curIndex + 1, word)
                || dfs(board, row, col + 1, curIndex + 1, word) || dfs(board, row + 1, col, curIndex + 1, word);
        board[row][col] = word[curIndex];   //当前搜索完成后将数组复原
        return res;
    }
}