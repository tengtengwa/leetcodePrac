package practice.leetcode;

public class No14 {
    public static void main(String[] args) {
        Solution14 s = new Solution14();
        String[] arr = {"aca", "cba"};
        System.out.println(s.longestCommonPrefix(arr));

    }
}


class Solution14 {

/**
 * 题目：最长公共前缀。找出数组中所有字符串的最长公共前缀
 *
 * 解法一：水平扫描
 * 每次比较两个字符串，求出公共前缀，最后的公共前缀即为所求
 *
 * 时间：O(mn)，其中m是字符串数组中的字符串的平均长度，n是字符串的数量。最坏情况下（也就是没有公共前缀的情况），字符串数组中的
 * 每个字符串的每个字符都会被比较一次。
 * 空间：O(1)
 */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(ans) != 0) {  //""是任何字符串的子串，这里会直接跳出while循环，因此不用管这种情况
                ans = ans.substring(0, ans.length() - 1);   //每次将第一个字符串末尾删掉一位，直到它是当前字符串的子串
            }
        }
        return ans;
    }

    /**
     * 解法二：竖直扫描
     * 从第一个字符开始判断所有字符串此位置的字符是否相同，是则将其添加到stringbuilder中，否则直接返回即可得到最长公共前缀
     *
     * 时间：O(mn)，其中m是字符串数组中的字符串的平均长度，n是字符串的数量。最坏情况下（也就是没有公共前缀的情况），字符串数组中的
     * 每个字符串的每个字符都会被比较一次。
     * 空间：O(1)
     */
/*    public String longestCommonPrefix(String[] strs) {
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
    }*/
}
