package practice.leetcode.String;

import java.util.*;

public class No49 {
    public static void main(String[] args) {


    }
}


class SolutionNo49 {

    /**
     * ����һ������������ࡣ  ˼·������һ��ӳ�䣺String -> List�������ַ������飬������ȫ�����뵽map�к󣬽��������е�value����һ��List����
     * �ҵ��ɵ㣺�����ж�һ���ַ���Ӧ�ö�Ӧ���Ǹ�key��������뷨��ͨ��һ��һ���ַ����Ƚϣ�����������������⡣
     * ������������ַ���תΪ�ַ����飬���ַ�����������ٽ���תΪ�ַ�����������ͬ����ĸ��λ�ʾ���ӳ�䵽ͬһ��String�ˣ�����Ӧͬһ��key��
     *
     * ʱ�临�Ӷȣ�O(NKlogK)������ N �� strs �ĳ��ȣ��� K�� strs ���ַ�������󳤶ȡ������Ǳ���ÿ���ַ���ʱ��
     * �ⲿѭ�����еĸ��Ӷ�Ϊ O(N)�� Arrays.sort()�ĸ��Ӷ�Ϊ O(KlogK)�����ǿ��źͺϲ�����Ľ�ϡ�
     *
     * �ռ临�Ӷȣ�O(NK)������洢�� map �е�ȫ����Ϣ���ݡ�
     */
/*    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        if (strs == null || strs.length == 0) {
            return new ArrayList<>(map.values());
        }
        for (String str : strs) {
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String key = String.valueOf(chars);
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> tem = new ArrayList<>();
                tem.add(str);
                map.put(key, tem);
            }
        }
        return new ArrayList<>(map.values());
    }*/

    /**
     * ������������������    ˼·�����ҽ������ǵ��ַ�������ÿ���ַ��ĳ��ִ�������ͬʱ�������ַ�������ĸ��λ�ʡ�
     * ˼·�ͷ���һ���ƣ�ֻ��Ѱ������һ���ַ�����Ӧ��key�ķ�ʽ���ˡ�
     *
     * ʱ�临�Ӷȣ�O(NK)������N��strs �ĳ��ȣ���K��strs���ַ�������󳤶ȡ�����ÿ���ַ������ַ�����С�����Եģ�����ͳ��ÿ���ַ�����
     * �ռ临�Ӷȣ�O(NK)������洢�� ans �е�ȫ����Ϣ���ݡ�
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            int[] arr = new int[26];
            for (int i = 0; i < str.length(); i++) {
                arr[str.charAt(i) - 'a']++;
            }
            StringBuilder sb = new StringBuilder("");
            for (int i = 0; i < arr.length; i++) {
                //sb.append("?");   ���п���
                sb.append(arr[i]);
            }
            String key = sb.toString();
            if (map.containsKey(key)) {
                map.get(key).add(str);
            } else {
                List<String> tem = new ArrayList<>();
                tem.add(str);
                map.put(key, tem);
            }
        }
        return new ArrayList<>(map.values());
    }
}