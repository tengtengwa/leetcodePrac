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
                //��ǰlist�е�����֮�ͼ���candidates[i]>target����ֱ������index�����������
                if (candidates[i] + sum > target) {
                    return;
                }
                //i���Ǵ�index��ʼʱ�������ǰλ����һλ�ظ�����������λ��ֹ�ظ�
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