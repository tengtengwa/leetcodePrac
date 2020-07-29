package practice.leetcode.Math;

public class No136 {
    public static void main(String[] args) {
        Solution136 s = new Solution136();
        s.singleNumber(new int[]{1, 2, 3, 2, 3});
    }
}

class Solution136 {
    /**
     * 题目：求数组中只出现一次的元素
     * 解法一：暴力双循环，O(n^2)
     * 解法二：使用一个set集合来存放出现过一次的元素，遍历一次数组，遇到set中没有的元素就加入set，否则删除set中响应的元素，
     * 最后剩下一个元素就是只出现一次的元素
     *
     * 解法三：位运算
     * 一次遍历，将所有元素进行异或运算，因为它有如下性质：
     * 1.交换律：a ^ b ^ c <=> a ^ c ^ b
     * 2.任何数于0异或为任何数 0 ^ n => n
     * 3.相同的数异或为0: n ^ n => 0
     * 因为只有一个元素出现过一次，其他所有出现两次的元素异或结果必定为0，因此所有元素异或的结果就是那个出现过一次的元素
     */
    public int singleNumber(int[] nums) {
        int ans = nums[0];
        for (int i = 1; i < nums.length; i++) {
            ans ^= nums[i];
        }
        return ans;
    }
}