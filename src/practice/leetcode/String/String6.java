package practice.leetcode.String;

public class String6 {
    public static void main(String[] args) {
        SolutionString6 s = new SolutionString6();
        s.simplifyPath("/a//b////c/d//././/..");
    }
}

class SolutionString6 {
    /**
     * 题目：简化路径
     * 解法一：栈+字符串分隔
     * 思路：
     * 1.首先将字符串以"/"进行分割，数组中的字符串只可能有以下结果：
     * 空串""、指向父目录的符号".."、当前目录符号"."，当前目录名称"xxx"。
     * 2.接着对数组进行遍历：
     * 如果是“..”还要再判断是否为空才能弹出栈；
     * 如果不是空字符串""也不是"."，说明当前是路径信息，入栈即可
     * 3.最后遍历完之后，先判断栈中是否有元素，没有则返回 “/”；
     * 如果有元素，则使用 StringBuilder 来存放可变字符串，最后返回 ans 即可。
     * <p>
     * 时间、空间复杂度：O(n)
     */
/*    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] strs = path.split("/");
        for (String str : strs) {
            if ("..".equals(str)) {
                if (!stack.isEmpty()) {     //这里的if语句不能和上面的逻辑放到一起
                    stack.pollLast();
                }
            } else if (!"".equals(str) && !".".equals(str)) {
                stack.addLast(str);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : stack) {
            sb.append("/").append(str);
        }
        return sb.toString();
    }*/


    /**
     * 解法二：自定义实现逻辑
     * 思路：遍历一次字符串，每次寻找两个"/"中间的字符串cur，对sb进行相应的操作即可。
     * 时间、空间：O(n)
     */
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = path.length();
        while (i < n) {
            while (i < n && path.charAt(i) == '/') i++;     //跳过前面的'/'
            if (i != n) sb.append('/');                     //先给sb后面付一个'/'，这两行实现了对'/'去重
            int start = i;                                  //记录当前路径的开头位置
            while (i < n && path.charAt(i) != '/') i++;     //寻找当前路径结尾位置i
            String cur = path.substring(start, i);          //cur即为当前路径，可能为"."、".."、"xxx"的一种
            if (cur.equals("..")) {
                start = Math.max(0, sb.length() - 2);       //防止当前sb为"/"的情况
                while (start > 0 && sb.charAt(start) != '/') start--;   //从sb末尾向前找到第一个'/'的位置
                sb.delete(start, sb.length());              //删掉sb中末尾的子路径
            } else if (cur.equals(".")) {
                sb.delete(sb.length() - 1, sb.length());    //删掉sb末尾的'/'
            } else sb.append(cur);                          //cur是路径字符串，直接附在sb末尾
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}