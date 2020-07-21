package practice.leetcode.BackTrack;

import java.util.*;

public class No47 {
    public static void main(String[] args) {
        Solution47 solution47 = new Solution47();
        solution47.permuteUnique(new int[]{2, 1, 1});

    }
}

class Solution47 {

    /**
     * 46��ٷ��ⷨ��Ӧ�İ汾�������Ļ�������forѭ���м���һ��if����֦
     */
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ArrayList<Integer> tem = new ArrayList<>();
        Arrays.sort(nums);
        for (int num : nums) {
            tem.add(num);
        }
        DFS(ans, nums, 0, tem);
        return ans;
    }

    private void DFS(List<List<Integer>> ans, int[] nums, int index, ArrayList<Integer> tem) {
        if (index == nums.length) {
            ans.add(new ArrayList<>(tem));
        } else {
            DFS(ans, nums, index + 1, tem);
            for (int i = 0; i < nums.length; i++) {
                if (tem.get(index).equals(tem.get(i))) {
                    break;
                }
                Collections.swap(tem, i, index);
                DFS(ans, nums, index + 1, tem);
                Collections.swap(tem, i, index);
            }
        }
    }


    /**
     * ����ⷨ����46��ڶ��ֽⷨ�Ļ��������ģ�����������backtrack�����е�һ��if�������֦���Ƚ�������⡣
     * ʱ�临�Ӷȣ�O(N��N!)������ N Ϊ����ĳ��ȡ�
     * �ռ临�Ӷȣ�O(N��N!)��
     */
/*    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        Arrays.sort(nums);
        int[] flag = new int[nums.length];
        backTrack(ans, nums, 0, new ArrayList<>(), flag);
        return ans;
    }

    private void backTrack(List<List<Integer>> ans, int[] nums, int depth, List<Integer> tem, int[] flag) {
        if (depth == nums.length) {
            ans.add(new ArrayList<>(tem));
            return;
        }
        for (int index = 0; index < nums.length; index++) {
            if (flag[index] == 1) {     //�����������Ѿ�ѡ������
                continue;
            }
            if (index > 0 && nums[index] == nums[index - 1] && flag[index - 1] == 0) {
                continue;
            }
            tem.add(nums[index]);
            flag[index] = 1;
            backTrack(ans, nums, depth + 1, tem, flag);
            flag[index] = 0;
            tem.remove(tem.size() - 1);
        }
    }*/

}