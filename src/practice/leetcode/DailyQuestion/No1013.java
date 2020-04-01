package practice.leetcode.DailyQuestion;

public class No1013 {
    public static void main(String[] args) {
        Solution1013 s = new Solution1013();
        s.canThreePartsEqualSum(new int[]{0, 2, 1, -6, 6, -7, 9, 1, 2, 0, 1});
    }
}


class Solution1013 {
    public boolean canThreePartsEqualSum(int[] A) {
        int sum1 = 0, sum3 = 0, sum = 0;
        int i, j;
        for (int a : A) {
            sum += a;
        }
        int target = sum / 3;
        if (sum % 3 != 0) {
            return false;
        }
        for (i = 0; i < A.length - 2; i++) {
            sum1 += A[i];
            if (sum1 == target) {
                break;
            }
        }
        if (sum1 != target) {
            return false;
        }
        for (j = A.length - 1; j >= i + 2; j--) {
            sum3 += A[j];
            if (sum3 == target) {
                break;
            }
        }
        if (sum3 != target) {
            return false;
        }
        return true;
    }
}