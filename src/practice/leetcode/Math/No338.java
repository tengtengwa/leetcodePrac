package practice.leetcode.Math;

public class No338 {
    public static void main(String[] args) {
        Solution338 s = new Solution338();
        s.countBits(9);
    }
}

class Solution338 {
    /**
     * ��Ŀ������λ������
     * ����һ���Ǹ����� num������ [0,num]��Χ�е�ÿ������ i ����������������е� 1 ����Ŀ����������Ϊ���鷵�ء�
     *
     * �ⷨһ��pop count��������ⷨ�͹ٷ��ⷨһ˼·��ͬ����������һ��λ���㣺n&(n-1)�����λ����Ὣn�����λ��1���0��
     * �����Ϳ���ͳ��n��1�ĸ�����
     *
     * ʱ�䣺O(nk)�������kӦ�ô���ÿ������x��1��λ�����ռ䣺O(n)��һ���������
     */
/*    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 0; i <= num; i++) {
            int n = 0;
            int tem = i;
            while (tem > 0) {
                tem = tem & (tem - 1);
                n++;
            }
            ans[i] = n;
        }
        return ans;
    }*/

    /**
     * �ⷨ����dp+�����Чλ
     * <p>
     * �۲�x�� x'=x/2�Ĺ�ϵ��
     * x = (1001011101)2 =(605)10
     * x��= (100101110)2  =(302)10
     * ���Է���x'��xֻ��һλ��ͬ��������Ϊx'���Կ���x�Ƴ������Чλ�Ľ�������������Ǿ����������״̬ת�ƺ�����
     * P(x)=P(x/2)+(x mod 2)    P(x)��ʾx��1��λ��
     *
     * ʱ�䡢�ռ䣺O(n)
     */
/*    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            //���һ����x%2==1��������������λһ����1(2^0)����Ϊ�����ϸߵ�λ����ʾ2^1���ϡ�
            // ��˿���ʹ��x&1���ж�x�����λ�Ƿ���1��Ҳ����˵ x&1 <==> x%2
            ans[i] = ans[i >> 1] + (i & 1);     //��ǰ����i��1��λ��Ϊi/2��1��λ��+x&1
        return ans;
    }*/

    /**
     * �ⷨ����dp+�������λ
     * ˼·���ͽⷨһ˼�����ƣ�״̬ת�Ʒ��̣�P(x) = P(x&(x-1)) + 1
     * ��dp������Ѱ�� [i&(i-1)] �������1��λ������Ϊ����i��1��λ�������1�����Ը�ǰ��+1����dp[i]
     *
     * ʱ�䡢�ռ䣺O(n)
     * ����һ��ÿ������Ҫͨ��λ����ѭ������1��λ����������ֱⷨ�Ӵ�dp������Ѱ��
     */
    public int[] countBits(int num) {
        int[] ans = new int[num + 1];
        for (int i = 1; i <= num; ++i)
            ans[i] = ans[i & (i - 1)] + 1;
        return ans;
    }
}