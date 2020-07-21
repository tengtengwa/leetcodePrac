package practice.leetcode.BackTrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class No46 {
    public static void main(String[] args) {
        Solution46 s = new Solution46();
        s.permute(new int[]{1, 2, 3});
    }
}

class Solution46 {

    /**
     * �ٷ���⣺�Ƚ�nums�����е�����Ԫ�ط��뼯�ϣ��ڻ���ʱ�������ǵ�˳�����õ���ͬ�����С�
     */
/*    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        DFS(lists, nums, 0, list);
        return lists;
    }

    private void DFS(List<List<Integer>> lists, int[] nums, int index, List<Integer> list) {
        if (index == nums.length) {
            lists.add(new ArrayList<>(list));
        } else {
            for (int i = index; i < nums.length; i++) {
                Collections.swap(list, index, i);
                DFS(lists, nums, index + 1, list);
                Collections.swap(list, index, i);
            }
        }
    }*/

    /**
     * ���ֽⷨʹ����һ���������flag����¼��ǰ�����е�Ԫ�أ�ÿ�λ���ʱ����������еķ��ʱ�Ǽ�Ϊδ���ʣ�
     * ����һ�ֽⷨ������⣬���Ƕ�����һ���������Ŀռ�
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tem = new ArrayList<>();
        int[] flag = new int[nums.length];
        backTrack(nums, ans, tem, 0, flag);
        return ans;
    }

    private void backTrack(int[] nums, List<List<Integer>> ans, ArrayList<Integer> tem, int depth, int[] flag) {
        if (depth == nums.length) {
            ans.add(new ArrayList<>(tem));
            return;
        }
        for (int index = 0; index < nums.length; index++) {
            if (flag[index] == 0) {
                tem.add(nums[index]);
                flag[index] = 1;
                backTrack(nums, ans, tem, depth + 1, flag);     //ע�������൱���������1
                flag[index] = 0;
                tem.remove(tem.size() - 1);
            }
        }
    }
}