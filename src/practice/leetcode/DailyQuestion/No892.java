package practice.leetcode.DailyQuestion;

public class No892 {
    public static void main(String[] args) {
        Solution892 s = new Solution892();
        s.surfaceArea(new int[][]{
                {1, 2},
                {3, 4}});

    }
}

class Solution892 {
    public int surfaceArea(int[][] grid) {
        int sumBlock = 0;   //�����������
        int sumHide = 0;    //�غϵ�������һ��
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (j + 1 != grid[0].length) {
                    sumHide += Math.min(grid[i][j], grid[i][j + 1]);    //�������������غ���
                }
                if (i + 1 != grid.length) {
                    sumHide += Math.min(grid[i][j], grid[i + 1][j]);    //�������������غ���
                }
                sumBlock += grid[i][j];             //�ܿ���
                sumHide += grid[i][j] != 0 ? grid[i][j] - 1 : 0;
            }
        }

        return sumBlock * 6 - sumHide * 2;
    }
}