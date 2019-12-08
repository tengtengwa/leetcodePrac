package DataStructure;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class CompressFileByHuffmanTree {
    public static void main(String[] args) {
        CompressFileByHuffmanTree cfbh = new CompressFileByHuffmanTree();
        cfbh.compressFile("C:\\Users\\腾腾娃发光的板砖\\Desktop\\超星网课.txt", "C:\\Users\\腾腾娃发光的板砖\\Desktop\\游戏");
    }


    static final int BUFFER_SIZE = 128;
    private int[] times = new int[256];
    private String[] huffmanCodes = new String[256];
    private PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(Node::getWeight));

    public void compressFile(String src, String des) {
        calCharWeigth(src);
        Node root = creatHuffmanTree();
        getHuffmanCode(root, "");
        compress(src, des);
    }

    int writeBufferSize = 0;
    byte[] writeBuffer = new byte[128];

    private void compress(String src, String des) {
        byte value = 0;
        int index = 0;
        int lastIndex = 0;   // 最后一个字节补0的个数

        File file = new File(des);
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        try {
            bis = new BufferedInputStream(new FileInputStream(src));
            bos = new BufferedOutputStream(new FileOutputStream(file));
            StringBuilder code = new StringBuilder();
            //将每个字符的编码的长度写入文件
            for (int i = 0; i < 256; i++) {
                bos.write(huffmanCodes[i].length());
                code.append(huffmanCodes[i]);
            }
            //将哈夫曼编码写入文件
            char[] codeArray = code.toString().toCharArray();
            for (int i = 0; i < codeArray.length; i++) {
                if (codeArray[i] == '0') {
                    value = setZero(value, index);
                }
                if (codeArray[i] == '1') {
                    value = setOne(value, index);
                }
                index++;
                if (index >= 8) {
                    index = 0;
                    writeInBuffer(bos, value);
                }
            }
            if (index != 0) {
                writeInBuffer(bos, value);
            }

            index = 0;
            value = 0;
            byte[] bytes = new byte[BUFFER_SIZE];
            int len;
            double length = 0;
            double totalLen = (double) bis.available();
            while ((len = bis.read(bytes)) != -1) {
                length += len;
                double progress = (length / totalLen) * 100;
                System.out.println("压缩进度：%f%%" + progress);
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < len; i++) {
                    int tem = bytes[i];
                    if (tem < 0) {
                        sb.append(huffmanCodes[tem + 256]);
                    } else {
                        sb.append(huffmanCodes[tem]);
                    }
                }
                // 将拼接好的01字节,每8位转为一个字节存到缓存区
                char[] arr = sb.toString().toCharArray();
                for (char ch : arr) {
                    if (ch == '0') {
                        value = setZero(value, index);
                    }
                    if (ch == '1') {
                        value = setOne(value, index);
                    }
                    index++;
                    if (index >= 8) {
                        writeInBuffer(bos, value);
                        index = 0;
                    }
                }
            }
            if (index != 0) {
                lastIndex = 8 - index;
                writeInBuffer(bos, value);
                writeInBuffer(bos, (byte) lastIndex);
            } else {
                writeInBuffer(bos, (byte) lastIndex);
            }
            byte[] bytes1 = Arrays.copyOfRange(writeBuffer, 0, writeBufferSize);
            bos.write(bytes1);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (bis != null) {
                    bis.close();
                }
                if (bos != null) {
                    bos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void writeInBuffer(BufferedOutputStream bos, byte value) throws IOException {
        if (writeBufferSize < BUFFER_SIZE) {
            writeBuffer[writeBufferSize] = value;
            if (++writeBufferSize > BUFFER_SIZE) {
                bos.write(writeBuffer);
                writeBufferSize = 0;
            }
        }
    }

    private byte setOne(byte value, int index) {
        return (value) |= (1 << (index - 1));
    }

    private byte setZero(byte value, int index) {
        return (value) &= (~(1 << (index - 1)));
    }

    //遍历哈夫曼树获取叶子节点的哈夫曼编码
    private void getHuffmanCode(Node root, String code) {
        if (root.getLchild() != null) {
            getHuffmanCode(root.getLchild(), code + "0");
        }
        if (root.getRchild() != null) {
            getHuffmanCode(root.getRchild(), code + "1");
        }
        if (root.getLchild() == null && root.getRchild() == null) {
            huffmanCodes[root.getIndex()] = code;
        }
    }

    private Node creatHuffmanTree() {
        for (int i = 0; i < times.length; i++) {
            if (times[i] != 0) {
                queue.add(new Node(i, times[i]));
            }
        }
        while (queue.size() > 1) {
            Node rChild = queue.remove();
            Node lChild = queue.remove();
            Node parent = new Node(lChild.getWeight() + rChild.getWeight(), -1);
            parent.setLchild(lChild);
            parent.setRchild(rChild);
            queue.add(parent);
        }
        return queue.remove();
    }

    //计算每个字符的权值
    private void calCharWeigth(String srcPath) {
        try {
            BufferedInputStream bis = new BufferedInputStream(new FileInputStream(srcPath));
            byte[] bytes = new byte[256];
            int len;
            while ((len = bis.read(bytes)) != -1) {
                for (int i = 0; i < len; i++) {
                    int tem = bytes[i];
                    if (tem < 0) {
                        times[tem + 256]++;
                    } else {
                        times[tem]++;
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class Node {
    private int weight;
    private int index;
    private Node lchild;
    private Node rchild;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public Node(int weight, int index) {
        this.weight = weight;
        this.index = index;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Node getLchild() {
        return lchild;
    }

    public void setLchild(Node lchild) {
        this.lchild = lchild;
    }

    public Node getRchild() {
        return rchild;
    }

    public void setRchild(Node rchild) {
        this.rchild = rchild;
    }
}