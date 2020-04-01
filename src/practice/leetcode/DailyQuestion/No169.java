package practice.leetcode.DailyQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No169 {
    public static void main(String[] args) {
        Solution169 s = new Solution169();
        s.majorityElement(new int[]{3, 4, 5, 5, 5});
    }
}

class Solution169 {
/*  //哈希表法求解
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int num : nums) {
            if (map.containsKey(num)) {
                int key = map.get(num);
                map.put(num, ++key);
            } else {
                map.put(num, 1);
            }
            if (map.containsKey(num) && map.get(num) > (n - 1) / 2) {
                return num;
            }
        }
        return nums[nums.length - 1];
    }*/

/*    //排序求解
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }*/

    //moore投票算法
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }
}