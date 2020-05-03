package practice.leetcode.DailyQuestion;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class IQ40 {
    public static void main(String[] args) {
        SolutionIQ40 s = new SolutionIQ40();
        s.getLeastNumbers(new int[]{0, 1, 2, 1}, 1);
    }
}

class SolutionIQ40 {
    //1.����
    //2.���ȶ���
/*    public int[] getLeastNumbers(int[] arr, int k) {
        if (arr.length == 0) {
            return new int[0];
        }
        Queue<Integer> heap = new PriorityQueue<>((o1, o2) -> o2 - o1);
        for (int num : arr) {
            if (heap.size() <= k) {
                heap.offer(num);
            }
            if (num < heap.peek()) {
                heap.poll();
            }
        }
        int[] ans = new int[k];
        int i = 0;
        for (int n : heap) {
            ans[i++] = n;
        }
        return ans;
    }*/

    //3.����ѡ��
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        } else if (arr.length <= k) {
            return arr;
        }

        // ԭ�ز��ϻ�������
        partitionArray(arr, 0, arr.length - 1, k);

        // �����ǰ k ������ʱ������С�� k ���������������
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    void partitionArray(int[] arr, int lo, int hi, int k) {
        // ��һ�� partition ����
        int m = partition(arr, lo, hi);
        // ��ʱ����ǰ m ������������С�� m ����
        if (k == m) {
            // �����ҵ���С�� k(m) ����
            return;
        } else if (k < m) {
            // ��С�� k ����һ����ǰ m �����У��ݹ黮��
            partitionArray(arr, lo, m - 1, k);
        } else {
            // ���Ҳ�������Ѱ����С�� k-m ����
            partitionArray(arr, m + 1, hi, k);
        }
    }

    // partition �����Ϳ�����������ͬ������ɲο�����������ص�����
// ����ο� Sedgewick �ġ��㷨4��
    int partition(int[] a, int lo, int hi) {
        int i = lo;
        int j = hi + 1;
        int v = a[lo];
        while (true) {
            while (a[++i] < v) {
                if (i == hi) {
                    break;
                }
            }
            while (a[--j] > v) {
                if (j == lo) {
                    break;
                }
            }

            if (i >= j) {
                break;
            }
            swap(a, i, j);
        }
        swap(a, lo, j);

        // a[lo .. j-1] <= a[j] <= a[j+1 .. hi]
        return j;
    }

    void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}