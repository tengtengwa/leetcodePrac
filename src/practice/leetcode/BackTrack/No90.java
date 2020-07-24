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
/*    public List<List<Integer>> subsetsWithDup(int[] nums) {
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
    }*/


    /**
     * ��78��Ľ���λ���㷽�����ѵ�����ȥ�أ�
     * 2 2 2 2 2
     * 1 1 0 0 0 -> [  2 2       ]
     * 1 0 1 0 0 -> [  2 2       ]
     * 0 1 1 0 0 -> [  2 2       ]
     * 0 1 0 1 0 -> [  2 2       ]
     * 0 0 0 1 1 -> [  2 2       ]
     * ˼·֮һ������ÿһλ 1��ǰ�棨�ұߣ�����0���Ӽ����һ��ɾ��
     *
     */
    public List<List<Integer>> subsetsWithDup(int[] num) {
        Arrays.sort(num);           //��Ȼ��Ҫ������
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < 1 << num.length; i++) {
            List<Integer> list = new ArrayList<>();
            boolean illegal = false;
            for (int j = 0; j < num.length; j++) {
                //��ǰλ�� 1
                if ((i >> j & 1) == 1) {        //��Ҫ���˺�1��
                    //��ǰ���ظ����֣�����ǰһλ�� 0�������������
                    if (j > 0 && num[j] == num[j - 1] && (i >> (j - 1) & 1) == 0) {    //��Ҫ���˺�1��
                        illegal = true;
                        break;
                    } else {
                        list.add(num[j]);
                    }
                }
            }
            if (!illegal) {         //��ѭ��������Ҳ��������Ӽ�������ȫ����ӽ�tem�б���ټ���ans����
                ans.add(list);
            }

        }
        return ans;
    }
}