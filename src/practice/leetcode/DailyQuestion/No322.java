package practice.leetcode.DailyQuestion;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class No322 {
    public static void main(String[] args) {
        Solution322 s = new Solution322();
        System.out.println(s.coinChange(new int[]{470,18,66,301,403,112,360}, 8235));
//186, 419, 83, 408     6249        [470,18,66,301,403,112,360] 8235
    }
}


class Solution322 {
    int ans = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        dfs(coins, amount, coins.length - 1, 0);    //���������Ӳ�ҿ�ʼ�ã�index=coins.length-1
        return ans == Integer.MAX_VALUE ? -1 : ans;     //��Ӳ���ò�������Ǯ���������ans==Integer.MAX_VALUE������-1
    }

    private void dfs(int[] coins, int amount, int index, int num) {
        if (index < 0) {                                    //��ֹ����Խ��
            return;
        }
        for (int n = amount / coins[index]; n >= 0; n--) {  //n��ʾ�õ�ǰ����Ӳ����������Ϊ�õĳ�����������СΪ0����˵��ʣ��Ǯ��������С��0����������Դ˽����ж�
            int curNum = n + num;                           //��ǰӲ������
            int restMoney = amount - n * coins[index];      //ʣ��Ǯ��
            if (restMoney == 0) {                           //��ǰ�õ�Ӳ�Ҹպù�Ǯ������������Ӳ����
                ans = Math.min(ans, curNum);
                break;
            }
            //���д���Ϊ�˼�֦�������ǰӲ������+1�Ѿ�����ǰ������Ӳ���������Ͳ����ټ������µݹ��ˣ�����Ƚ���������д��curNum>=ans
            if (curNum + 1 >= ans) {
                break;
            }
            dfs(coins, restMoney, index - 1, curNum);   //��Сһ������Ӳ��
        }
    }

/*    //�ĸ���������ֱ�Ϊ������Ӳ����������飬��ǰʣ��Ǯ��������Ӳ�Ҹ�������ǰ�ݹ����
    private int dfs(int[] coins, int rest, int ans, int level) {
        if (rest == 0) return 0;
        if (rest < 0) return -1;
        for (int i = coins.length - 1; i >= 0; i--) {
            int coin = coins[i];
            if (rest > coin) {
                return dfs(coins, rest - coin, ans + 1, level + 1);
            } else if (rest == coin) {
                return ans + 1;
            }
*//*            if (i == 0) {
                dfs(coins,rest,ans)
            }*//*
            if (level == 1 && i == 0) {
                return -1;
            }
        }
        return ans;
    }*/
}