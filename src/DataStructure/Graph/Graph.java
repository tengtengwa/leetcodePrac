package DataStructure.Graph;

import java.util.*;

public class Graph {
    private final int vertexNum = 5;                    //邻接表节点个数
    private ListNode[] list = new ListNode[vertexNum];  //邻接表储存图
    private int[] book = new int[vertexNum];            //邻接表的访问标记数组
    private static int[][] e = new int[101][101];       //储存图的二维数组
    private int[] markArr = new int[101];               //二维数组的标记数组
    private boolean isDirect;                           //以二维数组储存的图是否是有向图

    public static void main(String[] args) {
        Graph graph = new Graph();
        ListNode[] heads = graph.createGraphByLists();
        System.out.println("邻接表的深搜递归遍历：");
        graph.dfs_digui_lists(heads, 0);
        System.out.println("\n邻接表的深搜非递归遍历：");
        graph.dfs_lists(heads);
        System.out.println("邻接表的广搜遍历：");
        graph.bfs_lists(heads);

        e = graph.createGraphByArray();
        System.out.println("\n二维数组的深搜遍历：");
        graph.dfs_array(1);

        System.out.println("\n二维数组的广搜遍历：");
        graph.bfs_array();

        System.out.println("该图是否连通：" + graph.isConnected(e));

    }


    /**
     * 深搜遍历二维数组
     */
    private int sum = 0;
    private void dfs_array(int cur) {
        sum++;
        System.out.print(cur + " ");
        int n = e.length - 1;   //顶点的总个数
        if (sum == n) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (e[cur][i] == 1 && markArr[i] == 0) {
                if (!isDirect) {
                    markArr[cur] = 1;
                }
                markArr[i] = 1;
                dfs_array(i);
            }
        }
    }

    private void dfs_Array(int cur) {
        sum++;
        int n = e.length - 1;   //顶点的总个数
        if (sum == n) {
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (e[cur][i] == 1 && markArr[i] == 0) {
                if (!isDirect) {
                    markArr[cur] = 1;
                }
                markArr[i] = 1;
                ++num;
                isConnected = false;
                dfs_Array(i);
            }
        }
    }

    /**
     * 广搜遍历二维数组
     */
    private void bfs_array() {
        Arrays.fill(markArr, 0);    //重置标记数组
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        markArr[1] = 1;
        System.out.print(1 + " ");
        while (!queue.isEmpty()) {
            int cur = queue.poll();
            for (int i = 1; i < e.length; i++) {
                if (e[cur][i] == 1 && markArr[i] == 0) {
                    System.out.print(i + " ");
                    if (isDirect) markArr[cur] = 1;
                    queue.add(i);
                    markArr[i] = 1;
                }
            }
        }
        System.out.println();
    }


    /**
     * 创建以二维数组储存的图
     */
    private int[][] createGraphByArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n创建以二维数组储存的图:\n" + "是否有向图？（是输入y，否输入n）");
        String t = sc.next();
        boolean isDirected = false;
        if ("y".equals(t)) {
            isDirected = true;
            isDirect = true;
        } else if ("n".equals(t)) {
            isDirect = false;
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
    private void dfs_digui_lists(ListNode[] list, int i) {   //i为出发点
        book[i] = 1;                    //1表示已经访问过
        ListNode p = list[i];           //p指向i节点
        System.out.print(p.num + " ");
        while (p != null) {                  //当前节点有相连的节点
            if (book[p.num] != 1) {          //当前节点未被访问过
                dfs_digui_lists(list, p.num); //访问第一个与i节点相连的节点
            }
            p = p.next;                      //遍历与i节点相连的节点
        }
    }

    /**
     * 邻接表的深搜（非递归）
     */
    private void dfs_lists(ListNode[] list) {
        Stack<Integer> stack = new Stack<>();
        int[] visited = new int[list.length];
        stack.add(0);
        while (!stack.isEmpty()) {
            int n = stack.pop();
            if (visited[n] == 0) {
                visited[n] = 1;
                System.out.print(n + " ");
            }
            ListNode p = list[n];
            while (p != null) {
                if (visited[p.num] == 0) {
                    stack.add(p.num);
                }
                p = p.next;
            }
        }
        System.out.println();
    }


    /**
     * 邻接表的广搜遍历
     */
    private void bfs_lists(ListNode[] list) {
        ListNode p;
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
    private ListNode[] createGraphByLists() {
        //初始化链表所有头节点
        for (int i = 0; i < vertexNum; i++) {
            ListNode headi = new ListNode(i);
            list[i] = headi;
        }
        addEdge(0, 4);
        addEdge(0, 2);
        addEdge(0, 1);
        addEdge(1, 3);
        return list;
    }

    /**
     * 增加边的方法
     */
    private void addEdge(int i, int j) {
        ListNode tem = list[i].next;
        ListNode node = new ListNode(j);
        list[i].next = node;        //头插法
        node.next = tem;
    }


    /**
     * 判断一个以邻接矩阵储存的图是否连通，并打印连通分支个数
     */
    private Integer num = 1;        //连通分量大小
    private boolean isConnected = true;
    private boolean isConnected(int[][] e) {
        int[] book = new int[e.length];
        for (int i = 0; i < e.length; i++) {
            sum = 0;
            if (book[i] == 0) {
                book[i] = 1;
                dfs_Array(i);
            }
        }
        System.out.println("\n连通分量个数：" + num);
        return isConnected;
    }

}

/**
 * 节点类
 */
class ListNode {
    public ListNode(int num) {
        this.num = num;
    }

    int num;
    ListNode next;
}