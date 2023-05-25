package practice.leetcode.SortAlgorithm;

/**
 * 合并两个有序数组
 *
 * 1、双指针
 * 首先想到的是类似两个有序链表归并排序的方法，也就是题解中所谓的双指针。
 * 可以将两个有序数组也抽象看做两个有序链表，每次比较两个指针指向位置的两个数，较小的先放到新数组中，但需要注意先判断数组边界case，防止越界。
 * 最后需要注意：需要再遍历一次数组，将已排序数组中的内容copy至nums1中。
 * 时间复杂度：O(m+n)
 *
 * 2、借用库函数
 * 这种方法很简单，直接将nums2中的数组copy到num1的m的位置，接着把它当作一个无序数组，直接调用库函数进行排序。
 * 时间复杂度：即快排的时间复杂度，O（log(m+n)）
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
