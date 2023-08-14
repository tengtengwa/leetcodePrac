package practice.leetcode.Recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No51 {
    public static void main(String[] args) {
        Solution51 s = new Solution51();
        List<List<String>> lists = s.solveNQueens(4);
        for (List<String> list : lists) {
            for (String line : list) {
                System.out.println(line);
            }
            System.out.println();
        }
    }
}

/**
 * 51. N �ʺ�
 * ���չ�������Ĺ��򣬻ʺ���Թ�����֮����ͬһ�л�ͬһ�л�ͬһб���ϵ����ӡ�
 * n �ʺ����� �о�������ν� n ���ʺ������ n��n �������ϣ�����ʹ�ʺ�˴�֮�䲻���໥������
 * ����һ������ n ���������в�ͬ�� n �ʺ����� �Ľ��������
 * ÿһ�ֽⷨ����һ����ͬ�� n �ʺ����� �����ӷ��÷������÷����� 'Q' �� '.' �ֱ�����˻ʺ�Ϳ�λ��
 */
class Solution51 {
    /**
     * �ⷨһ�������ڼ��ϵģ�����
     * ���ͨ������ö��ÿһ���ʺ��λ�ã����㷨�ĸ��ӶȻ�ǳ��ߡ����ǿ��Թ۲���Է��֣�
     * ��һ���ʺ��λ��ȷ����ÿһ�С�ÿһ�С�ÿһ�������µ����ϵ�б�ߡ�ÿ�������ϵ����µ�б���϶������ٳ��������ʺ�
     * �����������Ҫ�ڻ��ݹ�������Ҫ��֦�ĵط���
     * ��Ҫע��Ľ���������б�ߣ����µ����ϵ�б�ߣ�row��col�ĺ���һ����ֵ�����ϵ����µ�б�ߣ�row��col�Ĳ���һ����ֵ
     * ʱ�临�Ӷȣ�O(N!)����һ���ʺ��λ��ȷ����������Ҫ����ʣ��N-1�С��к�б�ߡ�
     * �ռ临�Ӷȣ�O(N)������N�ǻʺ��������ռ临�Ӷ���Ҫȡ���ڵݹ���ò�������¼ÿ�з��õĻʺ�����±�������Լ�
     * �������ϣ��ݹ���ò������ᳬ��N������ĳ���ΪN��ÿ�����ϵ�Ԫ�ظ��������ᳬ��N��
     */
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        dfs(res, new int[n], n, 0, new ArrayList<>(), new ArrayList<>(), new ArrayList<>());
        return res;
    }

    private void dfs(List<List<String>> res, int[] queens, int n, int row, List<Integer> col, List<Integer> dia1s, List<Integer> dia2s) {
        if (row == n) {
            generateRes(res, queens);
        }
        for (int i = 0; i < n; i++) {
            if (col.contains(i)) {
                continue;
            }
            //�ӣ�List�ӿڵ�remove���������췽��remove(int index)��remove(Object o)������remove��ʱ��
            //�������intʱ��ͨ��index�Ƴ�Ԫ�أ�������Ҫʹ�ð�װ��Integer��ʹ��HashSet��
            Integer diff = row - i;
            Integer sum = row + i;
            if (dia1s.contains(diff)) {
                continue;
            }
            if (dia2s.contains(sum)) {
                continue;
            }
            queens[row] = i;
            col.add(i);
            dia1s.add(diff);
            dia2s.add(sum);
            dfs(res, queens, n, row + 1, col, dia1s, dia2s);
            col.remove(Integer.valueOf(i));
            dia1s.remove(diff);
            dia2s.remove(sum);
        }
    }

    private void generateRes(List<List<String>> res, int[] queens) {
        List<String> ans = new ArrayList<>();
        for (int i = 0; i < queens.length; i++) {
            char[] curChars = new char[queens.length];
            Arrays.fill(curChars, '.');
            curChars[queens[i]] = 'Q';
            ans.add(new String(curChars));
        }
        res.add(ans);
    }
}