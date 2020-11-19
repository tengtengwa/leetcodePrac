package practice.leetcode.BinarySearch;

public class O53_2 {
    public static void main(String[] args) {
        SolutionO53_2 s = new SolutionO53_2();
        s.missingNumber(new int[]{0, 1, 2, 3});
    }
}


class SolutionO53_2 {
    /**
     * ��Ŀ��0��n-1��ȱʧ������
     * һ������Ϊn-1�ĵ������������е��������ֶ���Ψһ�ģ�����ÿ�����ֶ��ڷ�Χ0��n-1֮�ڡ��ڷ�Χ0��n-1�ڵ�n������������ֻ��
     * һ�����ֲ��ڸ������У����ҳ�������֡�
     */

    /**
     * �ⷨһ��˳�����
     * ˼·�������ǰ����nums[i] != ��ǰ�±�i����ȱʧ�ľ��������i��������ȱʧ������������磺[0,1,2,3]����ʱȱʧ����4
     * �����ڱ������������Ҫ�������鳤��len
     *
     * ʱ�䣺O(n)
     */
/*    public int missingNumber(int[] nums) {
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] != i) {
                return i;
            }
        }
        return len;
    }*/


    /**
     * �ⷨ�������ֲ���
     * ˼·�����������ƣ�ֻ�����˶��ִ������Ա�����
     */
    public int missingNumber(int[] nums) {
        int len = nums.length, i = 0, j = len - 1;
        while (i <= j) {    //ע�����������������ӡ�=������Ȼȱʧ�������һ������ʱ������
            int mid = (i + j) >>> 1;
            if (nums[mid] > mid) {
                j = mid - 1;
            } else if (nums[mid] == mid) {
                i = mid + 1;
            }
        }
        return i;
    }
}