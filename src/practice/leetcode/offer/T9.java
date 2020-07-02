package practice.leetcode.offer;

public class T9 {

}

/**
 * ��̬��̨��
 * һֻ����һ�ο�������1��̨�ף�Ҳ��������2��������Ҳ��������n���������������һ��n����̨���ܹ��ж�����������
 * ���ƹ�ʽ��Fib(n) =  Fib(0)+Fib(1)+Fib(2)+.......+ Fib(n-2) + Fib(n-1)
 * ��ˣ��� Fib(n-1) = Fib(0)+Fib(1)+Fib(2)+.......+Fib(n-2)
 * ��ʽ����ã�Fib(n)-Fib(n-1) = Fib(n-1)   ---->  Fib(n) = 2*Fib(n-1)     n >= 3
 */
class SolutionT9 {
    /*���������Ե�����*/
    public int JumpFloorII(int target) {
        if (target == 0) return 1;
        if (target <= 2) return target;
        int[] cache = new int[target + 1];
        cache[0] = 1;
        cache[1] = 1;
        cache[2] = 2;
        for (int i = 3; i <= target; i++) {
            for (int j = i - 1; j >= 0; j--)
                cache[i] += cache[j];
        }
        return cache[target];
    }
}