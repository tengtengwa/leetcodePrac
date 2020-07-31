package practice.leetcode.BinarySearch;

public class No69 {
    public static void main(String[] args) {
        Solution69 s = new Solution69();
        s.mySqrt(5);
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
    public int mySqrt(int x) {
        int L = 0, R = x, ans = -1;
        while (L <= R) {                    //ע�⣡����������L<=R��
            int mid = L + (R - L) / 2;      //ע�⣬������R-L������ǰ��Χ[L,R]��һ�룬����L����(R - L) / 2
            if ((long) mid * mid <= x) {    //������ý�mid��ƽ��תΪlong��������ܻ��������
                ans = mid;
                L = mid + 1;
            } else {
                R = mid - 1;
            }
        }
        return ans;
    }
}