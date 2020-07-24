package practice.leetcode.BackTrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class No90 {
    public static void main(String[] args) {
        Solution90 s = new Solution90();
        s.subsetsWithDup(new int[]{2, 2, 2, 2, 2});
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
/*    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
    }*/


    /**
     * 对78题改进的位运算方法，难点在于去重：
     * 2 2 2 2 2
     * 1 1 0 0 0 -> [  2 2       ]
     * 1 0 1 0 0 -> [  2 2       ]
     * 0 1 1 0 0 -> [  2 2       ]
     * 0 1 0 1 0 -> [  2 2       ]
     * 0 0 0 1 1 -> [  2 2       ]
     * 思路之一：凡是每一位 1的前面（右边）出现0的子集情况一律删除
     *
     */
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);           //仍然需要先排序
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 1 << num.length; i++) {
            List<Integer> list = new ArrayList<>();
            boolean illegal = false;
            for (int j = 0; j < num.length; j++) {
                //当前位是 1
                if ((i >> j & 1) == 1) {        //不要忘了和1与
                    //当前是重复数字，并且前一位是 0，跳过这种情况
                    if (j > 0 && num[j] == num[j - 1] && (i >> (j - 1) & 1) == 0) {    //不要忘了和1与
                        illegal = true;
                        break;
                    } else {
                        list.add(num[j]);
                    }
                }
            }
            if (!illegal) {         //内循环结束，也就是这个子集的数字全部添加进tem列表后再加入ans集合
                ans.add(list);
            }

        }
        return ans;
    }
}