package practice.leetcode.ByteDance.String;

import java.util.LinkedList;
import java.util.List;

public class String7 {
    public static void main(String[] args) {
        SolutionStr7 s = new SolutionStr7();
        s.restoreIpAddresses("25525511135");
    }
}

class SolutionStr7 {
    /**
     * ��Ŀ����ԭIP��ַ��
     * ����һ��ֻ�������ֵ��ַ�������ԭ�����������п��ܵ� IP ��ַ��ʽ��
     * ����Ч��IP��ַ���������ĸ�������ÿ������λ�� 0 �� 255 ֮����ɣ��Ҳ��ܺ���ǰ�� 0��������֮���� '.' �ָ���
     *
     * ��⣺DFS����
     * ˼·����Ч��IP��ַ���ĸ�������255�����ֺ͵���϶��ɣ�������ÿ��ݹ�ö�ٵ�ǰ�Σ�0~255���ַ����ĳ��ȣ���1~3�����Ե�ǰ�ν�����Ч�жϣ�
     * �����Ч�ͼ��뼯���в�������һ��ݹ飬���򷵻���һ�㡣��ö�����Ķ�ʱ�������е�Ԫ��ת��Ϊ��'.'�ָ�����ЧIP��
     * Ҳ����ʹ��SB���漯�ϣ�ֻ�����ڼ���𰸼���ǰ��Ҫȥ���������һ��'.'
     */
    public List<String> restoreIpAddresses(String s) {
        LinkedList<String> ans = new LinkedList<>();
        if (s.length() > 12 || s.length() < 4) {
            return ans;
        }
        dfs(0, s, 4, new LinkedList<>(), ans);
        return ans;
    }

    private void dfs(int start, String s, int segId, LinkedList<String> tem, LinkedList<String> ans) {
        if (start >= s.length()) {
            if (segId == 0) {
                ans.add(String.join(".", tem));
            }
            return;
        }
        for (int i = start; i < start + 3 && i < s.length(); i++) {
            //���м�֦��ʣ��n���������3n����С��ʣ�µ��ַ������ȣ������ǵ�ǰ�γ���+1
            if (s.length() - i - 1 <= (segId - 1) * 3) {
                String cur = s.substring(start, i + 1);
                if (!isValide(cur)) {       //�Ե�ǰ�ε��ַ���������Ч�ж�
                    return;
                } else {
                    tem.add(cur);
                }
                dfs(i + 1, s, segId - 1, tem, ans);
                tem.removeLast();           //���л���
            }
        }
    }

    private boolean isValide(String str) {
        if (str.length() == 0) {
            return false;
        } else if (str.length() == 1) {
            return true;
        } else {
            return !str.startsWith("0") && Integer.parseInt(str) <= 255;    //��ǰ��0��a����255������Ч��
        }
    }
}