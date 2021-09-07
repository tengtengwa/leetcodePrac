package practice.OfferSpecial;

import java.util.Arrays;

public class No004 {
    public static void main(String[] args) {
        Solution004 s = new Solution004();
        int ans = s.singleNumber(new int[]{-2, -2, 1, 1, 4, 1, 4, 4, -4, -2});
        System.out.println(ans);
        /**
         * ������
         * -2, -2, 1, 1, 4, 1, 4, 4, -4, -2
         * 0,1,0,1,0,1,100
         * 2,2,3,2
         */
    }
}

/**
 * ��Ŀ��ֻ����һ�ε�����
 * ����һ���������� nums ����ĳ��Ԫ�ؽ����� һ�� �⣬����ÿ��Ԫ�ض�ǡ���� ���� �������ҳ��������Ǹ�ֻ������һ�ε�Ԫ�ء�
 */
class Solution004 {
    /**
     * �ⷨһ������
     * ˼·���ȶ��������������Ϊֻ��һ������һ�ε����������±���0,3,6,...    ���ֻ��Ҫ�ж���Щλ�õ����ͺ�һ���Ƿ���ͬ�������ͬ��
     * ��������ǳ���һ�ε��Ǹ�����
     *
     * ʱ�临�Ӷȣ�O(nlogn)������O(nlogn)��forѭ��O(n)������O(nlogn)
     * �ռ临�Ӷȣ�O(1)
     */
/*    public int singleNumber(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i += 3) {
            if (i + 1 < nums.length && nums[i] != nums[i + 1]) {
                return nums[i];
            }
        }
        return nums[nums.length - 1];
    }*/


    /**
     * �ⷨ����λ����
     * ˼·���������飬��������ÿһ������������1�ĸ����ͣ����洢��һ����СΪ32�������С�
     * ���Ŷ�������ÿһλģ3�õ�һ����0��1ΪԪ����ɵġ����������顱��
     * ������������32λ0/1Ԫ�ػ�ԭ��һ��int�����ɡ�
     *
     * ʱ�临�Ӷȣ�O(n)
     * �ռ临�Ӷȣ�O(1)
     */
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];       //bits����洢ÿһ��������ÿһλ1�ĸ����ĺ�
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                //��ǰ����num����ߵ����λ��һλһλȡ���ӵ�bits��ǰλ�ĺ��У�ע�⣺����bits��������0��31�����ÿ������0��31λ��1��λ����
                //��һ����������ÿһλ�ı�ʾ�����෴��������������ָ���һ������ʱ��Ҫע�ⷴ����
                bits[j] += num & 1;
                num >>>= 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            //���λ�����λ����������31~0λ
            ans <<= 1;
            ans |= bits[31 - i] % 3;    //��ǰλģ3�õ���ǰλ�Ķ�����
        }
        return ans;
    }


    /**
     * �ⷨ��������״̬�Զ��� + λ����
     * ˼·��https://leetcode-cn.com/problems/WGki4K/solution/jian-zhi-offer-ii-004-zhi-chu-xian-yi-ci-l3ud/
     *
     * ʱ�临�Ӷȣ�O(n)
     * �ռ临�Ӷȣ�O(1)
     */
/*    public int singleNumber(int[] nums) {
        int ones = 0, twos = 0;
        for(int num : nums){
            ones = ones ^ num & ~twos;
            twos = twos ^ num & ~ones;
        }
        return ones;
    }*/
}