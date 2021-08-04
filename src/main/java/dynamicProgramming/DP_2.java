package dynamicProgramming;

/**
 * @ProjectName:
 * @ClassName: DP_2
 * @Author: czf
 * @Description:
 * 博弈问题： 有一堆纸牌排成一列 A,B两个选手先手抽牌，每次只能抽最左或者最右的牌，两人都是绝顶聪明
 * 求抽到最后谁的积分最大
 * @Date: 2021/7/17 22:40
 * @Version: 1.0
 **/

public class DP_2 {

    public static int dealByRecursion(int[] array){
        return firstChose(array,0,array.length);
    }




    public static int firstChose(int[] array,int l,int r){
        if(l==r){
            return array[r];
        }
        int left = array[l]+afterChose(array,l+1,r);
        int right = array[r]+afterChose(array,l,r-1);
        return Math.max(left,right);


    }

    private static int afterChose(int[] array, int l, int r) {
        if(l==r){
            return 0;
        }
        return Math.min(firstChose(array,l+1,r),firstChose(array,l,r-1));
    }

}
