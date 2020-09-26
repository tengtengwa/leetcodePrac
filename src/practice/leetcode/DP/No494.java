package practice.leetcode.DP;

public class No494 {
    public static void main(String[] args) {
        Solution494 s = new Solution494();
        s.findTargetSumWays(new int[]{1, 2, 3, 4, 5}, 3);
    }
}

class Solution494 {
    /**
     * ��Ŀ��Ŀ���
     * ����һ���Ǹ����������һ��Ŀ����S������+��-�������ţ����ؿ���ʹ���������ΪĿ���� S ��������ӷ��ŵķ�������
     *
     * �ⷨһ�������ݹ飬ö��ÿ�������
     * ʱ�䣺O(2^(n))��n������ĳ��ȣ���Ϊÿ��Ԫ�ض���+-�������
     * �ռ䣺O(n)��ջ�ռ�ĵݹ����
     */

    /**
     * �ⷨ����dp
     * ����P�����Ӽ���N�Ǹ��Ӽ� ���磺 ����nums = [1, 2, 3, 4, 5]��target = 3��һ�����ܵĽ��������+1-2+3-4+5 = 3 �������Ӽ�P = [1, 3, 5]�͸��Ӽ�N = [2, 4]
     * �������Ӽ��ĺ�sum(p)-���Ӽ��ĺ�sum(n)����Ŀ���S������ͨ�����ʽ�ӽ���ת��Ϊ�Ӽ�������⣺
     *      			  sum(P) - sum(N) = target
     * sum(P) + sum(N) + sum(P) - sum(N) = target + sum(P) + sum(N)
     *                        2 * sum(P) = target + sum(nums)
     * ����ԭ���������ת��Ϊһ�����Ӽ��ĺ����⣺ �ҵ�nums��һ���Ӽ� P��ʹ��sum( P ) = (target + sum(nums)) / 2��
     * ����������ʽ�ӣ��ɿ��� target+sum(nums) Ϊż��
     *
     * ʱ�䣺
     */
    public int findTargetSumWays(int[] nums, int S) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        //Ŀ���S+sum������������������Ԫ�صĺ�<Ŀ��ͣ�����������޽⣬ֱ�ӷ���0
        if (((sum + S) & 1) == 1 || S > sum) {
            return 0;
        }
        int subSum = (S + sum) >> 1;    //ת��Ϊ�������к�ΪsubSum���Ӽ�������
        //dp[i]��ʾ��Ϊi���Ӽ�����������״̬ת�Ʒ���Ϊdp[j]+=dp[j-nums[i]]��
        // ����Ϊ��ǰ�Ӽ��������� j-��ǰԪ��nums[i]���Ӽ�������
        int[] dp = new int[subSum + 1];     //�࿪һ��Ԫ�أ��±�ֱ�Ӷ�Ӧ
        dp[0] = 1;
        for (int num : nums) {     //���ѭ������������ÿ��Ԫ��
            for (int j = subSum; j >= 0; j--) { //�ڲ�ѭ������dp�����У�ע�⣡����ֻ�������������Ϊ֮ǰ��i-num״̬�Ѿ�����״̬����
                if (dp[j] != 0 && j + num <= subSum) {
                    dp[j + num] += dp[j];
                }
            }
        }
        /*
        ����˫ѭ��д������Ҳ��һ����
        for(int num : nums) {
            for(int i = subSum; i >= num; i--) {    //���������һά���飬i>=num��ֹԽ��
                dp[i] += dp[i-num];
            }
        }
        * */
        return dp[subSum];
    }
}