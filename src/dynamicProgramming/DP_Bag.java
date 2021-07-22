package dynamicProgramming;

/**
 * @ProjectName:
 * @ClassName: DP_Bag
 * @Author: czf
 * @Description: 背包问题
 * v[] 价值
 * w[] 重量
 * int bag 容量
 * 选出符合容量的最大价值
 *
 *
 * @Date: 2021/7/21 21:19
 * @Version: 1.0
 **/

public class DP_Bag {

    public static void main(String[] args) {
        int[] value = new int[] {

        };
        int[] weight = new int[] {

        };
        int bag = 0;


    }

    /**
     *
     * @param v
     * @param w
     * @param index
     * @param rest
     * @return
     */
    public static int deal(int[] v,int[] w,int index,int rest){
        if(v.length==0||index>=v.length||v.length!=w.length){
            return 0;
        }
        if(rest<0){
            return -1;
        }
        // 不选index的货物
        int bv1 = deal(v,w,index+1,rest);
        // 选index的货物
        int temp = deal(v,w,index+1,rest-w[index]);
        int bv2 =temp==-1?0: temp;

        return Math.max(bv1,bv2);
    }

    public static int dealByDp(int[] v,int[] w,int index,int bag){
        int row = v.length+1;
        int col = bag+1;
        int[][]dp = new int[row][col];

        for(int i = v.length-1;i>=0;i--){
            for(int j = 0;j<col;j++){

                int bv1 = dp[i+1][j];
                // 选index的货物
                int temp =j-w[i]<0?-1:dp[i+1][j-w[i]];
                int bv2 = 0;

                if(temp!=-1){
                    bv2 = v[i] + temp;
                }
                dp[i][j] = Math.max(bv1,bv2);
            }
        }

        return dp[0][bag];

    }

}
