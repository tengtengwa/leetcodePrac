package practice.leetcode.Math;

import java.util.LinkedList;
import java.util.List;

public class No448 {
    public static void main(String[] args) {
        Solution448 s = new Solution448();
        s.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2});
    }
}

class Solution448 {
    /**
     * 题目：找到所有数组中消失的数字
     * 给定一个范围在1 ≤ a[i] ≤ n (n=数组大小)的整型数组，数组中的元素一些出现了两次，另一些只出现一次。
     * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
     * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
     *
     * 解法一：类似桶排序的解法，两次遍历。创建一个大小为nums+1的的数组用于记录每个下标的元素是否出现。
     * 第一次遍历记录出现的元素，第二次遍历将未出现过的元素加入集合。
     *
     * 时间：O(n)，空间O(n)
     * 因为题目要求不使用额外空间，所以这种方法不行
     */
/*    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        int[] arr = new int[nums.length + 1];
        for (int num : nums) {
            arr[num]++;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }*/

    /**
     * 解法二：愿地修改。两次遍历，不使用额外空间
     * 思路：第一次遍历将num[i]-1索引位置的元素置为负，表示这个位置的元素已经出现；
     * 第二次遍历时若nums[i]>0，则i+1就是一个未出现过的数
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}