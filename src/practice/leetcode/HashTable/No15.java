package practice.leetcode.HashTable;

import java.util.*;

public class No15 {
    public static void main(String[] args) {
        Solution15 s = new Solution15();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        s.threeSum(arr);

    }
}

class Solution15 {
/*    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // 排序
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // 如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue; // 去重
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // 去重
                    while (L<R && nums[R] == nums[R-1]) R--; // 去重
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }*/

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //如果最小的数字都大于0，则三数之和一定大于0，所以直接结束
            if (nums[i] > 0) {
                break;
            }
            //去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    //当 sum == 0 时，nums[L] == nums[L+1]时 则会导致结果重复，应该跳过
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    //当 sum == 0 时，nums[R] == nums[R-1]时 则会导致结果重复，应该跳过
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return lists;
    }

}