package DataStructure;

public class quickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 4, 6, 7, 8, 9};
        sort(nums, 0, nums.length - 1);

    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) { // 如果left已经超过right 直接返回
            return;
        }
        int i = left, j = right, tem = arr[left];
        while (i < j) {
            while (tem <= arr[j] && i < j) {   //先看右边，依次往左递减
                j--;
            }
            while (tem >= arr[i] && i < j) {  //再看左边，依次往右递增
                i++;
            }
            if (i < j) { //如果满足条件则交换
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];//最后将基准为与i和j相等位置的数字交换
        arr[i] = tem;

        sort(arr, left, i - 1); // 对左边快排
        sort(arr, i + 1, right);// 对右边快排
    }
}
