package practice.leetcode.Concurrent;

public class PrintIncrementalNum implements Runnable {

    //这里的锁只能是static的，每个线程共享类中的这一把锁。否则三个线程获取各自的lock锁，很有可能在while循环中一直执行。
    private static final Object lock = new Object();

    private static int num = 0;     //要打印的数字

    private int threadCount;        //线程个数

    private int threadId;          //当前线程的编号

    private int max;                //打印的最大值

    public PrintIncrementalNum(int max, int threadCount, int threadId) {
        this.max = max;
        this.threadCount = threadCount;
        this.threadId = threadId;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new PrintIncrementalNum(50, 3, i)).start();
        }
    }

    @Override
    public void run() {
        while (true) {
            synchronized (lock) {
                while (num % threadCount != threadId) {
                    if (num > max) {
                        break;
                    }
                    try {
                        lock.wait();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (num > max) {
                    break;
                }
                System.out.println("线程id：" + threadId + " 打印数字：" + num);
                num++;
                lock.notifyAll();
            }
        }
    }
}
