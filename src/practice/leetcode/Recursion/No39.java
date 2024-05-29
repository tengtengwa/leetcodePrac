package practice.leetcode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No39 {
    public static void main(String[] args) {
        Solution39 s = new Solution39();
        System.out.println(s.combinationSum(new int[]{2, 3, 5}, 8));;
    }
}

/**
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，
 * 并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 */
class Solution39 {
    /**
     * 解法：回溯+剪枝
     * 以下两种解法类似，只是一个做减法，一个做加法。
     */
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> cur = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        dfs(candidates, target, 0, 0);
        return ans;
    }

    private void dfs(int[] candidates, int target, int curSum, int start) {
        if (target == 0) {
            ans.add(new ArrayList<>());
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (curSum == target) {
                ans.add(new ArrayList<>(cur));
                break;
            }
            if (curSum + candidates[i] > target) {
                break;
            }
            cur.add(candidates[i]);
            //这里下次递归的start传i，表明下次递归从当前数开始，可以重复选择当前数
            dfs(candidates, target, curSum + candidates[i], i);
            cur.remove(cur.size() - 1);
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