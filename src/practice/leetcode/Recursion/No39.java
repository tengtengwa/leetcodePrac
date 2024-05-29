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
 * 39. ����ܺ�
 * ����һ�� ���ظ�Ԫ�� ���������� candidates ��һ��Ŀ������ target ���ҳ� candidates �п���ʹ���ֺ�ΪĿ���� target �� ���� ��ͬ��� ��
 * �����б���ʽ���ء�����԰� ����˳�� ������Щ��ϡ�
 * candidates �е� ͬһ�� ���ֿ��� �������ظ���ѡȡ ���������һ�����ֵı�ѡ������ͬ������������ǲ�ͬ�ġ�
 */
class Solution39 {
    /**
     * �ⷨ������+��֦
     * �������ֽⷨ���ƣ�ֻ��һ����������һ�����ӷ���
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
            //�����´εݹ��start��i�������´εݹ�ӵ�ǰ����ʼ�������ظ�ѡ��ǰ��
            dfs(candidates, target, curSum + candidates[i], i);
            cur.remove(cur.size() - 1);
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