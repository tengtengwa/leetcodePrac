package practice.leetcode;

public class No5214 {
    public static void main(String[] args) {
        Solution5214 s = new Solution5214();
        int[] arr = {1, 2, 3, 4};
        System.out.println(s.longestSubsequence(arr, 1));

    }
}

class Solution5214 {
    public int longestSubsequence(int[] arr, int difference) {
//        int tem = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            ans = 0;
//            tem = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                if (i - j == difference) {
//                    tem = arr[j];
                    ans++;
                }
            }
        }
        return ans;
    }
}