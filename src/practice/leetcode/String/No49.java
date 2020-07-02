package practice.leetcode.String;

import java.util.*;

public class No49 {
    public static void main(String[] args) {


    }
}


class SolutionNo49 {

    /**
     * 方法一：排序数组分类。  思路：建立一个映射：String -> List，遍历字符串数组，将它们全部加入到map中后，将其中所有的value加入一个List即可
     * 我的疑点：怎样判断一个字符串应该对应到那个key，起初的想法是通过一个一个字符来比较，但是这个方法有问题。
     * 解决方案：将字符串转为字符数组，将字符数组排序后，再将它转为字符串，这样不同的字母异位词就能映射到同一个String了（即对应同一个key）
     *
     * 时间复杂度：O(NKlogK)，其中 N 是 strs 的长度，而 K是 strs 中字符串的最大长度。当我们遍历每个字符串时，
     * 外部循环具有的复杂度为 O(N)。 Arrays.sort()的复杂度为 O(KlogK)，它是快排和合并排序的结合。
     *
     * 空间复杂度：O(NK)，排序存储在 map 中的全部信息内容。
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
     * 方法二：按计数分类    思路：当且仅当它们的字符计数（每个字符的出现次数）相同时，两个字符串是字母异位词。
     * 思路和方法一类似，只是寻找任意一个字符串对应的key的方式变了。
     *
     * 时间复杂度：O(NK)，其中N是strs 的长度，而K是strs中字符串的最大长度。计算每个字符串的字符串大小是线性的，我们统计每个字符串。
     * 空间复杂度：O(NK)，排序存储在 ans 中的全部信息内容。
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
                //sb.append("?");   可有可无
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