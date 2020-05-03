package practice.leetcode.BackTrack;

import java.util.ArrayList;
import java.util.List;

import static com.sun.org.apache.xalan.internal.xsltc.compiler.util.Type.Int;

public class No39A {
    public static void main(String[] args) {
        Solution39 s = new Solution39();
        s.combinationSum(new int[]{2, 3, 5}, 7);
    }
}

class Solution39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(0, candidates, target, ans, new ArrayList<>(), 0);
        return ans;
    }

    private void backTrack(int i, int[] candidates, int target, List<List<Integer>> ans, List<Integer> tem, int cur) {
        for (int j = i; j < candidates.length; j++) {
            tem.add(candidates[j]);
            cur += candidates[j];
            if (cur == target) {
                ans.add(tem);
                cur = 0;
            } else if (cur < target) {
                backTrack(j, candidates, target, ans, tem, cur);
            } else {
                tem.remove(tem.size() - 1);
                return;
            }
        }
    }
}