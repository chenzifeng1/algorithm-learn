package zuochengyun_algorithm;

import utils.RandomList;

/**
 * @Author: czf
 * @Description: 归并排序及其扩展问题
 * @Date: 2021-08-03 17:10
 * @Version: 1.0
 **/
public class MergeSortLeran {


    public static void main(String[] args) {
        testMinSum();
    }

    /**
     * 测试归并排序
     */
    public static void testMergeSort(){
        System.out.println(" 排序之前");
        int[] array = RandomList.generateRandomIntArray(100, 200);
        for (int num : array) {
            System.out.print(num + " ");
        }
        sortByIteration(array);
        System.out.println();
        System.out.println(" 排序之后");

        for (int num : array) {
            System.out.print(num + " ");
        }
    }
    /**
     * 合并函数
     *
     * @param array
     * @param left
     * @param mid
     * @param right
     */
    public static void merge(int[] array, int left, int mid, int right) {
        if (left >= right) {
            return;
        }
        // 左组下标
        int l = left;
        // 右组下标
        int r = mid + 1;
        // 辅助数组下标
        int index = 0;
        // 辅助数组
        int[] help = new int[right - left + 1];

        // 开始合并
        while (l <= mid && r <= right) {
            // 谁小放前面
            help[index++] = array[l] < array[r] ? array[l++] : array[r++];
        }

        // 比较完成之后，还有一个组有剩余元素没有加进来

        while (l <= mid) {
            help[index++] = array[l++];
        }
        while (r <= right) {
            help[index++] = array[r++];
        }

        // 将辅助数组的值拷贝回主数组
        System.arraycopy(help, 0, array, left, help.length);

    }
    // *********************************************************************递归版**********************************************************************************************

    /**
     * 递归版
     *
     * @param array
     * @param left
     * @param right
     * @return
     */
    public static void sortByRecursion(final int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        sortByRecursion(array, left, mid);
        sortByRecursion(array, mid + 1, right);
        // 当一个递归中 走到了merge这一步，则说明对应的左右两组数列已经局部有序
        merge(array, left, mid, right);
    }

    // ********************************************************************迭代版***********************************************************************************************

    /**
     * 迭代版 核心思想，使用步长解决分组问题
     *
     * @param array
     */
    public static void sortByIteration(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        // 步长
        int step = 1;
        // 数组下标长度
        int len = array.length - 1;

        // 外层 大循环，当步长超过整个数组长度停止
        while (step <= len) {
            int left = 0;
            // 同一步长下的分组 循环
            while (left <= len) {

                int mid = left + step - 1;
                if (mid > len) {
                    // 不够一组了 即左组都不够了，直接返回
                    break;
                }
                int right = Math.min(mid + step, len);
                merge(array, left, mid, right);
                // 开始下一组
                left = right + 1;
            }
            // 这里设置判断是为了防止步长溢出 int的最大值
            if (step > (len >> 1)) {
                break;
            }
            step <<= 1;
        }
    }
    // ******************************************************************** 衍生题目（一） 小和问题 ***********************************************************************************************

    public static void testMinSum() {
//        int[] array = RandomList.generateRandomIntArray(20, 30);
        int[] array = new int[] {1,2,3,4};
        RandomList.printArray(array);
        int result = minSumByForce(array);
        System.out.println("小和：" + result);
    }


    /**
     * 小和问题： 暴力破解版
     * 小和：数组中下标为n的元素A，其左边所有比A小的元素的和称为A元素的小和
     * 时间复杂度： 1+2+3+...+(n-1) = (1+n-1)*(n-1)/2 -> O(n^2)
     *
     * @param array
     * @return
     */
    public static int minSumByForce(int[] array) {
        int result = 0;
        // 暴力破解 下标直接从1开始
        for (int i = 1; i < array.length; i++) {
            int temp = array[i];
            for (int j = 0; j < i; j++) {
                if (array[j] < temp) {
                    result += array[j];
                }
            }
        }
        return result;
    }

    /**
     * 归并排序 变形  试试迭代版？
     *
     * @param array
     * @return
     */
    public static int minSumByMerge(int[] array, int left, int right) {
        if (left >= right) {
            return 0;
        }
        int mid = left + ((right - left) >> 1);

        return
                minSumByMerge(array, left, mid) +
                        minSumByMerge(array, mid + 1, right) +
                        minSumMerge(array, left, mid, right);

    }

    public static int minSumMerge(int[] array, int left, int mid, int right) {
        int result = 0;
        int l = left;
        int r = mid + 1;
        int[] help = new int[right - left + 1];
        int index = 0;
        while (l <= mid && r <= right) {
            if (array[l] < array[r]) {
                // 如果右组第r个数 比左组第l个数大，那么右组r后面的数大于左组第l个数
                result += array[l] * (right - r + 1);
                help[index++] = array[l++];
            } else {
                // 左组数大，不产生小和
                help[index++] = array[r++];
            }
        }
        // 剩下了的数，不产生小和，因为不管什么情况，都在之前已经统计出来小和了
        while (l <= mid) {
            help[index++] = array[l++];
        }
        while (r <= right) {
            help[index++] = array[r++];
        }
        // 拷贝数组
        for (int i = 0; i < help.length; i++) {
            array[left + i] = help[i];
        }
        return result;
    }


}
