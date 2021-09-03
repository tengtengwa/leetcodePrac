package practice.leetcodeOffer;

public class No11 {
    public static void main(String[] args) {
        Solution11 s = new Solution11();
        int min = s.minArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(min);
    }
}

class Solution11 {
    /**
     * 题目：旋转数组的最小数字。即寻找旋转数组中的最小数字
     * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
     */

    /**
     * 解法：二分查找
     * 思路：每次二分通过中间元素numbers[pivot]和最右边的元素numbers[high]的比较结果来决定二分排除哪些元素
     * 这个方法要注意的是如果用中值和最左边的元素来比较的话，需要每次二分判断当前范围是否已经单调递增。因为如果当前二分范围是单调递增时，
     * 此时预期的最小值和实际的相反，因此直接和右边元素比较更简单
     *
     * 时间：O(logn)，最坏情况为数组中元素全部相同的情况，此时为O(n)。空间：O(1)
     */
    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length - 1, pivot;
        while (low < high) {
            pivot = low + ((high - low) >>> 1);
            if (numbers[pivot] < numbers[high]) {
                high = pivot;       //当中间元素小于最右边元素时，因为不能排除当前元素为最小元素
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;    //当中间元素大于最右边元素时，此时可以确定最小元素在中间元素右侧，即排除中值为最小元素
            } else {
                high--;
            }
        }
        return numbers[low];
    }
}