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
     * ����ϲ��������⣬˼·���������ٸ�����������ɸѡ��
     * ʱ�䣺O(nlogn)���ռ䣺O(logn) ��Ϊ��������Ҫ�Ŀռ临�Ӷȡ�    ע�⣬�����nlognʱ��Ҫ����n
     */
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return intervals;
        }
        List<int[]> ans = new ArrayList<>();
        Arrays.sort(intervals, (o1, o2) -> o1[0] - o2[0]);  //Arrays.sortʹ�ÿ���+�ϲ�����ʱ�临�Ӷȶ�Ϊnlogn
        int[] pre = intervals[0];                   //pre����ǰһ������
        for (int i = 1; i < intervals.length; i++) {    //������1��ʼ
            if (intervals[i][0] <= pre[1]) {        //�����ǰ����Ŀ�ʼʱ������һ���������ʱ��֮ǰ���Ϳ��Ժϲ�
                pre[1] = Math.max(intervals[i][1], pre[1]);     //����ǰһ������Ľ���ʱ��
                continue;
            }
            ans.add(pre);
            pre = intervals[i];         //������������Ҫ��pre������и���
        }
        ans.add(pre);                   //������ʣ�µ�һ������
        //ע�⣡���� ���ｫlist�е�����int����תΪһ����ά�����д��������Ҫע�⣬��������ֻ��ʹ��toArray�Ĺ��췽��toArray(T[] a)
        return ans.toArray(new int[ans.size()][2]);     //����ֵ����Ϊ T[]��
    }
}