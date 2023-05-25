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
     * ���š����ȶ�
     *
     * ƽ��ʱ�䣺O(nlogn)���ʱ�䣺O(n^2)
     * �ռ䣺O(nlogn)����Ϊ�õ��ǵݹ飬���Ը��ӶȺ�ջ������йء�
     */
    private static void quickSort(int[] arr, int left, int right) {
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
     * ѡ�����򡣲��ȶ�
     * ˼�룺ÿ�δӵ�ǰλ��i�������������ѡ����С���󣩵����������͵�ǰλ��i�������н����������ǰλ��i�����Ѿ�����С���󣩵ģ����ý�����
     * <p>
     * ʱ�䣺O(n^2)���ռ䣺O(1)
     */
    private static void selectSort(int[] arr) {
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
    }


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

    /**
     * ð������
     * ˼�룺���ѭ��ÿ�ν�������һ�����С�������������������һ��λ�ã��ڲ�ѭ��ÿ�αȽ�����Ԫ�ء�Ҳ����˵���ѭ��ÿ�ν�һ��Ԫ�ع�λ��
     * ��һ��ѭ����ʣ�µ�Ԫ�ؼ���ð�ݣ�ֱ��������Ԫ������
     *
     * �����ȶ��ԣ��ȶ�����Ϊ�ڱȽϵĹ����У���������ͬ��С��Ԫ�����ڣ�ֻ�Ƚϴ����С��������ȵ�ʱ���ǲ��ύ��λ�õġ�
     * �����������Ԫ�����űȽ�Զ��ʱ��Ҳֻ�ǻ�����ǽ��������ڵ�λ�á����ǵ�λ��ǰ���ϵ���ᷢ���κα仯�������㷨���ȶ��ġ�
     *
     * ʱ�临�Ӷȣ�O(n^2)
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
     * ð�������Ż�
     */
    public static void optimizedBubbleSort(int[] array) {
        if (array == null || array.length < 2) {
            return;
        }

        boolean flag = true;
        int position = 0;
        int curInternalIndex = array.length - 1;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < curInternalIndex; j++) {    //ע������j������±�����һ����ѭ���и��µ��±�j��Ҳ����curInternalIndex��
                if (array[j] > array[j + 1]) {
                    swap(array, j, j + 1);
                    flag = false;
                    //�����Ż����ڲ�ѭ���м�¼���һ�ν���ʱԪ�ص��±꣬��Ϊ�����Ԫ�ض��Ѿ����򲢹�λ�ˣ������һ���ڲ�ѭ��ֱ����0~j�����Χ����
                    position = j;
                }
            }
            //һ���Ż���ͨ��һ�����λ���жϱ����Ƿ���Ԫ�ؽ���������ѭ��������Ԫ���Ƿ��Ѿ�����
            //�������ѭ��������Ԫ���Ѿ�������˵�����������Ѿ�����
            if (flag) {
                break;
            } else {
                flag = true;
                curInternalIndex = position;
            }
        }
    }
}
