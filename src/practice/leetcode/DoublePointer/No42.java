package practice.leetcode.DoublePointer;

import java.util.Stack;

public class No42 {
    public static void main(String[] args) {
        Solution42 s = new Solution42();
        s.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1});
    }
}

class Solution42 {

/*    //法一：动态规划
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int ans = 0;
        int size = height.length;
        int[] left_max = new int[size];
        int[] right_max = new int[size];
        left_max[0] = height[0];
        for (int i = 1; i < size; i++) {
            left_max[i] = Math.max(height[i], left_max[i - 1]);
        }
        right_max[size - 1] = height[size - 1];
        for (int i = size - 2; i >= 0; i--) {
            right_max[i] = Math.max(height[i], right_max[i + 1]);
        }
        for (int i = 1; i < size - 1; i++) {
            ans += Math.min(left_max[i], right_max[i]) - height[i];
        }
        return ans;
    }*/


/*    //法二：栈的应用
    public int trap(int[] height) {
        int ans = 0, cur = 0;
        Stack<Integer> stack = new Stack<>();
        while (cur < height.length) {
            while (!stack.isEmpty() && height[cur] > height[stack.peek()]) {
                int top = stack.pop();      //top为当前横条水柱的起始下标
                if (stack.isEmpty()) {
                    break;
                }
                int weigth = cur - stack.peek() - 1;    //weight为当前水柱的宽度
                int water_heigth = Math.min(height[cur], height[stack.peek()]) - height[top];   //当前水柱的高度
                ans += weigth * water_heigth;
            }
            stack.push(cur++);
        }
        return ans;
    }*/

    //法三：双指针
    public int trap(int[] height) {
        int left = 0, right = height.length - 1;
        int left_max = 0, right_max = 0;
        int ans = 0;
        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= left_max) {     //此处条件为大于或大于等于都不影响
                    left_max = height[left];
                } else {
                    ans += left_max - height[left];
                }
                left++;
            } else {
                if (height[right] > right_max) {
                    right_max = height[right];
                } else {
                    ans += right_max - height[right];
                }
                right--;
            }
        }
        return ans;
    }
}