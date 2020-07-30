package practice.leetcode.Recursion;

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
    /**
     * 给target做加法，下面两种方法类似，思路都是回溯+剪枝
     */
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
                if (candidates[i] > target) {       //剪枝
                    continue;
                }
                pro.add(candidates[i]);
                backTrack(candidates, target, sum + candidates[i], pro, i);
                pro.remove(pro.size() - 1);
            }

        }
    }


    /**
     * 给target做减法
     */
    /*
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ans;
        Arrays.sort(candidates);            //对数组排序，便于下面进行剪枝
        dfs(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }

    private void dfs(int[] candidates, int target, int start, List<List<Integer>> ans, ArrayList<Integer> tem) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(tem));      //因为这个tem列表只有一个，所以这里需要新建一个列表加入ans结果列表
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) break;      //这里进行剪枝
            tem.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, ans, tem);
            tem.remove(tem.size() - 1);
        }
    }
     */
}