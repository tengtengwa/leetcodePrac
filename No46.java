package practice.leetcode.BackTrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No46 {
    public static void main(String[] args) {
        Solution46 s = new Solution46();
        s.permute(new int[]{1, 2, 3});
    }
}

class Solution46 {
    List<List<Integer>> lists = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        DFS(nums, 0, list);
        return lists;
    }

    private void DFS(int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = index; i < nums.length; i++) {
                Collections.swap(list, index, i);
                DFS(nums, index + 1, list);
                Collections.swap(list, index, i);
            }
        }
    }
}