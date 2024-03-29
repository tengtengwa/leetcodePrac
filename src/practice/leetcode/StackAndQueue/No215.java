package practice.leetcode.StackAndQueue;

public class No215 {
    public static void main(String[] args) {
        Solution215 s = new Solution215();
        s.findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2);
    }
}

class Solution215 {

    /**
     * 题目：数组中第k个最大元素。
     * 注意，是排序后第k个最大的元素，而不是第k个不同元素！！！
     */

    /**
     * 解法一：排序
     * 思路：对数组排序后，第len-k个元素就是第k个最大的元素
     * 时间、空间：O(nlogn)
     */
/*    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }*/

    /**
     * 解法二：快速选择（快排思想）
     * 思路：数组中第k个最大元素的索引是target（len-k），我们每次对数组进行partition操作，通过交换使得基准数左边的元素都小于它，右边的元素
     * 都大于它（升序），然后对左右两边进行递归操作。进行一次partition操作返回的索引表示该位置的元素已经被放置在最终的位置上了，
     * 因此可以通过partition操作返回的索引来判断target是否是要找的元素。
     *
     * 这种解法需要注意的是，partition过程中对基准数的选择需要避免将子数组划分为1和n-1的长度，这样时间会变为O(n^2)，可以采用
     * 随机和三数取中等方法选择基准数
     *
     * 时间复杂度：O(n)
     * 空间复杂度：O(logn)，递归使用栈空间的空间代价的期望为O(logn)。
     */
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        int target = nums.length - k;

        while (true) {
            int index = partition(nums, left, right);
            if (index > target) {
                right = index - 1;
                //不能这么写：index = partition(nums, left, index - 1); 因为这样并没有改变right的值
            } else if (index < target) {
                left = index + 1;
                //同样不能这么写：index = partition(nums, index + 1, right); 因为没有改变left的值
            } else {
                return nums[target];     //注意，返回的是target位置的数
            }
        }
    }

    private int partition(int[] nums, int left, int right) {
        //当数组基本有序时，就会沦为冒泡排序，所以基准数的选择也很重要
        int tem = (left + right) >>> 1;
        swap(nums, left, tem);
//        if (right > left) {
//            int tem = left + 1 + new Random().nextInt(right - left);    //nextInt参数为负数时抛出异常
//            swap(nums, left, tem);
//        }
        int pivot = nums[left];

        int j = left;           //j指向基准数pivot当前待交换的位置
        for (int i = left + 1; i <= right; i++) {
            if (pivot > nums[i]) {  //升序排序，遇到比pivot小的，j就+1
                j++;
                swap(nums, i, j);
            }
        }
        swap(nums, j, left);
        return j;
    }


    /**
     * 思路和上面的类似，只是写法上有些不同
     */
/*    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1, target = nums.length - k;
        while (left <= right) {     //防止只有一个元素
            int tem = (right + left) / 2;
            int pivot = nums[tem];
            swap(nums, left, tem);
            int j = left;

            for (int i = left + 1; i <= right; i++) {
                if (nums[i] < pivot) {
                    swap(nums, i, ++j);
                }
            }
            swap(nums, left, j);
            if (j == target) {
                return nums[j];
            } else if (j < target) {
                left = j + 1;
            } else {
                right = j - 1;
            }
        }
        return -1;
    }*/


    /**
     * 解法三：优先队列，也就是构造最大/小堆
     */
/*    public int findKthLargest(int[] nums, int k) {
        int len = nums.length;
        //优先队列中数组中元素越靠前优先级越大
        Queue<Integer> maxHeap = new PriorityQueue<>(k + 1, (a, b) -> (a - b));  //初始空间为k+1，节省空间
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
     * 依然是优先队列的解法，只是将nums数组调整为堆而不使用标准的优先队列
     * <p>
     * 它的思路：我们也可以使用堆排序来解决这个问题——建立一个大根堆，做k-1次删除操作后堆顶元素就是我们要找的答案
     */
/*    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        buildMaxHeap(nums, heapSize);
        for (int i = nums.length - 1; i >= nums.length - k + 1; --i) {
            swap(nums, 0, i);   //堆排序后第一个元素是当前最大的元素，将它换到最后，--heapSize相当于删除这个元素
            --heapSize;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    }

    private void buildMaxHeap(int[] a, int heapSize) {
        for (int i = heapSize / 2; i >= 0; --i) {
            maxHeapify(a, i, heapSize);
        }
    }

    private void maxHeapify(int[] a, int i, int heapSize) {
        //l、r为索引为i的节点的“左右子树”
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
    }*/
    public void swap(int[] a, int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }
}