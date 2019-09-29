package practice.leetcode;

import java.util.HashMap;

public class No12 {
    public static void main(String[] args) {
        Solution12 s = new Solution12();
        System.out.println(s.intToRoman(3));

    }
}

class Solution12 {
    public String intToRoman(int num) {
        HashMap<Integer, String> map = new HashMap<>();
        int[] arr = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        map.put(1, "I");
        map.put(4, "IV");
        map.put(5, "V");
        map.put(9, "IX");
        map.put(10, "X");
        map.put(40, "XL");
        map.put(50, "L");
        map.put(90, "XC");
        map.put(100, "C");
        map.put(400, "CD");
        map.put(500, "D");
        map.put(900, "CM");
        map.put(1000, "M");

        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            int i = 0;
            while (num != 0 && i < 13) {
                if (arr[i] <= num) {
                    sb.append(map.get(arr[i]));
                    num -= arr[i];
                } else {
                    i++;
                }
            }
        }
        return sb.toString();
    }
}