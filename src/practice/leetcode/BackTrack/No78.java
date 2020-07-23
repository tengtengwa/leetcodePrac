package practice.leetcode.BackTrack;

import java.util.ArrayList;
import java.util.List;

public class No78 {
    public static void main(String[] args) {
        Solution78 s = new Solution78();
        s.subsets(new int[]{1, 2, 3});
    }
}

class Solution78 {

    /**
     * 解法一：回溯
     */
/*    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(0, nums, ans, new ArrayList<>());
        return ans;
    }

    private void backTrack(int i, int[] nums, List<List<Integer>> ans, ArrayList<Integer> tem) {
        ans.add(new ArrayList<>(tem));      //首次进入回溯函数，添加的是空集
        //if(i == nums.length) return;      //这行代码可有可无
        for (int index = i; index < nums.length; index++) {
            tem.add(nums[index]);
            backTrack(index + 1, nums, ans, tem);
            tem.remove(tem.size() - 1);
        }
    }*/


    /**
     * 方法二：循环枚举，遇到一个元素，就将它往之前幂集中的每个集合，追加这个元素，就是新增的子集
     * 也可以使用递归枚举的办法
     */
/*    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());         //先放入一个空集
        for (Integer num : nums) {
            int size = ans.size();      //下面循环是往ans中每个子集中添加元素，所以下面的循环次数为当前ans集合的大小
            for (int j = 0; j < size; j++) {
                //注意！这里获取的时候必须重新创建一个ArrayList，如果直接写ans.get(j)获取的是原子集的引用，
                //下面增加元素的时候原子集就改变了，导致出现错误
                List<Integer> list = new ArrayList<>(ans.get(j));
                list.add(num);
                ans.add(list);
            }
        }
        return ans;
    }*/


    /**
     * 方法三：位运算，这种方法比较巧妙，借助图形比较容易理解：
     * https://leetcode-cn.com/problems/subsets-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-19/
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {  //外层循环枚举所有子集对应的“二进制数”，出现为1，不出现为0
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < nums.length; j++)       //内层循环通过移位运算判断是否有这一位对应数组中的数，有就加入本次的子集
                if (((i >> j) & 1) == 1)
                    sub.add(nums[j]);
            res.add(sub);                   //每次内层循环完毕，增加一个子集
        }
        return res;
    }
}