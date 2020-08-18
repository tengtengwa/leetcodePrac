package practice.leetcode.Others;

public class No283 {
    public static void main(String[] args) {

    }
}

class Solution283 {
    /**
     * 题目：移动零，将数组中所有0移到数组末尾并保持其他元素相对位置不变
     *
     * 解法一：新建一个数组，在遍历给定数组时将非零元素一个个存入新建数组中，时间、空间：O(n)
     * 解法二：使用一个指针left记录当前最后一个非零元素的位置，第一次遍历时遇到一个非零元素就放到left的位置并且left指向下一个位置；
     * 之后left后面的所有元素都变为0即可。
     * 时间：O(n)，空间：O(1)
     */
    public void moveZeroes(int[] nums) {
        int left = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[left++] = nums[i];
            }
        }
        for (int j = left; j < nums.length; j++) {
            nums[j] = 0;
        }
    }
}