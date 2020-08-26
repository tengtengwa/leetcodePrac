package practice.leetcode.Others;

import java.util.*;

public class No347 {
    public static void main(String[] args) {
        Solution347 s = new Solution347();
        s.topKFrequent(new int[]{3, 0, 1, 0}, 1);
    }
}

class Solution347 {
    /**
     * 题目：前k个高频元素，求数组中前k个高频元素
     * <p>
     * 解法一：最小堆
     * 思路：先进行一次遍历，用一个map保存元素到它出现次数的映射；再将这些元素加入一个大小为k的最小堆（用最小堆是因为
     * 最大堆无法移除队尾元素，removeAt方法为private；前k个低频元素相反），如果其中元素大于k个就将堆顶频率最小的元素移除。最后将堆中元素
     * 转换为数组输出即可
     * <p>
     * 时间：O(nlogk)，空间：O(n)
     */
/*    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //注意下面这个写法，可以简化一个if-else语句
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //比较器比较的是元素出现的频率(也就是value)，而堆中存储的是元素本身
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int key : map.keySet()) {
            queue.add(key);
            if (queue.size() > k) {     //优先队列中只有k个元素，如果超过k个元素就将最小堆顶部元素出队
                queue.poll();
            }
        }
        int i = 0;
        for (int num : queue) {
            ans[i++] = num;
        }
        return ans;
    }*/


    /**
     * 解法二：桶排序
     * 思路：还是先遍历数组，用map存储元素到出现次数的映射；再创建一个List数组用于桶排序，数组下标为元素出现频率，数组中每个list存储
     * 该出现频率的所有元素；最后从后向前遍历list数组，将频率从大到小的元素存储在输出数组中即可
     *
     * 时间、空间：O(n)
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //不能使用int数组，因为每个频率可能出现多个元素
        List<Integer>[] lists = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int i = map.get(key);       //i为元素key出现的频率，将其作为数组下标
            if (lists[i] == null) {
                lists[i] = new ArrayList<>();
            }
            lists[i].add(key);
        }

        int[] ans = new int[k];
        int index = 0;
        for (int i = nums.length; i >= 0; i--) {
            //此位置有元素再遍历这个频率的list
            if (lists[i] != null) {
                for (int a : lists[i]) {
                    //当输出数组中元素小于k时才将此频率的数存入
                    if (index < k) {
                        ans[index] = a;
                        index++;
                    }
                }

            }
        }
        return ans;
    }
}