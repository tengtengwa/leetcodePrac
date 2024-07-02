package practice.leetcode.DynamicProgramming;

public class No32 {
    public static void main(String[] args) {
        Solution32 s = new Solution32();
        int n = s.longestValidParentheses(")()())");
        System.out.println(n);
    }
}

class Solution32 {
    /**
     * ��һ����������������Ӵ��ĺϷ��ԣ����ж���ĳ���
     * ʱ�临�Ӷȣ�O(n^3)���ռ临�Ӷȣ�O(n)
     *
     */
/*
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (!stack.empty() && stack.peek() == '(') {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.empty();
    }

    public int longestValidParentheses(String s) {
        int maxlen = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i + 2; j <= s.length(); j += 2) {
                if (isValid(s.substring(i, j))) {
                    maxlen = Math.max(maxlen, j - i);
                }
            }
        }
        return maxlen;
    }*/


    /**
     * ��������̬�滮��ʱ�临�Ӷȣ�O(n)���ռ临�Ӷȣ�O(n)
     * ������ƪ��⽲�ĺܺ�
     * https://leetcode-cn.com/problems/longest-valid-parentheses/solution/dong-tai-gui-hua-si-lu-xiang-jie-c-by-zhanganan042/
     *
     * ����˼·��
     * ֻ����')'��β�����вſ�������Ч���У����Ե�һ���������ǵ�ǰ�ַ�Ϊ')'��
     * ����dp��λ��i��Ԫ�ؼ�¼���ǵ�ǰλ��֮ǰ���±�Ϊi��β���ַ������Ч���ַ����ĳ��ȡ�
     * 1.��ǰ�ַ�Ϊ')'��ǰһ���ַ�Ϊ'('����ʱ����Ϊ...() ��dp[i] = dp[i-1] + 2
     * 2.��ǰ�ַ�Ϊ')'��ǰһ���ַ�Ϊ')'����ʱ����Ϊ..((..))����ʱ��Ҫ�ȿ���Ӧ���һ��')'�����ţ���i-1-dp[i-1]λ�õ����ţ��Ƿ���'('������������Ч���ţ�
     * ����dp[i]=dp[i-1]+2+dp[i-dp[i-1]-2]��dp[i-1-dp[i-1]-1]Ϊ ((..))ǰ��Ч���ų���
     *
     * ע�⣺��Ϊ��Ҫ�ж�ǰ������е������Ч���ų��ȣ�������Ҫ��ֹԽ�磬��������׳�������һ��Ҫϸ��!!!
     */

    public int longestValidParentheses(String s) {
        int max = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {   //��Ϊi��1��ʼ�ģ�����ֻ�����ﲻ���ж�Խ�磬�������ж���Ҫ��ֹԽ�磡����
                    dp[i] = (i - 2 >= 0 ? dp[i - 2] : 0) + 2;
                } else if (i - 1 - dp[i - 1] >= 0 && s.charAt(i - 1 - dp[i - 1]) == '(') {
                    dp[i] = dp[i - 1] + 2 + (i - 1 - dp[i - 1] - 1 >= 0 ? dp[i - 2 - dp[i - 1]] : 0);
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }


    /**
     * ��������ջ������ջ�д�ŵĲ��������ַ������Ǹ��ַ����±�
     */
/*    public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();            //�������ţ��Ƚ�ջ��Ԫ�س�ջ
                if (stack.empty()) {    //��ջһ��Ԫ�غ����ջΪ�գ��ͽ���������ջ
                    stack.push(i);
                } else {                //���������ź�ջ����������ԣ���ʱ������Ч����
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }*/
}