package practice.leetcode.HashTable;

import java.util.*;

public class No15 {
    public static void main(String[] args) {
        Solution15 s = new Solution15();
        int[] arr = {-1, 0, 1, 2, -1, -4};
        s.threeSum(arr);

    }
}

class Solution15 {
/*    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums); // ����
        for (int i = 0; i < len ; i++) {
            if(nums[i] > 0) break; // �����ǰ���ִ���0��������֮��һ������0�����Խ���ѭ��
            if(i > 0 && nums[i] == nums[i-1]) continue; // ȥ��
            int L = i+1;
            int R = len-1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[L],nums[R]));
                    while (L<R && nums[L] == nums[L+1]) L++; // ȥ��
                    while (L<R && nums[R] == nums[R-1]) R--; // ȥ��
                    L++;
                    R--;
                }
                else if (sum < 0) L++;
                else if (sum > 0) R--;
            }
        }
        return ans;
    }*/

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return lists;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            //�����С�����ֶ�����0��������֮��һ������0������ֱ�ӽ���
            if (nums[i] > 0) {
                break;
            }
            //ȥ��
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int L = i + 1;
            int R = nums.length - 1;
            while (L < R) {
                int sum = nums[i] + nums[L] + nums[R];
                if (sum == 0) {
                    lists.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    //�� sum == 0 ʱ��nums[L] == nums[L+1]ʱ ��ᵼ�½���ظ���Ӧ������
                    while (L < R && nums[L] == nums[L + 1]) {
                        L++;
                    }
                    //�� sum == 0 ʱ��nums[R] == nums[R-1]ʱ ��ᵼ�½���ظ���Ӧ������
                    while (L < R && nums[R] == nums[R - 1]) {
                        R--;
                    }
                    L++;
                    R--;
                } else if (sum > 0) {
                    R--;
                } else {
                    L++;
                }
            }
        }
        return lists;
    }

}