package practice.leetcode;

public class No14 {
    public static void main(String[] args) {
        Solution14 s = new Solution14();
        String[] arr = {"aca", "cba"};
        System.out.println(s.longestCommonPrefix(arr));

    }
}


//解法二：竖直扫描
//从第一个字符开始判断所有字符串此位置的字符是否相同，是则将其添加到stringbuilder中，否则直接返回即可得到最长公共前缀
class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            int j = 1;
            for (; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    break;
                }
            }
            if (j == strs.length) {
                sb.append(ch);
            } else {
                break;
            }
        }
        return sb.toString();
    }
}

/*
//解法一：水平扫描
//每次比较两个字符串，求出公共前缀，最后的公共前缀即为所求
class Solution14 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(ans) != 0) {         //如果ans是第i个字符串的子串，则indexof的返回值为0
                ans = ans.substring(0, ans.length() - 1);
                if (ans.isEmpty()) {
                    return "";
                }
            }
        }

        return ans;

    }
}*/
