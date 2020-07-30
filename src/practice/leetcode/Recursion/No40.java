package practice.leetcode.Recursion;

import java.util.*;

public class No40 {
    public static void main(String[] args) {
        Solution40 s = new Solution40();
        s.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);

    }
}

class Solution40 {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        DFS(candidates, target, 0, new ArrayList<>(), 0);
        return lists;
    }

    private void DFS(int[] candidates, int target, int sum, List<Integer> list, int index) {
        if (target == sum) {
            List<Integer> e = new ArrayList<>(list);
            lists.add(e);
        } else if (sum < target) {
            for (int i = index; i < candidates.length; i++) {
                //当前list中的数字之和加上candidates[i]>target，则直接跳过index后面的所有数
                if (candidates[i] + sum > target) {
                    return;
                }
                //i不是从index开始时，如果当前位和上一位重复，则跳过此位防止重复
                if (i > index && candidates[i] == candidates[i - 1]) {
                    continue;
                }
                list.add(candidates[i]);
                DFS(candidates, target, sum + candidates[i], list, i + 1);
                list.remove(list.size() - 1);
            }
        }

    }
}