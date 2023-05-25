package practice.OfferSpecial;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class No005 {
    public static void main(String[] args) {
        Solution005 s = new Solution005();
        System.out.println(s.maxProduct(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}));
    }
}

/**
 * ��Ŀ�����ʳ��ȵ����˻�
 * ����һ���ַ�������words������㵱�����ַ��� words[i] �� words[j] ��������ͬ�ַ�ʱ�����ǳ��ȵĳ˻������ֵ��
 * �����ַ�����ֻ����Ӣ���Сд��ĸ�����û�в�������ͬ�ַ���һ���ַ��������� 0��
 *
 * ʾ�� 2:
 *
 * ����: words = ["a","ab","abc","d","cd","bcd","abcd"]
 * ���: 4
 * ����: ����������Ϊ "ab", "cd"��
 *
 *
 * ʾ�� 3:
 *
 * ����: words = ["a","aa","aaa","aaaa"]
 * ���: 0
 * ����: �������������������ʡ�
 */
class Solution005 {
    public int maxProduct(String[] words) {
        Queue<String> queue = new PriorityQueue<>((o1, o2) -> o1.length() - o2.length());
        for (int i = 0; i < words.length; i++) {
            int j = i + 1;
            for (; j < words.length; j++) {
                if (words[i].contains(words[j])) {
                    break;
                }
            }
            if (j == words.length) {
                queue.add(words[i]);
            }
        }
        switch (queue.size()) {
            case 0:
                return 0;
            case 2:
                return queue.remove().length() * queue.remove().length();
        }
        return 0;
    }
}