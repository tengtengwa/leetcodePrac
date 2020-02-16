package WeeklyCompetetion;

public class No5255 {
    public static void main(String[] args) {
        Solution5255 s = new Solution5255();
        s.oddCells(2, 3, new int[][]{{0, 1}, {1, 1}});

    }
}

class Solution5255 {
    public int oddCells(int n, int m, int[][] indices) {
        int[][] arr = new int[n][m];
        for (int i = 0; i < indices.length; i++) {
            int[] indice = indices[i];
            int R = indice[0];
            int C = indice[1];
            //µÚRÐÐ
            for (int j = 0; j < m; j++) {
                arr[R][j] += 1;
            }
            for (int k = 0; k < n; k++) {
                arr[k][C] += 1;
            }
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (arr[i][j] % 2 == 1) {
                    sum++;
                }
            }
        }
        return sum;
    }
}