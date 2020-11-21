package practice.leetcode.offer;

import java.util.Arrays;
import java.util.HashMap;

public class O39 {
    public static void main(String[] args) {
        SolutionO39 s = new SolutionO39();
        s.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
    }
}

class SolutionO39 {
    /**
     * 题目：数组中出现次数超过一半的数字
     */

    /**
     * 解法一：排序
     * 这是最直观、最简单的解法。直接对数组进行排序，因为这个超过一半的所有数字不管放在数组的哪里，排序后中间的数都是这个数。
     *
     * 时间：O(nlogn)
     */
/*    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >>> 1];
    }*/


    /**
     * 解法二：哈希表
     * 思路：用一个哈希表记录每个数字出现的次数，如果当前数字出现次数大于数组长度的一半，那么就是这个数。
     *
     * 时间、空间：O(n)
     */
/*    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if (nums.length == 1) {     //对一个数字的情况进行特判
            return nums[0];
        }
        int midLen = nums.length >>> 1;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                int time = map.get(num);
                if (time + 1 > midLen) {        //这里在遍历的时候检查这个数字出现的次数，也可以再搞一个for循环去检查次数。
                    return num;
                }
                map.put(num, time + 1);
            }
        }
        return -1;
    }*/


    /**
     * 解法三：摩尔投票法
     * 思路：开始时假设第一个数为众数，向后迭代的过程中如果遇到和它相等的数，票数就+1；否则票数-1。当票数为0的时候说明前面的数都抵消了，
     * 而后面的数中这个众数出现的次数仍>数组长度的1/2。而这个要找的众数出现的次数大于数组长度的1/2，因此最后它的票数一定>0。
     *
     * 时间：O(n)、空间：O(1)
     */
    public int majorityElement(int[] nums) {
        int x = 0, vote = 0;
        for (int num : nums) {
            if (vote == 0) x = num;     //前面的数都抵消了，假设当前的数为众数
            vote += x == num ? 1 : -1;
        }
        return x;
    }
}