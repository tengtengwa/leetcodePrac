package practice.leetcode.Array;

public class No41 {
    public static void main(String[] args) {
        Solution41 s = new Solution41();
        System.out.println(s.firstMissingPositive(new int[]{1, 1}));
    }
}

/**
 * 41. 缺失的第一个正数
 *
 * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
 * 请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
 */
class Solution41 {
    /**
     * 解法一：“哈希表”
     * 第一次遍历将所有负数和0转为len+1，变为正数
     * 再用给定的数组来替代哈希表，对已经出现的数对应索引的数进行标记（取绝对值再加负号，用负号标记该索引已经出现过数字）
     * 再遍历一次数组，该索引的数如果大于0，则表示该位置i没有出现数字，返回i+1即可；如果数组中都是负数，则表示[1,len]全部出现过，返回len+1
     *
     *  时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
//    public int firstMissingPositive(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            int num = nums[i];
//            if (num <= 0) {
//                nums[i] = nums.length + 1;
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            //防止负数再变成正数，这里取绝对值统一处理
//            int num = Math.abs(nums[i]);
//            if (num <= nums.length) {
//                nums[num - 1] = -Math.abs(nums[num - 1]);
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 0) return i + 1;
//        }
//        return nums.length + 1;
//    }

    /**
     * 解法二：置换
     * 通过交换的方式，将每一个数换到它应有的位置上。对一个数x，它应该被还原到索引为x-1的位置上，因此交换 nums[i]和 nums[x?1]，
     * 这样x就出现在了正确的位置。在完成交换后，新的 nums[i]可能还在[1,N]的范围内，我们需要继续进行交换操作，直到 x?[1,N]
     * 交换的时候还需要防止两个数相等（nums[i]==nums[x-1]）的情况，防止死循环
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (cur == i + 1) {
                continue;
            }
            while ((cur != i + 1 && cur > 0 && cur <= nums.length) && nums[i] != nums[cur - 1]) {
                swap(nums, i, cur - 1);
                cur = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
}