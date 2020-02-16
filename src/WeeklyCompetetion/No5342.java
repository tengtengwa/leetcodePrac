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
 * 原理：结束时间相同，从最早开始时间开始选择，选完即止； 结束时间排在后面的，如果开始时间与排在前面的相同，选择参加前面的会议，
 * 因为后面的开始时间可选范围较大，如果开始时间比前面的慢，同样满足
 * 所以只需要根据结束时间由小到大进行排序即可
 */

class Solution5342 {
    public int maxEvents(int[][] events) {
        int ans = 0;
        Arrays.sort(events, (o1, o2) -> o1[1] - o2[1]);
        boolean[] arr = new boolean[100006];
        for (int[] tem : events) {          //一个tem数组代表一个会议tem[0]为开始时间，tem[1]为结束时间
            for (int i = tem[0]; i <= tem[1]; i++) {
                if (!arr[i]) {
                    arr[i] = true;
                    ans++;
                    break;      //参加了这个会议，直接break
                }
            }
        }

        return ans;
    }
}