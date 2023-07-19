package practice.leetcode.Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. ����Ԫ��
 * ����һ����СΪ n ������ nums ���������еĶ���Ԫ�ء�����Ԫ����ָ�������г��ִ��� ���� ? n/2 ? ��Ԫ�ء�
 * ����Լ��������Ƿǿյģ����Ҹ������������Ǵ��ڶ���Ԫ�ء�
 */
public class No169 {
    public static void main(String[] args) {
        Solution169 s = new Solution169();
        s.majorityElement(new int[]{3, 4, 5, 5, 5});
    }
}

class Solution169 {
    /**
     * �ⷨһ����ϣ�����
     * ˼·������һ�����飬ʹ��hashmapͳ��ÿ�����ֳ��ֵĴ��������ű���һ��hashmap�е�Ԫ�أ��ҳ����ִ�����������
     * Ҳ���Խ���һ����Ϊ����Ĳ������ڷ���Ԫ�غ��������һ�θ����ֵĴ������������n/2�����������������
     * ʱ�临�Ӷȣ�O(n)
     * �ռ临�Ӷȣ�O(n)
     */
//    public int majorityElement(int[] nums) {
//        Map<Integer, Integer> map = new HashMap<>();
//        int n = nums.length;
//        for(int num : nums) {
//            if (map.containsKey(num)) {
//                int key = map.get(num);
//                map.put(num, ++key);
//            } else {
//                map.put(num, 1);
//            }
//            if (map.containsKey(num) && map.get(num) > n / 2) {
//                return num;
//            }
//        }
//        return nums[nums.length - 1];
//    }

    /**
     * �ⷨ�����������
     * ��Ϊ�������г��ִ�������һ���������������������м��������Ȼ������Ҫ�ҵ��Ǹ���
     * ʱ�临�Ӷȣ�O(nlogn)��n�ζ��֣�nlogn
     * �ռ临�Ӷȣ�O(logn)�����ŵݹ�ʱռ�öѿռ�logn
     */
//    public int majorityElement(int[] nums) {
//        Arrays.sort(nums);
//        return nums[nums.length / 2];
//    }

    /**
     * �ⷨ����mooreͶƱ�㷨
     * ˼·���������������+1������������-1����Ϊ�������ִ�������n/2���������ǵĺͱ�Ȼ����1��
     */
    public int majorityElement(int[] nums) {
        int count = 0;
        int candidate = nums[0];
        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (candidate == num) ? 1 : -1;
        }
        return candidate;
    }
}