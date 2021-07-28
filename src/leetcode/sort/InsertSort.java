package leetcode.sort;

/**
 * @Author: czf
 * @Description:
 * 插入排序
 * @Date: 2021-07-28 15:19
 * @Version: 1.0
 **/
public class InsertSort {

    public static void main(String[] args) {
        int[] test = new int[]{3,2,1,4,21,45,6,17,34,8,91};
        sort(test);
    }

    public static void sort(int[] array){
        int temp = 0;
        for (int i = 1; i < array.length; i++) {
            temp = array[i];
            int j=i-1;
            for(;j>=0;j--){
                if(temp>=array[j]){
                    break;
                }
                array[j+1] = array[j];
            }
            array[j+1]  =temp;
        }

        for (int i : array) {
            System.out.print(i+" ");
        }

    }
}
