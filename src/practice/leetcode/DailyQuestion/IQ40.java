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
    //1.排序
    //2.优先队列
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

    //3.快速选择
    public int[] getLeastNumbers(int[] arr, int k) {
        if (k == 0) {
            return new int[0];
        } else if (arr.length <= k) {
            return arr;
        }

        // 原地不断划分数组
        partitionArray(arr, 0, arr.length - 1, k);

        // 数组的前 k 个数此时就是最小的 k 个数，将其存入结果
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = arr[i];
        }
        return res;
    }

    void partitionArray(int[] arr, int lo, int hi, int k) {
        // 做一次 partition 操作
        int m = partition(arr, lo, hi);
        // 此时数组前 m 个数，就是最小的 m 个数
        if (k == m) {
            // 正好找到最小的 k(m) 个数
            return;
        } else if (k < m) {
            // 最小的 k 个数一定在前 m 个数中，递归划分
            partitionArray(arr, lo, m - 1, k);
        } else {
            // 在右侧数组中寻找最小的 k-m 个数
            partitionArray(arr, m + 1, hi, k);
        }
    }

    // partition 函数和快速排序中相同，具体可参考快速排序相关的资料
// 代码参考 Sedgewick 的《算法4》
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