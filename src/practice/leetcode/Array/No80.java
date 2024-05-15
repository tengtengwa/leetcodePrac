package practice.leetcode.Array;

/**
 * No80 ɾ�����������е��ظ��� II
 * ����һ���������� nums ������ԭ��ɾ���ظ����ֵ�Ԫ�أ�ʹ�ó��ִ����������ε�Ԫ��ֻ�������� ��
 * ����ɾ����������³��ȡ�
 * ��Ҫʹ�ö��������ռ䣬������� ԭ�� �޸��������� ����ʹ�� O(1) ����ռ����������ɡ�
 */
public class No80 {
    public static void main(String[] args) {
        Solution80 s = new Solution80();
        int[] arr = new int[]{0, 0, 1, 1, 1, 1, 2, 3, 3};
        int len = s.removeDuplicates(arr);
        for (int i = 0; i < len; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}

/**
 * �ⷨ��˫ָ��
 * ��Ϊÿ��Ԫ�����ٳ���һ�Σ��������ǿ���ֱ�Ӵ�����2��ʼ�жϵڶ�������֡�����ָ��ͬʱָ��2��������ָ�뿪ʼ��������
 * ����ͨ��nums[l - 2]��nums[r]���бȽϣ����������ȣ�˵��nums[l-2]==nums[l-1]==nums[r]����ʱnums[r]
 * Ϊ�����γ��ֵ�������Ҫ������������Ҫ���£�����ֱ�ӽ�nums[r]���Ƹ�nums[l]���Դ����ƣ�ֱ����ָ��������������顣
 * ʱ�临�Ӷȣ�O(n)
 * �ռ临�Ӷȣ�O(1)
 *
 * ��չ��ɾ�����ִ������μ����ϵ�Ҳ�����Ƶ�˼·��
 */
class Solution80 {
    public int removeDuplicates(int[] nums) {
        int l = 2;
        for (int r = 2; r < nums.length; r++) {
            if (nums[l - 2] != nums[r]) {
                nums[l++] = nums[r];
            }
        }
        return l;
    }
}