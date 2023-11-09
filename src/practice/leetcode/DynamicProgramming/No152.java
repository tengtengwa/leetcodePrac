package practice.leetcode.DynamicProgramming;

public class No152 {
    public static void main(String[] args) {
        Solution152 s = new Solution152();
        s.maxProduct(new int[]{-2, 0, -3});
    }
}

class Solution152 {
    /**
     * 题目：乘积最大的连续子数组，数组中可能会出现负数
     *
     * 遍历数组时计算当前最大值，不断更新
     * 令imax为当前最大值，则当前最大值为 imax = max(imax * nums[i], nums[i])
     * 由于存在负数，那么会导致最大的变最小的，最小的变最大的。因此还需要维护当前最小值imin，imin = min(imin * nums[i], nums[i])
     * 当负数出现时则imax与imin进行交换再进行下一步计算
     * 时间复杂度：O(n)，空间O(1)
     */
    public int maxProduct(int[] nums) {
        int max = Integer.MIN_VALUE;
        int imax = 1, imin = 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0) {
                int tem = imax;
                imax = imin;
                imin = tem;
            }
            //注意！！！这里如果到当前元素的连续乘积imax * nums[i]较小，imax取得就是当前元素nums[i]；imin也是对应的
            imax = Math.max(nums[i], imax * nums[i]);
            imin = Math.min(nums[i], imin * nums[i]);
            max = Math.max(max, imax);
        }
        return max;
    }
}