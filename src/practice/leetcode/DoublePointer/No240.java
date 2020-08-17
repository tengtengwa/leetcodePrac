package practice.leetcode.DoublePointer;

public class No240 {
}

class Solution240 {

    /**
     * ��Ŀ��������λ����2
     * ���� m x n ���� matrix �е�һ��Ŀ��ֵ target���þ�������������ԣ�
     * ÿ�е�Ԫ�ش������������С�ÿ�е�Ԫ�ش��ϵ����������С����ؾ������Ƿ�������target
     *
     * �ⷨһ������˫ѭ����O(mn)
     *
     * �ⷨ�����Լ�����������ⷨ
     */
    /*public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) return false;
        int row = matrix.length;
        int col = matrix[0].length;
        int rowStart = -1, rowEnd = -1, colStart = -1, colEnd = -1;
        boolean R = false, C = false;

        //������
        for (int i = 0; i < row; i++) {
            if (target < matrix[i][0]) {    //targetС�����е�һ��Ԫ�أ�˵��target�������У�����������Ľ�����
                break;
            } else if (target == matrix[i][0] || target == matrix[i][col - 1]) {    //target������Ԫ��֮һ
                return true;
            } else if (target < matrix[i][col - 1] && !R) {
                //�ߵ����˵��target�����׺���βԪ�ش�С֮�䣬��һ���ߵ�����ʱ�������������ʼ��
                rowStart = i;
                R = true;
            }
            rowEnd = i;
        }
        //�����У�������ͬ��
        for (int i = 0; i < col; i++) {
            if (target < matrix[0][i]) {
                break;
            } else if (target == matrix[0][i] || target == matrix[row - 1][i]) {
                return true;
            } else if (target < matrix[row - 1][i] && !C) {
                colStart = i;
                C = true;
            }
            colEnd = i;
        }
        //��ʼ����ʼ�������涼δ���£�˵��target������
        if (rowStart == -1 || colStart == -1) {
            return false;
        }
        for (int i = rowStart; i <= rowEnd; i++) {
            if (binarySearch(matrix, target, colStart, colEnd, i)) {    //����ʹ�ö��ֺ���������Ч�ʲ�𲻴�
                return true;
            }
        }
        return false;
    }

    private boolean binarySearch(int[][] arr, int target, int i, int j, int row) {
        int left = i, right = j;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (arr[row][mid] == target) {
                return true;
            } else if (arr[row][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return false;
    }*/


    /**
     * �ⷨ������Ը��֮Ϊ�����޵�ը��˫ָ��ⷨ
     * �����½�Ԫ�أ��ĸ��ǵ�Ԫ�ض����ԣ���ʼ��ÿ��ѭ������������ϻ���������һ��
     *
     * ʱ�临�Ӷȣ�O(n+m)���ռ䣺O(1)
     * ʱ�临�Ӷȷ����Ĺؼ���ע�⵽��ÿ�ε��������ǲ����� true��ʱ���л��ж��ᾫȷ�صݼ�/����һ�Ρ�������ֻ�ܼ���m�Σ�
     * ����ֻ������n�Σ�����ڵ��� while ѭ����ֹ֮ǰ��ѭ���������г���n+m�Ρ���Ϊ���������Ĺ������ǳ�����
     * �����ܵ�ʱ�临�Ӷ��ھ���ά��֮���������Եġ�
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length - 1;
        int col = 0;

        while (row >= 0 && col < matrix[0].length) {
            //ÿ��ѭ����row--��col++���൱������һ�л�һ��
            if (matrix[row][col] > target) {
                row--;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                return true;
            }
        }
        return false;
    }
}