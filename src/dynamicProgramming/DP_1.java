package dynamicProgramming;

/**
 * @ProjectName:
 * @ClassName: DP_1
 * @Author: czf
 * @Description:
 * 指定 开始位置， 走N步 到达aim位置的走法总数
 *
 * @Date: 2021/7/17 20:54
 * @Version: 1.0
 **/

public class DP_1 {


    public static void main(String[] args) {

    }

    /**
     * 暴力递归形态
     * @param n
     * @param start
     * @param aim
     * @param k
     * @return
     */
    public static int way(int n, int start, int aim, int k) {
        if (k == 0) {
            return start == aim ? 1 : 0;
        }
        if (start == 0) {
            return way(n, 2, aim, k - 1);
        } else if (start == n){
            return way(n,n-1,aim,k-1);
        }
        return way(n,start+1,aim,k-1) + way(n,start-1,aim,k-1);
    }

    /**
     * 动态规划版本
     * @param n
     * @param start
     * @param aim
     * @param k
     * @return
     */
    public static int way1(int n,int start,int aim,int k){
        int[][] dp = new int[n+1][k+1];
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < k + 1; j++) {
                dp[i][j] = -1;
            }
        }

        for (int i = 1; i <= n; i++) {
            dp[i][0]= i==aim?1:0;
        }

        for(int i =1 ;i<=k;i++){
            dp[1][i] = dp[2][i-1];
            for(int j= 2;j<n;j++){
                dp[i][j] = dp[i-1][j-1]+dp[i+1][j-1];
            }
            dp[n][i]= dp[n-1][i-1];
        }

        return dp[aim][k];

    }


}
