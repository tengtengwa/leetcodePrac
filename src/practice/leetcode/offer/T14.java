package practice.leetcode.offer;

public class T14 {

}

class SolutionT14 {
    /**
     * ���������˼��
     * ����һ��˼·�����α���������������ż����˳��ŵ����������У��ٽ�������ż���ֱ�ŵ�ԭ�����У�O(n^2)
     */
    public void reOrderArray(int[] array) {
        int len = array.length;
        int k = 0;      //��¼�Ѿ��ź�������һ��������λ��
        for (int i = 0; i < len; i++) {
            if (array[i] % 2 == 1) {    //�ҵ�δ�����е�һ������
                int j = i;
                while (j > k) {         //������������κ�ǰ��һ����������ֱ�������ź����λ�ú�
                    int tem = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = tem;
                    j--;
                }
                k++;    //�����Ѿ��ź�������һ��������λ��
            }
        }
    }
}