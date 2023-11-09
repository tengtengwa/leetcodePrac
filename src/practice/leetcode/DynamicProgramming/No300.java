package practice.leetcode.DynamicProgramming;

public class No300 {
    public static void main(String[] args) {
        Solution300 s = new Solution300();
        s.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18, 4, 8, 6, 12});
    }
}

class Solution300 {

    /**
     * 题目：求最长上升子序列（严格递增），也就是说可以不连续
     * 解法一：动态规划，有点暴力，状态转移公式：dp[i] = Max(dp[j])+1，(0=<j<i,num[i]>num[j])
     * 时间：O(N^2)，空间：O(N)
     */
/*    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {   //内循环求[0,i)中子序列的最长上升长度
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }*/


    /**
     * 解法二：贪心+二分的思想，一次遍历，遍历过程中根据情况进行二分
     * 贪心的思想：创建一个数组用于维护一个上升序列，在遍历的过程中，遇到比数组末尾元素还大的就直接加到后面；否则在数组中通过二分查找
     * 第一个比它大的元素，将其替换，也就是
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        int[] arr = new int[nums.length];   //arr[i] 表示长度为 i + 1 的所有上升子序列的结尾的最小值。
        arr[0] = nums[0];
        int end = 0;    //arr数组中末尾元素，此位置以前的元素都是严格递增的

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > arr[end]) {
                end++;
                arr[end] = nums[i];
            } else {
                //当前元素比arr末尾元素小，通过二分查找到第一个比它大的元素，将其替换。替换时已有元素长度不变，所以end不会+1
                int left = 0, right = end;
                while (left < right) {
                    int mid = left + ((right - left) >>> 1);    //这里要留意，移位运算优先级小于逻辑运算符，必须加括号
                    if (arr[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                arr[left] = nums[i];        //跳出循环后left==right，这个位置的元素就是第一个比当前元素大的元素
            }
        }
        return end + 1;     //+1即为最长上升子序列长度
    }

}