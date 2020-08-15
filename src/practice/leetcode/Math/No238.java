package practice.leetcode.Math;

public class No238 {
    public static void main(String[] args) {
        Solution238 s = new Solution238();
        s.productExceptSelf(new int[]{1, 2, 3, 4});
    }
}

class Solution238 {
    /**
     * 题目：除自身以外数组的乘积
     * <p>
     * 解法一：使用两个辅助数组L、R来分别保存某个位置元素左右两边所有元素的乘积
     * <p>
     * 时间、空间：O(N)
     */
/*    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] ans = new int[len];
        left[0] = 1;
        right[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];    //当前位置元素左边的乘积 = 左一个元素的左边的乘积 * 左一个元素
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];  //右边也是类似的
        }
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }*/


    /**
     * 解法二：不使用辅助数组left和right，第一次遍历时ans数组存储每个位置元素左边的乘积，第二次遍历时使用一个变量R保存右边元素的乘积并进行更新
     *
     * 时间：O(N)，空间O(1)（输出数组ans不算在空间复杂度内）
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;

        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int R = 1;      //R保存的是右边元素的乘积
        for (int i = len - 1; i >= 0; i--) {    //注意范围，从最后一个元素开始，这相当于第一种解法的第三个循环
            ans[i] *= R;    //因为R是当前元素右边元素的乘积，ans[i]是左边元素的乘积，所以直接乘就好了
            R *= nums[i];   //更新R并继续计算前一个元素
        }
        return ans;
    }
}