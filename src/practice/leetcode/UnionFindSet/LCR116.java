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
 * <a href="https://leetcode.cn/problems/bLyHh0/description/">LCR 116. 省份数量</a>
 */
class SolutionLCR116 {
    /**
     * 解法一：并查集
     * 并查集的简单介绍：<a href="https://zhuanlan.zhihu.com/p/93647900">并查集</a>
     * 思路：
     * 假设有三个节点0，1，2，其中结点两两相连
     * 1、初始化一个大小为节点数量的数组parent；元素初始值为该元素的下标，即parent[i]=i，表示每个节点的父元素是它自己
     * 例如：[0,1,2]
     * 2、对于并查集，我们不需要知道图中节点的方向，所以只遍历图的右上小三角即可。当graph[i][j]==1时，表示节点
     * i和j连通，此时我们将节点i和j合并。合并结果为：[1,2,2]，表示节点0和1的父节点都是节点2
     * 3、再遍历一次parent数组，当parent[i]!=i时，表示节点i是某个集合中的子元素，否则是某个集合的根节点，
     * 我们只需要统计根节点的数量，即为合并以后集合的数量。
     * 时间复杂度：O(n^2logn)
     * 空间复杂度：O(n)
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
     * 将节点1和节点2的根节点r1和r2合并，这里是将r2作为合并后的根节点，也就是r1指向r2
     */
    public void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }

    /**
     * 查找index节点的根节点
     */
    public int find(int[] parent, int index) {
        if (parent[index] != index) {
            //当前节点不是根节点，则递归查找其根节点，并赋给当前节点
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }
}