package practice.leetcode.UnionFindSet;

public class LCR116 {
    public static void main(String[] args) {
        SolutionLCR116 s = new SolutionLCR116();
        int ans = s.findCircleNum(new int[][]{
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}});
        System.out.println(ans);
    }
}

/**
 * <a href="https://leetcode.cn/problems/bLyHh0/description/">LCR 116. ʡ������</a>
 */
class SolutionLCR116 {
    /**
     * �ⷨһ�����鼯
     * ���鼯�ļ򵥽��ܣ�<a href="https://zhuanlan.zhihu.com/p/93647900">���鼯</a>
     * ˼·��
     * �����������ڵ�0��1��2�����н����������
     * 1����ʼ��һ����СΪ�ڵ�����������parent��Ԫ�س�ʼֵΪ��Ԫ�ص��±꣬��parent[i]=i����ʾÿ���ڵ�ĸ�Ԫ�������Լ�
     * ���磺[0,1,2]
     * 2�����ڲ��鼯�����ǲ���Ҫ֪��ͼ�нڵ�ķ�������ֻ����ͼ������С���Ǽ��ɡ���graph[i][j]==1ʱ����ʾ�ڵ�
     * i��j��ͨ����ʱ���ǽ��ڵ�i��j�ϲ����ϲ����Ϊ��[1,2,2]����ʾ�ڵ�0��1�ĸ��ڵ㶼�ǽڵ�2
     * 3���ٱ���һ��parent���飬��parent[i]!=iʱ����ʾ�ڵ�i��ĳ�������е���Ԫ�أ�������ĳ�����ϵĸ��ڵ㣬
     * ����ֻ��Ҫͳ�Ƹ��ڵ����������Ϊ�ϲ��Ժ󼯺ϵ�������
     * ʱ�临�Ӷȣ�O(n^2logn)
     * �ռ临�Ӷȣ�O(n)
     */
    public int findCircleNum(int[][] isConnected) {
        int cities = isConnected.length;
        int[] parent = new int[cities];
        for (int i = 0; i < cities; i++) {
            parent[i] = i;
        }
        for (int i = 0; i < cities; i++) {
            for (int j = i + 1; j < cities; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }
        int provinces = 0;
        for (int i = 0; i < cities; i++) {
            if (parent[i] == i) {
                provinces++;
            }
        }
        return provinces;
    }

    /**
     * ���ڵ�1�ͽڵ�2�ĸ��ڵ�r1��r2�ϲ��������ǽ�r2��Ϊ�ϲ���ĸ��ڵ㣬Ҳ����r1ָ��r2
     */
    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    /**
     * ����index�ڵ�ĸ��ڵ�
     */
    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            //��ǰ�ڵ㲻�Ǹ��ڵ㣬��ݹ��������ڵ㣬��������ǰ�ڵ�
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}