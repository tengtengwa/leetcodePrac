package practice.leetcode.DoublePointer;

import java.util.ArrayDeque;
import java.util.Deque;

public class No84 {
    public static void main(String[] args) {
        Solution84 s = new Solution84();
        s.largestRectangleArea(new int[]{2, 1, 5, 6, 2, 3});
    }
}

class Solution84 {
    /**
     * 总体思路：
     * 首先，要想找到第 i 位置最大面积是什么？
     * 是以i为中心，向左找第一个小于 heights[i] 的位置 left_i；向右找第一个小于于 heights[i] 的位置 right_i，
     * 即最大面积为 heights[i] * (right_i - left_i -1)
     *
     * 解法一：暴力法
     * 遍历枚举以每个柱形为高度的最大矩形的面积，每次向左向右扩散，找出此次最大的面积并更新最大值。
     * 时间：O(n^2)    空间：O(1)
     */
/*    public int largestRectangleArea(int[] heights) {
        int max = 0;
        for (int i = 0; i < heights.length; i++) {
            int left = i;
            while (left - 1 >= 0 && heights[left - 1] >= heights[i]) {
                left--;
            }
            int rigth = i;
            while (rigth + 1 < heights.length && heights[rigth + 1] >= heights[i]) {
                rigth++;
            }
            max = Math.max(max, heights[i] * (rigth - left + 1));
        }
        return max;
    }*/

    /**
     * 解法二：单调栈法，利用一个栈对数组进行一次遍历
     * https://leetcode-cn.com/problems/largest-rectangle-in-histogram/solution/bao-li-jie-fa-zhan-by-liweiwei1419/
     * 思路：维护一个单调栈，栈中存储元素的下标。碰到递增的元素就入栈，否则可以通过出栈确定前面一些矩形的宽度和面积。
     * 时间：O(N) = 空间
     */


/*    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < len; i++) {
            //因为栈中存储的下标，所以下面凡是涉及比较数组元素的，不能直接通过栈中元素来比较
            while (!stack.isEmpty() && heights[i] < heights[stack.peekLast()]) {    //比较元素
                int heigth = heights[stack.pollLast()];     //将栈中取出的下标转换为元素对应的矩形高度
                while (!stack.isEmpty() && heights[stack.peekLast()] == heigth) {
                    stack.pollLast();
                }
                //当不满足上面的条件后，就说明找到了一个两边元素比它小的矩形，这样就可以求出宽度，进而求出面积
                int width;
                if (stack.isEmpty()) {
                    width = i;          //栈空了，说明i-1对应的就是宽度。因为索引从0开始，所以前面元素个数其实是i-1+1，即i就是宽度。
                } else {
                    width = i - stack.peekLast() - 1;       //注意，这里是求中间隔了多少，所以要-1
                }
                max = Math.max(max, heigth * width);
            }
            stack.add(i);
        }
        while (!stack.isEmpty()) {
            int height = heights[stack.pollLast()];
            while (!stack.isEmpty() && heights[stack.peekLast()] == height) {
                stack.pollLast();
            }
            int width;
            if (stack.isEmpty()) {
                width = len;    //这说明height为当前最低元素的高度，所以宽度直接对应数组长度
            } else {
                width = len - stack.peekLast() - 1;     //仍要注意-1
            }
            max = Math.max(max, height * width);
        }
        return max;
    }*/


    /**
     * 解法二的优化，在数组两边分别放置一个高度小于1的元素作为 “哨兵”，从而避免栈为空的判断
     */
    public int largestRectangleArea(int[] heights) {
        int len = heights.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return heights[0];
        }
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] arr = new int[len + 2];
        System.arraycopy(heights, 0, arr, 1, len);
        len += 2;
        arr[0] = 0;
        arr[len - 1] = 0;
        stack.add(0);       //先在栈中放入数组第一个元素0

        //从原数组的第一个元素开始遍历，因为最后一个元素和第一个相等，所以最后栈必定不为空，减少了上面解法的判空
        for (int i = 1; i < len; i++) {
            while (arr[i] < arr[stack.peekLast()]) {    //每次找到数组中小于栈顶的元素，就更新一次最大值
                int heigth = arr[stack.pollLast()];
                int width = i - stack.peekLast() - 1;
                max = Math.max(max, heigth * width);
            }
            stack.add(i);
        }
        return max;
    }
}