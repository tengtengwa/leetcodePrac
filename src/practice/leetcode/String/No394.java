package practice.leetcode.String;

import java.util.*;

public class No394 {
    public static void main(String[] args) {
        Solution394 s = new Solution394();
        s.decodeString("3[a2[c]]");
        //"3[z]2[2[y]pq4[2[jk]e1[f]]]ef"
    }
}

class Solution394 {
    /**
     * ��Ŀ�ַ������룺����һ������������ַ������������������ַ�����
     * <p>
     * �ⷨһ��ջ
     * ����ջ���⣬ջ�д洢String���͵�Ԫ�أ�����������Ҫ����ת��
     * 1.������ĸ��'['ֱ����ջ��
     * 2.��Ϊ�����������д����ϰٵģ���������������Ҫ������Ѱ�����֣���������ת��Ϊһ��String����ջ��
     * 3.����']'ʱ���г�ջ��ֱ������'['����Ҫע����ǳ�ջ��������ַ���˳���ǵߵ��ģ�������Ҫʹ��һ���б����Ƿ�ת��������SB��
     * ��Ϊÿ��String���ַ���˳������ȷ�ģ�ֻ����ЩԪ�ص�˳���Ƿ��ģ�����������'['ʱ��Ҫ������ջ
     * <p>
     * ʱ�䡢�ռ䣺O(S)���ǽ����ó����ַ�������ΪS
     */
/*    public String decodeString(String s) {
        LinkedList<String> stack = new LinkedList<>();
        int index = 0;

        while (index < s.length()) {    //��Ϊ��������ʱ��Ҫ���������������Բ���ʹ����ǿforѭ��
            char ch = s.charAt(index);
            //�������֣������������������������ת��Ϊһ��String
            if (Character.isDigit(ch)) {
                StringBuilder sb = new StringBuilder();
                while (Character.isDigit(s.charAt(index))) {
                    sb.append(s.charAt(index++));
                }
                stack.add(sb.toString());
            } else if (ch == '[' || Character.isLetter(ch)) {   //'['����ĸֱ����ջ
                stack.add(String.valueOf(ch));
                index++;
            } else {        //����']'
                //����һ��'['֮ǰ�������ַ�������һ��list����ת���ǵ�˳��ע�ⲻ����StringBuilder��
                List<String> temlist = new LinkedList<>();
                while (!stack.peekLast().equals("[")) {
                    temlist.add(stack.pollLast());
                }
                Collections.reverse(temlist);
                stack.pollLast();       //ȥ�������ţ�
                //������ǰ�����ظ�����
                int time = Integer.parseInt(stack.pollLast());
                StringBuilder tem = new StringBuilder();
                //���������list�з�ת˳��������Ԫ��ƴ�ӳ�һ��String
                String curStr = getString(temlist);
                while (time > 0) {
                    --time;
                    tem.append(curStr);
                }
                stack.add(tem.toString());
                index++;
            }
        }

//        StringBuilder sb = new StringBuilder();
//        for (String str : stack) {
//            sb.append(str);
//        }
//        return sb.toString();
        //���ϴ������ʹ������ķ����滻
        return String.join("", stack);
    }

    private String getString(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (String str : list) {
            sb.append(str);
        }
        return sb.toString();
    }*/


    /**
     * �ⷨ�����ݹ�
     * ˼·��
     * 1.�������֣�������ǰk[]�����ǿ����Ƚ�����һ�����֣�Ȼ��������������ţ��ݹ����½�����������ݣ�������Ӧ�������žͷ��أ�
     * ������ǰk[]������ݹ����������ַ�
     * 2.������ĸ��ֱ�ӽ�����ǰ�����ĸ��Ȼ��ݹ����½��������ĸ��������ݡ�
     */
    int index = 0;
    String str;

    public String decodeString(String s) {
        str = s;
        return getString();
    }

    private String getString() {
        //�ݹ��ȿ����˳�����
        if (index == str.length() || str.charAt(index) == ']') {
            return "";
        }

        char ch = str.charAt(index);
        String ret = "";

        //���������֣�������ǰk[]��ret
        if (Character.isDigit(ch)) {
            int time = getTime();
            ++index;    //����������
            String next = getString();  //�ݹ����������ַ�
            ++index;    //����������
            while (time > 0) {
                ret += next;
                --time;
            }
        } else if (Character.isLetter(ch)) {    //��ǰ�ַ�����ĸ��ֻ������ǰ�ַ�ΪString
            ret = String.valueOf(ch);
            index++;
        }
        return ret + getString();   //��������������ַ�
    }

    private int getTime() {
        int time = 0;
        while (Character.isDigit(str.charAt(index))) {
            time = time * 10 + str.charAt(index++) - '0';   //Ҫô�������������Ҫô����parseInt����
        }
        return time;
    }
}