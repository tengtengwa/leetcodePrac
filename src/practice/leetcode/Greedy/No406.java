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
     * ��Ŀ����������ؽ�����
     * ��Ŀ�����ò������⣬��ʵ�������ģ�����������վ��һ�ӣ���һ�����򣩣���ʱ��ͳ����ÿ����ǰ���м�����ߴ��ڵ����Լ����ˡ�
     * ͻȻ����������Щ�˵�˳��~~~ �����ǻָ���Щ�˵�˳��
     *
     * �ⷨ��
     * 1.�Ȱ���߽���������ͬ��߰�k�������򣬾����˴������ߵ���һ���ڰ����˵�ǰ�沢����ͬ�߶ȵ��˵����˳��������ս�������˳�����ס�����㣬�úڰ�
     * 2.����һ�����ϣ�������ϵ�ÿ��Ԫ����һ��һά���飬Ҳ�������Ƕ�ά�����һ�С�
     * 3.����Ϊ��λ�����ź����people[][]���飬����ÿ��������p[], ��ÿ��Ԫ�ز��뵽���ϵ�����Ϊp[1]��λ�ã�
     * 4.�Ѽ����е�����ת��Ϊһ����ά���飬���ؼ�����ȷ���
     */
    public int[][] reconstructQueue(int[][] people) {
        //ע�⣬ǰ-��Ϊ�������򣬺��ǰ�ǽ���
        Arrays.sort(people, (x, y) -> x[0] == y[0] ? x[1] - y[1] : y[0] - x[0]);
        //��Ϊ����ֵ�ǻָ�˳�������飬����list�д洢���������е�Ԫ��
        List<int[]> ans = new LinkedList<>();
        for (int[] p : people) {
            ans.add(p[1], p);   //add(int index, E element)����һ�������ǲ����λ�ã��ڶ����ǲ����Ԫ��
        }
        int len = people.length;
        return ans.toArray(new int[len][2]);    //listת��Ϊ���飬������һ��Ҫת���ɵ���������
    }
}