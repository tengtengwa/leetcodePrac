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
        dfs(coins, amount, coins.length - 1, 0);    //从最大面额的硬币开始拿，index=coins.length-1
        return ans == Integer.MAX_VALUE ? -1 : ans;     //拿硬币拿不到所给钱数的情况下ans==Integer.MAX_VALUE，返回-1
    }

    private void dfs(int[] coins, int amount, int index, int num) {
        if (index < 0) {                                    //防止数组越界
            return;
        }
        for (int n = amount / coins[index]; n >= 0; n--) {  //n表示拿当前面额的硬币数量，因为用的除法，所以最小为0，又说明剩余钱数不可能小于0，所以无需对此进行判断
            int curNum = n + num;                           //当前硬币数量
            int restMoney = amount - n * coins[index];      //剩余钱数
            if (restMoney == 0) {                           //当前拿的硬币刚好够钱数，更新最少硬币数
                ans = Math.min(ans, curNum);
                break;
            }
            //这行代码为了剪枝，如果当前硬币数量+1已经大于前面所求硬币数量，就不用再继续往下递归了，如果比较难理解可以写成curNum>=ans
            if (curNum + 1 >= ans) {
                break;
            }
            dfs(coins, restMoney, index - 1, curNum);   //拿小一个面额的硬币
        }
    }

/*    //四个参数意义分别为：所给硬币种类的数组，当前剩余钱数，最少硬币个数，当前递归层数
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