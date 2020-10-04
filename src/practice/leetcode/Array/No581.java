package practice.leetcode.Array;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class No581 {
    public static void main(String[] args) {
        Solution581 s = new Solution581();
        s.findUnsortedSubarray(new int[]{2, 6, 4, 8, 10, 9, 15});
    }
}

class Solution581 {
    /**
     * ��Ŀ�������������������
     * ����һ���������飬����ҪѰ��һ�������������飬���������������������������ô�������鶼���Ϊ��������
     * ���ҵ���������Ӧ����̵ģ���������ĳ��ȡ�
     *
     * �ⷨһ������
     * ˼·��ö��ÿ��������arr[i:j)���ҳ�����������ֵmax��min�����ж����Ƿ����������
     * 1.������ǰһ��arr[0,i-1]������Ԫ�ز�����min����һ��arr[j:len-1]������Ԫ�ز�С��max��
     * 2.���ζ��������
     * ��������������������������������飬j-i�������ĳ���
     *
     * ʱ�䣺O(n^3)���ռ䣺O(1)
     */
/*    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int ans = len;
        for (int i = 0; i < len; i++) {
            for (int j = i; j <= len; j++) {    //������ķ�Χ��arr[i:j)
                int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
                for (int k = i; k < j; k++) {
                    max = Math.max(max, nums[k]);
                    min = Math.min(min, nums[k]);
                }
                if ((i > 0 && nums[i - 1] > min) || (j < len && nums[j] < max)) {   //i>0,j<len��Ϊ�˷�ֹԽ��
                    continue;
                }
                int k = 0, pre = Integer.MIN_VALUE;
                while (k < i && pre <= nums[k]) {
                    pre = nums[k];
                    k++;
                }
                if (k != i) {
                    continue;
                }
                k = j;
                while (k < len && pre <= nums[k]) {
                    pre = nums[k];
                    k++;
                }
                if (k == len) {
                    ans = Math.min(j - i, ans);     //ȡ��С����
                }
            }
        }
        return ans;
    }*/

    /**
     * �ⷨ���������Ż���
     * ������Ȼö��ÿ��������Ŀ��ܣ����������������ұ߽�nums[j]����߽�nums[i]С������ζ��nums[i]��nums[j]
     * ����������������е���ȷλ�ã����Ǽ�¼i��j��������Ԫ�ر����Ŀǰ��������ı߽硣
     * �������������С���Ⱦ���r-l+1
     */
/*    public int findUnsortedSubarray(int[] nums) {
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[i]) {
                    r = Math.max(r, j);
                    l = Math.min(l, i);
                }
            }
        }
        return r - l < 0 ? 0 : r - l + 1;   //�����Ѿ�����ʱr-lС��0����ʱ�����鳤��Ϊ0
    }*/

    /**
     * �ⷨ���������Ƚ�
     * ˼·����¡һ��������������ٺ�ԭ������бȽϣ��ж����ǵ�һ�������һ������ͬԪ�ص��±꣬���������ĳ��Ⱦ���r-l+1
     * ʱ�䣺O(nlogn)���ռ䣺O(n)
     */
/*    public int findUnsortedSubarray(int[] nums) {
        int[] arr = nums.clone();
        Arrays.sort(arr);
        int l = nums.length, r = 0;
        for (int i = 0; i < nums.length; i++) {
            if (arr[i] != nums[i]) {
                l = Math.min(l, i);
                r = Math.max(r, i);
            }
        }
        return r - l < 0 ? 0 : r - l + 1;   //�����Ѿ�����ʱr-lС��0����ʱ�����鳤��Ϊ0
    }*/


    /**
     * �ⷨ�ģ�ʹ��ջ
     * ˼·���������������뷨��Ȼ��ѡ������������Ҫ�ҵ���������������СԪ�غ����Ԫ�طֱ��Ӧ����ȷλ�ã������������Ҫ��
     * ����������ı߽硣
     * Ϊ�˴ﵽ��һĿ�ģ��˷����У�����ʹ��ջ�����Ǵ�ͷ���� nums���飬������������ִ�Сһֱ������ģ����ǾͲ��ϰѶ�Ӧ���±�ѹ��ջ�У�
     * ��ô����Ŀ������Ϊ��ЩԪ����Ŀǰ���Ǵ�����ȷ��λ���ϡ�һ����������ǰ������Ⱥ��������Ҳ���� nums[j]��ջ��Ԫ��С��
     * ���ǿ���֪�� nums[j]һ��������ȷ��λ���ϡ�
     * Ϊ���ҵ� nums[j]����ȷλ�ã����ǲ��Ͻ�ջ��Ԫ�ص�����ֱ��ջ��Ԫ�ر�nums[j] С�����Ǽ���ջ��Ԫ�ض�Ӧ���±�Ϊk��
     * ��ô����֪�� nums[j]����ȷλ���±�Ӧ����k+1 ��
     * �����ظ���һ���̲��������������飬�������ǿ����ҵ���С��k����Ҳ���������������߽硣�������ҵ����������������߽�Ӧ�ó��ֵ�λ��
     * �������������һ�α�������һ������Ĳ��裬�Ϳ����ҵ�������������ұ߽磬��������������������̳��ȡ�
     *
     * ʱ�䡢�ռ䣺O(n)
     */
/*    public int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int l = len, r = 0;
        Deque<Integer> stack = new LinkedList<>();  //ջ�д洢Ԫ�ص��±�
        for (int i = 0; i < len; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peekLast()]) {  //����Ƚϵ���Ԫ�أ�ע�ⲻҪֱ����ջ�е��±����Ƚ���
                l = Math.min(l, stack.pollLast());      //��¼��������߽��±�
            }
            stack.addLast(i);
        }
        stack.clear();
        for (int i = len - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peekLast()]) {  //����ͬ���Ƚϵ���Ԫ��
                r = Math.max(r, stack.pollLast());
            }
            stack.addLast(i);
        }
        return Math.max(r - l + 1, 0);
    }*/


    /**
     * �ⷨ�壺��˫ָ�롱��Ҳ���ǹٷ��ⷨ��
     * ˼·��һ�α�����ͬʱ��ǰ��󡢴Ӻ���ǰ�ҵ�ǰ�����Сֵmax��min�����������ұ߽�
     * ʱ�䣺O(n)���ռ䣺O(1)
     */
    public int findUnsortedSubarray(int[] nums) {
        //�������ұ߽��ȡֵҲ�н�������������Ѿ�������ģ�l��r��û�иı䣬����r-l+1����0���Ͳ���дMath.max(r-l+1,0)�ˣ�
        //��󷵻�Math.max(r-l+1,0)����Ҫr-l+1<=0��Ҳ����r<=l-1
        int l = 0, r = -1;
        int max = nums[0], min = nums[nums.length -1];
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] < max) {    //Ѱ���ұ߽磬�����ǰԪ��С��ǰ������ֵ��˵������һ�����ܵ��ұ߽�
                r = i;
            } else {
                max = nums[i];
            }

            int j = nums.length - i - 1;
            if (nums[j] > min) {    //Ѱ����߽磬�����ǰԪ��С��ǰ������ֵ��˵������һ�����ܵ���߽�
                l = j;
            } else {
                min = nums[j];
            }
        }
        return r - l + 1;
    }
}