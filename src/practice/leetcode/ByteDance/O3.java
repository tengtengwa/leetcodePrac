package practice.leetcode.ByteDance;

import java.util.HashSet;

public class O3 {
    public static void main(String[] args) {
        SolutionO3 s = new SolutionO3();
        s.findRepeatNumber(new int[]{2, 3, 1, 0, 4, 5, 3});
    }
}

class SolutionO3 {
    /**
     * 题目：数组中重复的数字。
     * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内，数组中某些数字是重复的，但不知道有几个数字重复了，
     * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
     *
     * 注意：这题虽然和287寻找重复数相似，但并不能使用二分法求解。
     * 因为278题长度n+1,1~n代表必定有一个数字出现两次，所以你用二分有个区间的数字在原数组中出现次数是>这个区间范围的，
     * 但是对这题而言，长度n，0~n-1且有重复，代表有数重复，就有数不存在，这样长度才符合，这将会导致可能重复的数和不存在的数
     * 在同一个区间你无法找出来
     */

    /**
     * 解法一：排序
     * 思路：因为题目中没有限制修改数组，因此可以先排序，再进行一次遍历，遍历过程中如果相邻两个数相等，则找到了一个重复数。
     *
     * 时间：O(nlogn)，空间：O(1)。注意排序的复杂度nlogn高于n
     */
/*    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }*/

    /**
     * 解法二：哈希表
     * 思路：使用hashset记录每个数，在遍历的过程中如果set中已经包含了这个数，则它就是重复数之一。
     *
     * 时间、空间：O(n)
     */
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                return num;
            }
        }
        return -1;
    }

    /**
     * 解法三：原地置换（会修改数组）
     * 思路：遍历数组，将当前数字nums[i]放到下标为i的位置。也就是nums[i]-->nums[nums[i]]
     * 如果遇到nums[i] == nums[nums[i]]，就说明这个数字重复了
     *
     * 时间：O(n)，空间：O(1)
     */
/*    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {      //如果当前位置的数nums[i]就在下标为i的位置就直接跳过
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                //建议不要把交换的逻辑写到这里，容易出错
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }*/
}