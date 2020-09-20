package practice.leetcode.Math;

import java.util.LinkedList;
import java.util.List;

public class No448 {
    public static void main(String[] args) {
        Solution448 s = new Solution448();
        s.findDisappearedNumbers(new int[]{4, 3, 2, 7, 8, 2});
    }
}

class Solution448 {
    /**
     * ��Ŀ���ҵ�������������ʧ������
     * ����һ����Χ��1 �� a[i] �� n (n=�����С)���������飬�����е�Ԫ��һЩ���������Σ���һЩֻ����һ�Ρ�
     * �ҵ������� [1, n] ��Χ֮��û�г����������е����֡�
     * �����ڲ�ʹ�ö���ռ���ʱ�临�Ӷ�ΪO(n)�������������������? ����Լٶ����ص����鲻���ڶ���ռ��ڡ�
     *
     * �ⷨһ������Ͱ����Ľⷨ�����α���������һ����СΪnums+1�ĵ��������ڼ�¼ÿ���±��Ԫ���Ƿ���֡�
     * ��һ�α�����¼���ֵ�Ԫ�أ��ڶ��α�����δ���ֹ���Ԫ�ؼ��뼯�ϡ�
     *
     * ʱ�䣺O(n)���ռ�O(n)
     * ��Ϊ��ĿҪ��ʹ�ö���ռ䣬�������ַ�������
     */
/*    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        int[] arr = new int[nums.length + 1];
        for (int num : nums) {
            arr[num]++;
        }
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] == 0) {
                ans.add(i);
            }
        }
        return ans;
    }*/

    /**
     * �ⷨ����Ը���޸ġ����α�������ʹ�ö���ռ�
     * ˼·����һ�α�����num[i]-1����λ�õ�Ԫ����Ϊ������ʾ���λ�õ�Ԫ���Ѿ����֣�
     * �ڶ��α���ʱ��nums[i]>0����i+1����һ��δ���ֹ�����
     */
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) {
                ans.add(i + 1);
            }
        }
        return ans;
    }
}