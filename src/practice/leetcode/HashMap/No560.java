package practice.leetcode.HashMap;

import java.util.HashMap;
import java.util.Map;

public class No560 {
    public static void main(String[] args) {
        Solution560 s = new Solution560();
        s.subarraySum(new int[]{1, 1, 1, 2, 3, 4, -1}, 3);
    }
}

class Solution560 {
    /**
     * 题目：和为k的子数组。给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
     *
     * 解法一：暴力
     * 思路：枚举每种子数组的可能，分别计算出每种子数组的和
     * 时间：O(n^3)，空间：O(1)
     */
/*    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right < nums.length; right++) {
                int sum = 0;
                for (int i = left; i <= right; i++) {
                    sum += nums[i];
                }
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }*/


    /**
     * 解法二：暴力优化
     * sum和求的是左边界left到当前右边界right的和，减少了一维的时间复杂度
     * 时间：O(n^2)，空间O(1)
     */
/*    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int left = 0; left < nums.length; left++) {
            int sum = 0;
            for (int right = left; right < nums.length; right++) {
                sum += nums[right];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }*/


    /**
     * 解法三：前缀和
     * 利用前缀和数组计算出到当前位置的区间和
     * 时间：O(n^2)，空间O(n)
     */
/*    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int[] arr = new int[nums.length + 1];   //多申请一个元素，方便下面求前缀和
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = arr[i] + nums[i];
        }
        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right < nums.length; right++) {
                //这里计算的是[left,right]区间的和，注意下标，即sum(右边界)-sum(左边界-1)
                //因为数组下标向后有一个偏移，所以arr[right + 1]就是sum(右边界),arr[left]就是sum(左边界-1)
                if (arr[right + 1] - arr[left] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }*/


    /**
     * 解法四：前缀和+哈希表
     * 思路：https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode-solution/
     * 简单来说就是想要知道以i结尾的和为k的连续子数组个数时只要统计有多少个前缀和为pre[i]-k的pre[j]即可，pre[i]为[0..i]里所有数的和
     * 时间、空间：O(n)
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        //map映射保存前缀和key到它出现的次数value的映射
        Map<Integer, Integer> map = new HashMap<>();
        //最开始时，下标0之前没有元素，可以认为前缀和为0，个数为1个
        map.put(0, 1);
        int perSum = 0;     //当前前缀和
        for (int num : nums) {
            perSum += num;
            if (map.containsKey(perSum - k)) {      //如果当前映射中有pre[i]-k的前缀和，答案就加上它出现的次数
                ans += map.get(perSum - k);
            }
            map.put(perSum, map.getOrDefault(perSum, 0) + 1);   //当前前缀和出现的次数+1
        }
        return ans;
    }
}