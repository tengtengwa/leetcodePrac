package DataStructure;

public class quickSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 5, 4, 6, 7, 8, 9};
        sort(nums, 0, nums.length - 1);

    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int i = left, j = right, tem = arr[left];
        while (i < j) {
            while (tem <= arr[j] && i < j) {
                j--;
            }
            while (tem >= arr[i] && i < j) {
                i++;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
            }
        }
        arr[left] = arr[i];
        arr[i] = tem;

        sort(arr, left, i - 1);
        sort(arr, i + 1, right);
    }
}
