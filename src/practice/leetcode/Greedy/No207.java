package practice.leetcode.Greedy;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class No207 {
    public static void main(String[] args) {
        Solution207 s = new Solution207();
        s.canFinish(5, new int[][]{
//                {4, 0},
//                {3, 1},
//                {3, 2},
//                {4, 3},
                {0, 1}
        });
    }
}

class Solution207 {

    /**
     * 题目：课程表，给定课程总量以及它们的先决条件，请你判断是否可能完成所有课程的学习？
     *
     * 解法一：图的拓扑排序（广搜的思想）
     * 思路：记录每个节点的入度和后继结点（只能记录后继），开始时先将入度为0的所有节点入队，然后将这些节点删除（将它们的后继结点入度-1），
     * 并将删除后入度为0的节点继续入队，重复这个过程，直到队空
     *
     * 时间复杂度：O(E+V)。这里E表示邻边的条数，V表示结点的个数。初始化入度为0的集合需要遍历整张图，具体做法是检查每个结点和每条边，
     * 因此复杂度为O(E+V)，然后对该集合进行操作，又需要遍历整张图中的每个结点和每条边，复杂度也为 O(E+V)
     * 空间复杂度：O(E+V)：邻接表长度是V，每个课程里又保存了它所有的边。
     */
    /*public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 特判
        if (numCourses <= 0) {
            return false;
        }
        int pLen = prerequisites.length;
        if (pLen == 0) {
            return true;
        }

        int[] inDegree = new int[numCourses];                       //记录每个节点的入度
        LinkedList<Integer>[] list = new LinkedList[numCourses];    //数组中每个list记录该元素的所有后继结点，即邻接表的作用
        Queue<Integer> queue = new LinkedList<>();                  //记录当前入度为0的所有节点

        for (int i = 0; i < numCourses; i++) {      //初始化list
            list[i] = new LinkedList<>();
        }
        for (int[] p : prerequisites) {     //遍历二维数组，记录每个节点的入度和所有后继结点
            inDegree[p[0]]++;
            list[p[1]].add(p[0]);
        }
        for (int i = 0; i < inDegree.length; i++) { //入度为0的节点全部入队
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int cnt = 0;    //记录加入过队列的节点，拓扑排序中每个节点仅会出现一次，如果图中有元素成环，则cnt ！= numCourses
        while (!queue.isEmpty()) {
            Integer top = queue.poll();
            cnt++;
            for (Integer next : list[top]) {    //获取当前节点top所有的后继节点
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return cnt == numCourses;
    }*/


    /**
     * 解法二：DFS，也就是递归，了解即可，拓扑排序广搜更常用
     *
     * 思路：通过无向图记录每个节点的前驱（后继也是可以的），用一个flag数组记录每个节点的访问情况，然后遍历每个节点进行dfs，
     * 深捜中遍历当前节点的所有前驱，并更新当前节点的访问状态（flag数组），根据当前节点访问的状态来判断图中是否有环
     *
     * 时间：O(E+V)，无向图长度为节点个数，每个元素又记录了该节点的所有前驱
     * 空间：O(E+V)
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if (numCourses <= 0) {
            return false;
        }
        int pLen = prerequisites.length;
        if (pLen == 0) {
            return true;
        }

        int[] flag = new int[numCourses];
        HashSet<Integer>[] graph = new HashSet[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new HashSet<>();
        }
        for (int[] p : prerequisites) {
            graph[p[0]].add(p[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, flag)) {
                return false;
            }
        }
        return true;
    }

    /**
     * 从节点i开始搜索前驱和后继，并进行递归
     *
     * @param i     当前节点下标
     * @param graph 无向图
     * @param flag  标记数组，flag状态：1代表正在访问，2代表访问过。仅当深捜过程中当前元素正在访问（为1）时才能判断成环
     * @return  返回true表示图中有环，否则并不代表图中无环，只是当前节点深捜的过程中没有环
     */
    private boolean dfs(int i, HashSet<Integer>[] graph, int[] flag) {
        if (flag[i] == 1) {
            return true;
        } else if (flag[i] == 2) {
            return false;
        }
        flag[i] = 1;
        for (Integer nextNode : graph[i]) {
            if (dfs(nextNode, graph, flag)) {
                return false;
            }
        }
        flag[i] = 2;
        return false;
    }
}