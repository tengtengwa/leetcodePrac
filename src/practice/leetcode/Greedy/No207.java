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
     * ��Ŀ���γ̱������γ������Լ����ǵ��Ⱦ������������ж��Ƿ����������пγ̵�ѧϰ��
     *
     * �ⷨһ��ͼ���������򣨹��ѵ�˼�룩
     * ˼·����¼ÿ���ڵ����Ⱥͺ�̽�㣨ֻ�ܼ�¼��̣�����ʼʱ�Ƚ����Ϊ0�����нڵ���ӣ�Ȼ����Щ�ڵ�ɾ���������ǵĺ�̽�����-1����
     * ����ɾ�������Ϊ0�Ľڵ������ӣ��ظ�������̣�ֱ���ӿ�
     *
     * ʱ�临�Ӷȣ�O(E+V)������E��ʾ�ڱߵ�������V��ʾ���ĸ�������ʼ�����Ϊ0�ļ�����Ҫ��������ͼ�����������Ǽ��ÿ������ÿ���ߣ�
     * ��˸��Ӷ�ΪO(E+V)��Ȼ��Ըü��Ͻ��в���������Ҫ��������ͼ�е�ÿ������ÿ���ߣ����Ӷ�ҲΪ O(E+V)
     * �ռ临�Ӷȣ�O(E+V)���ڽӱ�����V��ÿ���γ����ֱ����������еıߡ�
     */
    /*public boolean canFinish(int numCourses, int[][] prerequisites) {
        // ����
        if (numCourses <= 0) {
            return false;
        }
        int pLen = prerequisites.length;
        if (pLen == 0) {
            return true;
        }

        int[] inDegree = new int[numCourses];                       //��¼ÿ���ڵ�����
        LinkedList<Integer>[] list = new LinkedList[numCourses];    //������ÿ��list��¼��Ԫ�ص����к�̽�㣬���ڽӱ������
        Queue<Integer> queue = new LinkedList<>();                  //��¼��ǰ���Ϊ0�����нڵ�

        for (int i = 0; i < numCourses; i++) {      //��ʼ��list
            list[i] = new LinkedList<>();
        }
        for (int[] p : prerequisites) {     //������ά���飬��¼ÿ���ڵ����Ⱥ����к�̽��
            inDegree[p[0]]++;
            list[p[1]].add(p[0]);
        }
        for (int i = 0; i < inDegree.length; i++) { //���Ϊ0�Ľڵ�ȫ�����
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        int cnt = 0;    //��¼��������еĽڵ㣬����������ÿ���ڵ�������һ�Σ����ͼ����Ԫ�سɻ�����cnt ��= numCourses
        while (!queue.isEmpty()) {
            Integer top = queue.poll();
            cnt++;
            for (Integer next : list[top]) {    //��ȡ��ǰ�ڵ�top���еĺ�̽ڵ�
                inDegree[next]--;
                if (inDegree[next] == 0) {
                    queue.add(next);
                }
            }
        }
        return cnt == numCourses;
    }*/


    /**
     * �ⷨ����DFS��Ҳ���ǵݹ飬�˽⼴�ɣ�����������Ѹ�����
     *
     * ˼·��ͨ������ͼ��¼ÿ���ڵ��ǰ�������Ҳ�ǿ��Եģ�����һ��flag�����¼ÿ���ڵ�ķ��������Ȼ�����ÿ���ڵ����dfs��
     * ����б�����ǰ�ڵ������ǰ���������µ�ǰ�ڵ�ķ���״̬��flag���飩�����ݵ�ǰ�ڵ���ʵ�״̬���ж�ͼ���Ƿ��л�
     *
     * ʱ�䣺O(E+V)������ͼ����Ϊ�ڵ������ÿ��Ԫ���ּ�¼�˸ýڵ������ǰ��
     * �ռ䣺O(E+V)
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
     * �ӽڵ�i��ʼ����ǰ���ͺ�̣������еݹ�
     *
     * @param i     ��ǰ�ڵ��±�
     * @param graph ����ͼ
     * @param flag  ������飬flag״̬��1�������ڷ��ʣ�2������ʹ���������ȹ����е�ǰԪ�����ڷ��ʣ�Ϊ1��ʱ�����жϳɻ�
     * @return  ����true��ʾͼ���л������򲢲�����ͼ���޻���ֻ�ǵ�ǰ�ڵ���ȵĹ�����û�л�
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