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
 * <a href="https://leetcode.cn/problems/russian-doll-envelopes/description/">354. ����˹�����ŷ�����</a>
 * ������300.������������е������棬������һ��ά�ȣ�������Ҫ�ڴ�ǰ�Ļ�����������һ����������У�
 * ��ѡ��k���ŷ�ʱ����Ҫ���ͬʱ���㣺
 * - w1<w2<...<w(k-1)
 * - h1<h2<...<w(k-1)
 *
 * �ⷨһ��̰��+dp
 *  ˼·��
 *  1�����ڶ�ά����e�����ǽ�w��Ϊ��һ�ؼ��֣�h��Ϊ�ڶ��ؼ��֣�������������w�͹̶�������
 *  2�����������ת��Ϊ300��������������У����ǶԵڶ�άh������������м��ɡ�
 *  ʱ�临�Ӷȣ�O(nlogn)���ռ临�Ӷȣ�O(n)
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