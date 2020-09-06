package practice.leetcode.Greedy;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class No406 {
    public static void main(String[] args) {
        Solution406 s = new Solution406();
        s.reconstructQueue(new int[][]{
                {7, 0},
                {4, 4},
                {7, 1},
                {5, 0},
                {6, 1},
                {5, 2}
        });

    }
}

class Solution406 {
    /**
     * 题目：根据身高重建队列
     * 题目描述得不大好理解，其实是这样的：本来所有人站成一队（不一定有序），这时候统计下每个人前边有几个身高大于等于自己的人。
     * 突然，打乱了这些人的顺序~~~ 问题是恢复这些人的顺序
     *
     * 解法：
     * 1.先按身高降序排序，相同身高按k升序排序，经过此次排序后高的人一定在矮的人的前面并且相同高度的人的相对顺序就是最终结果的相对顺序。请记住这两点，敲黑板
     * 2.创建一个集合，这个集合的每个元素是一个一维数组，也就是我们二维数组的一行。
     * 3.以行为单位遍历排好序的people[][]数组，假设每行数据是p[], 把每行元素插入到集合的索引为p[1]的位置，
     * 4.把集合中的数据转换为一个二维数组，返回即是正确结果
     */
    public int[][] reconstructQueue(int[][] people) {
        //注意，前-后为升序排序，后减前是降序
        Arrays.sort(people, (x, y) -> x[0] == y[0] ? x[1] - y[1] : y[0] - x[0]);
        //因为返回值是恢复顺序后的数组，所以list中存储单个数组中的元素
        List<int[]> ans = new LinkedList<>();
        for (int[] p : people) {
            ans.add(p[1], p);   //add(int index, E element)，第一个参数是插入的位置，第二个是插入的元素
        }
        int len = people.length;
        return ans.toArray(new int[len][2]);    //list转换为数组，参数是一个要转换成的数组类型
    }
}