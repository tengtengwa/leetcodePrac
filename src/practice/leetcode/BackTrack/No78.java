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
     * �ⷨһ������
     */
/*    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        backTrack(0, nums, ans, new ArrayList<>());
        return ans;
    }

    private void backTrack(int i, int[] nums, List<List<Integer>> ans, ArrayList<Integer> tem) {
        ans.add(new ArrayList<>(tem));      //�״ν�����ݺ�������ӵ��ǿռ�
        //if(i == nums.length) return;      //���д�����п���
        for (int index = i; index < nums.length; index++) {
            tem.add(nums[index]);
            backTrack(index + 1, nums, ans, tem);
            tem.remove(tem.size() - 1);
        }
    }*/


    /**
     * ��������ѭ��ö�٣�����һ��Ԫ�أ��ͽ�����֮ǰ�ݼ��е�ÿ�����ϣ�׷�����Ԫ�أ������������Ӽ�
     * Ҳ����ʹ�õݹ�ö�ٵİ취
     */
/*    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());         //�ȷ���һ���ռ�
        for (Integer num : nums) {
            int size = ans.size();      //����ѭ������ans��ÿ���Ӽ������Ԫ�أ����������ѭ������Ϊ��ǰans���ϵĴ�С
            for (int j = 0; j < size; j++) {
                //ע�⣡�����ȡ��ʱ��������´���һ��ArrayList�����ֱ��дans.get(j)��ȡ����ԭ�Ӽ������ã�
                //��������Ԫ�ص�ʱ��ԭ�Ӽ��͸ı��ˣ����³��ִ���
                List<Integer> list = new ArrayList<>(ans.get(j));
                list.add(num);
                ans.add(list);
            }
        }
        return ans;
    }*/


    /**
     * ��������λ���㣬���ַ����Ƚ��������ͼ�αȽ�������⣺
     * https://leetcode-cn.com/problems/subsets-ii/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-19/
     */
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        for (int i = 0; i < (1 << nums.length); i++) {  //���ѭ��ö�������Ӽ���Ӧ�ġ�����������������Ϊ1��������Ϊ0
            List<Integer> sub = new ArrayList<>();
            for (int j = 0; j < nums.length; j++)       //�ڲ�ѭ��ͨ����λ�����ж��Ƿ�����һλ��Ӧ�����е������оͼ��뱾�ε��Ӽ�
                if (((i >> j) & 1) == 1)
                    sub.add(nums[j]);
            res.add(sub);                   //ÿ���ڲ�ѭ����ϣ�����һ���Ӽ�
        }
        return res;
    }
}