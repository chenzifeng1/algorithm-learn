package interview;

/**
 * @ProjectName:
 * @ClassName: Test1
 * @Author: czf
 * @Description:
 * @Date: 2021/7/22 20:51
 * @Version: 1.0
 **/

public class Test1 {
    public static void main(String[] args) {
        int[] a = new int[] {
            1,5,3,4,9,2
        };
        sort(a,0,a.length-1);

        for (int i : a) {
            System.out.println(i);
        }

    }

    public static void sort(int[] array,int left,int right){
        if(left>right){
            return;
        }
        int temp = array[left];
        int l = left;
        int r = right;

        while (l<r){
            while(array[r]>temp&&l<r){
                r--;
            }
            array[l]=array[r];
            while (array[l]<=temp&&l<r){
                l++;
            }
            array[r] = array[l];
        }
        array[l] = temp;
        sort(array,left,l-1);
        sort(array,l+1,right);
    }


}
