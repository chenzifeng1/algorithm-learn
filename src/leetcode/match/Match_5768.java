package leetcode.match;

import java.lang.reflect.Array;

/**
 * @ProjectName:
 * @ClassName: Match_5768
 * @Author: czf
 * @Description:
 * @Date: 2021/6/12 22:48
 * @Version: 1.0
 **/

public class Match_5768 {
    public static void main(String[] args) {
      int[]  chalk =new int[] {5,1,5};
      int k = 22;

        int []   chalk1 =new int[] {3,4,1,2};
        int k1 = 25;
        System.out.println(chalkReplacer(chalk,k));
    }

    public  static int chalkReplacer(int[] chalk, int k) {
        int length = chalk.length;
        int index = 0;

        long chalkSum =0;
        for (int i : chalk) {
            chalkSum+=i;
        }
        k= (int) (k%chalkSum);

        while (k>=0){
            k-=chalk[(index++)];
            if(k<0) {
                return (index-1)%length;
            }else if(k==0){
                return (index)%length;
            }

            index=index%length;
        }
        return -1;
    }
}
