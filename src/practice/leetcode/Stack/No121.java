package practice.leetcode.Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class No121 {
    public static void main(String[] args) {
        Solution121 s = new Solution121();
        s.maxProfit(new int[]{1, 2});


    }
}

class Solution121 {
    /**
     *  ��Ŀ��������Ʊ�����ʱ���������������ҳ���������Сֵ�����ֵ�Ĳ�
     *  ��������˫ѭ������ÿ����Ԫ�صĲ�ֵ������󼴿ɡ�ʱ�� O(n^2)
     *
     *  �������������ǹٷ�������һ�α����������ڶ�̬�滮
     *  ˼·�����������У��߸�����Сֵ���߼����������
     */
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int maxProfit = 0;                  //�������
        int min = Integer.MAX_VALUE;        //min�ǵ�ǰԪ�ؼ���ǰ������Ԫ�صġ���ʷ��Сֵ��
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > maxProfit) {
                maxProfit = price - min;
            }
        }
        return maxProfit;
    }


    /**
     * ����ջ�ⷨ��
     */
/*    public int maxProfit(int[] prices) {
        int len = prices.length;
        if (len == 0) return 0;
        int max = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] arr = new int[len + 1];       //����β������һ�����ڱ�������ֹ����Ԫ�ص���������´�Ϊ0
        System.arraycopy(prices, 0, arr, 0, len);
        prices = arr;

        for (int i = 0; i < prices.length; i++) {
            //���Ԫ�ص�������ֱ����ջ������ջ��ǰ����ڵ�ǰԪ�ص�����Ԫ�س�ջ
            while (!stack.isEmpty() && prices[i] <= stack.peekLast()) {
                max = Math.max(max, stack.peekLast() - stack.peekFirst());
                stack.pollLast();       //ע���ȸ�����max�ٽ�ջ��Ԫ�س�ջ������ֻ��һ��Ԫ�ص�ʱ���ָ��
            }
            stack.add(prices[i]);
        }
        return max;
    }*/
}