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
     * ���š����ȶ�
     *
     * ƽ��ʱ�䣺O(nlogn)���ʱ�䣺O(n^2)
     * �ռ䣺O(nlogn)����Ϊ�õ��ǵݹ飬���Ը��ӶȺ�ջ������йء�
     */
/*    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) >>> 1;
//            int rand = left + new Random().nextInt(right - left);   //Ҳ����ȡ�����������ע���[left,right]�����Χ��ȡ
            swap(arr, left, mid);
            int base = arr[left];
            int low = left, hight = right;
            while (low < hight) {
                while (low < hight && arr[hight] >= base) {     //��������ע�����ұߵ�ǰ��>=��׼��
                    hight--;
                }
                while (low < hight && arr[low] <= base) {       //��������ע������ߵ�ǰ��<=��׼��
                    low++;
                }
                //����ҵ�������������Ҳ����˵�±겻��ȣ��ͽ��н���
                if (low < hight) {
                    swap(arr, low, hight);
                }
            }
            //����׼����λ
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
     * ѡ�����򡣲��ȶ�
     * ˼�룺ÿ�δӵ�ǰλ��i�������������ѡ����С���󣩵����������͵�ǰλ��i�������н����������ǰλ��i�����Ѿ�����С���󣩵ģ����ý�����
     * <p>
     * ʱ�䣺O(n^2)���ռ䣺O(1)
     */
/*    private static void selectSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int tem = arr[i];           //tem��¼i֮����С����
            int flag = i;               //flag��¼i֮��ǰ��Сֵ���±�
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < tem) {     //�����ȵ�ǰ��С����С�������ͼ�¼������������±�
                    tem = arr[j];
                    flag = j;
                }
            }
            if (flag != i) {            //�����ǰ��i����������С�ģ����ý�����������С���͵�i��������
                arr[flag] = arr[i];
                arr[i] = tem;
            }
        }
    }*/


    /**
     * ���������ȶ�
     * ˼�룺������ǰ���飬ÿ�ν���ǰ���ֲ��뵽ǰ���Ѿ����������֮�С�
     *
     * ƽ��ʱ�䣺O(n^2)�����ʱ�䣺O(n)���������������������
     * �ռ䣺O(1)
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
