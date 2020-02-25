package practice.leetcode.Greedy;

public class No392 {
    public static void main(String[] args) {
        Solution392 s = new Solution392();
        s.isSubsequence("acb", "ahbgdcb");

    }
}

class Solution392 {
    public boolean isSubsequence(String s, String t) {
        int tem = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            tem = t.indexOf(ch, tem + 1);
            if (tem == -1) {
                return false;
            }
        }
        return true;
    }
}