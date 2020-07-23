package practice.leetcode.BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No90 {
    public static void main(String[] args) {
        Solution90 s = new Solution90();
        s.subsetsWithDup(new int[]{1, 2, 2});
    }
}

class Solution90 {
    /**
     * 本题是78题“子集”的升级版，条件变为数组中含有重复元素，解决方法就是在78题解法的基础上去重。
     *
     * 解法一：迭代（循环枚举），在枚举的过程中跳过当前集合和上一次状态的集合的所有重复元素。
     */
/*    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        int index = 1;          //这个索引记录新解开始的位置
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tem = new ArrayList<>();        //每次新建一个集合，用来保存本次新加入的子集
            for (int j = 0; j < ans.size(); j++) {
                if (i > 0 && nums[i] == nums[i - 1] && j < index) {     //跳过当前集合中和上一次的集合所有重复的元素
                    continue;
                }
                List<Integer> sub = new ArrayList<>(ans.get(j));        //新加入的子集
                sub.add(nums[i]);
                tem.add(sub);           //先加入新集合中
            }
            index = ans.size();
            ans.addAll(tem);
        }
        return ans;
    }*/

    /**
     * 解法二：回溯+剪枝，回溯过程中跳过和上一个元素相同的元素。
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(0, ans, nums, new ArrayList<>());
        return ans;
    }

    private void backTrack(int start, List<List<Integer>> ans, int[] nums, ArrayList<Integer> tem) {
        ans.add(new ArrayList<>(tem));
        for (int index = start; index < nums.length; index++) {
            if (index > start && nums[index] == nums[index - 1]) {  //第一个元素不会重复，跳过同一层与前一个元素重复的情况
                continue;
            }
            tem.add(nums[index]);
            backTrack(index + 1, ans, nums, tem);       //注意！下一层的start为 index+1
            tem.remove(tem.size() - 1);
        }
    }

}