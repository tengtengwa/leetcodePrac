package practice.leetcode.offer;

public class T16 {

}

/**
 * 旋转数组最小数字：
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 * 输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
 * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。
 * NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
 */

class SolutionT16 {
    /*二分法*/
    public int minNumberInRotateArray(int[] array) {
        int left = 0, right = array.length - 1; //查找范围：[0,array.length - 1]
        while (left < right) {  //退出循环条件：left == right
            int mid = left + (right - left) / 2;
            //下面通过mid和right下标对应元素比较来缩小下一次的边界，注意边界！！
            if (array[mid] < array[right]) {
                right = mid;
            } else if (array[mid] > array[right]) {
                left = mid + 1;
            } else {    //重复元素的情况直接right--
                right--;
            }
        }
        return array[right];    //最后返回right和left索引对应元素均可
    }
}