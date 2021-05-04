package practice.leetcodeOffer;

public class No12 {
    public static void main(String[] args) {
        Solution12 s = new Solution12();
        boolean exist = s.exist(new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}}, "ABCCED");
        System.out.println(exist);
    }
}

class Solution12 {
    /**
     * ��Ŀ�������е�·����
     * ����һ����ά���飬Ѱ���������Ƿ���ָ���ַ��������򷵻�true��û�з���false�����ʱ��밴����ĸ˳��ͨ�����ڵĵ�Ԫ���ڵ���ĸ���ɣ�
     * ���С����ڡ���Ԫ������Щˮƽ���ڻ�ֱ���ڵĵ�Ԫ��ͬһ����Ԫ���ڵ���ĸ�������ظ�ʹ�á�
     * https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
     */
    /**
     * �ⷨ��DFS
     * ˼·���;��������˼·����һ�£����������Ŀ�������ַ�����Ҫ������ĸ���������Ҫ��¼��ǰ�ַ���
     * ��Ҫע���һ���ǣ���Ҫͨ����֦�������Ѿ����ʵ�·���͵�ǰ�����ܵ�·���������ڵ�ǰ������ɷ���ǰ����¼��·����ԭ
     *
     * ʱ�䣺O(n^2*3^k)��kΪ�ַ������ȣ����ռ䣺O(n)
     */
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (dfs(board, row, col, 0, words)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, int curIndex, char[] word) {
        if (row < 0 || row >= board.length || col < 0 || col >= board[0].length || board[row][col] != word[curIndex]) {
            return false;
        }
        if (curIndex == word.length - 1) {  //�Ѿ��������ַ�����ֱ�ӷ���true
            return true;
        }
        board[row][col] = '��';  //��¼��ǰ�߹���·������Ŀû��˵�����޸����飬����ֱ����ԭ�������޸�
        boolean res = dfs(board, row, col - 1, curIndex + 1, word) || dfs(board, row - 1, col, curIndex + 1, word)
                || dfs(board, row, col + 1, curIndex + 1, word) || dfs(board, row + 1, col, curIndex + 1, word);
        board[row][col] = word[curIndex];   //��ǰ������ɺ����鸴ԭ
        return res;
    }
}