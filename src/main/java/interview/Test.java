package interview;

/**
 * @ProjectName:
 * @ClassName: Test
 * @Author: czf
 * @Description:
 * @Date: 2021/7/22 20:12
 * @Version: 1.0
 **/

public class Test {
    static int count = 0;


    public static void main(String[] args) {
        int n = 10;
        int result = deal(1, 0, n) + deal(2, 0, n);
        int result1 = deal1(n);
        System.out.println("result:" + result);
        System.out.println("result1:" + result1);
    }

    /**
     * @param step  当前要走的步数
     * @param index 当前位置
     * @param n     终点
     * @return 方案数
     */
    public static int deal(int step, int index, int n) {
        if (step <= 0 || step > 2) {
            throw new IllegalArgumentException("错误输入");
        }
        if (index + step == n) {
            return 1;
        }
        if (index + step > n) {
            return 0;
        }
        return deal(1, index + step, n) + deal(2, index + step, n);
    }

    public static int deal1( int n) {

        int[] dp = new int[n + 1];
        dp[n] = 1;
        for (int i = n-1; i >= 0; i--) {
            int temp = dp[i+1];
            if(i+2<=n){
                temp+=dp[i+2];
            }
            dp[i] = temp;
        }
        return dp[0];
    }


}
