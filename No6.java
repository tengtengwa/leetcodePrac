package practice.leetcode;

public class No6 {
    public static void main(String[] args) {
        Solution6 s = new Solution6();
        System.out.println(s.convert("A", 1));

    }
}

class Solution6 {
    public String convert(String s, int numRows) {

        if (s.length() < numRows || numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            if (i == 0) {                       //第一行
                int j = 0;
                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    j += 2 * numRows - 2;
                }
            } else if (i == numRows - 1) {      //最后一行
                int j = i;
                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    j += numRows * 2 - 2;
                }
            } else {                    //中间行
                int j = i;
                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    j += (numRows - i - 1) * 2;
                    if (j < s.length()) {
                        sb.append(s.charAt(j));
                        j += i * 2;
                    }
                }

            }
        }
        return sb.toString();
    }
}


//第一个Z的字母数：num*3-2个，第二个为2*num-2