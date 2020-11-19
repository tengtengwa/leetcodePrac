package practice.leetcode.BinarySearch;

public class O53_2 {
    public static void main(String[] args) {
        SolutionO53_2 s = new SolutionO53_2();
        s.missingNumber(new int[]{0, 1, 2, 3});
    }
}


class SolutionO53_2 {
    /**
     * 题目：0～n-1中缺失的数字
     * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有
     * 一个数字不在该数组中，请找出这个数字。
     */

    /**
     * 解法一：顺序遍历
     * 思路：如果当前数字nums[i] != 当前下标i，则缺失的就是这个数i。特例：缺失的数在最后，例如：[0,1,2,3]，此时缺失的是4
     * 所以在遍历完数组后需要返回数组长度len
     *
     * 时间：O(n)
     */
/*    public int missingNumber(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return len;
    }*/


    /**
     * 解法二：二分查找
     * 思路：和上面类似，只是用了二分代替线性遍历。
     */
    public int missingNumber(int[] nums) {
        int len = nums.length, i = 0, j = len - 1;
        while (i <= j) {    //注意这里的条件，必须加“=”，不然缺失的是最后一个数的时候会出错。
            int mid = (i + j) >>> 1;
            if (nums[mid] > mid) {
                j = mid - 1;
            } else if (nums[mid] == mid) {
                i = mid + 1;
            }
        }
        return i;
    }
}