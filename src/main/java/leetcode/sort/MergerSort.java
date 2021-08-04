package leetcode.sort;

/**
 * @Author: czf
 * @Description:
 * 归并排序
 * @Date: 2021-07-28 14:43
 * @Version: 1.0
 **/
public class MergerSort {

    public static void main(String[] args) {
        int[] test = new int[]{3,2,1,4,21,45,6,17,34,8,91};
        sort1(test);
    }


    public static void sort(int[] array) {

    doSort(array,0,array.length-1);
        for (int i : array) {
            System.out.print(i+"  ");
        }
    }

    /**
     * 递归进行sort
     *
     * @param array
     * @param left
     * @param right
     */
    private static void doSort(final int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        doSort(array, left, mid);
        doSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private static void merge(final int[] array, int left, int mid, int right) {
        // 定义一个辅助数组
        int[] help = new int[right - left + 1];
        // 左数组下标
        int l = left;
        // 右数组下标
        int r = mid + 1;
        // 辅助数组指针
        int index = 0;

        while (l <= mid && r <= right) {
            help[index++] = array[l] > array[r] ? array[r++] : array[l++];
        }
        while (l <= mid) {
            help[index++] = array[l++];
        }
        while (r <= right) {
            help[index++] = array[r++];
        }
        for (int i = 0; i < help.length; i++) {
            array[left + i] = help[i];
        }
    }


    public static void sort1(final int[] array){
        if(array==null||array.length==0){
            return;
        }
        int length = array.length;
        int step = 1;
        while (step < length) {
            int left = 0;
            while(left<length){
                int mid = left+step-1;
                if(mid>length){
                    break;
                }
                int right = Math.min(mid+1,length - 1);
                merge(array,left,mid,right);
                left= right+1;
            }

            // 步长扩充一背
            step<<=1;

        }

        for (int i : array) {
            System.out.print(i+" ");
        }
    }

}
