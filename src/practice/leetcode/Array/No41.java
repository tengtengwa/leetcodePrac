package practice.leetcode.Array;

public class No41 {
    public static void main(String[] args) {
        Solution41 s = new Solution41();
        System.out.println(s.firstMissingPositive(new int[]{1, 1}));
    }
}

/**
 * 41. ȱʧ�ĵ�һ������
 *
 * ����һ��δ������������� nums �������ҳ�����û�г��ֵ���С����������
 * ����ʵ��ʱ�临�Ӷ�Ϊ O(n) ����ֻʹ�ó����������ռ�Ľ��������
 */
class Solution41 {
    /**
     * �ⷨһ������ϣ��
     * ��һ�α��������и�����0תΪlen+1����Ϊ����
     * ���ø����������������ϣ�����Ѿ����ֵ�����Ӧ�����������б�ǣ�ȡ����ֵ�ټӸ��ţ��ø��ű�Ǹ������Ѿ����ֹ����֣�
     * �ٱ���һ�����飬�����������������0�����ʾ��λ��iû�г������֣�����i+1���ɣ���������ж��Ǹ��������ʾ[1,len]ȫ�����ֹ�������len+1
     *
     *  ʱ�临�Ӷȣ�O(n)
     * �ռ临�Ӷȣ�O(1)
     */
//    public int firstMissingPositive(int[] nums) {
//        for (int i = 0; i < nums.length; i++) {
//            int num = nums[i];
//            if (num <= 0) {
//                nums[i] = nums.length + 1;
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            //��ֹ�����ٱ������������ȡ����ֵͳһ����
//            int num = Math.abs(nums[i]);
//            if (num <= nums.length) {
//                nums[num - 1] = -Math.abs(nums[num - 1]);
//            }
//        }
//        for (int i = 0; i < nums.length; i++) {
//            if (nums[i] > 0) return i + 1;
//        }
//        return nums.length + 1;
//    }

    /**
     * �ⷨ�����û�
     * ͨ�������ķ�ʽ����ÿһ����������Ӧ�е�λ���ϡ���һ����x����Ӧ�ñ���ԭ������Ϊx-1��λ���ϣ���˽��� nums[i]�� nums[x?1]��
     * ����x�ͳ���������ȷ��λ�á�����ɽ������µ� nums[i]���ܻ���[1,N]�ķ�Χ�ڣ�������Ҫ�������н���������ֱ�� x?[1,N]
     * ������ʱ����Ҫ��ֹ��������ȣ�nums[i]==nums[x-1]�����������ֹ��ѭ��
     *
     * ʱ�临�Ӷȣ�O(n)
     * �ռ临�Ӷȣ�O(1)
     */
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if (cur == i + 1) {
                continue;
            }
            while ((cur != i + 1 && cur > 0 && cur <= nums.length) && nums[i] != nums[cur - 1]) {
                swap(nums, i, cur - 1);
                cur = nums[i];
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length + 1;
    }

    private void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }
}