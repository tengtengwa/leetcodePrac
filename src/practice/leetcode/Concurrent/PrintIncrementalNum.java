package practice.leetcode.Concurrent;

public class PrintIncrementalNum implements Runnable {

    //�������ֻ����static�ģ�ÿ���̹߳������е���һ���������������̻߳�ȡ���Ե�lock�������п�����whileѭ����һֱִ�С�
    private static final Object lock = new Object();

    private static int num = 0;     //Ҫ��ӡ������

    private int threadCount;        //�̸߳���

    private int threadId;          //��ǰ�̵߳ı��

    private int max;                //��ӡ�����ֵ

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
                System.out.println("�߳�id��" + threadId + " ��ӡ���֣�" + num);
                num++;
                lock.notifyAll();
            }
        }
    }
}
