package practice.leetcode.DynamicProgramming;

public class No53 {
    public static void main(String[] args) {
        Solution53 s = new Solution53();
        s.maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4});

    }
}

/*
��̬�滮�������ȶ�������б�������ǰ������������к�Ϊ sum�����Ϊ ans
��� sum > 0����˵�� sum �Խ��������Ч������ sum ���������ϵ�ǰ��������
��� sum <= 0����˵�� sum �Խ��������Ч������Ҫ�������� sum ֱ�Ӹ���Ϊ��ǰ��������
ÿ�αȽ� sum �� ans�Ĵ�С�������ֵ��Ϊans�������������ؽ��
 */
class Solution53 {
    public int maxSubArray(int[] nums) {
        int sum = 0;
        int ans = nums[0];
        for (int num : nums) {
            if (sum > 0) {
                sum += num;
            } else {
                sum = num;
            }
            ans = Math.max(sum, ans);
        }
        return ans;
    }
}