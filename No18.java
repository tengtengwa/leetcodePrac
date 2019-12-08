package practice.leetcode.HashTable;

import java.util.*;

public class No18 {
    public static void main(String[] args) {
        Solution18 s = new Solution18();
        s.fourSum(new int[]{-3, -2, -1, 0, 0, 1, 2, 3}, 0);
    }
}

class Solution18 {
/*    public List<List<Integer>> fourSum(int[] nums, int target) {
        HashMap<Integer, List<List<Integer>>> t = new HashMap<>();
        HashSet<List<Integer>> ret = new HashSet<>();
        Arrays.sort(nums);
        int n = nums.length;

        int start = 0;
        int end = n - 1;
        for (int i = start; i <= end - 1; i++) {
            for (int j = i + 1; j <= end; j++) {
                int s = nums[i] + nums[j];
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                tmp.add(j);
                if (t.containsKey(s)) {
                    List<List<Integer>> tmp1 = t.get(s);
                    tmp1.add(tmp);
                    t.put(s, tmp1);
                } else {
                    List<List<Integer>> tmp1 = new ArrayList<>();
                    tmp1.add(tmp);
                    t.put(s, tmp1);
                }
            }
        }

        start = 0;
        end = n - 1;
        for (int i = start; i <= end - 1; i++) {
            for (int j = i + 1; j <= end; j++) {
                int s = target - (nums[i] + nums[j]);
                //map�в�����s��ʱֱ������
                if (t.containsKey(s)) {
                    for (List<Integer> pairs : t.get(s)) {
                        int k = pairs.get(0);
                        int l = pairs.get(1);
                        if (j != k && j != l && i != k && i != l) {
                            List<Integer> tmp = new ArrayList<>();
                            tmp.add(nums[k]);
                            tmp.add(nums[l]);
                            tmp.add(nums[i]);
                            tmp.add(nums[j]);
                            tmp.sort(Comparator.comparingInt(o -> o));
                            ret.add(tmp);
                        }
                    }
                }
            }
        }
        return new ArrayList<>(ret);
    }*/

/*    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        if(len < 4){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        List<List<Integer>> list = new ArrayList<>();
        //��һ������������Χ��0~len-3
        for(int i = 0; i < len - 3; i ++) {
            // ȥ��(i>0��ֹ����Խ��)
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            // ��С����
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) break;
            // ���С
            if (nums[i] + nums[len - 1] + nums[len - 2] + nums[len - 3] < target) continue;
            //�ڶ������ķ�Χ��0~len-2
            for (int prev = i + 1; prev < len - 2; prev++) {
                // ȥ��
                if (prev - i > 1 && nums[prev] == nums[prev - 1]) continue;
                // ��С����
                if (nums[i] + nums[prev] + nums[prev + 1] + nums[prev + 2] > target) break;
                // ���С
                if (nums[i] + nums[prev] + nums[nums.length - 1] + nums[nums.length - 2] < target) continue;
                int tmp = nums[i] + nums[prev];
                //ʣ��������������֮���еĴ���ʽ����
                int mid = prev + 1, post = nums.length - 1;
                // ˫ָ��
                while (mid < post) {
                    if ((tmp + nums[mid] + nums[post]) == target) {
                        list.add(Arrays.asList(nums[i], nums[prev], nums[mid], nums[post]));
                        // ȥ��
                        while (mid < post && nums[mid] == nums[mid + 1]) {
                            mid ++;
                        }
                        // ȥ��
                        while (mid < post && nums[post] == nums[post - 1]) {
                            post --;
                        }
                        mid ++;
                        post --;
                    } else if ((tmp + nums[mid] + nums[post]) < target) {
                        mid ++;
                    } else {
                        post --;
                    }
                }
            }
        }
        return list;
    }*/

    public List<List<Integer>> fourSum(int[] nums, int target) {
        int len = nums.length;
        if (len < 4) {
            return new ArrayList<>();
        }
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        for (int i = 0; i < len - 3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            //��С����
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[3] > target) {
                break;
            }
            //���С
            if (nums[len - 1] + nums[len - 2] + nums[len - 3] + nums[i] < target) {
                continue;       //??
            }
            for (int j = i + 1; j < len - 2; j++) {
                //�˴���һ������Ϊj > i + 1������j�ĵ�һ��ֵ,��Ȼ��������Ϊ�棬[0,0,0,0],0����������
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                //��С����
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[len - 1] + nums[len - 2] < target) {
                    continue;
                }
                int tem = nums[i] + nums[j];
                int third = j + 1, four = len - 1;
                while (third < four) {
                    if (tem + nums[third] + nums[four] == target) {
                        res.add(Arrays.asList(nums[i], nums[j], nums[third], nums[four]));
                        while (third < four && nums[third] == nums[third + 1]) {
                            third++;
                        }
                        while (third < four && nums[four] == nums[four - 1]) {
                            four--;
                        }
                        //ȥ���������������
                        third++;
                        four--;
                    } else if (tem + nums[third] + nums[four] < target) {
                        third++;
                    } else {
                        four--;
                    }
                }
            }
        }
        return res;
    }
}