package practice.leetcode.BinarySearch;

public class No153 {

}

/**
 * ��⣺https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/solution/er-fen-cha-zhao-wei-shi-yao-zuo-you-bu-dui-cheng-z/
 */

class Solution153 {
    public int findMin(int[] nums) {
        int left = 0;
        int right = nums.length - 1;                /* ����ұ����䣬������ҿ������򲻷����ж���ֵ */
        while (left < right) {                      /* ѭ������ʽ�����left == right����ѭ������ */
            int mid = left + (right - left) / 2;    /* �ذ����mid������left */
            if (nums[mid] > nums[right]) {          /* ��ֵ > ��ֵ����Сֵ���Ұ�ߣ�������߽� */
                left = mid + 1;                     /* ��Ϊ��ֵ > ��ֵ����ֵ�϶�������Сֵ����߽���Կ��mid */
            } else if (nums[mid] < nums[right]) {   /* ��ȷ��ֵ < ��ֵ����Сֵ�����ߣ������ұ߽� */
                right = mid;                        /* ��Ϊ��ֵ < ��ֵ����ֵҲ��������Сֵ���ұ߽�ֻ��ȡ��mid�� */
            }
        }
        return nums[left];    /* ѭ��������left == right����Сֵ���nums[left]��nums[right]���� */
    }
}