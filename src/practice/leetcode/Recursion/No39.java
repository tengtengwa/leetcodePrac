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
     * ��target���ӷ����������ַ������ƣ�˼·���ǻ���+��֦
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
            //��Ϊ������pro�����ã�������Ҫ�½����󴢴�
            List<Integer> e = new ArrayList<>(pro);
            list.add(e);
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (candidates[i] > target) {       //��֦
                    continue;
                }
                pro.add(candidates[i]);
                backTrack(candidates, target, sum + candidates[i], pro, i);
                pro.remove(pro.size() - 1);
            }

        }
    }


    /**
     * ��target������
     */
    /*
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        if (candidates == null || candidates.length == 0) return ans;
        Arrays.sort(candidates);            //���������򣬱���������м�֦
        dfs(candidates, target, 0, ans, new ArrayList<>());
        return ans;
    }

    private void dfs(int[] candidates, int target, int start, List<List<Integer>> ans, ArrayList<Integer> tem) {
        if (target < 0) return;
        if (target == 0) {
            ans.add(new ArrayList<>(tem));      //��Ϊ���tem�б�ֻ��һ��������������Ҫ�½�һ���б����ans����б�
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (target < candidates[i]) break;      //������м�֦
            tem.add(candidates[i]);
            dfs(candidates, target - candidates[i], i, ans, tem);
            tem.remove(tem.size() - 1);
        }
    }
     */
}