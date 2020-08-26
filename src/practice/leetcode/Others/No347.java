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
     * ��Ŀ��ǰk����ƵԪ�أ���������ǰk����ƵԪ��
     * <p>
     * �ⷨһ����С��
     * ˼·���Ƚ���һ�α�������һ��map����Ԫ�ص������ִ�����ӳ�䣻�ٽ���ЩԪ�ؼ���һ����СΪk����С�ѣ�����С������Ϊ
     * �����޷��Ƴ���βԪ�أ�removeAt����Ϊprivate��ǰk����ƵԪ���෴�����������Ԫ�ش���k���ͽ��Ѷ�Ƶ����С��Ԫ���Ƴ�����󽫶���Ԫ��
     * ת��Ϊ�����������
     * <p>
     * ʱ�䣺O(nlogk)���ռ䣺O(n)
     */
/*    public int[] topKFrequent(int[] nums, int k) {
        int[] ans = new int[k];
        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            //ע���������д�������Լ�һ��if-else���
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //�Ƚ����Ƚϵ���Ԫ�س��ֵ�Ƶ��(Ҳ����value)�������д洢����Ԫ�ر���
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.comparingInt(map::get));
        for (int key : map.keySet()) {
            queue.add(key);
            if (queue.size() > k) {     //���ȶ�����ֻ��k��Ԫ�أ��������k��Ԫ�ؾͽ���С�Ѷ���Ԫ�س���
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
     * �ⷨ����Ͱ����
     * ˼·�������ȱ������飬��map�洢Ԫ�ص����ִ�����ӳ�䣻�ٴ���һ��List��������Ͱ���������±�ΪԪ�س���Ƶ�ʣ�������ÿ��list�洢
     * �ó���Ƶ�ʵ�����Ԫ�أ����Ӻ���ǰ����list���飬��Ƶ�ʴӴ�С��Ԫ�ش洢����������м���
     *
     * ʱ�䡢�ռ䣺O(n)
     */
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        //����ʹ��int���飬��Ϊÿ��Ƶ�ʿ��ܳ��ֶ��Ԫ��
        List<Integer>[] lists = new List[nums.length + 1];
        for (int key : map.keySet()) {
            int i = map.get(key);       //iΪԪ��key���ֵ�Ƶ�ʣ�������Ϊ�����±�
            if (lists[i] == null) {
                lists[i] = new ArrayList<>();
            }
            lists[i].add(key);
        }

        int[] ans = new int[k];
        int index = 0;
        for (int i = nums.length; i >= 0; i--) {
            //��λ����Ԫ���ٱ������Ƶ�ʵ�list
            if (lists[i] != null) {
                for (int a : lists[i]) {
                    //�����������Ԫ��С��kʱ�Ž���Ƶ�ʵ�������
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