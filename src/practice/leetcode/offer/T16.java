package practice.leetcode.offer;

public class T16 {

}

/**
 * ��ת������С���֣�
 * ��һ�������ʼ�����ɸ�Ԫ�ذᵽ�����ĩβ�����ǳ�֮Ϊ�������ת��
 * ����һ���ǵݼ�����������һ����ת�������ת�������СԪ�ء�
 * ��������{3,4,5,1,2}Ϊ{1,2,3,4,5}��һ����ת�����������СֵΪ1��
 * NOTE������������Ԫ�ض�����0���������СΪ0���뷵��0��
 */

class SolutionT16 {
    /*���ַ�*/
    public int minNumberInRotateArray(int[] array) {
        int left = 0, right = array.length - 1; //���ҷ�Χ��[0,array.length - 1]
        while (left < right) {  //�˳�ѭ��������left == right
            int mid = left + (right - left) / 2;
            //����ͨ��mid��right�±��ӦԪ�رȽ�����С��һ�εı߽磬ע��߽磡��
            if (array[mid] < array[right]) {
                right = mid;
            } else if (array[mid] > array[right]) {
                left = mid + 1;
            } else {    //�ظ�Ԫ�ص����ֱ��right--
                right--;
            }
        }
        return array[right];    //��󷵻�right��left������ӦԪ�ؾ���
    }
}