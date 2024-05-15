package practice.leetcode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No51 {
    public static void main(String[] args) {
        Solution51 s = new Solution51();
        List<List<String>> lists = s.solveNQueens(4);
        for (List<String> list : lists) {
            for (String line : list) {
                System.out.println(line);
            }
            System.out.println();
        }
    }
}

/**
 * 51. N 皇后
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
class Solution51 {
    /**
     * 解法一：（基于集合的）回溯
     * 如果通过暴力枚举每一个皇后的位置，则算法的复杂度会非常高。我们可以观察可以发现：
     * 当一个皇后的位置确定后，每一行、每一列、每一条从左下到右上的斜线、每条从左上到右下的斜线上都不能再出现其他皇后
     * 这就是我们需要在回溯过程中需要剪枝的地方。
     * 需要注意的仅仅是两条斜线：左下到右上的斜线，row和col的和是一个定值；左上到右下的斜线，row和col的差是一个定值
     * 时间复杂度：O(N!)，当一个皇后的位置确定后，我们需要搜索剩下N-1行、列和斜线。
     * 空间复杂度：O(N)，其中N是皇后数量。空间复杂度主要取决于递归调用层数、记录每行放置的皇后的列下标的数组以及
     * 三个集合，递归调用层数不会超过N，数组的长度为N，每个集合的元素个数都不会超过N。
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new int[n], n, 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        return res;
    }

    private void dfs(List<List<String>> res, int[] queens, int n, int row, List<Integer> col, List<Integer> dia1s, List<Integer> dia2s) {
        if (row == n) {
            generateRes(res, queens);
        }
        for (int i = 0; i < n; i++) {
            if (col.contains(i)) {
                continue;
            }
            //坑：List接口的remove有两个构造方法remove(int index)、remove(Object o)，下面remove的时候
            //传入的是int时是通过index移除元素，这里需要使用包装类Integer或使用HashSet。
            Integer diff = row - i;
            Integer sum = row + i;
            if (dia1s.contains(diff)) {
                continue;
            }
            if (dia2s.contains(sum)) {
                continue;
            }
            queens[row] = i;
            col.add(i);
            dia1s.add(diff);
            dia2s.add(sum);
            dfs(res, queens, n, row + 1, col, dia1s, dia2s);
            col.remove(Integer.valueOf(i));
            dia1s.remove(diff);
            dia2s.remove(sum);
        }
    }

    private void generateRes(List<List<String>> res, int[] queens) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            char[] curChars = new char[queens.length];
            Arrays.fill(curChars, '.');
            curChars[queens[i]] = 'Q';
            ans.add(new String(curChars));
        }
        res.add(ans);
    }
}