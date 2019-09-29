package practice.leetcode;

public class No8 {
    public static void main(String[] args) {
        Solution8 s = new Solution8();
        System.out.println(s.myAtoi("   -42"));
    }
}

class Solution8 {
    public int myAtoi(String str) {
        if (str == null || "".equals(str)) {
            return 0;
        }
        boolean flag = false;
        StringBuilder sb = new StringBuilder();

        int j = 0;
        while (str.charAt(j) == ' ') {
            j++;
        }
        for (int i = j; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return 0;
            }
            if (!(!flag && str.charAt(i) == ' ')) {
                flag = true;
                if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                    sb.append(str.charAt(i++));
                    if (!Character.isDigit(str.charAt(i))) {
                        break;
                    } else {
                        while (Character.isDigit(str.charAt(i))) {
                            sb.append(str.charAt(i++));
                            if (i == str.length()) {
                                break;
                            }
                        }
                        break;
                    }
                } else {
                    if (!Character.isDigit(str.charAt(i))) {
                        break;
                    } else {
                        while (Character.isDigit(str.charAt(i))) {
                            sb.append(str.charAt(i++));
                            if (i == str.length()) {
                                break;
                            }
                        }
                        break;
                    }
                }

            }
        }
        int result;
        try {
            result = Integer.parseInt(sb.toString());
        } catch (Exception e) {
            if (sb.charAt(0) == '-') {
                result = -2147483648;
            } else {
                result = 2147483647;
            }
        }
        return result;
    }
}
