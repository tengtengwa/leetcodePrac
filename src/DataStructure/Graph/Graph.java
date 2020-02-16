package DataStructure.Graph;

import java.util.*;

public class Graph {
    private final int vertexNum = 5;                    //�ڽӱ�ڵ����
    private ListNode[] list = new ListNode[vertexNum];  //�ڽӱ���ͼ
    private int[] book = new int[vertexNum];            //�ڽӱ�ķ��ʱ������
    private static int[][] e = new int[101][101];       //����ͼ�Ķ�ά����
    private int[] markArr = new int[101];               //��ά����ı������
    private boolean isDirect;                           //�Զ�ά���鴢���ͼ�Ƿ�������ͼ

    public static void main(String[] args) {
        Graph graph = new Graph();
        ListNode[] heads = graph.createGraphByLists();
        System.out.println("�ڽӱ�����ѵݹ������");
        graph.dfs_digui_lists(heads, 0);
        System.out.println("\n�ڽӱ�����ѷǵݹ������");
        graph.dfs_lists(heads);
        System.out.println("�ڽӱ�Ĺ��ѱ�����");
        graph.bfs_lists(heads);

        e = graph.createGraphByArray();
        System.out.println("\n��ά��������ѱ�����");
        graph.dfs_array(1);

        System.out.println("\n��ά����Ĺ��ѱ�����");
        graph.bfs_array();

        System.out.println("��ͼ�Ƿ���ͨ��" + graph.isConnected(e));

    }


    /**
     * ���ѱ�����ά����
     */
    private int sum = 0;
    private void dfs_array(int cur) {
        sum++;
        System.out.print(cur + " ");
        int n = e.length - 1;   //������ܸ���
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
        int n = e.length - 1;   //������ܸ���
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
     * ���ѱ�����ά����
     */
    private void bfs_array() {
        Arrays.fill(markArr, 0);    //���ñ������
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
     * �����Զ�ά���鴢���ͼ
     */
    private int[][] createGraphByArray() {
        Scanner sc = new Scanner(System.in);
        System.out.println("\n�����Զ�ά���鴢���ͼ:\n" + "�Ƿ�����ͼ����������y��������n��");
        String t = sc.next();
        boolean isDirected = false;
        if ("y".equals(t)) {
            isDirected = true;
            isDirect = true;
        } else if ("n".equals(t)) {
            isDirect = false;
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
    private void dfs_digui_lists(ListNode[] list, int i) {   //iΪ������
        book[i] = 1;                    //1��ʾ�Ѿ����ʹ�
        ListNode p = list[i];           //pָ��i�ڵ�
        System.out.print(p.num + " ");
        while (p != null) {                  //��ǰ�ڵ��������Ľڵ�
            if (book[p.num] != 1) {          //��ǰ�ڵ�δ�����ʹ�
                dfs_digui_lists(list, p.num); //���ʵ�һ����i�ڵ������Ľڵ�
            }
            p = p.next;                      //������i�ڵ������Ľڵ�
        }
    }

    /**
     * �ڽӱ�����ѣ��ǵݹ飩
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
     * �ڽӱ�Ĺ��ѱ���
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
     * �������ڽӱ����ͼ
     */
    private ListNode[] createGraphByLists() {
        //��ʼ����������ͷ�ڵ�
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
     * ���ӱߵķ���
     */
    private void addEdge(int i, int j) {
        ListNode tem = list[i].next;
        ListNode node = new ListNode(j);
        list[i].next = node;        //ͷ�巨
        node.next = tem;
    }


    /**
     * �ж�һ�����ڽӾ��󴢴��ͼ�Ƿ���ͨ������ӡ��ͨ��֧����
     */
    private Integer num = 1;        //��ͨ������С
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
        System.out.println("\n��ͨ����������" + num);
        return isConnected;
    }

}

/**
 * �ڵ���
 */
class ListNode {
    public ListNode(int num) {
        this.num = num;
    }

    int num;
    ListNode next;
}