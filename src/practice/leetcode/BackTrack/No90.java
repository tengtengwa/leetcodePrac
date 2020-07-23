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
     * ������78�⡰�Ӽ����������棬������Ϊ�����к����ظ�Ԫ�أ��������������78��ⷨ�Ļ�����ȥ�ء�
     *
     * �ⷨһ��������ѭ��ö�٣�����ö�ٵĹ�����������ǰ���Ϻ���һ��״̬�ļ��ϵ������ظ�Ԫ�ء�
     */
/*    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        int index = 1;          //���������¼�½⿪ʼ��λ��
        for (int i = 0; i < nums.length; i++) {
            List<List<Integer>> tem = new ArrayList<>();        //ÿ���½�һ�����ϣ��������汾���¼�����Ӽ�
            for (int j = 0; j < ans.size(); j++) {
                if (i > 0 && nums[i] == nums[i - 1] && j < index) {     //������ǰ�����к���һ�εļ��������ظ���Ԫ��
                    continue;
                }
                List<Integer> sub = new ArrayList<>(ans.get(j));        //�¼�����Ӽ�
                sub.add(nums[i]);
                tem.add(sub);           //�ȼ����¼�����
            }
            index = ans.size();
            ans.addAll(tem);
        }
        return ans;
    }*/

    /**
     * �ⷨ��������+��֦�����ݹ�������������һ��Ԫ����ͬ��Ԫ�ء�
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
            if (index > start && nums[index] == nums[index - 1]) {  //��һ��Ԫ�ز����ظ�������ͬһ����ǰһ��Ԫ���ظ������
                continue;
            }
            tem.add(nums[index]);
            backTrack(index + 1, ans, nums, tem);       //ע�⣡��һ���startΪ index+1
            tem.remove(tem.size() - 1);
        }
    }

}