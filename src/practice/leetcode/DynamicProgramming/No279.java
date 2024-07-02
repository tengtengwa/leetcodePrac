package practice.leetcode.DynamicProgramming;

public class No279 {
    public static void main(String[] args) {
        Solution279 s = new Solution279();
        s.numSquares(12);
    }
}

class Solution279 {
    /**
     * ��Ŀ����ȫƽ���������������� n���ҵ����ɸ���ȫƽ���������� 1, 4, 9, 16, ...��ʹ�����ǵĺ͵��� n��
     * ����Ҫ����ɺ͵���ȫƽ�����ĸ������١�
     *
     * �ⷨһ�������ݹ�(BFS)����Ƕ��forѭ������ѭ��д���˵ݹ����ʽ��
     * ����ʹ��HashMap�����Ż��������ͺ������ڶ�̬�滮��
     */
/*    public int numSquares(int n) {
        return numSquaresHelper(n);
    }

    Map<Integer, Integer> map = new HashMap<>();
    private int numSquaresHelper(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }
        if (n == 0) {
            return 0;
        }
        int count = Integer.MAX_VALUE;
        //���μ�ȥһ��ƽ����
        for (int i = 1; i * i <= n; i++) {
            //ѡ��С��
            count = Math.min(count, numSquaresHelper(n - i * i) + 1);
        }
        map.put(n, count);
        return count;
    }*/

    /**
     * �ⷨ������̬�滮
     * ״̬ת�Ʒ��̣�numSquares(n)=min(numSquares(n-k) + 1) ��k������ȫƽ������
     *
     * ʱ�临�Ӷȣ�(n*sqrt(n)) ���������У�������һ��Ƕ��ѭ���������ⲿѭ����n�ε��������ڲ�ѭ�������Ҫsqrt(n)�ε�����
     * �ռ临�Ӷȣ�O(n)��ʹ����һ��һά���� dp��
     */
/*    public int numSquares(int n) {
        int[] dp = new int[n + 1];      // �����СΪn+1��Ĭ�ϳ�ʼ��ֵ��Ϊ0
        for (int i = 1; i <= n; i++) {
            dp[i] = i;                  //ÿ��λ��i�������ȫƽ�������ᳬ���Լ�
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // ��̬ת�Ʒ���
            }
        }
        return dp[n];
    }*/

    /**
     * �ⷨ����BFS
     * ˼·��BFS �Ļ������ǿ���һ��һ����㡣��һ�����μ�ȥһ��ƽ�����õ��ڶ��㣬�ڶ������μ�ȥһ��ƽ�����õ������㡣
     * ֱ��ĳһ������� 0����ʱ�Ĳ�����������Ҫ�ҵ�ƽ�����͵���С������
     *
     * ʱ�䣺O(n*(h/2))��h��NԪ���ĸ߶�
     * �ռ䣺O(n^(h/2))����Ҳ���� h �����Գ��ֵ����ڵ��������Կ�������Ȼ���Ǳ�����һ����ȫƽ�����б����ǿռ����Ҫ�����Ƕ��б�����
     * �����ٸ��� N Ԫ��������Ҫ���ʵ�ʣ��ڵ㡣
     */
/*    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int level = 0;
        queue.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();    //��ǰ��Ԫ���������Ƕ�����Ԫ�ص�����
            level++;                    // ��ʼ������һ��
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                //���μ� 1, 4, 9... ������һ��Ľڵ�
                for (int j = 1; j * j <= cur; j++) {    //�ڵ�ǰcur�Ļ����ϼ�һ����ȫƽ����������������cur
                    int next = cur - j * j;
                    if (next == 0) {
                        return level;
                    }
                    if (!visited.contains(next)) {
                        queue.offer(next);
                        visited.add(next);
                    }
                }
            }
        }
        return -1;
    }*/

    /**
     * �ⷨ�ģ���ѧ��������ƽ���Ͷ�����ƽ���Ͷ���
     * ��ƽ���Ͷ���ÿ����Ȼ�������Ա�ʾΪ�ĸ�����ƽ����
     * ��ƽ���Ͷ���n!=4k(8m+7) <=> n���Էֽ�Ϊ3����ȫƽ����
     */
    public int numSquares(int n) {
        //�ж��Ƿ���4��ʹ����ƽ���Ͷ��������㼴Ϊ4
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 3;
        }
        //�ж��Ƿ���1����n�����Ƿ�����ȫƽ����
        if (isSquare(n)) {
            return 1;
        }
        //�ж��Ƿ���2��ͨ��ö���ж����Ƿ��ֽܷ��������ȫƽ����
        for (int i = 1; i * i <= n; i++) {
            if (isSquare(n - i * i)) {
                return 2;
            }
        }
        return 3;
    }

    private boolean isSquare(int n) {
        int seq = (int) Math.sqrt(n);
        return n == seq * seq;
    }
}