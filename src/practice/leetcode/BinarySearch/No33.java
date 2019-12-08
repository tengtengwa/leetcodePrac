package practice.leetcode.BinarySearch;

public class No33 {
    public static void main(String[] args) {
        Solution33 s = new Solution33();
        s.search(new int[]{3, 1}, 1);
    }
}

class Solution33 {
/*    public int search(int[] nums, int target) {
        //��Ϊ�˴���һ�ˣ�left+rightΪ����ʱ������ƫ�ơ����������ж��Ĳ�������ֻ����nums[right]��nums[mid]�Ĵ�С��ϵ�ж�
        int L = 0, R = nums.length - 1;
        while (L <= R) {
            int mid = (L + R) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > nums[R]) {       //��������,�ж�target�Ƿ�����벿��
                if (nums[L] <= target && target < nums[mid]) {      //���target�Ĵ�С��nums[L,mid)�����ڣ���������СΪ[L,mid-1]
                    R = mid - 1;
                } else {                                            //targetС��nums[L]����ڵ���nums[mid]����������СΪ[mid+1,R]
                    L = mid + 1;
                }
            } else if (nums[mid] <= nums[R]) {      //�Ұ�������ж��Ƿ����Ұ벿��
                if (nums[mid] < target && target <= nums[R]) {      //target�Ĵ�С��nums(mid,R]�����ڣ���������СΪ[mid+1,R]
                    L = mid + 1;
                } else {
                    R = mid - 1;
                }
            }
        }
        return -1;
    }*/

    public int search(int[] nums, int target) {
        //��Ϊ�˴���һ�ˣ�left+rightΪ����ʱ������ƫ�ơ����������ж��Ĳ�������ֻ����nums[right]��nums[mid]�Ĵ�С��ϵ�ж�
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[right] < nums[mid]) {    //��벿������
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {        //�Ұ벿������
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }
}