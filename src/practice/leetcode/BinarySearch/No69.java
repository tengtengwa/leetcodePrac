package practice.leetcode.BinarySearch;

public class No69 {
    public static void main(String[] args) {
        Solution69 s = new Solution69();
        s.mySqrt(2);
    }
}

class Solution69 {
    /**
     * ��Ŀ����һ���Ǹ�����x��ƽ����������ʹ�ÿ⺯��sqrt
     * �ⷨһ����ѧ�������л��ף�ʹ��������ѧ����
     * x^(1/2) = (e^lnx)^(1/2) = e^(1/2lnx)�������Ϳ���ʹ��exp��log�����������ˣ�log�������ܼ�����eΪ�׵Ķ�����
     *
     * ��ָ�������Ͷ��������Ĳ����ͷ���ֵ��Ϊ�������������������л���������統 x = 2147395600ʱ��e^(1/2lnx)
     * �ļ���������ȷֵ 46340��� 10^(-11)�������ڶԽ��ȡ��������ʱ����õ� 46339�������Ľ����
     *
     * ʱ�䡢�ռ����ΪO(1)
     */
/*    public int mySqrt(int x) {
        if (x == 0) {
            return 0;
        }
        int ans = (int) Math.exp(0.5 * Math.log(x));
        return (long) (ans + 1) * (ans + 1) <= x ? ans + 1 : ans;   //��֤�Ƿ������
    }*/

    /**
     * �ⷨ�������ֲ���
     * ˼·����Ϊx��ƽ��������������ans������k^2<=x�����kֵ����˿���ʹ�ö��ֲ�������0~max(k)֮�䲻��ѡ���м�㣬��max(k)
     * �����ޡ���£���������ans
     * ʱ�䣺O(logx)���ռ�O(1)
     */
/*    public int mySqrt(int x) {
        long L = 0, R = x, ans = -1;
        while (L <= R) {                    //ע�⣡����������L<=R��
            long mid = L + (R - L) / 2;      //ע�⣬������R-L������ǰ��Χ[L,R]��һ�룬����L����(R - L) / 2
            if (mid * mid <= x) {    //������ý�mid��ƽ��תΪlong��������ܻ��������
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return (int) ans;
    }*/


    /**
     * �ⷨ����ţ�ٵ�����
     * ˼·�ο��ٷ���⣺https://leetcode-cn.com/problems/sqrtx/solution/x-de-ping-fang-gen-by-leetcode-solution/
     *
     * ˼·��������C����ʾҪ��ƽ�����������������C��ƽ��������������y=f(x)=x^2-C������㡣��Ϊx=sqrt(C)��
     * ��������ѡȡһ����ʼֵx0����ÿ�εĵ����У������ҵ������ϵĵ㣨xi,f(xi)�������������һ��б��Ϊ��һ�㵼��f'(xi)��ֱ�ߣ�
     * �������Ľ������xi+1������xi���Ծ������������ڶ�ε�����Ϳ��Եõ�һ�������ǳ����Ľ��㡣
     *
     * һЩ���ۣ�
     * ��x0=C��Ϊ��ʼֵ��������ÿ�ε���ʱ�����赱ǰ����Ϊxi�����������ߺͺ����Ľ���Ϊ����xi,xi^2-C��������ֱ��б��Ϊ2xi��
     * ������������ֱ�ߵķ���Ϊ��f(x) = 2xi(x - xi) + xi^2 - C
     *                          = 2xi x - (xi^2 + C)
     * ���ͺ���Ľ��㼴Ϊ����f(x) = 0�Ľ⣬��x = 1/2(xi + C/xi)��
     * ��xi+1���룬��xi+1 = 0.5*(xi + C/xi)���ڽ���k�ε�����x_k��ֵ����ʵ�����sqrt(C)�㹻�ӽ���������Ϊ�𰸡�
     *
     * ʱ�䣺O(logx)���ռ䣺O(1)
     *
     * �����С���Ľ���������ֱ�ӷ���double���͵�x0����
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