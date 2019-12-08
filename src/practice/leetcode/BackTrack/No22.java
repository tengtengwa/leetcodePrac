package practice.leetcode.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class No22 {
    public static void main(String[] args) {
        Solution22 s = new Solution22();
        List<String> list = s.generateParenthesis(3);

    }
}

class Solution22 {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return list;
        }
        backtrack("", 0, 0, n);
        return list;
    }

    private void backtrack(String str, int L, int R, int n) {
        //把握好回溯结束条件
        if (n * 2 == str.length()) {
            list.add(str);
            return;
        }
        //回溯过程中判断括号组合的合法性
        if (L < n) {
            backtrack(str + "(", L + 1, R, n);
        }
        //产生的过程中右括号数目必须小于左括号数量
        if (R < L) {
            backtrack(str + ")", L, R + 1, n);
        }
    }
}