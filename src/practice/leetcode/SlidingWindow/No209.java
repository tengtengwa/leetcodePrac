package practice.leetcode.SlidingWindow;

/**
 * 209. ������С��������
 * ����һ������ n ���������������һ�������� target ��
 * �ҳ���������������� �� target �ĳ�����С������������[numsl, numsl+1, ..., numsr-1, numsr],�������䳤�ȡ�
 * ��������ڷ��������������飬����0
 */
public class No209 {

}

class Solution209 {
    /**
     * �ⷨһ������
     * ö���������������ϣ��ж�������ĺͣ��������С�����鳤�ȡ�
     * ʱ�临�Ӷȣ�O(n^2)���ռ临�Ӷȣ�O(1)
     */

    /**
     * �ⷨ������������
     * ��ʵҲ�������Ϊ˫ָ�롣�ⷨ����ͨ��˫ָ��ά��һ��[l,r]�Ĵ����Լ�������������ĺ�curSum��
     * ���������������С��targetʱ����ָ�����ƣ�������ָ�����ƣ�ͬʱ�������������̳��ȡ�
     * ʱ�临�Ӷȣ�O(n)���ռ临�Ӷȣ�O(1)
     */
    public int minSubArrayLen(int target, int[] nums) {
        int l = 0, r = 0, min = Integer.MAX_VALUE, curSum = 0;
        while (r < nums.length) {
            while (curSum < target && r < nums.length) {
                curSum += nums[r++];
            }
            while (curSum >= target && l < r) {
                curSum -= nums[l++];
                min = Math.min(min, r - l + 1);
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
