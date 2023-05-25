package practice.leetcode.SortAlgorithm;

import java.util.Random;

public class SortAlgorithm {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 8, 9, 4, 1, 6, 3, 2};
//        quickSort(arr, 0, arr.length - 1);
//        selectSort(arr);
        optimizedBubbleSort(arr);
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
    private static void quickSort(int[] arr, int left, int right) {
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
    }

    private static void swap(int[] arr, int i, int j) {
//        int tem = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tem;
        arr[i] ^= arr[j];
        arr[j] ^= arr[i];
        arr[i] ^= arr[j];
    }



    /**
     * 选择排序。不稳定
     * 思想：每次从当前位置i后面的所有数中选择最小（大）的数，将它和当前位置i的数进行交换。如果当前位置i的数已经是最小（大）的，则不用交换。
     * <p>
     * 时间：O(n^2)，空间：O(1)
     */
    private static void selectSort(int[] arr) {
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
    }


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

    /**
     * 冒泡排序
     * 思想：外层循环每次将本轮中一个最大（小）的数交换到本轮最后一个位置，内层循环每次比较相邻元素。也就是说外层循环每次将一个元素归位，
     * 下一轮循环在剩下的元素继续冒泡，直到将所有元素排序。
     *
     * 关于稳定性：稳定。因为在比较的过程中，当两个相同大小的元素相邻，只比较大或者小，所以相等的时候是不会交换位置的。
     * 而当两个相等元素离着比较远的时候，也只是会把他们交换到相邻的位置。他们的位置前后关系不会发生任何变化，所以算法是稳定的。
     *
     * 时间复杂度：O(n^2)
     */
    public static void bubbleSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    /**
     * 冒泡排序优化
     */
    public static void optimizedBubbleSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        boolean flag = true;
        int position = 0;
        int curInternalIndex = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < curInternalIndex; j++) {    //注意这里j的最大下标是上一层内循环中更新的下标j（也就是curInternalIndex）
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = false;
                    //二重优化：内层循环中记录最后一次交换时元素的下标，因为后面的元素都已经有序并归位了，因此下一次内层循环直接在0~j这个范围即可
                    position = j;
                }
            }
            //一重优化：通过一个标记位来判断本轮是否有元素交换（本轮循环中所有元素是否已经有序）
            //如果本轮循环中所有元素已经有序，则说明整个数组已经有序
            if (flag) {
                break;
            } else {
                flag = true;
                curInternalIndex = position;
            }
        }
    }
}
