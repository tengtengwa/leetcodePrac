package practice.leetcode;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        EightPuzzle e = new EightPuzzle();
//        e.DFS();
//        e.BFS();
        e.bestFirstSearch();
    }
}

@SuppressWarnings("rawtypes")
class EightPuzzle implements Comparable {
    private int[] num = new int[9];
    private int evaluation;                //估计函数f(n)：从起始状态到目标的最小估计值
    private int depth;                    //d(n)：当前的深度，即走到当前状态的步骤
    private int misposition;            //启发函数 h(n)：到目标的最小估计(记录和目标状态有多少个数不同)
    private EightPuzzle parent;            //当前状态的父状态
    private final ArrayList<EightPuzzle> answer = new ArrayList<>();    //保存最终路径

    private enum Direction {
        UP, DOWN, LEFT, RIGHT
    }

    public int[] getNum() {
        return num;
    }

    public void setNum(int[] num) {
        this.num = num;
    }

    public int getDepth() {
        return depth;
    }

    public void setDepth(int depth) {
        this.depth = depth;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    public int getMisposition() {
        return misposition;
    }

    public void setMisposition(int misposition) {
        this.misposition = misposition;
    }

    public EightPuzzle getParent() {
        return parent;
    }

    public void setParent(EightPuzzle parent) {
        this.parent = parent;
    }

    /**
     * 判断当前状态是否为目标状态
     */
    private boolean isTarget(EightPuzzle target) {
        return Arrays.equals(getNum(), target.getNum());
    }

    /**
     * 求估计函数f(n) = g(n)+h(n); g(n)+h(n)指的是n的深度和不在位的棋子数，估值函数就是两者的和。
     * 初始化状态信息
     */
    private void init(EightPuzzle target) {
        int temp = 0;
        int[] targetNum = target.getNum();
        for (int i = 0; i < 9; i++) {
            if (num[i] != targetNum[i])
                temp++;            //记录当前节点与目标节点差异的度量，也就是不在位的棋子数
        }
        this.setMisposition(temp);
        if (this.getParent() == null) {
            this.setDepth(0);    //初始化步数（深度）
        } else {
            this.depth = this.parent.getDepth() + 1;//记录步数
        }
        this.setEvaluation(this.getDepth() + this.getMisposition());//返回当前状态的估计值
    }

    /**
     * 求逆序值并判断是否有解，逆序值同奇或者同偶才有解
     *
     * @return 有解：true 无解：false
     */
    private boolean isSolvable(EightPuzzle target) {
        int reverse = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < i; j++) {//遇到0跳过
                if (num[j] > num[i] && num[j] != 0 && num[i] != 0)
                    reverse++;
                if (target.getNum()[j] > target.getNum()[i] && target.getNum()[j] != 0 && target.getNum()[i] != 0)
                    reverse++;
            }
        }
        return reverse % 2 == 0;
    }

    /**
     * 对每个子状态的f(n)进行由小到大排序
     */
    @Override
    public int compareTo(Object o) {
        EightPuzzle c = (EightPuzzle) o;
        return this.evaluation - c.getEvaluation();//默认排序为f(n)由小到大排序
    }

    /**
     * @return 返回0在八数码中的位置
     */
    private int getZeroPosition() {
        int position = -1;
        for (int i = 0; i < 9; i++) {
            if (this.num[i] == 0) {
                position = i;
            }
        }
        return position;
    }

    /**
     * 去重，当前状态不重复返回-1
     *
     * @param open 状态集合
     * @return 判断当前状态是否存在于open表中
     */
    private int isContains(ArrayList<EightPuzzle> open) {
        for (int i = 0; i < open.size(); i++) {
            if (Arrays.equals(open.get(i).getNum(), getNum())) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 一维数组
     *
     * @return 小于3（第一行）的不能上移返回false
     */
    private boolean canMoveUp() {
        int position = getZeroPosition();
        return position > 2;
    }

    /**
     * @return 大于6（第三行）返回false
     */
    private boolean canMoveDown() {
        int position = getZeroPosition();
        return position < 6;
    }

    /**
     * @return 0，3，6（第一列）返回false
     */
    private boolean canMoveLeft() {
        int position = getZeroPosition();
        return position % 3 != 0;
    }

    /**
     * @return 2，5，8（第三列）不能右移返回false
     */
    private boolean canMoveRight() {
        int position = getZeroPosition();
        return (position) % 3 != 2;
    }

    /**
     * 将0和上/下/左/右的数字互换
     *
     * @return 返回移动后的状态
     */
    private EightPuzzle moveUp(Direction direction) {
        EightPuzzle temp = new EightPuzzle();
        int[] tempNum = num.clone();
        temp.setNum(tempNum);
        int position = getZeroPosition();    //0的位置
        int p = 0;                            //与0换位置的位置
        switch (direction) {
            case UP:
                p = position - 3;
                temp.getNum()[position] = num[p];
                break;
            case DOWN:
                p = position + 3;
                temp.getNum()[position] = num[p];
                break;
            case LEFT:
                p = position - 1;
                temp.getNum()[position] = num[p];
                break;
            case RIGHT:
                p = position + 1;
                temp.getNum()[position] = num[p];
                break;
        }
        temp.getNum()[p] = 0;
        return temp;
    }

    /**
     * 按照3*3格式输出
     */
    private void print() {
        System.out.println("---------------------------");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 2) {
                System.out.println(this.num[i]);
            } else {
                System.out.print(this.num[i] + "  ");
            }
        }
    }

    private void print(EightPuzzle cur) {
        System.out.println("---------------------------");
        for (int i = 0; i < 9; i++) {
            if (i % 3 == 2) {
                System.out.println(cur.num[i]);
            } else {
                System.out.print(cur.num[i] + "  ");
            }
        }
    }

    /**
     * 将最终答案路径保存下来并输出
     */
    private void printRoute() {
        EightPuzzle temp;
        int count = 0;
        temp = this;
        System.out.println("----------开始移动----------");
        while (temp != null) {
            answer.add(temp);
            temp = temp.getParent();
            count++;
        }
        for (int i = answer.size() - 1; i >= 0; i--) {
            answer.get(i).print();
            System.out.println("--------------------");
        }
        System.out.println("最小移动步数：" + (count - 1));
    }

    /**
     * 扩展当前节点，并更新open表
     *
     * @param open   open表
     * @param close  close表
     * @param parent 父状态
     * @param target 目标状态
     */
    private void operation(ArrayList<EightPuzzle> open, ArrayList<EightPuzzle> close, EightPuzzle parent, EightPuzzle target) {
        if (this.isContains(close) == -1) {//如果不在close表中
            int position = this.isContains(open);//获取在open表中的位置
            if (position == -1) {//如果也不在open表中
                this.parent = parent;//指明它的父状态
                this.init(target);//计算它的估计值
                open.add(this);//把它添加进open表
            } else {//如果它在open表中
                if (this.getDepth() < open.get(position).getDepth()) {//跟已存在的状态作比较，如果它的步数较少则是较优解
                    open.remove(position);//把已经存在的相同状态替换掉
                    this.parent = parent;
                    this.init(target);
                    open.add(this);
                }
            }
        }
    }

    private final int[] sNum = new int[9];
    private final int[] tNum = new int[9];

    private void readNum() {
        Scanner s = new Scanner(System.in);
        System.out.println("请输入初始状态：");
        for (int i = 0; i < 9; i++) {
            sNum[i] = s.nextInt();
        }
        System.out.println("请输入目标状态：");
        for (int j = 0; j < 9; j++) {
            tNum[j] = s.nextInt();
        }
        s.close();
    }

    @SuppressWarnings("unchecked")
    public void bestFirstSearch() {
        //定义open表
        ArrayList<EightPuzzle> open = new ArrayList<>();
        ArrayList<EightPuzzle> close = new ArrayList<>();
        EightPuzzle start = new EightPuzzle();
        EightPuzzle target = new EightPuzzle();
        readNum();      //读入起始和最终状态
        start.setNum(sNum);
        target.setNum(tNum);
        long startTime = System.currentTimeMillis();

        if (start.isSolvable(target)) {
            //初始化初始状态
            start.init(target);
            open.add(start);
            while (!open.isEmpty()) {
                Collections.sort(open);            //按照evaluation的值排序
                EightPuzzle best = open.remove(0);    //从open表中取出最小估值的状态并移出open表
                close.add(best);

                if (best.isTarget(target)) {
                    //输出
                    best.printRoute();
                    long end = System.currentTimeMillis();
                    System.out.println("程序运行 " + (end - startTime) + " ms");
                    System.exit(0);
                }

                //由best状态进行扩展并加入到open表中
                //0的位置上移之后状态不在close和open中设定best为其父状态，并初始化f(n)估值函数
                if (best.canMoveUp()) {//可以上移的话
                    EightPuzzle up = best.moveUp(Direction.UP);//best的一个子状态
                    up.operation(open, close, best, target);
                }
                //0的位置下移之后状态不在close和open中设定best为其父状态，并初始化f(n)估值函数
                if (best.canMoveDown()) {
                    EightPuzzle down = best.moveUp(Direction.DOWN);
                    down.operation(open, close, best, target);
                }
                //0的位置左移之后状态不在close和open中设定best为其父状态，并初始化f(n)估值函数
                if (best.canMoveLeft()) {
                    EightPuzzle left = best.moveUp(Direction.LEFT);
                    left.operation(open, close, best, target);
                }
                //0的位置右移之后状态不在close和open中设定best为其父状态，并初始化f(n)估值函数
                if (best.canMoveRight()) {
                    EightPuzzle right = best.moveUp(Direction.RIGHT);
                    right.operation(open, close, best, target);
                }

            }
        } else {
            System.out.println("目标状态不可达，无解");
        }
    }

    /**
     * 这个方法仅用来读取初始和目标数组，并判断是否有解。实际的递归交给了下面它的构造方法
     */
    public void DFS() {
        EightPuzzle target = new EightPuzzle();
        readNum();              //读入起始和最终状态
        this.setNum(sNum);
        target.setNum(tNum);
        if (this.isSolvable(target)) {
            DFSStartTime = System.currentTimeMillis();
            DFS(this, target);
        } else {
            System.out.println("目标状态不可达，无解");
        }
    }

    //visited储存的是已经扩展过的节点
    private final Queue<EightPuzzle> visited = new LinkedList<>();
    private int steps = 0;          //用于记录搜索所用步骤
    private long DFSStartTime;

    /**
     * DFS的实现方法
     *
     * @param cur       当前状态
     * @param target    目标状态
     */
    private void DFS(EightPuzzle cur, EightPuzzle target) {
        print(cur);
        if (cur.depth > 4) {
            return;
        }
        if (cur.isTarget(target)) {
            System.out.println("搜索完成，DFS共用步骤：" + steps);
            long end = System.currentTimeMillis();
            System.out.println("程序运行 " + (end - DFSStartTime) + " ms");
            System.exit(0);
        }
        visited.add(cur);
        ArrayList<EightPuzzle> expendState = new ArrayList<>();     //存储可以扩展的下一个状态
        if (cur.canMoveUp()) {
            EightPuzzle up = cur.moveUp(Direction.UP);
            up.depth = cur.depth + 1;
            if (!visited.contains(up)) {
                expendState.add(up);
            }
        }
        if (cur.canMoveRight()) {
            EightPuzzle right = cur.moveUp(Direction.RIGHT);
            right.depth = cur.depth + 1;
            if (!visited.contains(right)) {
                expendState.add(right);
            }
        }
        if (cur.canMoveLeft()) {
            EightPuzzle left = cur.moveUp(Direction.LEFT);
            left.depth = cur.depth + 1;
            if (!visited.contains(left)) {
                expendState.add(left);
            }
        }
        if (cur.canMoveDown()) {
            EightPuzzle down = cur.moveUp(Direction.DOWN);
            down.depth = cur.depth + 1;
            if (!visited.contains(down)) {
                expendState.add(down);
            }
        }
        for (EightPuzzle e : expendState) {
            steps += 1;
            DFS(e, target);
        }
        visited.poll();     //回到上一层前，将这个记录移除
    }

    public void BFS() {
        EightPuzzle target = new EightPuzzle();
        readNum();              //读入起始和最终状态
        this.setNum(sNum);
        target.setNum(tNum);
        if (!this.isSolvable(target)) {
            System.out.println("目标状态不可达，无解");
        }

        long startTime = System.currentTimeMillis();
        Queue<EightPuzzle> queue = new LinkedList<>();
        queue.add(this);
        while (!queue.isEmpty()) {
            EightPuzzle cur = queue.poll();
            print(cur);
            if (cur.depth > 4) {
                return;
            }
            if (cur.isTarget(target)) {
                System.out.println("搜索完成，BFS共用步骤：" + steps);
                long end = System.currentTimeMillis();
                System.out.println("程序运行 " + (end - startTime) + " ms");
                System.exit(0);
            }
            visited.add(cur);
            ArrayList<EightPuzzle> expendState = new ArrayList<>();     //存储可以扩展的下一个状态
            if (cur.canMoveUp()) {
                EightPuzzle up = cur.moveUp(Direction.UP);
                up.depth = cur.depth + 1;
                if (!visited.contains(up)) {
                    expendState.add(up);
                }
            }
            if (cur.canMoveRight()) {
                EightPuzzle right = cur.moveUp(Direction.RIGHT);
                right.depth = cur.depth + 1;
                if (!visited.contains(right)) {
                    expendState.add(right);
                }
            }
            if (cur.canMoveLeft()) {
                EightPuzzle left = cur.moveUp(Direction.LEFT);
                left.depth = cur.depth + 1;
                if (!visited.contains(left)) {
                    expendState.add(left);
                }
            }
            if (cur.canMoveDown()) {
                EightPuzzle down = cur.moveUp(Direction.DOWN);
                down.depth = cur.depth + 1;
                if (!visited.contains(down)) {
                    expendState.add(down);
                }
            }
            for (EightPuzzle e : expendState) {
                steps += 1;
                queue.add(e);
            }
            visited.poll();     //回到上一层前，将这个记录移除
        }
    }
}