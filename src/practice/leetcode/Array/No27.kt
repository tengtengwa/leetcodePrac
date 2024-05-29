package practice.leetcode.Array

/**
 * 27���Ƴ�Ԫ��
 * ����һ������ nums��һ��ֵ val������Ҫ ԭ�� �Ƴ�������ֵ����val��Ԫ�أ��������Ƴ���������³��ȡ�
 *
 * ��Ҫʹ�ö��������ռ䣬������ʹ�� O(1) ����ռ䲢 ԭ�� �޸��������顣
 * Ԫ�ص�˳����Ըı䡣�㲻��Ҫ���������г����³��Ⱥ����Ԫ�ء�
 */
fun main() {

}

class Solution {
    /**
     * �ⷨһ��˫ָ��
     * ��ָ��ָ����ߵ�һ��Ԫ�أ���ָ�����һ�����飬������������val��Ԫ��ʱ������ָ��λ�õ�Ԫ�ظ�ֵ����ָ��λ��
     * ��Ԫ�أ���Ϊ��ĿҪ��ֻ��Ҫ��û��ɾ����Ԫ�طŵ���߼��ɣ�����������ֱ�Ӹ��Ƕ����ùܱ�ɾ����Ԫ�ء�
     * ʱ�临�Ӷȣ���n��
     * �ռ䣺��1��
     */
//    fun removeElement(nums: IntArray, `val`: Int): Int {
//        var res = 0
//        var i = 0
//        nums.forEach {
//            if (it != `val`) {
//                nums[i++] = it
//                res++
//            }
//        }
//        return res
//    }

    /**
     * �ⷨ�����Ż���˫ָ��
     * �ⷨһ��������û��valʱ������ָ�붼������һ�����顣����ⷨ�У�����ָ�������������һ�����飬�����ӶȲ���
     */
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var i = 0
        var j = nums.size   //��������size������ʼ������[1],1���case�޷�����
        while (i < j) {
            if (nums[i] == `val`) {
                nums[i] = nums[--j]
            } else {
                i++
            }
        }
        return i
    }
}