package practice.leetcode.DynamicProgramming;

public class No279 {
    public static void main(String[] args) {
        Solution279 s = new Solution279();
        s.numSquares(12);
    }
}

class Solution279 {
    /**
     * 题目：完全平方数，给定正整数 n，找到若干个完全平方数（比如 1, 4, 9, 16, ...）使得它们的和等于 n。
     * 你需要让组成和的完全平方数的个数最少。
     *
     * 解法一：暴力递归(BFS)，在嵌套for循环的内循环写成了递归的形式。
     * 可以使用HashMap进行优化，这样就很类似于动态规划了
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
        //依次减去一个平方数
        for (int i = 1; i * i <= n; i++) {
            //选最小的
            count = Math.min(count, numSquaresHelper(n - i * i) + 1);
        }
        map.put(n, count);
        return count;
    }*/

    /**
     * 解法二：动态规划
     * 状态转移方程：numSquares(n)=min(numSquares(n-k) + 1) （k属于完全平方数）
     *
     * 时间复杂度：(n*sqrt(n)) 在主步骤中，我们有一个嵌套循环，其中外部循环是n次迭代，而内部循环最多需要sqrt(n)次迭代。
     * 空间复杂度：O(n)，使用了一个一维数组 dp。
     */
/*    public int numSquares(int n) {
        int[] dp = new int[n + 1];      // 数组大小为n+1，默认初始化值都为0
        for (int i = 1; i <= n; i++) {
            dp[i] = i;                  //每个位置i的最大完全平方数不会超过自己
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1); // 动态转移方程
            }
        }
        return dp[n];
    }*/

    /**
     * 解法三：BFS
     * 思路：BFS 的话，我们可以一层一层的算。第一层依次减去一个平方数得到第二层，第二层依次减去一个平方数得到第三层。
     * 直到某一层出现了 0，此时的层数就是我们要找到平方数和的最小个数。
     *
     * 时间：O(n*(h/2))，h是N元树的高度
     * 空间：O(n^(h/2))，这也是在 h 级可以出现的最大节点数。可以看到，虽然我们保留了一个完全平方数列表，但是空间的主要消耗是队列变量，
     * 它跟踪给定 N 元树级别上要访问的剩余节点。
     */
/*    public int numSquares(int n) {
        Queue<Integer> queue = new LinkedList<>();
        HashSet<Integer> visited = new HashSet<>();
        int level = 0;
        queue.add(n);
        while (!queue.isEmpty()) {
            int size = queue.size();    //当前层元素数量就是队列中元素的数量
            level++;                    // 开始生成下一层
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                //依次减 1, 4, 9... 生成下一层的节点
                for (int j = 1; j * j <= cur; j++) {    //在当前cur的基础上减一个完全平方数，所以这里是cur
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
     * 解法四：数学方法，四平方和定理、三平方和定理。
     * 四平方和定理：每个自然数都可以表示为四个整数平方和
     * 三平方和定理：n!=4k(8m+7) <=> n可以分解为3个完全平方数
     */
    public int numSquares(int n) {
        //判断是否是4，使用三平方和定理，不满足即为4
        while (n % 4 == 0) {
            n /= 4;
        }
        if (n % 8 == 7) {
            return 3;
        }
        //判断是否是1，即n本身是否是完全平方数
        if (isSquare(n)) {
            return 1;
        }
        //判断是否是2，通过枚举判断它是否能分解成两个完全平方数
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