package practice.leetcode.StackAndQueue;

import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;

public class No215 {
    public static void main(String[] args) {
        Solution215 s = new Solution215();
        s.findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4);
    }
}

class Solution215 {

    /**
     * ��Ŀ�������е�k�����Ԫ�أ�������Ŀ�����϶��ǿ���ѡ��͹���ѵĽⷨ
     *
     * �ⷨһ������ѡ�񣨿���˼�룩
     * ˼·�������е�k�����Ԫ�ص�������target��len-k��������ÿ�ζ��������partition������ͨ������ʹ�û�׼����ߵ�Ԫ�ض�С�������ұߵ�Ԫ��
     * �������������򣩣�Ȼ����������߽��еݹ����������һ��partition�������ص�������ʾ��λ�õ�Ԫ���Ѿ������������յ�λ�����ˣ�
     * ��˿���ͨ��partition�������ص��������ж�target�Ƿ���Ҫ�ҵ�Ԫ�ء�
     *
     * ���ֽⷨ��Ҫע����ǣ�partition�����жԻ�׼����ѡ����Ҫ���⽫�����黮��Ϊ1��n-1�ĳ��ȣ�����ʱ����ΪO(n^2)�����Բ���
     * ���������ȡ�еȷ���ѡ���׼��
     *
     * ʱ�临�Ӷȣ�O(n)
     * �ռ临�Ӷȣ�O(logn)���ݹ�ʹ��ջ�ռ�Ŀռ���۵�����ΪO(logn)��
     */
/*    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int target = nums.length - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index > target) {
                right = index - 1;
            } else if (index < target) {
                left = index + 1;
            } else {
                return nums[target];     //ע�⣬���ص���targetλ�õ���
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        //�������������ʱ���ͻ���Ϊð���������Ի�׼����ѡ��Ҳ����Ҫ
//        int tem = (left + right) / 2;
        if (right > left) {
            int tem = left + 1 + new Random().nextInt(right - left);    //nextInt����Ϊ����ʱ�׳��쳣
            swap(nums, left, tem);
        }
        int pivot = nums[left];

        int j = left;           //jָ���׼��pivot��ǰ��������λ��
        for (int i = left + 1; i <= right; i++) {
            if (pivot > nums[i]) {  //��������������pivotС�ģ�j��+1
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, j, left);
        return j;
    }

    private void swap(int[] nums, int i, int j) {
        int tem = nums[i];
        nums[i] = nums[j];
        nums[j] = tem;
    }*/


    /**
     * �ⷨ�������ȶ��У�Ҳ���ǹ������/С��
     */
/*    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        //���ȶ�����������Ԫ��Խ��ǰ���ȼ�Խ��
        Queue<Integer> maxHeap = new PriorityQueue<>(k + 1, (a, b) -> (a - b));  //��ʼ�ռ�Ϊk+1����ʡ�ռ�
        for (int i = 0; i < k; i++) {
            maxHeap.add(nums[i]);
        }
        for (int i = k; i < len; i++) {
            maxHeap.add(nums[i]);
            maxHeap.poll();
        }
        return maxHeap.peek();
    }*/

    /**
     * ��Ȼ�����ȶ��еĽⷨ��ֻ�ǽ�nums�������Ϊ��
     * <p>
     * ����˼·������Ҳ����ʹ�ö����������������⡪������һ������ѣ���k-1��ɾ��������Ѷ�Ԫ�ؾ�������Ҫ�ҵĴ�
     */
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);   //��������һ��Ԫ���ǵ�ǰ����Ԫ�أ������������--heapSize�൱��ɾ�����Ԫ��
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    public void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    public void maxHeapify(int[] a, int i, int heapSize) {
        //l��rΪ����Ϊi�Ľڵ�ġ�����������
        int l = (i << 1) + 1, r = (i << 1) + 2, largest = i;
        if (l < heapSize && a[l] > a[largest]) {
            largest = l;
        }
        if (r < heapSize && a[r] > a[largest]) {
            largest = r;
        }
        if (largest != i) {
            swap(a, i, largest);
            maxHeapify(a, largest, heapSize);
        }
    }

    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}