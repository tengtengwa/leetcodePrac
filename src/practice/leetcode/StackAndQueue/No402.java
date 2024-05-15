package practice.leetcode.StackAndQueue;

import java.util.Deque;
import java.util.LinkedList;

public class No402 {
    public static void main(String[] args) {
        Solution402 s = new Solution402();
        System.out.println(s.removeKdigits("112", 1));
        System.out.println(s.removeKdigits("1234567890", 9));
    }
}

/**
 * �Ƶ� K λ����
 * ����һ�����ַ�����ʾ�ķǸ����� num ��һ������ k ���Ƴ�������е� k λ���֣�ʹ��ʣ�µ�������С��
 * �������ַ�����ʽ���������С�����֡�
 */
class Solution402 {
    /**
     * ˼·��̰��+����ջ
     * <a href="https://blog.csdn.net/qfc_128220/article/details/127407642?spm=1001.2014.3001.5502">csdn</a>
     * <a href="https://leetcode.cn/problems/remove-k-digits/solutions/484940/yi-diao-kwei-shu-zi-by-leetcode-solution/">leetcode</a>
     *
     */
    public String removeKdigits(String num, int k) {
        if (num.length() == k) return "0";  //���У�n���ַ���ɾ��n����ֱ�ӷ���0
        Deque<Character> stack = new LinkedList<>();
        int remain = num.length() - k;  //�Ƴ�k���ַ���ʣ�µ��ַ�����
        for (int i = 0; i < num.length(); i++) {
            char ch = num.charAt(i);
            //��k>0���ҵ�ǰԪ��С��ջ��Ԫ��ʱ���Ƴ�ջ��Ԫ�أ�ֱ��ջ��Ԫ��<=��ǰԪ�أ�������"����"
            //���磺[1234567890]��k=9ʱ����ch��0ʱ��kΪ������Ҫ�Ƴ�ջ��������
            while (stack.size() > 0 && k > 0 && stack.peek() > ch) {
                k--;
                stack.pop();
            }
            stack.push(ch); //��ǰ�ַ�ѹջ
        }
        //ջ��Ԫ�ص�������������Ҫ�Ƴ����ַ�����ֱ����ջ���Ƴ������ַ�
        //���磺[112]��k=1����ʱstack.sizeΪ3��remainΪ2����Ҫ�Ƴ�ջ����2
        while (stack.size() > remain) {
            stack.pop();
        }
        //�Ƴ����е�ǰ��0
        while (stack.getLast() == '0' && stack.size() > 1) stack.removeLast();
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) sb.append(stack.removeLast());
        return sb.toString();
    }
}