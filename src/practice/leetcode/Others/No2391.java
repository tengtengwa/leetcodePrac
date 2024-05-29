package practice.leetcode.Others;

public class No2391 {
    public static void main(String[] args) {
        Solution2391 s = new Solution2391();
        s.garbageCollection(new String[]{"G", "P", "GP", "GG"}, new int[]{2, 4, 3});
    }
}

/**
 * 2391. 收集垃圾的最少总时间
 * 情景题，题目描述较长，详情见：https://leetcode.cn/problems/minimum-amount-of-time-to-collect-garbage/description/
 */
class Solution2391 {
    public int garbageCollection(String[] garbage, int[] travel) {
        int mTime = 0, gTime = 0, pTime = 0;
        //上次m、g、p车所在房子位置
        int mIndex = 0, gIndex = 0, pIndex = 0;
        //从索引0到i需要的步数
        int[] dis = new int[garbage.length];
        for (int i = 0; i < travel.length; i++) {
            dis[i + 1] = dis[i] + travel[i];
        }

        for (int i = 0; i < garbage.length; i++) {
            String gar = garbage[i];
            for (char g : gar.toCharArray()) {
                switch (g) {
                    case 'G':
                        if (i > 0) {
                            gTime += dis[i] - dis[gIndex];
                        }
                        gTime++;
                        gIndex = i;
                        break;
                    case 'M':
                        if (i > 0) {
                            mTime += dis[i] - dis[mIndex];
                        }
                        mTime++;
                        mIndex = i;
                        break;
                    case 'P':
                        if (i > 0) {
                            pTime += dis[i] - dis[pIndex];
                        }
                        pTime++;
                        pIndex = i;
                        break;
                    default:
                        break;
                }
            }
        }
        return mTime + gTime + pTime;
    }
}