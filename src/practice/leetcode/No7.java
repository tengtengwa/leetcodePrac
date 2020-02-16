package practice.leetcode;

public class No7 {
    public static void main(String[] args) {
        Solution7 s = new Solution7();
        System.out.println(s.reverse(-1234567893));
    }
}

class Solution7 {
/*    public int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        if (sb.charAt(0) == '-') {
            sb.deleteCharAt(0);
            try {
                return Integer.parseInt("-" + sb.reverse());
            } catch (Exception e) {
                return 0;
            }

        } else {
            try {
                return Integer.parseInt(sb.reverse().toString());
            } catch (Exception e) {
                return 0;
            }
        }
    }*/

    public int reverse(int x) {
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            //或运算后面是判断最后一位是否超过int范围(-2147483648——2147483647)
            if (rev > Integer.MAX_VALUE / 10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE / 10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}