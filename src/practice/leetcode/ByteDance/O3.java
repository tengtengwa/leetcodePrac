package practice.leetcode.ByteDance;

import java.util.HashSet;

public class O3 {
    public static void main(String[] args) {
        SolutionO3 s = new SolutionO3();
        s.findRepeatNumber(new int[]{2, 3, 1, 0, 4, 5, 3});
    }
}

class SolutionO3 {
    /**
     * ��Ŀ���������ظ������֡�
     * ��һ������Ϊ n ������ nums ����������ֶ��� 0��n-1 �ķ�Χ�ڣ�������ĳЩ�������ظ��ģ�����֪���м��������ظ��ˣ�
     * Ҳ��֪��ÿ�������ظ��˼��Ρ����ҳ�����������һ���ظ������֡�
     *
     * ע�⣺������Ȼ��287Ѱ���ظ������ƣ���������ʹ�ö��ַ���⡣
     * ��Ϊ278�ⳤ��n+1,1~n����ض���һ�����ֳ������Σ��������ö����и������������ԭ�����г��ִ�����>������䷶Χ�ģ�
     * ���Ƕ�������ԣ�����n��0~n-1�����ظ������������ظ��������������ڣ��������Ȳŷ��ϣ��⽫�ᵼ�¿����ظ������Ͳ����ڵ���
     * ��ͬһ���������޷��ҳ���
     */

    /**
     * �ⷨһ������
     * ˼·����Ϊ��Ŀ��û�������޸����飬��˿����������ٽ���һ�α������������������������������ȣ����ҵ���һ���ظ�����
     *
     * ʱ�䣺O(nlogn)���ռ䣺O(1)��ע������ĸ��Ӷ�nlogn����n
     */
/*    public int findRepeatNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                return nums[i];
            }
        }
        return -1;
    }*/

    /**
     * �ⷨ������ϣ��
     * ˼·��ʹ��hashset��¼ÿ�������ڱ����Ĺ��������set���Ѿ�����������������������ظ���֮һ��
     *
     * ʱ�䡢�ռ䣺O(n)
     */
    public int findRepeatNumber(int[] nums) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.contains(num)) {
                set.add(num);
            } else {
                return num;
            }
        }
        return -1;
    }

    /**
     * �ⷨ����ԭ���û������޸����飩
     * ˼·���������飬����ǰ����nums[i]�ŵ��±�Ϊi��λ�á�Ҳ����nums[i]-->nums[nums[i]]
     * �������nums[i] == nums[nums[i]]����˵����������ظ���
     *
     * ʱ�䣺O(n)���ռ䣺O(1)
     */
/*    public int findRepeatNumber(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i) {      //�����ǰλ�õ���nums[i]�����±�Ϊi��λ�þ�ֱ������
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }
                //���鲻Ҫ�ѽ������߼�д��������׳���
                swap(nums, i, nums[i]);
            }
        }
        return -1;
    }

    private void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }*/
}