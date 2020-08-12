package practice.leetcode.DP;

public class No221 {
    public static void main(String[] args) {
        Solution221 s = new Solution221();
        s.maximalSquare(new char[][]{
                {'1', '0', '1', '0', '0'},
                {'1', '0', '1', '1', '1'},
                {'1', '1', '1', '1', '1'},
                {'1', '1', '1', '1', '1'}
        });
    }
}

class Solution221 {
    /**
     * ��Ŀ����������Σ��ҳ��ɡ�0������1�����ɵ��ַ��������������������
     * ˼·������˼·����������߳�����󷵻�������
     * <p>
     * �ⷨһ������
     * 1.���������е�ÿ��Ԫ�أ�ÿ������ 1���򽫸�Ԫ����Ϊ�����ε����Ͻǣ�
     * 2.ȷ�������ε����ϽǺ󣬸������Ͻ����ڵ��к��м�����ܵ���������εı߳��������εķ�Χ���ܳ����������������������
     * �ڸñ߳���Χ��Ѱ��ֻ���� 1����������Σ�
     * 3.ÿ�����·�����һ���Լ����ҷ�����һ�У��ж��������к����Ƿ���������Ԫ�ض��� 1
     * <p>
     * ʱ�䣺O(MN*min(M,N)^2)��
     * ��Ҫ������������Ѱ��ÿ��1,���������ʱ�临�Ӷ��� O(mn)
     * ����ÿ�����ܵ������Σ���߳�������m��n�е���Сֵ����Ҫ�������������е�ÿ��Ԫ���ж��ǲ���ֻ����1��
     * ����������ʱ�临�Ӷ��� O(min(m,n)^2)
     * ��ʱ�临�Ӷ��� O(mnmin(m,n)^2)
     * <p>
     * �ռ䣺O(1)
     */

    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }
        int rows = matrix.length, columns = matrix[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (matrix[i][j] == '1') {
                    maxSide = Math.max(maxSide, 1);
                    int curMaxside = Math.min(rows - i, columns - j);
                    //��i,j��ʼ�����½����ţ����ŵ����������ΪcurMaxside
                    for (int k = 1; k < curMaxside; k++) {
                        //�ж�������һ��һ���Ƿ�Ϊ��1��
                        boolean flag = true;
                        if (matrix[i + k][j + k] == '0') {  //�ж�������һ��һ�е����½�
                            break;
                        }
                        for (int m = 0; m < curMaxside; m++) {  //�ж�ʣ�µ�Ԫ��
                            if (matrix[i + m][j + k] == '0' || matrix[i + k][j + m] == '0') {   //ע������Ԫ�صı�ʾ
                                flag = false;
                                break;
                            }
                        }
                        if (flag) {
                            maxSide = Math.max(maxSide, k + 1); //������ÿ�α߳�����1
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return maxSide * maxSide;
    }

    /** �ⷨ������̬�滮
     * dp[i,j]��ʾ��i��jΪ���½ǵ������ε����߳���
     * ���matrix[i][j]Ϊ��1������dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1])) + 1
     * ����dp[i][j] = 0�����ǵ÷����������
     *
     * ʱ�䣬�ռ䣺(M*N)
     */
/*    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;     //ע���п�
        int col = matrix[0].length;
        int[][] dp = new int[row][col];
        int max = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix[i][j] == '1') {
                    //������Խ����Ż�����һ��int[row+1][col+1]��ô������飬��1,1��ʼ������
                    // ������ʡȥ���ж�i == 0 || j == 0���ռ任ʱ��
                    if (i == 0 || j == 0) {
                        dp[i][j] = 1;
                    } else {
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                }*//* else {
                    dp[i][j] = 0;   //dp����Ĭ��Ϊ0�����Բ������д���
                }*//*
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max * max;   //ע�ⷵ�ص������
    }*/

    /**
     * ��̬�滮���Ż����ύ�����ʱ��ûʲô�仯����...
     */
/*    public int maximalSquare(char[][] matrix) {
        int row = matrix.length;
        if (row == 0) return 0;
        int col = matrix[0].length;
        int[][] dp = new int[row + 1][col + 1];     //����һ��[row + 1][col + 1]������
        int max = 0;
        for (int i = 1; i <= row; i++) {        //ע�ⷶΧ��[1,row]
            for (int j = 1; j <= col; j++) {    //ע�ⷶΧ��[1,col]
                if (matrix[i - 1][j - 1] == '1') {
                    dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                }
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max * max;
    }*/
}