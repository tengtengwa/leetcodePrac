package practice.leetcode.DailyQuestion;

public class No914 {
    public static void main(String[] args) {
        Solution914 s = new Solution914();
        s.hasGroupsSizeX(new int[]{1, 2, 3, 4, 4, 3, 2, 1});
    }
}

class Solution914 {
    public boolean hasGroupsSizeX(int[] deck) {
        if (deck.length <= 1) {
            return false;
        }
        int[] arr = new int[10000];
        for (int num : deck) {
            arr[num]++;
        }
        int g = -1;
        for (int num : arr) {
            if (num != 0) {
                if (g == -1) {
                    g = num;
                } else {
                    g = gcd(g, num);
                }
            }
        }
        return g >= 2;
    }

    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}