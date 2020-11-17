package practice.leetcode.HashMap;

import java.util.*;

public class No15 {
    public static void main(String[] args) {
        Solution15 s = new Solution15();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        s.threeSum(arr);

    }
}

class Solution15 {
    /**
     * ��Ŀ������֮�͡�
     * ����һ������ n ������������nums���ж�nums���Ƿ��������Ԫ�� a��b��c ��ʹ��a + b + c = 0 ��
     * �����ҳ��������������Ҳ��ظ�����Ԫ�顣
     * ע�⣺Ҫ����ȥ�أ�Ҳ���ǲ��ܳ�������˳��һ���Ĵ𰸡�
     */

    /**
     * �ⷨһ����������ѭ��
     * ʱ�䣺O(n^3)
     */

    /**
     * �ⷨ��������+˫ָ��
     * ˼·�����ѭ��ö�ٵ�һ�������ڲ�ѭ��ͨ��˫ָ�벢��ö�ٵڶ����͵���������
     *
     * ʱ�䣺O(N^2)
     * �ռ临�Ӷȣ�O(logN)�����Ǻ��Դ洢�𰸵Ŀռ䣬���������Ŀռ临�Ӷ�ΪO(logN)��Ȼ�������޸������������nums��
     * ��ʵ������²�һ���������Ҳ���Կ���ʹ����һ�����������洢��nums�ĸ������������򣬿ռ临�Ӷ�ΪO(N)��
     */
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if (len < 3) {
            return ans;
        }
        Arrays.sort(nums);
        for (int i = 0; i < len - 2; i++) {     //�����ѭ��ö�ٵ�һ����
            //��������ǰ��С�������������������������޽⣬ֱ���˳�ѭ��
            if (nums[i] > 0) {
                break;
            }
            if (i > 0 && nums[i] == nums[i - 1]) {  //�Ե�һ����ȥ��
                continue;
            }
            int L = i + 1, R = len - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    //��������Ϊ�Եڶ����͵�������ȥ��
                    while (L < R && nums[L] == nums[L + 1]) L++;
                    while (L < R && nums[R] == nums[R - 1]) R--;
                    //���潫����𰸼��뼯�Ϻ�Ӧ���ƶ�����ָ�룬�����ٴμ���
                    L++;
                    R--;
                } else if (sum < 0) {
                    L++;
                } else {
                    R--;
                }
            }
        }
        return ans;
    }
}