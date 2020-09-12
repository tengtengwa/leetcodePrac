package practice.leetcode.Recursion;

import java.util.HashMap;

public class No437 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(-3);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(2);
        root.right.right = new TreeNode(11);
        root.left.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(-2);
        root.left.right.right = new TreeNode(1);
        Solution437 s = new Solution437();
        s.pathSum(root, 8);
    }
}

class Solution437 {
    /**
     * ��Ŀ��·���ܺ�3���ҳ���������·������ֵ���ڸ���sum�ĸ�����·������ֻ�����£�ֻ�ܴӸ��ڵ㵽�ӽڵ㣩
     *
     * �ⷨһ��DFS���������������ʹ��һ�������¼��ǰ·�����ϵ������нڵ��ֵ��ÿ�εݹ�ӵ�ǰ�ڵ�����Ѱ�ң����Ǵ�������
     * ��ǰָ��Ľڵ�����һ�����ӣ�
     *
     * ʱ�临�Ӷȣ�����n���ڵ㣬Ϊÿ���ڵ�����Ե�ǰ�ڵ�Ϊ·���յ������·���ͣ�ƽ��·��������logn������ƽ��ʱ�临�Ӷ���O(nlogn)
     */
/*    int ans = 0;
    public int pathSum(TreeNode root, int sum) {
        dfs(root, sum, new int[1000], 0);
        return ans;
    }

    private void dfs(TreeNode root, int sum, int[] arr, int size) {
        if (root == null) {
            return;
        }
        int tem = root.val;
        if (tem == sum) {       //�����ǰ�ڵ��ֵ�͵���sum��·������+1
            ans++;
        }
        for (int i = size - 1; i >= 0; i--) {   //����Ӻ���ǰ����������׷�ݣ�����size-1���ǵ�ǰ�ڵ�ĸ��ڵ㣬
            tem += arr[i];
            if (tem == sum) {
                ans++;
            }
        }
        //���鵱ǰ���һ��Ԫ����Ϊ��ǰ�ڵ��ֵ����һ��������ӽڵ�����׷��ʱ�ͻ����Ÿ��ڵ�����׷��
        arr[size] = root.val;
        dfs(root.left, sum, arr, size + 1);
        dfs(root.right, sum, arr, size + 1);
    }*/

    /**
     * �ⷨ��������+��ϣ��
     * ͨ����ϣ���¼��ǰ�Ӹ��ڵ㵽��ǰ�ڵ������·�����ȣ�ÿ�εݹ�ʱͨ��map.containsKey(curSum - sum)�жϵ�ǰ·����
     * �Ƿ���ڳ���Ϊsum����·�������µݹ�ʱ�ڹ�ϣ���и���ǰ���Ⱥ͵�·������+1������ʱ-1�����ص�ǰ�㳤��Ϊsum��·����
     *
     * ʱ�䣺O(n)�����нڵ㶼��������һ��
     */
    public int pathSum(TreeNode root, int sum) {
        HashMap<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);      //��ֹ����curSum==sum�����
        return helper(root, sum, 0, map);
    }

    private int helper(TreeNode root, int sum, int curSum, HashMap<Integer, Integer> map) {
        if (root == null) {
            return 0;
        }
        int res = 0;
        curSum += root.val;     //curSumΪ���ڵ㵽��ǰ�ڵ��·����
        if (map.containsKey(curSum - sum)) {
            res += map.get(curSum - sum);
        }
        map.put(curSum, map.getOrDefault(curSum, 0) + 1);   //���ڵ㵽��ǰ�ڵ㳤�ȵ�·������+1
        res += helper(root.left, sum, curSum, map);
        res += helper(root.right, sum, curSum, map);
        map.put(curSum, map.getOrDefault(curSum, 0) - 1);   //���ݣ�·����-1
        return res;
    }
}