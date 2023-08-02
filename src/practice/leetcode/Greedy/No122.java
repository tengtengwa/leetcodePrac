package practice.leetcode.Greedy;

/**
 * 122. ������Ʊ�����ʱ�� II
 * ����һ����������prices������prices[i]��ʾĳ֧��Ʊ��i��ļ۸�
 * ��ÿһ�죬����Ծ����Ƿ����/����۹�Ʊ�������κ�ʱ�����ֻ�ܳ���һ�ɹ�Ʊ����Ҳ�����ȹ���Ȼ����ͬһ����ۡ�
 * �������ܻ�õ��������
 * ע�⣺��ĿҪ���У�ÿһ�����ͬʱ������۳�
 */
public class No122 {
    public static void main(String[] args) {
        Solution122 s = new Solution122();
        int max = s.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
        System.out.println(max);
    }
}

class Solution122 {
    /**
     * �ⷨһ������
     * dfsö�����п��ܵ������ȡ������󼴿ɡ�
     * ʱ�临�Ӷȣ�O(2^n)���ռ临�Ӷȣ�O(n)
     */
    private int res = 0;
    public int maxProfit(int[] prices) {
        if (prices.length < 2) {
            return 0;
        }
        dfs(prices, 0, 0, 0);
        return res;
    }

    /**
     * @param prices        ��Ʊ�۸�����
     * @param i             ��ǰ�ǵ�i+1��
     * @param status        ��ǰ���й�Ʊ/�ֽ�1������й�Ʊ��0��������ֽ�
     * @param curProfile    ��ǰ������
     */
    private void dfs(int[] prices, int i, int status, int curProfile) {
        if (i == prices.length) {
            res = Math.max(res, curProfile);
            return;
        }
        dfs(prices, i + 1, status, curProfile);
        if (status == 0) {
            dfs(prices, i + 1, 1, curProfile - prices[i]);
        } else {
            dfs(prices, i + 1, 0, curProfile + prices[i]);
        }
    }

    /**
     * �ⷨ������̬�滮
     * ͨ��һ����ά����/����һά�������洢״̬������������һά����cash��stock���洢��i����й�Ʊ/�ֽ�ʱ����������
     * �����ֽ�/��Ʊʱ����������ת�Ƶ�״̬���ֽ𣺲���/���룻��Ʊ������/����
     * ת�Ʒ��̣�
     * cash[i]=max(cash[i-1], price[i] - stock[i-1])
     * stock[i]=max(stock[i-1], cash[i-1] - price[i])
     * ����cash[n-1]���������������
     *
     * ʱ�临�Ӷȣ�O(n)���ռ临�Ӷȣ�O(n)
     * �Ż�������ͨ���ĸ������滻�����������Ż��ռ䣬�洢��i-1�켰i��ʱ�����ֽ�/��Ʊʱ���������
     */
//    public int maxProfit(int[] prices) {
//        int res = 0;
//        if (prices.length < 2) {
//            return res;
//        }
//        int[] cash = new int[prices.length];
//        int[] stock = new int[prices.length];
//        cash[0] = 0;
//        stock[0] = -prices[0];
//        for (int i = 1; i < prices.length; i++) {
//            cash[i] = Math.max(cash[i - 1], prices[i] + stock[i - 1]);
//            stock[i] = Math.max(stock[i - 1], cash[i - 1] - prices[i]);
//        }
//        return cash[prices.length - 1];
//    }

    /**
     * �ⷨ����̰��
     * �����һ������ⷨ��ֻ��������ֵ������������ʵ�ʵĽ��׹��̡�
     * ��Ϊ����ÿ�춼����ͬʱ����������Ĳ�������ˣ�[l,r]���乱�׵�������Էֽ��ÿһ��С�Σ�
     * P[l,r]=P[l,l+1]+P[l+1,l+2]...P[r-2,r-1]+P[r-1,r]
     * ��������ֻ��Ҫ������й��״���0�����伴��ʹ�������
     * ʱ�临�Ӷȣ�O(n)���ռ临�Ӷȣ�O(1)
     */
//    public int maxProfit(int[] prices) {
//        int ans = 0;
//        for (int i = 1; i < prices.length; i++) {
//            int delta = prices[i] - prices[i - 1];
//            if (delta > 0) {
//                ans += delta;
//            }
//        }
//        return ans;
//    }
}