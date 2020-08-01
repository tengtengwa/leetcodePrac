package practice.leetcode.StackAndQueue;

import java.util.*;

public class No128 {
    public static void main(String[] args) {
        Solution128 s = new Solution128();
        s.longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6});
    }
}

class Solution128 {
    /**
     * 题目：最长连续序列，要求时间复杂度为O(N)
     *
     * 解法一：使用优先队列
     * 这种方法和桶排序的解法类似，都是先将数组变得有序，然后再进行一次线性遍历
     * 建立堆的时间复杂度：O(N)，证明比较复杂，直接给结论。总的时间也是O(n)；空间：O(n)
     *
     * 桶排序的解法：先建立一个int范围大小的数组，再进行一次线性遍历
     * Arrays.sort()先排序，时间会达到O(nlogn)
     */
/*    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int num : nums) {
            queue.add(num);
        }
        int maxLen = 1, curLen = 1;
        int num = queue.poll();
        while (!queue.isEmpty()) {
            int curNum = queue.poll();
            if (curNum - num == 1) {
                ++curLen;
                maxLen = Math.max(maxLen, curLen);
            } else if (curNum - num > 1) {
                curLen = 1;
            }
            num = curNum;
        }
        return maxLen;
    }*/

    /**
     * 解法二：使用set集合
     * 思路：先将所有元素加入set进行去重，再对set进行一次遍历。如果有比当前小1的元素就交给较小的元素去查找，也就是说没有比当前元素
     * 小1的元素时查询一次此元素开始的连续序列的长度并更新最大值
     *
     * 时间、空间：O(N)
     */
    /*public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        int max = 1;
        Set<Integer> set = new HashSet<>();
        for (int v : nums) set.add(v);

        for (int n : nums) {
            // 技巧：如果有比自己小一点的，那自己不查，让小的去查
            if (set.contains(n - 1)) continue;

            int r = n;                      // r: right 表示「以 v 开头，能连续到多少」
            while (set.contains(r + 1))
                r++;                        // 逐个查看
            max = Math.max(max, r - n + 1); // 记录区间 [v, r] 长度
        }
        return max;
    }*/


    /**
     * 解法三：使用Map
     * 思路：使用一个Map保存以每个元素为起始的一个区间，在遍历时通过map中前面已知的右边界来更新当前元素的右边界，然后更新最大值
     * 时间、空间：O(N),时间和使用优先队列差不多
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        Map<Integer, Integer> map = new HashMap<>(); // 记录区间 [v, r]
        for (int v : nums) map.put(v, v);

        int max = 1;
        for (int num : nums) {
            int r = num;
            while (map.containsKey(r + 1))
                r = map.get(r + 1);     //利用前面已知的右边界，快速找到当前需要的右边界，也就相当于剪枝，比不剪枝快很多
            map.put(num, r);
            max = Math.max(max, r - num + 1);
        }
        return max;
    }
}