package practice.leetcode.DynamicProgramming;

public class No300 {
    public static void main(String[] args) {
        Solution300 s = new Solution300();
        s.lengthOfLIS(new int[]{10, 9, 2, 5, 3, 7, 101, 18, 4, 8, 6, 12});
    }
}

class Solution300 {

    /**
     * ��Ŀ��������������У��ϸ��������Ҳ����˵���Բ�����
     * �ⷨһ����̬�滮���е㱩����״̬ת�ƹ�ʽ��dp[i] = Max(dp[j])+1��(0=<j<i,num[i]>num[j])
     * ʱ�䣺O(N^2)���ռ䣺O(N)
     */
/*    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return len;
        }

        int[] dp = new int[len];
        Arrays.fill(dp, 1);

        for (int i = 1; i < len; i++) {
            for (int j = 0; j < i; j++) {   //��ѭ����[0,i)�������е����������
                if (nums[j] < nums[i]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for (int i = 0; i < len; i++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }*/


    /**
     * �ⷨ����̰��+���ֵ�˼�룬һ�α��������������и���������ж���
     * ̰�ĵ�˼�룺����һ����������ά��һ���������У��ڱ����Ĺ����У�����������ĩβԪ�ػ���ľ�ֱ�Ӽӵ����棻������������ͨ�����ֲ���
     * ��һ���������Ԫ�أ������滻��Ҳ����
     */
    public int lengthOfLIS(int[] nums) {
        int len = nums.length;
        if (len <= 1) {
            return len;
        }

        int[] arr = new int[nums.length];   //arr[i] ��ʾ����Ϊ i + 1 ���������������еĽ�β����Сֵ��
        arr[0] = nums[0];
        int end = 0;    //arr������ĩβԪ�أ���λ����ǰ��Ԫ�ض����ϸ������

        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > arr[end]) {
                end++;
                arr[end] = nums[i];
            } else {
                //��ǰԪ�ر�arrĩβԪ��С��ͨ�����ֲ��ҵ���һ���������Ԫ�أ������滻���滻ʱ����Ԫ�س��Ȳ��䣬����end����+1
                int left = 0, right = end;
                while (left < right) {
                    int mid = left + ((right - left) >>> 1);    //����Ҫ���⣬��λ�������ȼ�С���߼�����������������
                    if (arr[mid] < nums[i]) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                arr[left] = nums[i];        //����ѭ����left==right�����λ�õ�Ԫ�ؾ��ǵ�һ���ȵ�ǰԪ�ش��Ԫ��
            }
        }
        return end + 1;     //+1��Ϊ����������г���
    }

}