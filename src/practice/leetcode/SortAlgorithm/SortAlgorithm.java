package practice.leetcode.SortAlgorithm;

import java.util.Random;

public class SortAlgorithm {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 1, 6, 3, 2, 8, 9};
//        quickSort(arr, 0, arr.length - 1);
//        selectSort(arr);
        insertSort(arr);
        for (int num : arr) {
            System.out.print(num + " ");
        }
    }


    /**
     * 快排。不稳定
     *
     * 平均时间：O(nlogn)、最坏时间：O(n^2)
     * 空间：O(nlogn)，因为用的是递归，所以复杂度和栈的深度有关。
     */
/*    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) >>> 1;
//            int rand = left + new Random().nextInt(right - left);   //也可以取随机数，但是注意从[left,right]这个范围来取
            swap(arr, left, mid);
            int base = arr[left];
            int low = left, hight = right;
            while (low < hight) {
                while (low < hight && arr[hight] >= base) {     //这里条件注意是右边当前数>=基准数
                    hight--;
                }
                while (low < hight && arr[low] <= base) {       //这里条件注意是左边当前数<=基准数
                    low++;
                }
                //如果找到了这两个数，也就是说下标不相等，就进行交换
                if (low < hight) {
                    swap(arr, low, hight);
                }
            }
            //将基准数归位
            arr[left] = arr[low];
            arr[low] = base;
            quickSort(arr, left, low - 1);
            quickSort(arr, low + 1, right);
        }
    }*/

    private static void swap(int[] arr, int i, int j) {
        int tem = arr[i];
        arr[i] = arr[j];
        arr[j] = tem;
    }



    /**
     * 选择排序。不稳定
     * 思想：每次从当前位置i后面的所有数中选择最小（大）的数，将它和当前位置i的数进行交换。如果当前位置i的数已经是最小（大）的，则不用交换。
     * <p>
     * 时间：O(n^2)，空间：O(1)
     */
/*    private static void selectSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int tem = arr[i];           //tem记录i之后最小的数
            int flag = i;               //flag记录i之后当前最小值的下标
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < tem) {     //碰到比当前最小数还小的数，就记录这个数和它的下标
                    tem = arr[j];
                    flag = j;
                }
            }
            if (flag != i) {            //如果当前第i个数就是最小的，则不用交换；否则将最小数和第i个数交换
                arr[flag] = arr[i];
                arr[i] = tem;
            }
        }
    }*/


    /**
     * 插入排序。稳定
     * 思想：遍历当前数组，每次将当前数字插入到前面已经有序的序列之中。
     *
     * 平均时间：O(n^2)，最好时间：O(n)，是数组基本有序的情况。
     * 空间：O(1)
     */
    private static void insertSort(int[] arr) {
        int j, insertNum;
        for (int i = 1; i < arr.length; i++) {
            insertNum = arr[i];
            j = i - 1;
            while (j >= 0 && arr[j] > insertNum) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = insertNum;
        }
    }

}
