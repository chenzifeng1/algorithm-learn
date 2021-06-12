package leetcode.match;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @ProjectName:
 * @ClassName: Match_5767
 * @Author: czf
 * @Description:
 * @Date: 2021/6/12 22:31
 * @Version: 1.0
 **/

public class Match_5767 {


    public static void main(String[] args) {
      int[][]  ranges = new int[][]{{1,2},{5,6},{3,4}} ;
      int[][]  ranges1 = new int[][]{{1,10},{10,20}} ;

        //判断，第一列是否相等，不相等则，使用第二列作为判断条件
        System.out.println(isCovered(ranges1,21,21));


    }
    public static boolean isCovered(int[][] ranges, int left, int right) {
        Arrays.sort(ranges, (x1, x2) -> {
            if(x1[0]==x2[0]){
                return x1[1]-x2[1];
            }
            return x1[0]-x2[0];
        });
        int count = 0;
        for (int i = left; i <= right; i++) {
            for (int[] range : ranges) {
                if(range[0]<=i&&i<=range[1]){
                    count++;
                    break;
                }
            }
        }

        return count==(right-left+1);
    }
}
