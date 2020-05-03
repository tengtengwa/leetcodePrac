package practice.leetcode.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class No78 {
    public static void main(String[] args) {
        Solution78 s = new Solution78();
        s.subsets(new int[]{1, 2, 3});
    }
}

class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(0, nums, ans, new ArrayList<>());
        return ans;
    }

    private void backTrack(int i, int[] nums, List<List<Integer>> ans, ArrayList<Integer> tem) {
        ans.add(new ArrayList<>(tem));
        for (int j = i; j < nums.length; j++) {
            tem.add(nums[j]);
            backTrack(j + 1, nums, ans, tem);
            tem.remove(tem.size() - 1);
        }
    }
}