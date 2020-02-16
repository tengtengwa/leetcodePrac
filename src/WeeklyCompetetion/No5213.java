package WeeklyCompetetion;

public class No5213 {
    public static void main(String[] args) {
        Solution5213 s = new Solution5213();
        int[] arr = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
        System.out.println(s.minCostToMoveChips(arr));
    }
}

class Solution5213 {
    public int minCostToMoveChips(int[] chips) {
        if (chips.length <= 1) {
            return 0;
        }
        if (chips.length % 2 == 0) {
            return chips.length / 2;
        } else {
            return (chips.length - 1) / 2;
        }
    }
}