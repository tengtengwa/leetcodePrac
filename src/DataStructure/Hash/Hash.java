package DataStructure.Hash;


import java.util.Random;

public class Hash {
    public static void main(String[] args) {
        Hash hash = new Hash();
        String[] arr = hash.createHash();
        for (int i = 1; i < arr.length; i++) {
            System.out.println("哈希值：" + i + " " + arr[i] + " ");
        }
        System.out.println();
    }

    String[] createHash() {
        String[] hash = new String[40];
        String[] name = {"yulin", "sheyichen", "zhaochenhui", "baiyunpeneg", "caokuocheng", "jinqi", "liuke", "yaojunhao",
                "sunzehua", "libo", "chenjinhua", "wangzihan", "wenpuzhi", "chenzhengfang", "songchaoqi", "liyupeng", "chentengchuang",
                "zhangkai", "quanshijia", "lijinchao", "wangjiaqi", "zhonghao", "huzeying", "songzebin", "mayixin", "wangshuai",
                "chenkai", "zhangboyu", "boya", "ziqi"
        };
        for (int i = 0; i < name.length; i++) {
            Random random = new Random();
            int num = random.nextInt(29) + 1;
            if (hash[num] == null) {
                hash[num] = name[i];
            } else {
                while (hash[num] != null) {
                    num = random.nextInt(39) + 1;
                }
                hash[num] = name[i];
            }
        }
        return hash;
    }

}


/**
 * 节点类
 */
class ListNode {
    public ListNode(int num) {
        this.num = num;
    }

    private int num;
    ListNode next;
}