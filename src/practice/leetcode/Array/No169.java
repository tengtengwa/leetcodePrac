package practice.leetcode.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. 多数元素
 * 给定一个大小为 n 的数组 nums ，返回其中的多数元素。多数元素是指在数组中出现次数 大于 ? n/2 ? 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 */
public class No169 {
    public static void main(String[] args) {
        Solution169 s = new Solution169();
        s.majorityElement(new int[]{3, 4, 5, 5, 5});
    }
}

class Solution169 {
    /**
     * 解法一：哈希表法求解
     * 思路：遍历一次数组，使用hashmap统计每个数字出现的次数。接着遍历一次hashmap中的元素，找出出现次数最多的数，
     * 也可以将这一步简化为下面的操作，在放入元素后立即检查一次该数字的次数，如果大于n/2，则该数就是众数。
     * 时间复杂度：O(n)
     * 空间复杂度：O(n)
     */
//    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int n = nums.length;
//        for(int num : nums) {
//            if (map.containsKey(num)) {
//                int key = map.get(num);
//                map.put(num, ++key);
//            } else {
//                map.put(num, 1);
//            }
//            if (map.containsKey(num) && map.get(num) > n / 2) {
//                return num;
//            }
//        }
//        return nums[nums.length - 1];
//    }

    /**
     * 解法二：排序求解
     * 因为数组中有出现次数超过一半的数，所以排序后数组中间这个数必然是我们要找的那个。
     * 时间复杂度：O(nlogn)，n次二分，nlogn
     * 空间复杂度：O(logn)，快排递归时占用堆空间logn
     */
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//    }

    /**
     * 解法三：moore投票算法
     * 思路：如果把众数记作+1，其他数记作-1，因为众数出现次数大于n/2，所以它们的和必然大于1。
     */
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