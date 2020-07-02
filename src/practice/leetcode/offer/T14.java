package practice.leetcode.offer;

public class T14 {

}

class SolutionT14 {
    /**
     * 插入排序的思想
     * 还有一种思路：依次遍历将所有奇数和偶数按顺序放到两个集合中，再将奇数和偶数分别放到原数组中，O(n^2)
     */
    public void reOrderArray(int[] array) {
        int len = array.length;
        int k = 0;      //记录已经排好序的最后一个奇数的位置
        for (int i = 0; i < len; i++) {
            if (array[i] % 2 == 1) {    //找到未排序中第一个奇数
                int j = i;
                while (j > k) {         //将这个奇数依次和前面一个数交换，直到到达排好序的位置后
                    int tem = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tem;
                    j--;
                }
                k++;    //更新已经排好序的最后一个奇数的位置
            }
        }
    }
}