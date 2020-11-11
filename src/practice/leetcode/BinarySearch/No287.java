package practice.leetcode.BinarySearch;

import java.util.Arrays;

public class No287 {
    public static void main(String[] args) {
        Solution287 s = new Solution287();
        s.findDuplicate(new int[]{3, 1, 3, 4, 2});
    }
}

class Solution287 {
    /**
     * ��Ŀ��Ѱ���ظ���������һ������n+1������������nums�������ֶ���1��n֮�䣨����1��n������֪���ٴ���һ���ظ���������
     * ����ֻ��һ���ظ����������ҳ�����ظ�������
     * ��ĿҪ��
     * ���ܸ���ԭ���飨����������ֻ���ģ���
     * ֻ��ʹ�ö���� O(1) �Ŀռ䡣
     * ʱ�临�Ӷ�С�� O(n2) ��
     * ������ֻ��һ���ظ������֣��������ܲ�ֹ�ظ�����һ�Ρ�
     *
     *
     * �ⷨһ�����ֲ���
     * ˼·����[1.n]֮����ж��ֲ��ң�ÿ��ѭ����ͨ������ԭ��ȷ���ظ�Ԫ�����ĸ��������С�����Χ
     *
     * ʱ�䣺O(nlogn)�����ַ���ʱ�临�Ӷ�ΪO(logN)���ڶ��ַ����ڲ���ִ����һ��forѭ����ʱ�临�Ӷ�ΪO(N)����ʱ�临�Ӷ�ΪO(NlogN)��
     * �ռ䣺O(1)
     */
    public int findDuplicate(int[] nums) {
        int len = nums.length;
        //��Ŀ����Ϊ��������Ԫ����[1,n]֮�䣬������ҵķ�Χ[left,right]Ҳ����[1,n]
        int left = 1;
        int right = len - 1;
        while (left < right) {      //��������Ϊ��Χ[left,right]��ֻ��һ��������left==right��ʱ��
            // �� Java �������ô�ã��� left + right �����ʱ���޷������Ʊ�֤�����Ȼ��ȷ
            int mid = (left + right) >>> 1;

            int cnt = 0;
            for (int num : nums) {
                if (num <= mid) {
                    cnt += 1;
                }
            }

            //���ݳ���ԭ��С�ڵ���4�ĸ�������ϸ����4������ʱ�ظ�Ԫ��һ�������� [1, 4] ������
            //������ظ�Ԫ�������߻������Ұ���޹أ���Ϊ���ǲ��ҵ�����������������<=midԪ�ص�Ԫ�ظ���
            if (cnt > mid) {
                // �ظ�Ԫ��λ������ [left, mid]
                right = mid;
            } else {
                // if ������ȷ���Ժ�else ������������� if �ķ��棬[mid + 1, right]
                left = mid + 1;
            }
        }
        return left;
    }


    /**
     * �ⷨ����˫ָ��
     * ˼·������������˫ָ�룬�ⷨ��ѭ������2���ƣ�
     * ��ָ��ָ����һ���ڵ�Ĳ���Ϊslow = nums[slow];��ָ��ָ��������ڵ�Ĳ���Ϊfast = nums[nums[fast]];
     * ���Բο���ƪ��⣺https://leetcode-cn.com/problems/find-the-duplicate-number/solution/287xun-zhao-zhong-fu-shu-by-kirsche/
     *
     * ʱ�䣺O(n)��ʱ�䣺O(1)
     */
/*    public int findDuplicate(int[] nums) {
        int slow = 0, fast = nums[0];
        while (slow != fast) {  //slow��fast����ʾ��ǰ�ڵ㣬������������������ֱ���ж������Ƿ���ȼ���
            slow = nums[slow];
            fast = nums[nums[fast]];
        }
        //��һ�������󽫿�ָ��ָ���׽ڵ㣬��ָ�����һ���ڵ㣨��Ϊ��ʼʱ��ָ�������һ����
        fast = 0;
        slow = nums[slow];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }*/
}