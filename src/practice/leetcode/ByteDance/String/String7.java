package practice.leetcode.ByteDance.String;

import java.util.LinkedList;
import java.util.List;

public class String7 {
    public static void main(String[] args) {
        SolutionStr7 s = new SolutionStr7();
        s.restoreIpAddresses("25525511135");
    }
}

class SolutionStr7 {
    /**
     * 题目：复原IP地址。
     * 给定一个只包含数字的字符串，复原它并返回所有可能的 IP 地址格式。
     * ”有效的IP地址“正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
     *
     * 题解：DFS回溯
     * 思路：有效的IP地址由四个不超过255的数字和点组合而成，我们在每层递归枚举当前段（0~255的字符）的长度（从1~3）并对当前段进行有效判断；
     * 如果有效就加入集合中并进入下一层递归，否则返回上一层。当枚举完四段时将集合中的元素转换为由'.'分隔的有效IP。
     * 也可以使用SB代替集合，只不过在加入答案集合前需要去掉最后多余的一个'.'
     */
    public List<String> restoreIpAddresses(String s) {
        LinkedList<String> ans = new LinkedList<>();
        if (s.length() > 12 || s.length() < 4) {
            return ans;
        }
        dfs(0, s, 4, new LinkedList<>(), ans);
        return ans;
    }

    private void dfs(int start, String s, int segId, LinkedList<String> tem, LinkedList<String> ans) {
        if (start >= s.length()) {
            if (segId == 0) {
                ans.add(String.join(".", tem));
            }
            return;
        }
        for (int i = start; i < start + 3 && i < s.length(); i++) {
            //进行剪枝，剩下n个段最长长度3n不能小于剩下的字符串长度；否则考虑当前段长度+1
            if (s.length() - i - 1 <= (segId - 1) * 3) {
                String cur = s.substring(start, i + 1);
                if (!isValide(cur)) {       //对当前段的字符串进行有效判断
                    return;
                } else {
                    tem.add(cur);
                }
                dfs(i + 1, s, segId - 1, tem, ans);
                tem.removeLast();           //进行回溯
            }
        }
    }

    private boolean isValide(String str) {
        if (str.length() == 0) {
            return false;
        } else if (str.length() == 1) {
            return true;
        } else {
            return !str.startsWith("0") && Integer.parseInt(str) <= 255;    //有前导0或a大于255则是无效的
        }
    }
}