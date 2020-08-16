package practice.leetcode.SlidingWindow;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class No239 {
    public static void main(String[] args) {
        Solution239 s = new Solution239();
        s.maxSlidingWindow(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1}, 3);
    }
}

class Solution239 {
    /**
     * ��Ŀ���������ڵ����ֵ
     * <p>
     * �ⷨһ��������ÿ�δӵ�ǰλ�����k��Ԫ�صĴ�����Ѱ�����ֵ
     * <p>
     * ʱ�临�Ӷȣ�O(Nk)������ N Ϊ������Ԫ�ظ������ռ临�Ӷȣ�O(N-k+1)������������顣
     */
/*    public int[] maxSlidingWindow(int[] nums, int k) {
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        int[] ans = new int[len - k - 1];

        ans[0] = max;
        max = Integer.MIN_VALUE;
        for (int i = 0; i <= len - k; i++) {
            for (int j = i; j < i + k; j++) {
                max = Math.max(max, nums[j]);
            }
            ans[i] = max;
            max = Integer.MIN_VALUE;
        }
        return ans;
    }*/


    /**
     * �ⷨ����ʹ��һ��˫�˶���ά��һ���ݼ�Ԫ�ص��±꣬ע�����±�
     * <p>
     * ˼·���ڱ����Ĺ����У���̬ά������洢�ݼ�Ԫ�ص��±�Ķ��У������±�ǰ��ȥ����β����С�ڵ�ǰλ��Ԫ�ص��±ꣻ�����±��������ڳ���
     * ����k���ͽ�����һ��Ԫ���Ƴ���ÿ���������������Ԫ�ؾ��ǵ�ǰ�����±��Ӧ��Ԫ�ء�
     * <p>
     * ʱ�䣺O(N)��forѭ���е�whileѭ���ǳ������ģ����ռ䣺O(N)
     */
/*    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length <= 1 || k <= 1) {
            return nums;
        }
        //ע�⣬����ֻ��������LinkedList������ʹ�ö�̬����Ϊ����Ҫ��LinkedList��Ϊ˫�˶���ʹ�ã���List��û��LinkedList��һЩ����
        //����һ�㣬˫�˶����д洢����Ԫ�ص��±�
        LinkedList<Integer> list = new LinkedList<>();
        int[] ans = new int[nums.length - k + 1];

        for (int i = 0; i < nums.length; i++) {
            //����һ��Ԫ�ص��±�ǰ��������β��<=��ǰ[Ԫ��]�������±��Ƴ���ע�⣡�Ƚϵ���Ԫ��
            while (!list.isEmpty() && nums[list.peekLast()] <= nums[i]) {
                list.pollLast();        //��Ҫʹ��poll��add������ʹ��pollFirst��pollLast��addFirst��addLast�����
            }
            //����Ժ���뵱ǰ�±�
            list.add(i);
            //���ڳ��ȳ���k��Ҫ������Ԫ���Ƴ�
            if (list.peek() + k <= i) {
                list.pollFirst();
            }
            //�ӵ�k��Ԫ�ؿ�ʼ���������������Ӵ�
            if (i + 1 - k >= 0) {
                ans[i - k + 1] = nums[list.peek()];
            }
        }
        return ans;
    }*/


    /**
     * �ⷨ�����Ż��ı�����
     * <p>
     * ˼·����̬ά��һ����ǰ���ڵ����Ԫ�ص��±�maxIndex����������ڵ�ǰ���ڵķ�Χ���ʹӵ�ǰ������Ѱ�����Ԫ���±ꣻ
     * ��������һ��ѭ�����ô������ұߵ�Ԫ�غ����Ԫ�رȽϲ��������Ԫ������
     *
     * ʱ�䣺O(n)������ǽ������������Ӷ�Ϊkn��kΪ����������O(n)�����ռ䣺O(N)
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int[] ans = new int[nums.length - k + 1];
        int maxIndex = -1;
        int j = 0;
        for (int i = 0; i <= nums.length - k; i++) {
            //�������ڵķ�ΧΪ[i,i+k-1]���ж����Ԫ�ص��±�maxIndex�Ƿ��������Χ��
            if (i <= maxIndex && maxIndex <= i + k - 1) {
                //��Ϊif-else�����ϰ��һ����������else���ִ�к����һ��ѭ��ִ�У���������Ƚϴ������ұߵ��Ǹ���Ԫ�غʹ����е����Ԫ��
                if (nums[maxIndex] <= nums[i + k - 1]) {   //����������ұߵ�Ԫ�ش��ڵ�ǰ���Ԫ�أ��͸������Ԫ���±�
                    maxIndex = i + k - 1;
                }
            } else {
                //���Ԫ���±겻��[i,i+k-1]��Χ�У��ڴ˷�ΧѰ�����Ԫ���±겢����
                maxIndex = i;
                for (int m = i; m <= i + k - 1; m++) {  //ע��m�ķ�Χ[i,i+k-1]
                    if (nums[maxIndex] < nums[m])
                        maxIndex = m;
                }
            }
            ans[j++] = nums[maxIndex];
        }
        return ans;
    }
}