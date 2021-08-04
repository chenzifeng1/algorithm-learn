package data_structure;

/**
 * @ProjectName: spring-security
 * @ClassName: Test_01_MergeSort
 * @Author: czf
 * @Description: 归并排序
 * 1. 递归版
 * 2. 迭代版
 * @Date: 2021/3/15 20:01
 * @Version: 1.0
 **/

public class Test_01_MergeSort {


    /**
     * master公式： T(N) = a*T(N/b) + O(N^d)
     * 代入参数： T(N) = 2*T(N/2) +O(N)
     * a/b = d -> o(N) = O(N * logN)
     *
     * @param array
     * @param left
     * @param right
     */
    public void process(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int mid = (left + right) >> 1;
        process(array, left, mid);
        process(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    /**
     * 给定一个数组array，因为merge之前调用了两次process，所以调用merge的时候，我们可以认为
     * 在left->mid以及mid+1->right上数组已经有序了
     *
     * @param array
     * @param left
     * @param mid
     * @param right
     */
    private void merge(int[] array, int left, int mid, int right) {

        int[] newArray = new int[right - left + 1];
        int index = 0;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            newArray[index++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
        }

        while (p1 <= mid) {
            newArray[index++] = array[p1++];
        }

        while (p2 <= right) {
            newArray[index++] = array[p2++];
        }

        for (int i = 0; i < newArray.length; i++) {
            array[left + i] = newArray[i];
        }
    }


    public void sortAndMerge(int[] array) {
        int step = 1;
        int length = array.length;
        while (step < length) {
            //左分组的第一个位置
            int left = 0;
            while (left < length) {
                //左侧分组能来到的最大的位置
                int n = left + step - 1;
                if (n >= length) {
                    break;
                }
                //右侧分组最大能到的位置
                int right = Math.min(n + step, length - 1);
                //在第一次分组中 进行merge操作
                merge(array, left, n, right);
                //下一次的同步长分组中的左侧分组的位置
                left = right + 1;
            }
            // 防止溢出int的最大值
            if (step > length / 2) {
                break;
            }
            //步长翻倍
            step <<= 1;
        }
    }

    /**
     * 数组小和：
     * 例，一个数组 [1,5,2,7,6,9]
     * 一个数左边小于它的的数的和被称为这个数的小和。那么一个数组中所有数的小和为这个数组的数组小和。
     * 1的左边为空 ，小和为 0
     * 5的左边为1 ，小和为 1
     * 2的左边为1、5 ，小和为1
     * 7的左边为1、5、2 ， 小和为1+5+2
     * 6的左边为1、5、2、7，小和为1+5+2
     * 9的左边为1、5、2、7、6，小和为1+5+2+7+6
     * <p>
     * 该数组的小和为 1 + （1） + （1+5+2） + （1+5+2） +（1+5+2+7+6）
     *
     * @param array
     */
    public int minSumOfArray(int[] array, int left, int right) {
        if (left == right) {
            return 0;
        }
        int mid = left + (right - left) << 1;
        return minSumOfArray(array, left, mid) +
                minSumOfArray(array, mid + 1, right) +
                minSumOfArrayMerge(array, left, mid, right);
    }


    /**
     * merge的过程就是产生小和的过程
     * 过程如下：
     * 左右两个分组，两个下标p1,p2指向两个数组的第一个元素，建立一个辅助数组help，那么合并的过程就是：
     * <p>
     * 1. 如果左侧p1指向的数据a，比p2指向的数b要小，那么将a放入辅助数组，小和sum = a * 右侧数组比a大的数的个数
     * 注：这个无需便利，由于左右两个数组都是排好序的，因此这个个数直接可以有b的下标做减法求得。
     * 2. 如果左侧p1指向的数据a>=p2指向的数b,那么将b放入辅助数组help，p2向后移动。
     *
     * @param array
     * @param left
     * @param mid
     * @param right
     * @return
     */
    private int minSumOfArrayMerge(int[] array, int left, int mid, int right) {
        int p1 = left;
        int p2 = mid + 1;
        int sum = 0;
        int[] help = new int[right - left];
        int index = 0;
        while (p1 <= mid && p2 <= right) {
            sum += array[p1] < array[p2] ? array[p1] * (right - p2 + 1) : 0;
            help[index++] = array[p1] < array[p2] ? array[p1++] : array[p2++];
        }


        while (p1 <= mid) {
            help[index++] = array[p1++];
        }

        while (p2 <= right) {
            help[index++] = array[p2++];
        }


        int i = 0;
        while (i <= index) {
            array[left + i] = help[i];
            i++;
        }


        return sum;
    }



}
