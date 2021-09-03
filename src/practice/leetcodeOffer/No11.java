package practice.leetcodeOffer;

public class No11 {
    public static void main(String[] args) {
        Solution11 s = new Solution11();
        int min = s.minArray(new int[]{1, 2, 3, 4, 5});
        System.out.println(min);
    }
}

class Solution11 {
    /**
     * ��Ŀ����ת�������С���֡���Ѱ����ת�����е���С����
     * https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
     */

    /**
     * �ⷨ�����ֲ���
     * ˼·��ÿ�ζ���ͨ���м�Ԫ��numbers[pivot]�����ұߵ�Ԫ��numbers[high]�ıȽϽ�������������ų���ЩԪ��
     * �������Ҫע������������ֵ������ߵ�Ԫ�����ȽϵĻ�����Ҫÿ�ζ����жϵ�ǰ��Χ�Ƿ��Ѿ�������������Ϊ�����ǰ���ַ�Χ�ǵ�������ʱ��
     * ��ʱԤ�ڵ���Сֵ��ʵ�ʵ��෴�����ֱ�Ӻ��ұ�Ԫ�رȽϸ���
     *
     * ʱ�䣺O(logn)������Ϊ������Ԫ��ȫ����ͬ���������ʱΪO(n)���ռ䣺O(1)
     */
    public int minArray(int[] numbers) {
        int low = 0, high = numbers.length - 1, pivot;
        while (low < high) {
            pivot = low + ((high - low) >>> 1);
            if (numbers[pivot] < numbers[high]) {
                high = pivot;       //���м�Ԫ��С�����ұ�Ԫ��ʱ����Ϊ�����ų���ǰԪ��Ϊ��СԪ��
            } else if (numbers[pivot] > numbers[high]) {
                low = pivot + 1;    //���м�Ԫ�ش������ұ�Ԫ��ʱ����ʱ����ȷ����СԪ�����м�Ԫ���Ҳ࣬���ų���ֵΪ��СԪ��
            } else {
                high--;
            }
        }
        return numbers[low];
    }
}