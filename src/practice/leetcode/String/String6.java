package practice.leetcode.String;

public class String6 {
    public static void main(String[] args) {
        SolutionString6 s = new SolutionString6();
        s.simplifyPath("/a//b////c/d//././/..");
    }
}

class SolutionString6 {
    /**
     * ��Ŀ����·��
     * �ⷨһ��ջ+�ַ����ָ�
     * ˼·��
     * 1.���Ƚ��ַ�����"/"���зָ�����е��ַ���ֻ���������½����
     * �մ�""��ָ��Ŀ¼�ķ���".."����ǰĿ¼����"."����ǰĿ¼����"xxx"��
     * 2.���Ŷ�������б�����
     * ����ǡ�..����Ҫ���ж��Ƿ�Ϊ�ղ��ܵ���ջ��
     * ������ǿ��ַ���""Ҳ����"."��˵����ǰ��·����Ϣ����ջ����
     * 3.��������֮�����ж�ջ���Ƿ���Ԫ�أ�û���򷵻� ��/����
     * �����Ԫ�أ���ʹ�� StringBuilder ����ſɱ��ַ�������󷵻� ans ���ɡ�
     * <p>
     * ʱ�䡢�ռ临�Ӷȣ�O(n)
     */
/*    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] strs = path.split("/");
        for (String str : strs) {
            if ("..".equals(str)) {
                if (!stack.isEmpty()) {     //�����if��䲻�ܺ�������߼��ŵ�һ��
                    stack.pollLast();
                }
            } else if (!"".equals(str) && !".".equals(str)) {
                stack.addLast(str);
            }
        }
        if (stack.isEmpty()) {
            return "/";
        }
        StringBuilder sb = new StringBuilder();
        for (String str : stack) {
            sb.append("/").append(str);
        }
        return sb.toString();
    }*/


    /**
     * �ⷨ�����Զ���ʵ���߼�
     * ˼·������һ���ַ�����ÿ��Ѱ������"/"�м���ַ���cur����sb������Ӧ�Ĳ������ɡ�
     * ʱ�䡢�ռ䣺O(n)
     */
    public String simplifyPath(String path) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        int n = path.length();
        while (i < n) {
            while (i < n && path.charAt(i) == '/') i++;     //����ǰ���'/'
            if (i != n) sb.append('/');                     //�ȸ�sb���渶һ��'/'��������ʵ���˶�'/'ȥ��
            int start = i;                                  //��¼��ǰ·���Ŀ�ͷλ��
            while (i < n && path.charAt(i) != '/') i++;     //Ѱ�ҵ�ǰ·����βλ��i
            String cur = path.substring(start, i);          //cur��Ϊ��ǰ·��������Ϊ"."��".."��"xxx"��һ��
            if (cur.equals("..")) {
                start = Math.max(0, sb.length() - 2);       //��ֹ��ǰsbΪ"/"�����
                while (start > 0 && sb.charAt(start) != '/') start--;   //��sbĩβ��ǰ�ҵ���һ��'/'��λ��
                sb.delete(start, sb.length());              //ɾ��sb��ĩβ����·��
            } else if (cur.equals(".")) {
                sb.delete(sb.length() - 1, sb.length());    //ɾ��sbĩβ��'/'
            } else sb.append(cur);                          //cur��·���ַ�����ֱ�Ӹ���sbĩβ
        }
        return sb.length() == 0 ? "/" : sb.toString();
    }
}