package practice.leetcode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TxNo40 {
    public static void main(String[] args) {
        SolutionTxNo40 s = new SolutionTxNo40();
        System.out.println(s.getSumList(new int[]{2, 5, 2, 1, 2}, 5));
    }
}


/**
 * 题目描述：给定一个整数列表和一个目标值target，找出数组中和为target的所有数的列表，返回结果为一个二维数组。
 * 注意限制条件：每个数只能使用一次
 * 例如：给定{1,2,3,5}，target为6，返回二维列表：[[1,2,3], [1,5]]
 * <p>
 * 注：此题就是力扣40题：组合总数II，https://leetcode.cn/problems/combination-sum-ii/description/
 */
class SolutionTxNo40 {
    /**
     * 解法：回溯
     * https://leetcode.cn/problems/combination-sum-ii/solutions/14753/hui-su-suan-fa-jian-zhi-python-dai-ma-java-dai-m-3/
     *
     * 思路：
     * 1、我们先对数组进行排序，在进行递归回溯。
     * 2、我们在本层递归时，先将当前数加入cur列表中，并求出当前列表的和sum
     * 3、从当前数的后一个数开始，继续下一层递归，避免重复选数
     * 4、递归后将上一个数从cur列表中移除，进行回溯
     * <p>
     * 注意：
     * - 如果sum+当前数已经大于target，则表示和已经超过target，后续更大的数就可以直接跳过，进行剪枝。
     * - 递归退出条件是sum==target，此时我们找到了一个正确的解，将其加入二维列表中，知道求出所有的解。
     */
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> getSumList(int[] arr, int target) {
        //先进行排序，方便剪枝
        Arrays.sort(arr);
        rec(arr, target, 0, 0, new ArrayList<>());
        return ans;
    }

    private void rec(int[] arr, int target, int idx, int sum, List<Integer> cur) {
        if (target == sum) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            //选择当前数后大于target了，就可以直接剪枝，跳过后续所有数的选择。
            if (sum + arr[i] > target) {
                break;
            }
            //同一层出现相同的数，只保留第一个分支，跳过其余分支，防止重复
            if (i > idx && arr[i] == arr[i - 1]) continue;
            cur.add(arr[i]);
            //下一层递归从当前数的后一个开始，索引是i+1，防止选择同一个数
            rec(arr, target, i + 1, sum + arr[i], cur);
            cur.remove(cur.size() - 1);
        }
    }
}