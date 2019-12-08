package practice.leetcode;

import java.util.ArrayList;
import java.util.List;

public class No39 {
    public static void main(String[] args) {
        Solution39 s = new Solution39();
        List<List<Integer>> lists = s.combinationSum(new int[]{2, 3, 6, 7}, 7);
        List<Integer> list1 = lists.get(0);
        List<Integer> list2 = lists.get(1);
    }
}

class Solution39 {
    List<List<Integer>> list = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backTrack(candidates, target, 0, new ArrayList<>(), 0);
        return list;
    }

    private void backTrack(int[] candidates, int target, int sum, List<Integer> pro, int index) {
        if (index >= candidates.length || sum > target) {
            return;
        }
        if (sum == target) {
            //因为参数中pro是引用，所以需要新建对象储存
            List<Integer> e = new ArrayList<>(pro);
            list.add(e);
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (candidates[i] > target) {
                    continue;
                }
                pro.add(candidates[i]);
                backTrack(candidates, target, sum + candidates[i], pro, i);
                pro.remove(pro.size() - 1);
            }

        }
    }
}