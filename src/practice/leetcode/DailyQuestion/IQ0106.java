package practice.leetcode.DailyQuestion;

public class IQ0106 {
    public static void main(String[] args) {
        Solution0106 s = new Solution0106();
        s.compressString("bb");

    }
}


class Solution0106 {
    public String compressString(String S) {
        if (S.length() == 0) {
            return "";
        }
        char[] arr = S.toCharArray();
        char cur = arr[0];
        StringBuilder sb = new StringBuilder();
        sb.append(cur);
        int num = 1;
        for (int i = 1; i < arr.length; i++) {
            char ch = arr[i];
            if (ch == cur) {
                num++;
            } else {
                sb.append(num);
                cur = arr[i];
                sb.append(cur);
                num = 1;
            }
        }
        sb.append(num);
        if (S.length() <= sb.length()) {
            return S;
        }
        return sb.toString();
    }
}