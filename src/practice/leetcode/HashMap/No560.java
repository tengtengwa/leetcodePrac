package practice.leetcode.HashMap;

import java.util.HashMap;
import java.util.Map;

public class No560 {
    public static void main(String[] args) {
        Solution560 s = new Solution560();
        s.subarraySum(new int[]{1, 1, 1, 2, 3, 4, -1}, 3);
    }
}

class Solution560 {
    /**
     * ��Ŀ����Ϊk�������顣����һ�����������һ������ k������Ҫ�ҵ��������к�Ϊ k ��������������ĸ�����
     *
     * �ⷨһ������
     * ˼·��ö��ÿ��������Ŀ��ܣ��ֱ�����ÿ��������ĺ�
     * ʱ�䣺O(n^3)���ռ䣺O(1)
     */
/*    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right < nums.length; right++) {
                int sum = 0;
                for (int i = left; i <= right; i++) {
                    sum += nums[i];
                }
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }*/


    /**
     * �ⷨ���������Ż�
     * sum���������߽�left����ǰ�ұ߽�right�ĺͣ�������һά��ʱ�临�Ӷ�
     * ʱ�䣺O(n^2)���ռ�O(1)
     */
/*    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        for (int left = 0; left < nums.length; left++) {
            int sum = 0;
            for (int right = left; right < nums.length; right++) {
                sum += nums[right];
                if (sum == k) {
                    ans++;
                }
            }
        }
        return ans;
    }*/


    /**
     * �ⷨ����ǰ׺��
     * ����ǰ׺��������������ǰλ�õ������
     * ʱ�䣺O(n^2)���ռ�O(n)
     */
/*    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        int[] arr = new int[nums.length + 1];   //������һ��Ԫ�أ�����������ǰ׺��
        for (int i = 0; i < nums.length; i++) {
            arr[i + 1] = arr[i] + nums[i];
        }
        for (int left = 0; left < nums.length; left++) {
            for (int right = left; right < nums.length; right++) {
                //����������[left,right]����ĺͣ�ע���±꣬��sum(�ұ߽�)-sum(��߽�-1)
                //��Ϊ�����±������һ��ƫ�ƣ�����arr[right + 1]����sum(�ұ߽�),arr[left]����sum(��߽�-1)
                if (arr[right + 1] - arr[left] == k) {
                    ans++;
                }
            }
        }
        return ans;
    }*/


    /**
     * �ⷨ�ģ�ǰ׺��+��ϣ��
     * ˼·��https://leetcode-cn.com/problems/subarray-sum-equals-k/solution/he-wei-kde-zi-shu-zu-by-leetcode-solution/
     * ����˵������Ҫ֪����i��β�ĺ�Ϊk���������������ʱֻҪͳ���ж��ٸ�ǰ׺��Ϊpre[i]-k��pre[j]���ɣ�pre[i]Ϊ[0..i]���������ĺ�
     * ʱ�䡢�ռ䣺O(n)
     */
    public int subarraySum(int[] nums, int k) {
        int ans = 0;
        //mapӳ�䱣��ǰ׺��key�������ֵĴ���value��ӳ��
        Map<Integer, Integer> map = new HashMap<>();
        //�ʼʱ���±�0֮ǰû��Ԫ�أ�������Ϊǰ׺��Ϊ0������Ϊ1��
        map.put(0, 1);
        int perSum = 0;     //��ǰǰ׺��
        for (int num : nums) {
            perSum += num;
            if (map.containsKey(perSum - k)) {      //�����ǰӳ������pre[i]-k��ǰ׺�ͣ��𰸾ͼ��������ֵĴ���
                ans += map.get(perSum - k);
            }
            map.put(perSum, map.getOrDefault(perSum, 0) + 1);   //��ǰǰ׺�ͳ��ֵĴ���+1
        }
        return ans;
    }
}