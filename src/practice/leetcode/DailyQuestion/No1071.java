package practice.leetcode.DailyQuestion;

public class No1071 {
    public static void main(String[] args) {
        Solution1071 s = new Solution1071();
        System.out.println(s.gcdOfStrings("ABCABC", "ABC"));
    }
}

class Solution1071 {
    public String gcdOfStrings(String str1, String str2) {
        //如果 str1 和 str2 拼接后等于 str2和 str1 拼接起来的字符串（注意拼接顺序不同），那么一定存在符合条件的字符串 X。否则不存在
        if (!(str1 + str2).equals(str2 + str1)) {
            return "";
        }
        return str2.substring(0, gcd(str1.length(), str2.length()));
    }

    //gcd求最大公约数，注意这个写法，不要记混
    private int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }
}