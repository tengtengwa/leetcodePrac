package practice.leetcode;

public class No11 {
    public static void main(String[] args) {
        Solution11 s = new Solution11();
        int[] a = {1,8,6,2,5,4,8,3,7};
        System.out.println(s.maxArea(a));

    }
}

class Solution11 {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int L = 0;
        int R = height.length - 1;
        while (L < R) {
            int curr = (R - L) * Math.min(height[L], height[R]);
            if (curr > maxArea) {
                maxArea = curr;
            }
            if (height[L] > height[R]) {
                R--;
            } else {
                L++;
            }
        }
        return maxArea;
    }
}