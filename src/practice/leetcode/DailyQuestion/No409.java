package practice.leetcode.DailyQuestion;

public class No409 {
    public static void main(String[] args) {
        Solution409 s = new Solution409();
        s.longestPalindrome("");

    }
}

/**
 * ���ĳ��ĸ��ż��������Ϊż���жԳ��ԣ����԰���ȫ������������Ĵ�����������������Ļ�����������ȫ����������������Ҳ����ֻ��ѡ����Ǹ�������ֻҪ����1����ʣ�µı��ż���Ϳ���ȫ��������
 * ��������ĸ����Ա���1��������������Ϊ���Ĵ������ģ��������Ҫ�ټӻ�һ��1
 * ���ǣ����ѹ��û����������������1Ҳ�������ӣ����Ի�Ҫ���������
 */
class Solution409 {
    public int longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s.length();
        }
        int[] arr = new int[58];
        for (char ch : s.toCharArray()) {
            int num = ch - 'A';
            arr[num]++;
        }
        int odd = 0;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] % 2 == 1) {
                odd++;
            }
            ans += arr[i];
        }
        return ans - odd;
    }
}