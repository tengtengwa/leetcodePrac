package practice.leetcode.BackTrack;

import java.util.*;

public class No47 {
    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        solution47.permuteUnique(new int[]{2, 1, 1});

    }
}

class Solution47 {

    /**
     * 46题官方解法对应的版本，在它的基础上在for循环中加了一个if来剪枝
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tem = new ArrayList<>();
        Arrays.sort(nums);
        for (int num : nums) {
            tem.add(num);
        }
        DFS(ans, nums, 0, tem);
        return ans;
    }

    private void DFS(List<List<Integer>> ans, int[] nums, int index, ArrayList<Integer> tem) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(tem));
        } else {
            DFS(ans, nums, index + 1, tem);
            for (int i = 0; i < nums.length; i++) {
                if (tem.get(index).equals(tem.get(i))) {
                    break;
                }
                Collections.swap(tem, i, index);
                DFS(ans, nums, index + 1, tem);
                Collections.swap(tem, i, index);
            }
        }
    }


    /**
     * 这个解法是在46题第二种解法的基础上来的，仅仅增加了backtrack函数中的一个if语句来剪枝，比较容易理解。
     * 时间复杂度：O(N×N!)，这里 N 为数组的长度。
     * 空间复杂度：O(N×N!)。
     */
/*    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int[] flag = new int[nums.length];
        backTrack(ans, nums, 0, new ArrayList<>(), flag);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, int[] nums, int depth, List<Integer> tem, int[] flag) {
        if (depth == nums.length) {
            ans.add(new ArrayList<>(tem));
            return;
        }
        for (int index = 0; index < nums.length; index++) {
            if (flag[index] == 1) {     //跳过数组中已经选过的数
                continue;
            }
            if (index > 0 && nums[index] == nums[index - 1] && flag[index - 1] == 0) {
                continue;
            }
            tem.add(nums[index]);
            flag[index] = 1;
            backTrack(ans, nums, depth + 1, tem, flag);
            flag[index] = 0;
            tem.remove(tem.size() - 1);
        }
    }*/

}