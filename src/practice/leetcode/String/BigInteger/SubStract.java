package practice.leetcode.String.BigInteger;

public class SubStract {
    public static void main(String[] args) {
        SolutionSubStract s = new SolutionSubStract();
        System.out.println(s.subStract("678", "99"));
    }
}

class SolutionSubStract {
    /**
     * 题目：大数相减（这里是两个整数相减）
     * 思路：低位向高位（从右向左一位一位地减）
     * 要注意判断，大数减小数正常相减，小数减大数相当于大数减小数前添加个负号
     */
    public String subStract(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        //下面的判断都是为了让subTract计算大减小
        if (len1 > len2) {
            return subTract(num1, num2);
        } else if (len1 < len2) {
            return "-" + subTract(num2, num1);
        } else {        //两个数长度相同
            //String的compareTo方法是一个一个字符比较，假设第一个不同的字符下标为i，则返回str1[i]-str2[i]
            int compare = num1.compareTo(num2);
            if (compare == 0) {     //两数相等，差为零
                return "0";
            } else if (compare > 0) {
                return subTract(num1, num2);
            } else {
                return "-" + subTract(num2, num1);
            }
        }
    }

    private String subTract(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int borrow = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = len1 - 1, j = len2 - 1; i >= 0 || j >= 0; i--, j--) {
            //每次给当前的差预+10，保证大减小；本次差值为：10+本位被减数-本位减数-上一位向本位的借位
            int sub = 10;
            sub += i < 0 ? 0 : num1.charAt(i) - '0';
            sub -= j < 0 ? 0 : num2.charAt(j) - '0';
            sub -= borrow;
            sb.append(sub % 10);
            borrow = (sub / 10 == 0) ? 1 : 0;   //如果差值小于10（sub/10==0），说明有借位，否则没有借位
        }
        sb.reverse();
        while (sb.charAt(0) == '0') {   //消除高位无用的0，例如999-1000=-0001
            sb.deleteCharAt(0);
        }
        return sb.toString();
    }
}