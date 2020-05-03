package practice.leetcode.DP;

public class No509 {
    public static void main(String[] args) {
        Solution509 s = new Solution509();
        s.fib(4);
    }
}

class Solution509 {

    /*�Զ�����*/
    Integer[] cache = new Integer[31];
    public int fib(int N) {
        cache[0] = 0;
        cache[1] = 1;
        return memoize(N);
    }

    private int memoize(int n) {
        if (cache[n] != null) {
            return cache[n];
        }
        return memoize(n - 1) + memoize(n - 2);
    }


    /*ʹ�������¼�Ե�����*/
/*    public int fib(int N) {
        if (N <= 1) {
            return N;
        }
        return memoize(N);
    }

    public int memoize(int N) {
        int[] cache = new int[N + 1];
        cache[1] = 1;

        for (int i = 2; i <= N; i++) {
            cache[i] = cache[i - 1] + cache[i - 2];
        }
        return cache[N];
    }*/


    /*�Ե����ϵ���*/
/*    public int fib(int n) {
        if (n <= 1) return n;
//        if (n == 2) return 1;
        int pre1 = 0, pre2 = 1, cur = 0;
        //���������2��ʼ��Ҫע�����������������нϴ��ֵ������С��ֵ������3��ʼʱ����������1�����Ը���˭������
        for (int i = 2; i <= n; i++) {
            cur = pre1 + pre2;
            pre1 = pre2;
            pre2 = cur;
        }
        return cur;
    }*/
}