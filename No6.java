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
            if (i == 0) {                       //��һ��
                int j = 0;
                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    j += 2 * numRows - 2;
                }
            } else if (i == numRows - 1) {      //���һ��
                int j = i;
                while (j < s.length()) {
                    sb.append(s.charAt(j));
                    j += numRows * 2 - 2;
                }
            } else {                    //�м���
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


//��һ��Z����ĸ����num*3-2�����ڶ���Ϊ2*num-2