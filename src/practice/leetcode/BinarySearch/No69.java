package practice.leetcode.BinarySearch;

public class No69 {
    public static void main(String[] args) {
        Solution69 s = new Solution69();
        s.mySqrt(2);
    }
}

class Solution69 {
    /**
     * 题目：求一个非负整数x的平方根，不能使用库函数sqrt
     * 解法一：数学方法进行换底，使用其他数学函数
     * x^(1/2) = (e^lnx)^(1/2) = e^(1/2lnx)，这样就可以使用exp和log方法来计算了（log函数仅能计算以e为底的对数）
     *
     * 而指数函数和对数函数的参数和返回值均为浮点数，因此运算过程中会存在误差。例如当 x = 2147395600时，e^(1/2lnx)
     * 的计算结果与正确值 46340相差 10^(-11)，这样在对结果取整数部分时，会得到 46339这个错误的结果。
     *
     * 时间、空间近似为O(1)
     */
/*    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;   //验证是否有误差
    }*/

    /**
     * 解法二：二分查找
     * 思路：因为x的平方根的整数部分ans是满足k^2<=x的最大k值，因此可以使用二分查找来在0~max(k)之间不断选择中间点，向max(k)
     * “无限”靠拢，最终求得ans
     * 时间：O(logx)，空间O(1)
     */
/*    public int mySqrt(int x) {
        long L = 0, R = x, ans = -1;
        while (L <= R) {                    //注意！条件必须是L<=R，
            long mid = L + (R - L) / 2;      //注意，这里是R-L，即当前范围[L,R]的一半，所以L加上(R - L) / 2
            if (mid * mid <= x) {    //这里最好将mid的平方转为long，否则可能会整型溢出
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return (int) ans;
    }*/


    /**
     * 解法三：牛顿迭代法
     * 思路参考官方题解：https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
     *
     * 思路：我们用C来表示要求平方根的这个整数，则C的平方根就是求函数：y=f(x)=x^2-C的正零点。因为x=sqrt(C)。
     * 现我们任选取一个初始值x0，在每次的迭代中，我们找到函数上的点（xi,f(xi)），过这个点作一条斜率为这一点导数f'(xi)的直线，
     * 它与横轴的交点记作xi+1，它较xi而言距离零点更近。在多次迭代后就可以得到一个和零点非常近的交点。
     *
     * 一些结论：
     * （x0=C作为初始值）我们在每次迭代时，假设当前交点为xi，以它作垂线和函数的交点为：（xi,xi^2-C），所作直线斜率为2xi，
     * 则可以求得这条直线的方程为：f(x) = 2xi(x - xi) + xi^2 - C
     *                          = 2xi x - (xi^2 + C)
     * 它和横轴的交点即为函数f(x) = 0的解，即x = 1/2(xi + C/xi)。
     * 把xi+1代入，则xi+1 = 0.5*(xi + C/xi)。在进行k次迭代后，x_k的值与真实的零点sqrt(C)足够接近，即可作为答案。
     *
     * 时间：O(logx)，空间：O(1)
     *
     * 如果带小数的结果，则最后直接返回double类型的x0即可
     */
    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        double x0 = x, C = x;
        while (true) {
            double xi = 0.5 * (x0 + C / x0);
            if (Math.abs(x0 - xi) < 1e-7) {
                break;
            }
            x0 = xi;
        }
        return (int) x0;
    }
}