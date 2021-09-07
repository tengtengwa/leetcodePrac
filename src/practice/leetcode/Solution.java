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
    private int evaluation;                //���ƺ���f(n)������ʼ״̬��Ŀ�����С����ֵ
    private int depth;                    //d(n)����ǰ����ȣ����ߵ���ǰ״̬�Ĳ���
    private int misposition;            //�������� h(n)����Ŀ�����С����(��¼��Ŀ��״̬�ж��ٸ�����ͬ)
    private EightPuzzle parent;            //��ǰ״̬�ĸ�״̬
    private final ArrayList<EightPuzzle> answer = new ArrayList<>();    //��������·��

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
     * �жϵ�ǰ״̬�Ƿ�ΪĿ��״̬
     */
    private boolean isTarget(EightPuzzle target) {
        return Arrays.equals(getNum(), target.getNum());
    }

    /**
     * ����ƺ���f(n) = g(n)+h(n); g(n)+h(n)ָ����n����ȺͲ���λ������������ֵ�����������ߵĺ͡�
     * ��ʼ��״̬��Ϣ
     */
    private void init(EightPuzzle target) {
        int temp = 0;
        int[] targetNum = target.getNum();
        for (int i = 0; i < 9; i++) {
            if (num[i] != targetNum[i])
                temp++;            //��¼��ǰ�ڵ���Ŀ��ڵ����Ķ�����Ҳ���ǲ���λ��������
        }
        this.setMisposition(temp);
        if (this.getParent() == null) {
            this.setDepth(0);    //��ʼ����������ȣ�
        } else {
            this.depth = this.parent.getDepth() + 1;//��¼����
        }
        this.setEvaluation(this.getDepth() + this.getMisposition());//���ص�ǰ״̬�Ĺ���ֵ
    }

    /**
     * ������ֵ���ж��Ƿ��н⣬����ֵͬ�����ͬż���н�
     *
     * @return �н⣺true �޽⣺false
     */
    private boolean isSolvable(EightPuzzle target) {
        int reverse = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < i; j++) {//����0����
                if (num[j] > num[i] && num[j] != 0 && num[i] != 0)
                    reverse++;
                if (target.getNum()[j] > target.getNum()[i] && target.getNum()[j] != 0 && target.getNum()[i] != 0)
                    reverse++;
            }
        }
        return reverse % 2 == 0;
    }

    /**
     * ��ÿ����״̬��f(n)������С��������
     */
    @Override
    public int compareTo(Object o) {
        EightPuzzle c = (EightPuzzle) o;
        return this.evaluation - c.getEvaluation();//Ĭ������Ϊf(n)��С��������
    }

    /**
     * @return ����0�ڰ������е�λ��
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
     * ȥ�أ���ǰ״̬���ظ�����-1
     *
     * @param open ״̬����
     * @return �жϵ�ǰ״̬�Ƿ������open����
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
     * һά����
     *
     * @return С��3����һ�У��Ĳ������Ʒ���false
     */
    private boolean canMoveUp() {
        int position = getZeroPosition();
        return position > 2;
    }

    /**
     * @return ����6�������У�����false
     */
    private boolean canMoveDown() {
        int position = getZeroPosition();
        return position < 6;
    }

    /**
     * @return 0��3��6����һ�У�����false
     */
    private boolean canMoveLeft() {
        int position = getZeroPosition();
        return position % 3 != 0;
    }

    /**
     * @return 2��5��8�������У��������Ʒ���false
     */
    private boolean canMoveRight() {
        int position = getZeroPosition();
        return (position) % 3 != 2;
    }

    /**
     * ��0����/��/��/�ҵ����ֻ���
     *
     * @return �����ƶ����״̬
     */
    private EightPuzzle moveUp(Direction direction) {
        EightPuzzle temp = new EightPuzzle();
        int[] tempNum = num.clone();
        temp.setNum(tempNum);
        int position = getZeroPosition();    //0��λ��
        int p = 0;                            //��0��λ�õ�λ��
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
     * ����3*3��ʽ���
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
     * �����մ�·���������������
     */
    private void printRoute() {
        EightPuzzle temp;
        int count = 0;
        temp = this;
        System.out.println("----------��ʼ�ƶ�----------");
        while (temp != null) {
            answer.add(temp);
            temp = temp.getParent();
            count++;
        }
        for (int i = answer.size() - 1; i >= 0; i--) {
            answer.get(i).print();
            System.out.println("--------------------");
        }
        System.out.println("��С�ƶ�������" + (count - 1));
    }

    /**
     * ��չ��ǰ�ڵ㣬������open��
     *
     * @param open   open��
     * @param close  close��
     * @param parent ��״̬
     * @param target Ŀ��״̬
     */
    private void operation(ArrayList<EightPuzzle> open, ArrayList<EightPuzzle> close, EightPuzzle parent, EightPuzzle target) {
        if (this.isContains(close) == -1) {//�������close����
            int position = this.isContains(open);//��ȡ��open���е�λ��
            if (position == -1) {//���Ҳ����open����
                this.parent = parent;//ָ�����ĸ�״̬
                this.init(target);//�������Ĺ���ֵ
                open.add(this);//������ӽ�open��
            } else {//�������open����
                if (this.getDepth() < open.get(position).getDepth()) {//���Ѵ��ڵ�״̬���Ƚϣ�������Ĳ����������ǽ��Ž�
                    open.remove(position);//���Ѿ����ڵ���ͬ״̬�滻��
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
        System.out.println("�������ʼ״̬��");
        for (int i = 0; i < 9; i++) {
            sNum[i] = s.nextInt();
        }
        System.out.println("������Ŀ��״̬��");
        for (int j = 0; j < 9; j++) {
            tNum[j] = s.nextInt();
        }
        s.close();
    }

    @SuppressWarnings("unchecked")
    public void bestFirstSearch() {
        //����open��
        ArrayList<EightPuzzle> open = new ArrayList<>();
        ArrayList<EightPuzzle> close = new ArrayList<>();
        EightPuzzle start = new EightPuzzle();
        EightPuzzle target = new EightPuzzle();
        readNum();      //������ʼ������״̬
        start.setNum(sNum);
        target.setNum(tNum);
        long startTime = System.currentTimeMillis();

        if (start.isSolvable(target)) {
            //��ʼ����ʼ״̬
            start.init(target);
            open.add(start);
            while (!open.isEmpty()) {
                Collections.sort(open);            //����evaluation��ֵ����
                EightPuzzle best = open.remove(0);    //��open����ȡ����С��ֵ��״̬���Ƴ�open��
                close.add(best);

                if (best.isTarget(target)) {
                    //���
                    best.printRoute();
                    long end = System.currentTimeMillis();
                    System.out.println("�������� " + (end - startTime) + " ms");
                    System.exit(0);
                }

                //��best״̬������չ�����뵽open����
                //0��λ������֮��״̬����close��open���趨bestΪ�丸״̬������ʼ��f(n)��ֵ����
                if (best.canMoveUp()) {//�������ƵĻ�
                    EightPuzzle up = best.moveUp(Direction.UP);//best��һ����״̬
                    up.operation(open, close, best, target);
                }
                //0��λ������֮��״̬����close��open���趨bestΪ�丸״̬������ʼ��f(n)��ֵ����
                if (best.canMoveDown()) {
                    EightPuzzle down = best.moveUp(Direction.DOWN);
                    down.operation(open, close, best, target);
                }
                //0��λ������֮��״̬����close��open���趨bestΪ�丸״̬������ʼ��f(n)��ֵ����
                if (best.canMoveLeft()) {
                    EightPuzzle left = best.moveUp(Direction.LEFT);
                    left.operation(open, close, best, target);
                }
                //0��λ������֮��״̬����close��open���趨bestΪ�丸״̬������ʼ��f(n)��ֵ����
                if (best.canMoveRight()) {
                    EightPuzzle right = best.moveUp(Direction.RIGHT);
                    right.operation(open, close, best, target);
                }

            }
        } else {
            System.out.println("Ŀ��״̬���ɴ�޽�");
        }
    }

    /**
     * ���������������ȡ��ʼ��Ŀ�����飬���ж��Ƿ��н⡣ʵ�ʵĵݹ齻�����������Ĺ��췽��
     */
    public void DFS() {
        EightPuzzle target = new EightPuzzle();
        readNum();              //������ʼ������״̬
        this.setNum(sNum);
        target.setNum(tNum);
        if (this.isSolvable(target)) {
            DFSStartTime = System.currentTimeMillis();
            DFS(this, target);
        } else {
            System.out.println("Ŀ��״̬���ɴ�޽�");
        }
    }

    //visited��������Ѿ���չ���Ľڵ�
    private final Queue<EightPuzzle> visited = new LinkedList<>();
    private int steps = 0;          //���ڼ�¼�������ò���
    private long DFSStartTime;

    /**
     * DFS��ʵ�ַ���
     *
     * @param cur       ��ǰ״̬
     * @param target    Ŀ��״̬
     */
    private void DFS(EightPuzzle cur, EightPuzzle target) {
        print(cur);
        if (cur.depth > 4) {
            return;
        }
        if (cur.isTarget(target)) {
            System.out.println("������ɣ�DFS���ò��裺" + steps);
            long end = System.currentTimeMillis();
            System.out.println("�������� " + (end - DFSStartTime) + " ms");
            System.exit(0);
        }
        visited.add(cur);
        ArrayList<EightPuzzle> expendState = new ArrayList<>();     //�洢������չ����һ��״̬
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
        visited.poll();     //�ص���һ��ǰ���������¼�Ƴ�
    }

    public void BFS() {
        EightPuzzle target = new EightPuzzle();
        readNum();              //������ʼ������״̬
        this.setNum(sNum);
        target.setNum(tNum);
        if (!this.isSolvable(target)) {
            System.out.println("Ŀ��״̬���ɴ�޽�");
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
                System.out.println("������ɣ�BFS���ò��裺" + steps);
                long end = System.currentTimeMillis();
                System.out.println("�������� " + (end - startTime) + " ms");
                System.exit(0);
            }
            visited.add(cur);
            ArrayList<EightPuzzle> expendState = new ArrayList<>();     //�洢������չ����һ��״̬
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
            visited.poll();     //�ص���һ��ǰ���������¼�Ƴ�
        }
    }
}