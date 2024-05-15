package practice.leetcode.Array;

/**
 * 26��ɾ�����������е��ظ���
 * ����һ�� �������� ������ nums ������ ԭ�� ɾ���ظ����ֵ�Ԫ�أ�ʹÿ��Ԫ�� ֻ����һ�� ������ɾ����������³��ȡ�
 * Ԫ�ص� ���˳�� Ӧ�ñ��� һ�� ��Ȼ�󷵻� nums ��ΨһԪ�صĸ�����
 */
public class No26 {
    public static void main(String[] args) {

    }
}

/**
 * �ⷨ��˫ָ��
 * ǰָ��ָ��ǰ��Ҫ��Ĳ��ظ����ֵ���������ָ��������飬Ѱ����һ�����ظ����֡�
 * ʱ�临�Ӷȣ�O(n)
 * �ռ临�Ӷȣ�O(1)
 */
class Solution26 {
    public int removeDuplicates(int[] nums) {
        int i = 0, j = 0, res = 0;
        while (j < nums.length) {
            if (nums[i] == nums[j]) {
                j++;
                continue;
            }
            nums[++i] = nums[j++];
            res++;
        }
        return res + 1;
    }
}