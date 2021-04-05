package practice.leetcodeOffer;

public class No4 {
    public static void main(String[] args) {
        Solution4 s = new Solution4();
        boolean isFind = s.findNumberIn2DArray(new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        }, 17);
        System.out.println(isFind);
    }
}

class Solution4 {
    /**
     * ��Ŀ����ά�����еĲ��ң�����һ����ά���飬ÿһ�ж����մ����ҵ�����˳������ÿһ�ж����մ��ϵ��µ�����˳�������ҳ�ָ������
     *
     * �ⷨһ����������˫��forѭ����һ��һ��Ԫ�ص�Ѱ��
     * ʱ�䣺O(n^2)���ռ䣺O(1)
     */

    /**
     * �ⷨ�������Բ��ң����ö�ά����ÿ�д����ҵ����Լ�ÿ�д��ϵ��µ������ص㣬�����ʵ�һ��Ԫ��ʱ�������ų������еĲ���Ԫ�ء�
     * ���Դ����½ǻ������Ͻǵ�һ��Ԫ�ؿ�ʼѰ�ң������Ǵ����½ǵ�һ��Ԫ�ؿ�ʼ�Ľⷨ��
     *
     * ʱ�䣺O(n)���ռ䣺O(1)
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length - 1, col = 0;
        while (row >= 0 && col < matrix[0].length) {
            int cur = matrix[row][col];
            if (cur == target) {
                return true;
            } else if (cur > target) {
                row--;
            } else {
                col++;
            }
        }
        return false;
    }
}