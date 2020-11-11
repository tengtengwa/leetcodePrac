package practice.leetcode.BinarySearch;

import java.util.Arrays;

public class No287 {
    public static void main(String[] args) {
        Solution287 s = new Solution287();
        s.findDuplicate(new int[]{3, 1, 3, 4, 2});
    }
}

class Solution287 {
    /**
     * 题目：寻找重复数，给定一个包含n+1个整数的数组nums，其数字都在1到n之间（包括1和n），可知至少存在一个重复的整数。
     * 假设只有一个重复的整数，找出这个重复的数。
     * 题目要求：
     * 不能更改原数组（假设数组是只读的）。
     * 只能使用额外的 O(1) 的空间。
     * 时间复杂度小于 O(n2) 。
     * 数组中只有一个重复的数字，但它可能不止重复出现一次。
     *
     *
     * 解法一：二分查找
     * 思路：在[1.n]之间进行二分查找，每个循环中通过抽屉原理确定重复元素在哪个半边来缩小这个范围
     *
     * 时间：O(nlogn)，二分法的时间复杂度为O(logN)，在二分法的内部，执行了一次for循环，时间复杂度为O(N)，故时间复杂度为O(NlogN)。
     * 空间：O(1)
     */
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        //题目条件为：数组中元素在[1,n]之间，这里查找的范围[left,right]也就是[1,n]
        int left = 1;
        int right = len - 1;
        while (left < right) {      //结束条件为范围[left,right]内只有一个数，即left==right的时候
            // 在 Java 里可以这么用，当 left + right 溢出的时候，无符号右移保证结果依然正确
            int mid = (left + right) >>> 1;

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }

            //根据抽屉原理，小于等于4的个数如果严格大于4个，此时重复元素一定出现在 [1, 4] 区间里
            //这里和重复元素在左半边还是在右半边无关，因为我们查找的是整个数组中所有<=mid元素的元素个数
            if (cnt > mid) {
                // 重复元素位于区间 [left, mid]
                right = mid;
            } else {
                // if 分析正确了以后，else 搜索的区间就是 if 的反面，[mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }


    /**
     * 解法二：双指针
     * 思路：抽象成链表的双指针，解法和循环链表2类似，
     * 慢指针指向下一个节点的操作为slow = nums[slow];快指针指向后两个节点的操作为fast = nums[nums[fast]];
     * 可以参考这篇题解：https://leetcode-cn.com/problems/find-the-duplicate-number/solution/287xun-zhao-zhong-fu-shu-by-kirsche/
     *
     * 时间：O(n)，时间：O(1)
     */
/*    public int findDuplicate(int[] nums) {
        int slow = 0, fast = nums[0];
        while (slow != fast) {  //slow、fast都表示当前节点，所以这里和下面的条件直接判断它们是否相等即可
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //第一次相遇后将快指针指向首节点，慢指针后移一个节点（因为开始时快指针多走了一步）
        fast = 0;
        slow = nums[slow];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }*/
}