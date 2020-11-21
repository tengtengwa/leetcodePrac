package practice.leetcode.offer;

import java.util.Arrays;
import java.util.HashMap;

public class O39 {
    public static void main(String[] args) {
        SolutionO39 s = new SolutionO39();
        s.majorityElement(new int[]{2, 2, 1, 1, 1, 2, 2});
    }
}

class SolutionO39 {
    /**
     * ��Ŀ�������г��ִ�������һ�������
     */

    /**
     * �ⷨһ������
     * ������ֱ�ۡ���򵥵Ľⷨ��ֱ�Ӷ��������������Ϊ�������һ����������ֲ��ܷ�����������������м���������������
     *
     * ʱ�䣺O(nlogn)
     */
/*    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length >>> 1];
    }*/


    /**
     * �ⷨ������ϣ��
     * ˼·����һ����ϣ���¼ÿ�����ֳ��ֵĴ����������ǰ���ֳ��ִ����������鳤�ȵ�һ�룬��ô�����������
     *
     * ʱ�䡢�ռ䣺O(n)
     */
/*    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        if (nums.length == 1) {     //��һ�����ֵ������������
            return nums[0];
        }
        int midLen = nums.length >>> 1;

        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, 1);
            } else {
                int time = map.get(num);
                if (time + 1 > midLen) {        //�����ڱ�����ʱ����������ֳ��ֵĴ�����Ҳ�����ٸ�һ��forѭ��ȥ��������
                    return num;
                }
                map.put(num, time + 1);
            }
        }
        return -1;
    }*/


    /**
     * �ⷨ����Ħ��ͶƱ��
     * ˼·����ʼʱ�����һ����Ϊ�������������Ĺ������������������ȵ�����Ʊ����+1������Ʊ��-1����Ʊ��Ϊ0��ʱ��˵��ǰ������������ˣ�
     * ���������������������ֵĴ�����>���鳤�ȵ�1/2�������Ҫ�ҵ��������ֵĴ����������鳤�ȵ�1/2������������Ʊ��һ��>0��
     *
     * ʱ�䣺O(n)���ռ䣺O(1)
     */
    public int majorityElement(int[] nums) {
        int x = 0, vote = 0;
        for (int num : nums) {
            if (vote == 0) x = num;     //ǰ������������ˣ����赱ǰ����Ϊ����
            vote += x == num ? 1 : -1;
        }
        return x;
    }
}