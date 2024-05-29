package practice.leetcode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Tx {
    public static void main(String[] args) {
        SolutionTx s = new SolutionTx();
        System.out.println(s.getSumList(new int[]{1, 2, 3, 5}, 6));
    }
}


/**
 * ��Ŀ����������һ�������б��һ��Ŀ��ֵtarget���ҳ������к�Ϊtarget�����������б����ؽ��Ϊһ����ά���顣
 * ע������������ÿ����ֻ��ʹ��һ��
 * ���磺����{1,2,3,5}��targetΪ6�����ض�ά�б�[[1,2,3], [1,5]]
 */
class SolutionTx {
    /**
     * �ⷨ������
     * 1�������ȶ�������������ڽ��еݹ���ݡ�
     * 2�������ڱ���ݹ�ʱ���Ƚ���ǰ������cur�б��У��������ǰ�б�ĺ�sum
     * 3���ӵ�ǰ���ĺ�һ������ʼ��������һ��ݹ飬�����ظ�ѡ��
     * 4���ݹ����һ������cur�б����Ƴ������л���
     *
     * ע�⣺
     * - ���sum+��ǰ���Ѿ�����target�����ʾ���Ѿ�����target��������������Ϳ���ֱ�����������м�֦��
     * - �ݹ��˳�������sum==target����ʱ�����ҵ���һ����ȷ�Ľ⣬��������ά�б��У�֪��������еĽ⡣
     */
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> getSumList(int[] arr, int target) {
        Arrays.sort(arr);
        rec(arr, target, 0, 0, new ArrayList<>());
        return ans;
    }

    private void rec(int[] arr, int target, int idx, int sum, List<Integer> cur) {
        if (target == sum) {
            ans.add(new ArrayList<>(cur));
            return;
        }
        for (int i = idx; i < arr.length; i++) {
            if (sum + arr[i] > target) {
                break;
            }
            cur.add(arr[i]);
            rec(arr, target, i + 1, sum + arr[i], cur);
            cur.remove(cur.size() - 1);
        }
    }
}