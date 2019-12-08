package DataStructure.Graph;

import java.util.*;

public class Graph {
    private final int vertexNum = 5;    //�ڽӱ�ڵ����
    private listNode[] list = new listNode[vertexNum];  //�ڽӱ���ͼ
    private int[] book = new int[vertexNum];     //�ڽӱ�ķ��ʱ������

    public static void main(String[] args) {
        Graph graph = new Graph();
        listNode[] heads = graph.createGraphByLists();
        System.out.println("�ڽӱ�����ѵݹ������");
        graph.dfs_digui_lists(heads, 0);
        System.out.println("\n�ڽӱ�����ѷǵݹ������");
        graph.dfs_lists(heads, 0);
        System.out.println("�ڽӱ�Ĺ��ѱ�����");
        graph.bfs_lists(heads);

//        int[][] e = graph.createGraphByArray();
//        System.out.println("\n��ά��������ѱ�����");
//        int[] markArr = new int[e.length];   //��ά����ı������
//        graph.dfs_array(e, 1, markArr);
//        System.out.println("\n��ά����Ĺ��ѱ�����");
//        graph.bfs_array(e);
    }

/*
    //���ѱ�����ά����
    private int sum = 0;
    private void dfs_array(int cur, int[] markArr) {
        System.out.print(cur + " ");
        sum++;
        int n = e.length - 1;
        if (sum == n) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (e[cur][i] == 1 && markArr[i] == 0) {
                markArr[i] = 1;
                dfs_array(e, i, markArr);
            }
        }
    }

    //���ѱ�����ά����
    private void bfs_array(int[][] e) {

    }*/

    /**
     * �����Զ�ά���鴢���ͼ
     */
    private int[][] createGraphByArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("�Ƿ�����ͼ����������y��������n��");
        String t = sc.next();
        boolean isDirected = false;
        if ("y".equals(t)) {
            isDirected = true;
        } else if ("n".equals(t)) {
        } else {
            System.out.println("��������������");
        }
        System.out.println("����ڵ�ͱ�����");
        int nodeNum = sc.nextInt();
        int edgeNum = sc.nextInt();
        int[][] e = new int[nodeNum + 1][nodeNum + 1];
        if (isDirected) {   //����ͼ
            for (int i = 0; i < edgeNum; i++) {
                for (int j = 0; j < edgeNum; j++) {
                    if (i == j) {
                        e[i][j] = 666666;       //��666666Ϊ������
                    }
                }
            }
            System.out.println("���������֮��ıߣ�");
            for (int i = 0; i < edgeNum; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                e[a][b] = 1;
            }

        } else {        //����ͼ
            System.out.println("���������֮��ıߣ�");
            for (int i = 0; i < edgeNum; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                e[a][b] = 1;
                e[b][a] = 1;
            }
        }
        return e;
    }

    /**
     * �ڽӱ�����ѱ���(�ݹ�)
     */
    private void dfs_digui_lists(listNode[] list, int i) {   //iΪ������
        book[i] = 1;     //1��ʾ�Ѿ����ʹ�
        listNode p = list[i];
        System.out.print(p.num + " ");
        while (p != null) {
            if (book[p.num] != 1) {
                dfs_digui_lists(list, p.num);
            }
            p = p.next;
        }
    }

    /**
     * �ڽӱ�����ѣ��ǵݹ飩
     */
    private void dfs_lists(listNode[] list, int i) {
        Stack<listNode> stack = new Stack<>();
        int[] visited = new int[list.length];
        stack.push(list[0]);
        while (!stack.isEmpty()) {
            listNode v = stack.pop();
            if (visited[v.num] == 0) {
                System.out.print(v.num + " ");
                visited[v.num] = 1;
            }
            listNode p = list[v.num];
            while (p != null) {
                if (visited[p.num] == 0) {
                    System.out.print(p.num + " ");
                    visited[p.num] = 1;
                    stack.push(list[p.num]);
                }
                p = p.next;
            }
        }
        System.out.println();
    }


    /**
     * �ڽӱ�Ĺ��ѱ���
     */
    private void bfs_lists(listNode[] list) {
        listNode p;
        Queue<Integer> queue = new LinkedList<>();
        Arrays.fill(book, 0);
        for (int i = 0; i < list.length; i++) {
            if (book[i] == 0) {
                book[i] = 1;
                System.out.print(list[i].num + " ");
                queue.add(i);
                while (!queue.isEmpty()) {
                    i = queue.poll();
                    p = list[i];
                    while (p != null) {
                        if (book[p.num] == 0) {
                            book[p.num] = 1;
                            System.out.print(p.num + " ");
                            queue.add(p.num);
                        }
                        p = p.next;
                    }
                }
            }
        }
        System.out.println();
    }

    /**
     * �������ڽӱ����ͼ
     */
    private listNode[] createGraphByLists() {
        //��ʼ����������ͷ�ڵ�
        for (int i = 0; i < vertexNum; i++) {
            listNode headi = new listNode(i, null);
            list[i] = headi;
        }
//        addEdge(0, 4, 6);
//        addEdge(1, 0, 9);
//        addEdge(1, 2, 3);
//        addEdge(2, 0, 2);
//        addEdge(2, 3, 5);
//        addEdge(3, 4, 1);
        addEdge(0, 4, 9);
        addEdge(0, 2, 3);
        addEdge(0, 1, 2);
        addEdge(1, 3, 5);
        return list;
    }

    /**
     * ���ӱߵķ���
     */
    private void addEdge(int i, int j, int weight) {
        listNode tem = list[i].next;
        listNode node = new listNode(j, weight);
        list[i].next = node;        //ͷ�巨
        node.next = tem;
    }


}

/**
 * �ڵ���
 */
class listNode {
    public listNode(int num, Integer weight) {
        this.num = num;
        this.weight = weight;
    }

    int num;
    Integer weight;
    listNode next;
}