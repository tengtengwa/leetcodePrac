package practice.leetcode.StackAndQueue;

import java.util.*;

public class No128 {
    public static void main(String[] args) {
        Solution128 s = new Solution128();
        s.longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6});
    }
}

class Solution128 {
    /**
     * ��Ŀ����������У�Ҫ��ʱ�临�Ӷ�ΪO(N)
     *
     * �ⷨһ��ʹ�����ȶ���
     * ���ַ�����Ͱ����Ľⷨ���ƣ������Ƚ�����������Ȼ���ٽ���һ�����Ա���
     * �����ѵ�ʱ�临�Ӷȣ�O(N)��֤���Ƚϸ��ӣ�ֱ�Ӹ����ۡ��ܵ�ʱ��Ҳ��O(n)���ռ䣺O(n)
     *
     * Ͱ����Ľⷨ���Ƚ���һ��int��Χ��С�����飬�ٽ���һ�����Ա���
     * Arrays.sort()������ʱ���ﵽO(nlogn)
     */
/*    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        Queue<Integer> queue = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int num : nums) {
            queue.add(num);
        }
        int maxLen = 1, curLen = 1;
        int num = queue.poll();
        while (!queue.isEmpty()) {
            int curNum = queue.poll();
            if (curNum - num == 1) {
                ++curLen;
                maxLen = Math.max(maxLen, curLen);
            } else if (curNum - num > 1) {
                curLen = 1;
            }
            num = curNum;
        }
        return maxLen;
    }*/

    /**
     * �ⷨ����ʹ��set����
     * ˼·���Ƚ�����Ԫ�ؼ���set����ȥ�أ��ٶ�set����һ�α���������бȵ�ǰС1��Ԫ�ؾͽ�����С��Ԫ��ȥ���ң�Ҳ����˵û�бȵ�ǰԪ��
     * С1��Ԫ��ʱ��ѯһ�δ�Ԫ�ؿ�ʼ���������еĳ��Ȳ��������ֵ
     *
     * ʱ�䡢�ռ䣺O(N)
     */
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;

        int max = 1;
        Set<Integer> set = new HashSet<>();
        for (int v : nums) set.add(v);

        for (int n : nums) {
            // ���ɣ�����б��Լ�Сһ��ģ����Լ����飬��С��ȥ��
            if (set.contains(n - 1)) continue;

            int r = n;                      // r: right ��ʾ���� v ��ͷ�������������١�
            while (set.contains(r + 1))
                r++;                        // ����鿴
            max = Math.max(max, r - n + 1); // ��¼���� [v, r] ����
        }
        return max;
    }

}