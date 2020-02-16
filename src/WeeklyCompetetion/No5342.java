package WeeklyCompetetion;

import java.util.Arrays;

public class No5342 {
    public static void main(String[] args) {
        int[][] events = {{1, 2}, {1, 2}, {3, 3}, {1, 5}, {1, 5}};
        Solution5342 s = new Solution5342();
        s.maxEvents(events);
    }
}

/**
 * ԭ������ʱ����ͬ�������翪ʼʱ�俪ʼѡ��ѡ�꼴ֹ�� ����ʱ�����ں���ģ������ʼʱ��������ǰ�����ͬ��ѡ��μ�ǰ��Ļ��飬
 * ��Ϊ����Ŀ�ʼʱ���ѡ��Χ�ϴ������ʼʱ���ǰ�������ͬ������
 * ����ֻ��Ҫ���ݽ���ʱ����С����������򼴿�
 */

class Solution5342 {
    public int maxEvents(int[][] events) {
        int ans = 0;
        Arrays.sort(events, (o1, o2) -> o1[1] - o2[1]);
        boolean[] arr = new boolean[100006];
        for (int[] tem : events) {          //һ��tem�������һ������tem[0]Ϊ��ʼʱ�䣬tem[1]Ϊ����ʱ��
            for (int i = tem[0]; i <= tem[1]; i++) {
                if (!arr[i]) {
                    arr[i] = true;
                    ans++;
                    break;      //�μ���������飬ֱ��break
                }
            }
        }

        return ans;
    }
}