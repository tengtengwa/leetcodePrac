package practice.leetcode;

import java.util.HashMap;

public class No13 {
    public static void main(String[] args) {
        Solution13 s = new Solution13();
        System.out.println(s.romanToInt("IXLVIII"));

    }
}

class Solution13 {
    public int romanToInt(String s) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("I", 1);
        map.put("IV", 4);
        map.put("V", 5);
        map.put("IX", 9);
        map.put("X", 10);
        map.put("XL", 40);
        map.put("L", 50);
        map.put("XC", 90);
        map.put("C", 100);
        map.put("CD", 400);
        map.put("D", 500);
        map.put("CM", 900);
        map.put("M", 1000);
        int sum = 0;
        char[] arr = s.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            String str = "";
            try {
                str = s.substring(i, i + 1) + arr[i + 1];
            } catch (Exception e) {

            }
            if (map.get(str) == null) {
                sum += map.get(arr[i] + "");
            } else {
                sum += map.get(str);
                i++;
            }
        }
        return sum;
    }
}