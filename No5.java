package practice.leetcode;

public class No5 {
    public static void main(String[] args) {
        Solution5 s = new Solution5();
        System.out.println(s.longestPalindrome("abccba"));

    }
}

class Solution5 {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expendFromCenter(s, i, i);           //中心为一个字母
            int len2 = expendFromCenter(s, i, i + 1);   //中心为一对字母
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;      //当长度为偶数时，如果不减一start就会出错
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expendFromCenter(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;   //因为扩展结束后左右边界多扩展了一回，所以-1
    }


















/*    public String longestPalindrome(String s) {
        if (s == null || s.length() < 1) return "";
        int start = 0, end = 0;
        for (int i = 0; i < s.length(); i++) {
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int expandAroundCenter(String s, int left, int right) {
        int L = left, R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        return R - L - 1;
    }*/



/*    public String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        if (s.length() == 1) {
            return s;
        }
        if (isHuiWen(s)) {
            return s;
        }
        String maxSub = null;
        int max = 0;
        for (int i = 0; i < s.length() - 1; i++) {
            for (int j = 1; j < s.length(); j++) {
                if (i >= j) {
                    continue;
                }
                String sub = s.substring(i, j + 1);
                if (isHuiWen(sub)) {
                    if (sub.length() > max) {
                        max = sub.length();
                        maxSub = sub;
                    }
                }
            }
        }

        return maxSub;
    }*/

/*    private boolean isHuiWen(String s) {
        boolean is = true;
        for (int i = 0, j = s.length() - 1; i < s.length(); i++, j--) {
            if (s.charAt(i) != s.charAt(j)) {
                is = false;
                break;
            }
        }
        return is;
    }*/
}