package practice.leetcode.HashMap;

import java.util.*;

public class No15 {
    public static void main(String[] args) {
        Solution15 s = new Solution15();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        s.threeSum(arr);

    }
}

class Solution15 {
    /**
     * 题目：三数之和。
     * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？
     * 请你找出所有满足条件且不重复的三元组。
     * 注意：要进行去重，也就是不能出现三个顺序不一样的答案。
     */

    /**
     * 解法一：暴力三重循环
     * 时间：O(n^3)
     */

    /**
     * 解法二：排序+双指针
     * 思路：外层循环枚举第一个数，内层循环通过双指针并行枚举第二个和第三个数。
     *
     * 时间：O(N^2)
     * 空间复杂度：O(logN)。我们忽略存储答案的空间，额外的排序的空间复杂度为O(logN)。然而我们修改了输入的数组nums，
     * 在实际情况下不一定允许，因此也可以看成使用了一个额外的数组存储了nums的副本并进行排序，空间复杂度为O(N)。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {     //最外层循环枚举第一个数
            //如果排序后当前最小的数都大于所求的数，则后面无解，直接退出循环
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {  //对第一个数去重
                continue;
            }
            int L = i + 1, R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    //下面两行为对第二个和第三个数去重
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    //上面将这个答案加入集合后应该移动左右指针，避免再次加入
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return ans;
    }
}