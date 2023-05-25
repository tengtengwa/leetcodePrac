package practice.leetcode.SortAlgorithm;

/**
 * �ϲ�������������
 *
 * 1��˫ָ��
 * �����뵽��������������������鲢����ķ�����Ҳ�����������ν��˫ָ�롣
 * ���Խ�������������Ҳ������������������ÿ�αȽ�����ָ��ָ��λ�õ�����������С���ȷŵ��������У�����Ҫע�����ж�����߽�case����ֹԽ�硣
 * �����Ҫע�⣺��Ҫ�ٱ���һ�����飬�������������е�����copy��nums1�С�
 * ʱ�临�Ӷȣ�O(m+n)
 *
 * 2�����ÿ⺯��
 * ���ַ����ܼ򵥣�ֱ�ӽ�nums2�е�����copy��num1��m��λ�ã����Ű�������һ���������飬ֱ�ӵ��ÿ⺯����������
 * ʱ�临�Ӷȣ������ŵ�ʱ�临�Ӷȣ�O��log(m+n)��
 */
public class No88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] arr = new int[m + n];
        int a = 0, b = 0;
        for (int i = 0; i < m + n; i++) {
            if (a == m) {
                arr[i] = nums2[b++];
                continue;
            }
            if (b == n) {
                arr[i] = nums1[a++];
                continue;
            }

            if (nums1[a] >= nums2[b]) {
                arr[i] = nums2[b++];
            } else {
                arr[i] = nums1[a++];
            }
        }
        for (int i = 0; i < nums1.length; i++) {
            nums1[i] = arr[i];
        }
    }
}
