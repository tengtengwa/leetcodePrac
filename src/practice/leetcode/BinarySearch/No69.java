package practice.leetcode.BinarySearch;

public class No69 {
    public static void main(String[] args) {
        Solution69 s = new Solution69();
        s.mySqrt(4);
    }
}

class Solution69 {
    public int mySqrt(int x) {
        long a = x;
        while (a * a > x) {
            a = (a + x / a) / 2;
        }
        return (int) a;
    }
}