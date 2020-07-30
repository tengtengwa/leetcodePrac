package practice.leetcode.Recursion;

import java.util.*;

public class No17 {
    public static void main(String[] args) {
        Solution17 s = new Solution17();
        List<String> list = s.letterCombinations("23");
        for (String arr : list) {
            System.out.println(arr);
        }
    }
}

/*
class Solution17 {
    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        HashMap<Integer, String> map = new HashMap<>();
        map.put(2, "abc");
        map.put(3, "def");
        map.put(4, "ghi");
        map.put(5, "jkl");
        map.put(6, "mno");
        map.put(7, "pqrs");
        map.put(8, "tuv");
        map.put(9, "wxyz");

        char[] arr = digits.toCharArray();
        String[] str = new String[digits.length() * 3];
        for (int i = 0; i < arr.length; i++) {
            str[i] = map.get(Integer.parseInt(String.valueOf(arr[i])));
        }
        int num = 0;
        String[] string = new String[(int) Math.pow(3, str.length)];
        for (int j = 0; j < 2; j++) {
            for (int i = 0; i < str.length; i++) {
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < 2; k++) {
                    sb.append(str[k].charAt(i));
                }
                string[num++] = sb.toString();
            }
        }
        return Arrays.asList(string);
    }
}
*/

//�����㷨
class Solution17 {
    Map<String, String> phone = new HashMap<String, String>() {{
        put("2", "abc");
        put("3", "def");
        put("4", "ghi");
        put("5", "jkl");
        put("6", "mno");
        put("7", "pqrs");
        put("8", "tuv");
        put("9", "wxyz");
    }};

    List<String> output = new ArrayList<>();


    public List<String> letterCombinations(String digits) {
        if (digits.length() != 0)
            backtrack("", digits);
        return output;
    }

    private void backtrack(String combination, String next_digits) {
        //��һ������Ϊ�գ�ֱ�ӽ�����ϼ���list����������һ�λ���
        if (next_digits.isEmpty()) {
            output.add(combination);
            return;
        }
        //ÿ�λ�ȡ��ǰ��һλ����
        String num = next_digits.substring(0, 1);
        //��ȡ��һλ����ӳ����ַ���
        String lts = phone.get(num);
        //�����ַ����������л���
        for (int i = 0; i < lts.length(); i++) {
            String letter = lts.substring(i, i + 1);
            //����ǰ��ĸ����combination�󣬲�������һ����ĸ�Ĵ���
            backtrack(combination + letter, next_digits.substring(1));
        }
    }

}

/*class Solution17 {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) return ans;
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = Character.getNumericValue(digits.charAt(i));
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray())
                    ans.add(t + s);
            }
        }
        return ans;
    }
}*/
