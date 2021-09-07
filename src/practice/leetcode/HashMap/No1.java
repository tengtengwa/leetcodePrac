package practice.leetcode.HashMap;

import java.util.HashMap;
import java.util.Map;

public class No1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        int[] arr = s.twoSum(new int[]{2, 5, 5, 11}, 10);
        System.out.println(arr[0] + ", " + arr[1]);
    }
}

/*
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        int[] index = new int[2];
        int flag = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (flag == 1) {
                break;
            }
            for (int j = 1; j < nums.length; j++) {
                if (i == j) {
                    continue;
                }
                if (nums[i] + nums[j] == target) {
                    flag = 1;
                    index[0] = i;
                    index[1] = j;
                    break;
                }
            }
        }

        return index;
    }
}*/

//一边哈希表，一边遍历一边检查
class Solution1 {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)) {
                return new int[] {map.get(complement), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("No two sum solution");
    }
}
