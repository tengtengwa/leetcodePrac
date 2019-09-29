package practice.leetcode;

public class No7 {
    public static void main(String[] args) {
        Solution7 s = new Solution7();
        System.out.println(s.reverse(-2147483648));
    }
}

class Solution7 {
    public int reverse(int x) {
        StringBuilder sb = new StringBuilder(String.valueOf(x));
        if (sb.charAt(0) == '-') {
            sb.deleteCharAt(0);
            try {
                return Integer.parseInt(new StringBuilder("-").append(sb.reverse()).toString());
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
    }
}