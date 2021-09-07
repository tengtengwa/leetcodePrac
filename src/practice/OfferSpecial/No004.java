package practice.OfferSpecial;

import java.util.Arrays;

public class No004 {
    public static void main(String[] args) {
        Solution004 s = new Solution004();
        int ans = s.singleNumber(new int[]{-2, -2, 1, 1, 4, 1, 4, 4, -4, -2});
        System.out.println(ans);
        /**
         * 用例：
         * -2, -2, 1, 1, 4, 1, 4, 4, -4, -2
         * 0,1,0,1,0,1,100
         * 2,2,3,2
         */
    }
}

/**
 * 题目：只出现一次的数字
 * 给你一个整数数组 nums ，除某个元素仅出现 一次 外，其余每个元素都恰出现 三次 。请你找出并返回那个只出现了一次的元素。
 */
class Solution004 {
    /**
     * 解法一：排序
     * 思路：先对数组进行排序，因为只有一个出现一次的数，它的下标是0,3,6,...    因此只需要判断这些位置的数和后一个是否相同，如果相同则
     * 这个数就是出现一次的那个数。
     *
     * 时间复杂度：O(nlogn)，快排O(nlogn)，for循环O(n)，总体O(nlogn)
     * 空间复杂度：O(1)
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
     * 解法二：位运算
     * 思路：遍历数组，求数组中每一个数二进制中1的个数和，并存储到一个大小为32的数组中。
     * 接着对数组中每一位模3得到一个由0和1为元素组成的“二进制数组”。
     * 最后把数组中这32位0/1元素还原成一个int数即可。
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
     */
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];       //bits数组存储每一个数字中每一位1的个数的和
        for (int num : nums) {
            for (int j = 0; j < 32; j++) {
                //当前数字num从最高到最低位，一位一位取出加到bits当前位的和中，注意：这里bits的索引从0到31存的是每个数从0到31位的1的位数和
                //和一个数二进制每一位的表示正好相反，因此下面把数组恢复成一个数的时候，要注意反着来
                bits[j] += num & 1;
                num >>>= 1;
            }
        }
        int ans = 0;
        for (int i = 0; i < 32; i++) {
            //最高位到最低位，依次左移31~0位
            ans <<= 1;
            ans |= bits[31 - i] % 3;    //当前位模3得到当前位的二进制
        }
        return ans;
    }


    /**
     * 解法三：有限状态自动机 + 位运算
     * 思路：https://leetcode-cn.com/problems/WGki4K/solution/jian-zhi-offer-ii-004-zhi-chu-xian-yi-ci-l3ud/
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(1)
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