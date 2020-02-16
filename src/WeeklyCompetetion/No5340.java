package WeeklyCompetetion;

public class No5340 {
    public static void main(String[] args) {


    }
}

class Solution5340 {
    public int countNegatives(int[][] grid) {
        int ans = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) ans++;
            }
        }
        return ans;
    }
}