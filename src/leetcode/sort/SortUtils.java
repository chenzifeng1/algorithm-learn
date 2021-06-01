package leetcode.sort;

/**
 * @Author: czf
 * @Description:
 * @Date: 2021-06-01 19:22
 * @Version: 1.0
 **/
public class SortUtils {

    /**
     * 快排
     *
     * @param a
     * @param b
     */
    public void quickSort(final int[] a, final int[] b, int left, int right) {
        if (left >= right) {
            return;
        }
        int head = left;
        int tail = right;
        //取得基准点
        int pivot = a[head + (tail - head) >> 1];

        while (head < head) {
            //
            if (a[head] > a[pivot]) {
                int temp = a[head];
                a[head] = a[pivot];
                a[pivot] = temp;
                //b也要跟着动
                temp = b[head];
                b[head] = b[pivot];
                b[pivot] = temp;
                ++head;
            }
        }
        quickSort(a,b,left,pivot);
        quickSort(a,b,pivot,right);

    }

}
