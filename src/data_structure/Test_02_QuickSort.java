package data_structure;

import java.util.HashMap;

/**
 * @ProjectName:
 * @ClassName: Test_02_MergeSort
 * @Author: czf
 * @Description:
 * 快速排序：要求空间复杂度为O(1),时间复杂度为O(N)
 *  1. 选取一个中间数num,将整个数组分成两个组，左边组是小于num,右边组大于num,不要求组内有序
 *  2. 一开始左边组的起始位置设为p = -1，使用index遍历右边组，如果array[index]<=num,那么将该位置与array[++p]互换，否则index++;
 *  3. 遍历完成之后，p所在位置就是左右两个组的分界的位置，然后左右递归调用
 *
 *
 * 进阶 分三个区域：< = > 荷兰国旗问题
 * 提示：左右两个区，往中间推
 * @Date: 2021/3/30 19:43
 * @Version: 1.0
 **/

public class Test_02_QuickSort {

    int[] array = new int[]{6, 9, 1, 5, 3, 2, 0, 7, 4};

    public static void main(String[] args) {

    }

    private void sort(int[] array, int left, int right) {
        if (left == right) {
            return;
        }
        int middle = left + (right-left)>>1;
        sort(array,left,middle);
        sort(array,middle+1,right);
        merge(array,left,middle,right);
    }


    private void merge(int[] array,int left,int middle,int right){
        int p1 = left;
        int p2 = middle +1 ;
        int temp =0;
        while (p1<=middle&&p2<=right){

        }
    }
}
