package practice.leetcode.Others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No56 {
    public static void main(String[] args) {


    }
}

class Solution56 {
    /**
     * 经典合并区间问题，思路：先排序，再根据条件进行筛选。
     * 时间：O(nlogn)，空间：O(logn) 即为排序所需要的空间复杂度。    注意，排序的nlogn时间要多于n
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);  //Arrays.sort使用快排+合并排序，时间复杂度都为nlogn
        int[] pre = intervals[0];                   //pre代表前一个区间
        for (int i = 1; i < intervals.length; i++) {    //索引从1开始
            if (intervals[i][0] <= pre[1]) {        //如果当前区间的开始时间在上一个区间结束时间之前，就可以合并
                pre[1] = Math.max(intervals[i][1], pre[1]);     //更新前一个区间的结束时间
                continue;
            }
            ans.add(pre);
            pre = intervals[i];         //添加新区间后需要将pre区间进行更新
        }
        ans.add(pre);                   //添加最后剩下的一个区间
        //注意！！！ 这里将list中的所有int数组转为一个二维数组的写法尤其需要注意，而且这里只能使用toArray的构造方法toArray(T[] a)
        return ans.toArray(new int[ans.size()][2]);     //返回值类型为 T[]，
    }
}