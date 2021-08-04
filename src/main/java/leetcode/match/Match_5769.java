package leetcode.match;

/**
 * @ProjectName:
 * @ClassName: Match_5769
 * @Author: czf
 * @Description: 最大幻方
 * @Date: 2021/6/12 23:13
 * @Version: 1.0
 **/

public class Match_5769 {
    public int largestMagicSquare(int[][] grid) {
        int n = grid.length;
        int m= grid[0].length;
        int[][] dp = new int[n+1][m+1];
        for (int i = 0; i < (n + 1); i++) {
            dp[i][0]=1;
        }
        for (int i = 0; i < (m + 1); i++) {
            dp[0][i] = 1;
        }
        
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                int sum =0;
               if(isMagic(grid,Math.min(i,j),i,j)){
                   dp[i][j] = Math.max(dp[i][j-1],dp[i][j-1]+1);
               }

            }
        }
        return dp[n+1][m+1];
    }

    public boolean isMagic(int[][] array, int len, int x, int y){
        int sum = 0;
        int temp = 0;
        for (int i = x; i < len+x; i++) {
            sum+=array[i][y];
        }


        for (int i = x; i < len+x; i++) {
            for (int j = y; j < len+y; j++) {
                temp += array[i][j];
            }
            if(sum!=temp){
                return false;
            }
        }
        for (int i = y+1; i < len+y; i++){
            for (int j = x; j < len+x; j++) {
                temp += array[j][i];
            }
            if(sum!=temp){
                return false;
            }
        }

        return true;

    }
}
