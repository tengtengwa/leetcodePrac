package practice.leetcode.Array;

/**
 * No80 删除有序数组中的重复项 II
 * 给你一个有序数组 nums ，请你原地删除重复出现的元素，使得出现次数超过两次的元素只出现两次 ，
 * 返回删除后数组的新长度。
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 */
public class No80 {
    public static void main(String[] args) {
        Solution80 s = new Solution80();
        int[] arr = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int len = s.removeDuplicates(arr);
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

/**
 * 解法：双指针
 * 因为每个元素至少出现一次，所以我们可以直接从索引2开始判断第二大的数字。左右指针同时指向2，并且右指针开始向后遍历，
 * 我们通过nums[l - 2]和nums[r]进行比较，如果两者相等，说明nums[l-2]==nums[l-1]==nums[r]，此时nums[r]
 * 为第三次出现的数，需要舍弃；否则需要留下，我们直接将nums[r]复制给nums[l]。以此类推，直到右指针遍历完整个数组。
 * 时间复杂度：O(n)
 * 空间复杂度：O(1)
 *
 * 扩展：删除出现次数三次及以上的也是类似的思路。
 */
class Solution80 {
    public int removeDuplicates(int[] nums) {
        int l = 2;
        for (int r = 2; r < nums.length; r++) {
            if (nums[l - 2] != nums[r]) {
                nums[l++] = nums[r];
            }
        }
        return l;
    }
}