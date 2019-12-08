package DataStructure.Graph;

import java.util.*;

public class Graph {
    private final int vertexNum = 5;    //邻接表节点个数
    private listNode[] list = new listNode[vertexNum];  //邻接表储存图
    private int[] book = new int[vertexNum];     //邻接表的访问标记数组

    public static void main(String[] args) {
        Graph graph = new Graph();
        listNode[] heads = graph.createGraphByLists();
        System.out.println("邻接表的深搜递归遍历：");
        graph.dfs_digui_lists(heads, 0);
        System.out.println("\n邻接表的深搜非递归遍历：");
        graph.dfs_lists(heads, 0);
        System.out.println("邻接表的广搜遍历：");
        graph.bfs_lists(heads);

//        int[][] e = graph.createGraphByArray();
//        System.out.println("\n二维数组的深搜遍历：");
//        int[] markArr = new int[e.length];   //二维数组的标记数组
//        graph.dfs_array(e, 1, markArr);
//        System.out.println("\n二维数组的广搜遍历：");
//        graph.bfs_array(e);
    }

/*
    //深搜遍历二维数组
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

    //广搜遍历二维数组
    private void bfs_array(int[][] e) {

    }*/

    /**
     * 创建以二维数组储存的图
     */
    private int[][] createGraphByArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("是否有向图？（是输入y，否输入n）");
        String t = sc.next();
        boolean isDirected = false;
        if ("y".equals(t)) {
            isDirected = true;
        } else if ("n".equals(t)) {
        } else {
            System.out.println("错误，请重新输入");
        }
        System.out.println("输入节点和边数：");
        int nodeNum = sc.nextInt();
        int edgeNum = sc.nextInt();
        int[][] e = new int[nodeNum + 1][nodeNum + 1];
        if (isDirected) {   //有向图
            for (int i = 0; i < edgeNum; i++) {
                for (int j = 0; j < edgeNum; j++) {
                    if (i == j) {
                        e[i][j] = 666666;       //设666666为正无穷
                    }
                }
            }
            System.out.println("输入各顶点之间的边：");
            for (int i = 0; i < edgeNum; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                e[a][b] = 1;
            }

        } else {        //无向图
            System.out.println("输入各顶点之间的边：");
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
     * 邻接表的深搜遍历(递归)
     */
    private void dfs_digui_lists(listNode[] list, int i) {   //i为出发点
        book[i] = 1;     //1表示已经访问过
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
     * 邻接表的深搜（非递归）
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
     * 邻接表的广搜遍历
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
     * 创建以邻接表储存的图
     */
    private listNode[] createGraphByLists() {
        //初始化链表所有头节点
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
     * 增加边的方法
     */
    private void addEdge(int i, int j, int weight) {
        listNode tem = list[i].next;
        listNode node = new listNode(j, weight);
        list[i].next = node;        //头插法
        node.next = tem;
    }


}

/**
 * 节点类
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