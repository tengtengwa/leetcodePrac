package practice.leetcode.DP;

public class No198 {
    public static void main(String[] args) {


    }
}

class Solution198 {
    /**
     * ��Ŀ����ҽ��ᣬ����һ�����飬����ѡȡ���ڵ�Ԫ�أ�����ȡ�������ֵ
     * һ��easy�Ķ�̬�滮...
     *
     * �ⷨ����̬�滮������dp���鱣��ÿ��λ��i��ȡ�������ֵ
     * ״̬ת�Ʒ��̣�dp[i] = max(dp[i-2]+nums[i], dp[i-1])
     * ʱ�䡢�ռ䣺O(N)
     */
/*    public int rob(int[] nums) {
        int len = nums.length;
        int[] dp = new int[len];

        if (len == 0) {
            return 0;
        } else if (len == 1) {
            return nums[0];
        } else if (len == 2) {
            return Math.max(nums[0], nums[1]);
        }
        //ֻ��һ�䷿�ݣ�ֻ��͵���
        dp[0] = nums[0];
        //�����䷿�ݣ���Ϊ����͵���ڵķ��ݣ�����ѡ������֮�нϴ��͵
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < len; i++) {
            //ÿ��λ�ã����ݣ���͵�Ͳ�͵����״̬��͵�ˣ�dp[i]=dp[i - 2] + nums[i]����͵��dp[i]=dp[i - 1]
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[len - 1];
    }*/

    /**
     * ��ʹ��dp�����¼ÿ��״̬��һ��λ�õ�״ֻ̬��ǰ����λ�õ�״̬�йأ���������ֻ��Ҫ��¼������λ�õ�״̬����
     */
    public int rob(int[] nums) {
        int len = nums.length;
        if (len == 0) {
            return 0;
        }
        if (len == 1) {
            return nums[0];
        }
        int first = nums[0];
        int second = Math.max(nums[0], nums[1]);

        for (int i = 2; i < len; i++) {
            int tem = second;                           //����tem��¼ǰһ��λ�õ�״̬
            second = Math.max(first + nums[i], second); //����secondΪ��ǰλ�õ�״̬
            first = tem;                                //��ǰ����λ�õ�״̬����Ϊǰһ��λ�õ�״̬
        }
        return second;
    }
}