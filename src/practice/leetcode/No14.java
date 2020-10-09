package practice.leetcode;

public class No14 {
    public static void main(String[] args) {
        Solution14 s = new Solution14();
        String[] arr = {"aca", "cba"};
        System.out.println(s.longestCommonPrefix(arr));

    }
}


class Solution14 {

/**
 * ��Ŀ�������ǰ׺���ҳ������������ַ����������ǰ׺
 *
 * �ⷨһ��ˮƽɨ��
 * ÿ�αȽ������ַ������������ǰ׺�����Ĺ���ǰ׺��Ϊ����
 *
 * ʱ�䣺O(mn)������m���ַ��������е��ַ�����ƽ�����ȣ�n���ַ����������������£�Ҳ����û�й���ǰ׺����������ַ��������е�
 * ÿ���ַ�����ÿ���ַ����ᱻ�Ƚ�һ�Ρ�
 * �ռ䣺O(1)
 */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        String ans = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(ans) != 0) {  //""���κ��ַ������Ӵ��������ֱ������whileѭ������˲��ù��������
                ans = ans.substring(0, ans.length() - 1);   //ÿ�ν���һ���ַ���ĩβɾ��һλ��ֱ�����ǵ�ǰ�ַ������Ӵ�
            }
        }
        return ans;
    }

    /**
     * �ⷨ������ֱɨ��
     * �ӵ�һ���ַ���ʼ�ж������ַ�����λ�õ��ַ��Ƿ���ͬ����������ӵ�stringbuilder�У�����ֱ�ӷ��ؼ��ɵõ������ǰ׺
     *
     * ʱ�䣺O(mn)������m���ַ��������е��ַ�����ƽ�����ȣ�n���ַ����������������£�Ҳ����û�й���ǰ׺����������ַ��������е�
     * ÿ���ַ�����ÿ���ַ����ᱻ�Ƚ�һ�Ρ�
     * �ռ䣺O(1)
     */
/*    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs[0].length(); i++) {
            char ch = strs[0].charAt(i);
            int j = 1;
            for (; j < strs.length; j++) {
                if (i >= strs[j].length() || strs[j].charAt(i) != ch) {
                    break;
                }
            }
            if (j == strs.length) {
                sb.append(ch);
            } else {
                break;
            }
        }
        return sb.toString();
    }*/
}
