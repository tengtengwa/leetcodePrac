package practice.leetcode.DailyQuestion;

public class No409 {
    public static void main(String[] args) {
        Solution409 s = new Solution409();
        s.longestPalindrome("");

    }
}

/**
 * 如果某字母有偶数个，因为偶数有对称性，可以把它全部用来构造回文串；但如果是奇数个的话，并不是完全不可以用来构建，也不是只能选最长的那个，而是只要砍掉1个，剩下的变成偶数就可以全部计入了
 * 但奇数字母里，可以保留1个不砍，把它作为回文串的中心，所以最后还要再加回一个1
 * 但是！如果压根没有奇数的情况，这个1也不能随便加，所以还要分情况讨论
 */
class Solution409 {
    public int longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int[] arr = new int[58];
        for (char ch : s.toCharArray()) {
            int num = ch - 'A';
            arr[num]++;
        }
        int odd = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                odd++;
            }
            ans += arr[i];
        }
        return ans - odd;
    }
}