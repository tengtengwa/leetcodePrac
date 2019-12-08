package practice.leetcode.BackTrack;

import java.util.*;

public class No47 {
    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        solution47.permuteUnique(new int[]{2, 2, 1, 1});

    }
}

class Solution47 {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        ArrayList<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        for (int num : nums) {
            list.add(num);
        }
        DFS(nums, 0, list);
        return lists;
    }

    private void DFS(int[] nums, int index, ArrayList<Integer> list) {
        if (index == nums.length) {
            lists.add(new ArrayList<>(list));
        } else {
            DFS(nums, index + 1, list);
            for (int i = 0; i < nums.length; i++) {
                if (list.get(index).equals(list.get(i))) {
                    break;
                }
                Collections.swap(list, i, index);
                DFS(nums, index + 1, list);
                Collections.swap(list, i, index);
            }
        }

    }

/*    public List<List<Integer>> permuteUnique(int[] nums) {
        if(nums == null || nums.length == 0) return Collections.EMPTY_LIST;
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        helper(nums, n, 0, res);
        return res;
    }
    void helper(int[] nums, int n, int k, List<List<Integer>> res){
        if(k == n){
            List<Integer> l = new ArrayList<>(n);
            for(int num : nums) l.add(num);
            res.add(l);
            return;
        }
        helper(nums, n, k + 1, res);
        for(int i = 0; i < k; i++){
            if(nums[i] == nums[k]) break;
            swap(nums, i, k);
            helper(nums, n, k + 1, res);
            swap(nums, i, k);
        }
    }
    void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }*/
}