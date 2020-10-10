package practice.leetcode.String.BigInteger;

public class No43 {
    public static void main(String[] args) {
        Solution43 s = new Solution43();
        s.multiply("123", "456");
    }
}

class Solution43 {
    /**
     * 题目：字符串相乘，经典大数相乘
     * 大佬题解：https://leetcode-cn.com/problems/multiply-strings/solution/you-hua-ban-shu-shi-da-bai-994-by-breezean/
     *
     * 解法一：普通竖式，即第二个字符串的每一位分别与第一个字符串做乘法，将这些和全部相加即为最终结果。懂了大数相加，大数相乘也就敢敢单单
     */
/*    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {     //有0直接返回0
            return "0";
        }
        String ans = "";
        int carry = 0;
        for (int i = num2.length() - 1; i >= 0; i--) {
            StringBuilder tem = new StringBuilder();        //tem存储当前一次乘积的结果
            //注意补零
            for (int k = 0; k < num2.length() - 1 - i; k++) {
                tem.append('0');
            }
            int y = num2.charAt(i) - '0';       //char型数字转为int要减去字符'0'
            for (int j = num1.length() - 1; j >= 0 || carry != 0; j--) {    //内循环记得把最后的进位加上
                int x = j < 0 ? 0 : num1.charAt(j) - '0';
                int sum = (x * y + carry) % 10;
                tem.append(sum);
                carry = (x * y + carry) / 10;
            }
            ans = addString(ans, tem.reverse().toString());     //当前一次乘积的结果是反的
        }
        return ans;
    }

    private String addString(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for (int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry != 0; i--, j--) {
            int x = i < 0 ? 0 : num1.charAt(i) - '0';   //依旧注意char型数字转为int的写法
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            int sum = (x + y + carry) % 10;
            sb.append(sum);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }*/

    /**
     * 解法二：优化竖式
     * 该算法是通过两数相乘时，乘数某位与被乘数某位相乘，与产生结果的位置的规律来完成。也就是直接将每次的结果暂存到数组中，后面
     * 通过相应位置的数和规律计算结果。
     * 乘数 num1 位数为M，被乘数 num2 位数为N， num1 x num2 结果 res 最大总位数为 M+N
     * num1[i] x num2[j] 的结果为 tmp(位数为两位，"0x","xy"的形式)，其第一位位于 res[i+j]，第二位位于 res[i+j+1]。
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {     //有0直接返回0
            return "0";
        }
        int[] ans = new int[num1.length() + num2.length()];
        for (int i = num2.length() - 1; i >= 0; i--) {
            int x = num2.charAt(i) - '0';
            for (int j = num1.length() - 1; j >= 0; j--) {
                int y = num1.charAt(j) - '0';
                int sum = ans[i + j + 1] + x * y;
                ans[i + j + 1] = sum % 10;  //先求低位
                ans[i + j] += sum / 10;     //高位需要将进位加上去，注意这里的+=
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ans.length; i++) {
            if (i == 0 && ans[i] == 0) {    //过滤掉第一位的0，比如10*10=[0100]
                continue;
            }
            sb.append(ans[i]);
        }
        return sb.toString();
    }
}








