package practice.leetcode.offer;

public class T11 {
    public static void main(String[] args) {
        SolutionT112 s = new SolutionT112();
        s.Power(2.0, -10);
    }
}

class SolutionT112 {
    /**
     * a^n = a^(n/2) * a^(n/2)              n为偶数
     *       a^((n-1)/2) * a^((n-1)/2) * a  n为奇数
     */
    public double Power(double base, int exponent) {
        if (-0.0000001 < base && base < 0.0000001) {    //注意这里判断浮点数是否相等
            return 0.0;
        }
        int absExponent = exponent > 0 ? exponent : -exponent;
        double result = AbsPower(base, absExponent);
        if (exponent < 0) {
            result = 1.0 / result;
        }
        return result;
    }

    private double AbsPower(double base, int exponent) {
        if (exponent == 0) {    //base的0次方
            return 1;
        }
        if (exponent == 1) {    //base的1次方
            return base;
        }
        double result = AbsPower(base, exponent >> 1);
        result *= result;
        if ((exponent & 1) == 1) {
            result *= base;
        }
        return result;
    }
}