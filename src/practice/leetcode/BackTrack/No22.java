package practice.leetcode.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class No22 {
    public static void main(String[] args) {
        Solution22 s = new Solution22();
        List<String> list = s.generateParenthesis(3);

    }
}

class Solution22 {
    List<String> list = new ArrayList<>();

    public List<String> generateParenthesis(int n) {
        if (n == 0) {
            return list;
        }
        backtrack("", 0, 0, n);
        return list;
    }

    private void backtrack(String str, int L, int R, int n) {
        //���պû��ݽ�������
        if (n * 2 == str.length()) {
            list.add(str);
            return;
        }
        //���ݹ������ж�������ϵĺϷ���
        if (L < n) {
            backtrack(str + "(", L + 1, R, n);
        }
        //�����Ĺ�������������Ŀ����С������������
        if (R < L) {
            backtrack(str + ")", L, R + 1, n);
        }
    }
}