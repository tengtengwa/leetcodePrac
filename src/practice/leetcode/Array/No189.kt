package practice.leetcode.Array;

/**
 * 189. ��ת����
 * ����һ���������� nums���������е�Ԫ��������ת k ��λ�ã����� k �ǷǸ�����
 */
fun main() {
    val s = Solution189()
    val arr = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    s.rotate(arr, 3)
    arr.forEach {
        print("$it ")
    }
}

class Solution189 {
    /**
     * �ⷨһ������������
     * ����һ��ԭ���飬�����ÿ��Ԫ���ƶ����������������������顣��ɺ󽫽��������ԭ���鼴��
     * ʱ�䣺O(n)
     * �ռ䣺O(n)
     */
//    fun rotate(nums: IntArray, k: Int): Unit {
//        val res = IntArray(nums.size)
//        nums.forEachIndexed { i, it ->
//            val index = (i + k) % nums.size
//            res[index] = it
//        }
//        nums.forEachIndexed { i, _ ->
//            nums[i] = res[i]
//        }
//    }

    /**
     * �ⷨ�������η�ת
     * [1,2,3,4,5,6,7] k=3�� [5,6,7,1,2,3,4]
     * ͨ���۲����鷭תǰ��Ľ�������Ƿ��֣�ֻҪ����ת���[0, (k%n)-1]��[k%n, n-1]��
     * ����������ֱ�תһ�Σ��͵õ���ԭ����ķ�ת���飬���Ž��������鷭תһ�μ��ɡ�
     * ʱ�䣺O(n)
     * �ռ䣺O(1)
     */
//    fun rotate(nums: IntArray, k: Int): Unit {
//        val n = nums.size
//        reverseArray(nums, 0, n - 1)
//        reverseArray(nums, 0, (k % n) - 1)
//        reverseArray(nums, k % n, nums.size - 1)
//    }
//
//    private fun reverseArray(arr: IntArray, l: Int, r: Int) {
//        var start = l
//        var end = r
//        while (start < end) {
//            val tem: Int = arr[start]
//            arr[start++] = arr[end]
//            arr[end--] = tem
//        }
//    }

    /**
     * �ⷨ������״�滻
     * �ڽⷨһ�Ļ��������˸Ľ�������ʹ��O(n)�Ŀռ䡣����һ��ʹ�ö��������ԭ�����ڣ��������ֱ�ӽ�ÿ�����ַ���
     * ������λ�ã�����������λ�õ�Ԫ�ػᱻ���ǴӶ���ʧ��
     * ����ʹ��һ��tem����������һ���ƶ�������λ�ú��Ԫ�ء��������Ƿ��س�ʼλ��0��ʱ�򣬿��ܻ���һ����Ԫ��
     * û�б���������ʱ��Ҫ����һ��λ�õ���������k step��������Ԫ��λ�á�
     * �ƴ�ĳ��������ʼ����k step��������ֱ�����س�ʼ����һ��Ϊ1Ȧ����������Ҫ������������gcd(n,k)Ȧ��
     * nΪ���鳤�ȣ�gcdΪ���������Լ��
     * ʱ�临�Ӷȣ�O(n)
     * �ռ临�Ӷȣ�O(1)
     */
    fun rotate(nums: IntArray, k: Int): Unit {
        val count = gcd(nums.size, k)
        val n = nums.size
        for (i in 0 until count) {
            var cur = i
            var pre = nums[cur]
            do {
                val next = (cur + k) % n
                //ע�⣬����Ҫ������һ�μ�¼��Ԫ��pre����һ��λ�õ�Ԫ��nums[next]
                val tem = nums[next]
                nums[next] = pre
                pre = tem
                cur = next
            } while (cur != i)
        }
    }

    private fun gcd(x: Int, y: Int): Int {
        return if (y > 0) gcd(y, x % y) else x
    }
}