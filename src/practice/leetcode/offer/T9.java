package practice.leetcode.offer;

public class T9 {

}

/**
 * 变态跳台阶
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 递推公式：Fib(n) =  Fib(0)+Fib(1)+Fib(2)+.......+ Fib(n-2) + Fib(n-1)
 * 因此，有 Fib(n-1) = Fib(0)+Fib(1)+Fib(2)+.......+Fib(n-2)
 * 两式相减得：Fib(n)-Fib(n-1) = Fib(n-1)   ---->  Fib(n) = 2*Fib(n-1)     n >= 3
 */
class SolutionT9 {
    /*辅助数组自底向上*/
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