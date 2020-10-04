package practice.leetcode.Array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class No581 {
    public static void main(String[] args) {
        Solution581 s = new Solution581();
        s.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
    }
}

class Solution581 {
    /**
     * 题目：最短无序连续子数组
     * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
     * 你找到的子数组应是最短的，请输出它的长度。
     *
     * 解法一：暴力
     * 思路：枚举每种子数组arr[i:j)，找出子数组的最大值max和min，并判断它是否符合条件：
     * 1.子数组前一段arr[0,i-1]的所有元素不大于min；后一段arr[j:len-1]的所有元素不小于max；
     * 2.两段都是升序的
     * 满足这三个条件的子数组就是所求数组，j-i就是它的长度
     *
     * 时间：O(n^3)，空间：O(1)
     */
/*    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int ans = len;
        for (int i = 0; i < len; i++) {
            for (int j = i; j <= len; j++) {    //子数组的范围是arr[i:j)
                int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    max = Math.max(max, nums[k]);
                    min = Math.min(min, nums[k]);
                }
                if ((i > 0 && nums[i - 1] > min) || (j < len && nums[j] < max)) {   //i>0,j<len是为了防止越界
                    continue;
                }
                int k = 0, pre = Integer.MIN_VALUE;
                while (k < i && pre <= nums[k]) {
                    pre = nums[k];
                    k++;
                }
                if (k != i) {
                    continue;
                }
                k = j;
                while (k < len && pre <= nums[k]) {
                    pre = nums[k];
                    k++;
                }
                if (k == len) {
                    ans = Math.min(j - i, ans);     //取最小长度
                }
            }
        }
        return ans;
    }*/

    /**
     * 解法二：暴力优化。
     * 我们依然枚举每种子数组的可能，如果存在子数组的右边界nums[j]比左边界nums[i]小，这意味着nums[i]和nums[j]
     * 都不在排序后数组中的正确位置，我们记录i和j，这两个元素标记着目前无序数组的边界。
     * 最终子数组的最小长度就是r-l+1
     */
/*    public int findUnsortedSubarray(int[] nums) {
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;   //数组已经有序时r-l小于0，此时子数组长度为0
    }*/

    /**
     * 解法三：排序后比较
     * 思路：克隆一个数组进行排序，再和原数组进行比较，判断它们第一个和最后一个不相同元素的下标，最短子数组的长度就是r-l+1
     * 时间：O(nlogn)，空间：O(n)
     */
/*    public int findUnsortedSubarray(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (arr[i] != nums[i]) {
                l = Math.min(l, i);
                r = Math.max(r, i);
            }
        }
        return r - l < 0 ? 0 : r - l + 1;   //数组已经有序时r-l小于0，此时子数组长度为0
    }*/


    /**
     * 解法四：使用栈
     * 思路：这个方法背后的想法仍然是选择排序。我们需要找到无序子数组中最小元素和最大元素分别对应的正确位置，来求得我们想要的
     * 无序子数组的边界。
     * 为了达到这一目的，此方法中，我们使用栈。我们从头遍历 nums数组，如果遇到的数字大小一直是升序的，我们就不断把对应的下标压入栈中，
     * 这么做的目的是因为这些元素在目前都是处于正确的位置上。一旦我们遇到前面的数比后面的数大，也就是 nums[j]比栈顶元素小，
     * 我们可以知道 nums[j]一定不在正确的位置上。
     * 为了找到 nums[j]的正确位置，我们不断将栈顶元素弹出，直到栈顶元素比nums[j] 小，我们假设栈顶元素对应的下标为k，
     * 那么我们知道 nums[j]的正确位置下标应该是k+1 。
     * 我们重复这一过程并遍历完整个数组，这样我们可以找到最小的k，它也是无序子数组的左边界。这样就找到了无序子数组的左边界应该出现的位置
     * 我们再逆序进行一次遍历，走一遍上面的步骤，就可以找到无序子数组的右边界，这样就求得了子数组的最短长度。
     *
     * 时间、空间：O(n)
     */
/*    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int l = len, r = 0;
        Deque<Integer> stack = new LinkedList<>();  //栈中存储元素的下标
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peekLast()]) {  //这里比较的是元素，注意不要直接拿栈中的下标来比较了
                l = Math.min(l, stack.pollLast());      //记录子数组左边界下标
            }
            stack.addLast(i);
        }
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peekLast()]) {  //这里同样比较的是元素
                r = Math.max(r, stack.pollLast());
            }
            stack.addLast(i);
        }
        return Math.max(r - l + 1, 0);
    }*/


    /**
     * 解法五：“双指针”，也就是官方解法五
     * 思路：一次遍历，同时从前向后、从后向前找当前最大最小值max和min，并更新左右边界
     * 时间：O(n)，空间：O(1)
     */
    public int findUnsortedSubarray(int[] nums) {
        //这里左右边界的取值也有讲究，如果数组已经是升序的，l和r就没有改变，下面r-l+1就是0，就不用写Math.max(r-l+1,0)了；
        //最后返回Math.max(r-l+1,0)就需要r-l+1<=0，也就是r<=l-1
        int l = 0, r = -1;
        int max = nums[0], min = nums[nums.length -1];
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] < max) {    //寻找右边界，如果当前元素小于前面的最大值，说明这是一个可能的右边界
                r = i;
            } else {
                max = nums[i];
            }

            int j = nums.length - i - 1;
            if (nums[j] > min) {    //寻找左边界，如果当前元素小于前面的最大值，说明这是一个可能的左边界
                l = j;
            } else {
                min = nums[j];
            }
        }
        return r - l + 1;
    }
}