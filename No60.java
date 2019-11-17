package practice.leetcode.BackTrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No60 {
    public static void main(String[] args) {
        Solution60 s = new Solution60();
        s.getPermutation(4, 5);

    }
}

class Solution60 {
    List<List<Integer>> lists = new ArrayList<>();
    public String getPermutation(int n, int k) {
        int[] nums = new int[n];
        ArrayList<Integer> list = new ArrayList<>();
        int j = 0;
        for (int i = 1; i <= n; i++) {
            nums[j] = i;
            list.add(nums[j++]);
        }
        DFS(nums, 0, list);
        StringBuilder sb = new StringBuilder();
        ArrayList list1 = (ArrayList) lists.get(k - 1);
        for (int i = 0; i < list1.size(); i++) {
            sb.append(list1.get(i).toString());
        }
        return sb.toString();
    }

    private void DFS(int[] nums, int index, ArrayList<Integer> list) {
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