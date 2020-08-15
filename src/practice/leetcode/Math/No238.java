package practice.leetcode.Math;

public class No238 {
    public static void main(String[] args) {
        Solution238 s = new Solution238();
        s.productExceptSelf(new int[]{1, 2, 3, 4});
    }
}

class Solution238 {
    /**
     * ��Ŀ����������������ĳ˻�
     * <p>
     * �ⷨһ��ʹ��������������L��R���ֱ𱣴�ĳ��λ��Ԫ��������������Ԫ�صĳ˻�
     * <p>
     * ʱ�䡢�ռ䣺O(N)
     */
/*    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];
        int[] ans = new int[len];
        left[0] = 1;
        right[len - 1] = 1;

        for (int i = 1; i < len; i++) {
            left[i] = left[i - 1] * nums[i - 1];    //��ǰλ��Ԫ����ߵĳ˻� = ��һ��Ԫ�ص���ߵĳ˻� * ��һ��Ԫ��
        }
        for (int i = len - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];  //�ұ�Ҳ�����Ƶ�
        }
        for (int i = 0; i < len; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }*/


    /**
     * �ⷨ������ʹ�ø�������left��right����һ�α���ʱans����洢ÿ��λ��Ԫ����ߵĳ˻����ڶ��α���ʱʹ��һ������R�����ұ�Ԫ�صĳ˻������и���
     *
     * ʱ�䣺O(N)���ռ�O(1)���������ans�����ڿռ临�Ӷ��ڣ�
     */
    public int[] productExceptSelf(int[] nums) {
        int len = nums.length;
        int[] ans = new int[len];
        ans[0] = 1;

        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * nums[i - 1];
        }
        int R = 1;      //R��������ұ�Ԫ�صĳ˻�
        for (int i = len - 1; i >= 0; i--) {    //ע�ⷶΧ�������һ��Ԫ�ؿ�ʼ�����൱�ڵ�һ�ֽⷨ�ĵ�����ѭ��
            ans[i] *= R;    //��ΪR�ǵ�ǰԪ���ұ�Ԫ�صĳ˻���ans[i]�����Ԫ�صĳ˻�������ֱ�ӳ˾ͺ���
            R *= nums[i];   //����R����������ǰһ��Ԫ��
        }
        return ans;
    }
}