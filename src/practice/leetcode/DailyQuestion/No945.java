package practice.leetcode.DailyQuestion;

public class No945 {
    public static void main(String[] args) {
        Solution945 s = new Solution945();
        s.minIncrementForUnique(new int[]{3,2,1,2,1,7});

    }
}

class Solution945 {
    public int minIncrementForUnique(int[] A) {
        if (A.length == 0) {
            return 0;
        }
        int ans = 0;
        int[] bucket = new int[40001];
        int num = A[0];
        bucket[num] = 1;
        for (int i = 1; i < A.length; i++) {
            num = A[i];
            if (bucket[num] == 1) {
                while (bucket[num] != 0) {
                    num++;
                    ans++;
                }
                bucket[num]++;
            } else {
                bucket[num]++;
            }
        }
        return ans;
    }
}