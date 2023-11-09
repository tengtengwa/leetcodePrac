package practice.leetcode.DynamicProgramming;

import java.util.*;

public class No354 {
    public static void main(String[] args) {
        Solution354 s = new Solution354();
        s.maxEnvelopes(new int[][]{
                {5, 4},
                {6, 4},
                {6, 7},
                {2, 3},
                {4, 1},
                {4, 3},
                {4, 2},
                {4, 4}
        });
    }
}

/**
 * <a href="https://leetcode.cn/problems/russian-doll-envelopes/description/">354. 俄罗斯套娃信封问题</a>
 * 此题是300.求最长上升子序列的升级版，增加了一个维度，我们需要在此前的基础上求这样一个最大子序列：
 * 当选择k个信封时，需要宽高同时满足：
 * - w1<w2<...<w(k-1)
 * - h1<h2<...<w(k-1)
 *
 * 解法一：贪心+dp
 *  思路：
 *  1、对于二维数组e，我们将w作为第一关键字，h作为第二关键字，进行排序，这样w就固定了下来
 *  2、接着问题就转化为300的求最长上升子序列，我们对第二维h求最长上升子序列即可。
 *  时间复杂度：O(nlogn)，空间复杂度：O(n)
 */
class Solution354 {
    public int maxEnvelopes(int[][] envelopes) {
        Arrays.sort(envelopes, (a, b) ->
                a[0] == b[0] ? b[1] - a[1] : a[0] - b[0]);
        List<Integer> list = new ArrayList<>();
        list.add(envelopes[0][1]);
        int n = envelopes.length;
        for (int i = 1; i < n; i++) {
            int w = envelopes[i][1];
            if (w > list.get(list.size() - 1)) list.add(w);
            else {
                int idx = Collections.binarySearch(list, w);
                if (idx < 0) idx = -idx - 1;
                list.set(idx, w);
            }
        }
        return list.size();
    }
}