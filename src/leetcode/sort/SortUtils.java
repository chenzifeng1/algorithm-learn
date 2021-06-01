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
     * @param a
     * @param b
     */
    public void quickSort(final int[] a,final int[] b,int left,int right){
        if(left>=right){
            return;
        }
        int head = left;
        int tail = right;
        //取得基准点
        int pivot = head+(tail-head)>>1;
        while (head < tail) {
            if(a[head]>a[tail]){

            }

        }


    }

}
