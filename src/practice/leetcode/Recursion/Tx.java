package practice.leetcode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tx {
    public static void main(String[] args) {
        SolutionTx s = new SolutionTx();
        System.out.println(s.getSumList(new int[]{1, 2, 3, 5}, 6));
    }
}


/**
 * 题目描述：给定一个整数列表和一个目标值target，找出数组中和为target的所有数的列表，返回结果为一个二维数组。
 * 注意限制条件：每个数只能使用一次
 * 例如：给定{1,2,3,5}，target为6，返回二维列表：[[1,2,3], [1,5]]
 */
class SolutionTx {
    /**
     * 解法：回溯
     * 1、我们先对数组进行排序，在进行递归回溯。
     * 2、我们在本层递归时，先将当前数加入cur列表中，并求出当前列表的和sum
     * 3、从当前数的后一个数开始，继续下一层递归，避免重复选数
     * 4、递归后将上一个数从cur列表中移除，进行回溯
     *
     * 注意：
     * - 如果sum+当前数已经大于target，则表示和已经超过target，后续更大的数就可以直接跳过，进行剪枝。
     * - 递归退出条件是sum==target，此时我们找到了一个正确的解，将其加入二维列表中，知道求出所有的解。
     */
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> getSumList(int[] arr, int target) {
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
            if (sum + arr[i] > target) {
                break;
            }
            cur.add(arr[i]);
            rec(arr, target, i + 1, sum + arr[i], cur);
            cur.remove(cur.size() - 1);
        }
    }
}