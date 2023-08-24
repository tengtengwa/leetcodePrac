package practice.leetcode.SlidingWindow;

import java.util.*;

public class No239 {
    public static void main(String[] args) {
        Solution239 s = new Solution239();
        s.maxSlidingWindow(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, 3);
    }
}

class Solution239 {
    /**
     * 题目：滑动窗口的最大值
     * <p>
     * 解法一：暴力，每次从当前位置向后k个元素的窗口中寻找最大值
     * <p>
     * 时间复杂度：O(Nk)。其中 N 为数组中元素个数。空间复杂度：O(N-k+1)，用于输出数组。
     */
/*    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int[] ans = new int[len - k - 1];

        ans[0] = max;
        max = Integer.MIN_VALUE;
        for (int i = 0; i <= len - k; i++) {
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            ans[i] = max;
            max = Integer.MIN_VALUE;
        }
        return ans;
    }*/


    /**
     * 解法二：使用一个双端队列维护一个递减元素的下标，注意是下标
     * <p>
     * 思路：在遍历的过程中，动态维护这个存储递减元素的下标的队列
     * 1、加入下标前，去除队尾所有小于当前位置元素的下标；
     * 2、如果队列中最大值已经不在当前窗口中，直接移除队首元素
     * 每次经过以上操作后，队首元素就是当前窗口最大值的下标，每次向输出数组加入的元素就是当前队首下标对应的元素。
     * <p>
     * 时间：O(N)（for循环中的while循环是常数级的），空间：O(N)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= 1 || k <= 1) {
            return nums;
        }
        //注意：双端队列中存储的是元素的下标
        Deque<Integer> list = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            //加入一个元素的下标前，将队列尾部<=当前[元素]的所有下标移除。注意！比较的是元素
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[i]) {
                list.pollLast();
            }
            //检查以后加入当前元素下标
            list.add(i);
            //如果队列中最大值已经不在当前窗口中，直接移除队首元素
            if (list.peek() <= i - k) {
                list.pollFirst();
            }
            //从第k个元素开始，向输出数组中添加答案
            if (i + 1 - k >= 0) {
                ans[i - k + 1] = nums[list.peek()]; //注意队中的元素是下标，这里要去取元素
            }
        }
        return ans;
    }


    /**
     * 解法三：优化的暴力法
     * <p>
     * 思路：动态维护一个当前窗口的最大元素的下标maxIndex，如果它不在当前窗口的范围，就从当前窗口中寻找最大元素下标；
     * 否则在下一次循环中用窗口最右边的元素和最大元素比较并更新最大元素索引
     *
     * 时间：O(n)（最差是降序的情况，复杂度为kn，k为常数，还是O(n)），空间：O(N)
     */
//    public int[] maxSlidingWindow(int[] nums, int k) {
//        int[] ans = new int[nums.length - k + 1];
//        int maxIndex = -1;
//        int j = 0;
//        for (int i = 0; i <= nums.length - k; i++) {
//            //滑动窗口的范围为[i,i+k-1]，判断最大元素的下标maxIndex是否在这个范围中
//            if (i <= maxIndex && maxIndex <= i + k - 1) {
//                //因为if-else语句的上半句一定会在下面else语句执行后的下一次循环执行，所以这里比较窗口最右边的那个新元素和窗口中的最大元素
//                if (nums[maxIndex] <= nums[i + k - 1]) {   //如果窗口最右边的元素大于当前最大元素，就更新最大元素下标
//                    maxIndex = i + k - 1;
//                }
//            } else {
//                //最大元素下标不在[i,i+k-1]范围中，在此范围寻找最大元素下标并更新
//                maxIndex = i;
//                for (int m = i; m <= i + k - 1; m++) {  //注意m的范围[i,i+k-1]
//                    if (nums[maxIndex] < nums[m])
//                        maxIndex = m;
//                }
//            }
//            ans[j++] = nums[maxIndex];
//        }
//        return ans;
//    }
}