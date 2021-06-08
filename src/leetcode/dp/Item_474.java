package leetcode.dp;

/**
 * @ProjectName:
 * @ClassName: Item_474
 * @Author: czf
 * @Description: 1和0  动态规划
 * 给你一个二进制字符串数组 strs 和两个整数 m 和 n 。
 *
 * 请你找出并返回 strs 的最大子集的大小，该子集中 最多 有 m 个 0 和 n 个 1 。
 *
 * 如果 x 的所有元素也是 y 的元素，集合 x 是集合 y 的 子集 。
 *
示例 1：

输入：strs = ["10", "0001", "111001", "1", "0"], m = 5, n = 3
输出：4
解释：最多有 5 个 0 和 3 个 1 的最大子集是 {"10","0001","1","0"} ，因此答案是 4 。
其他满足题意但较小的子集包括 {"0001","1"} 和 {"10","1","0"} 。{"111001"} 不满足题意，因为它含 4 个 1 ，大于 n 的值 3 。
示例 2：

输入：strs = ["10", "0", "1"], m = 1, n = 1
输出：2
解释：最大的子集是 {"0", "1"} ，所以答案是 2 。

解题思路： 动态规划的背包问题 进阶

最终得到 \textit{dp}[l][m][n]dp[l][m][n] 的值即为答案。

由此可以得到空间复杂度为 O(lmn)O(lmn) 的实现。



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/ones-and-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2021/6/8 7:04
 * @Version: 1.0
 **/

public class Item_474 {

    public static void main(String[] args) {
        String[] str = new String[] {"10", "0001", "111001", "1", "0" } ;
        System.out.println(findMaxForm(str,5,3));
    }



    public static int findMaxForm(String[] strs, int m, int n) {
        //dp[i][j][k] 表示前i个字符串中，使用j个0和k个1 所能选择的子集的最多元素个数
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        int len = strs.length;

         for (int i = 1; i <= len; i++) {
            int[] nums = getZero(strs[i-1]);
            int zeros = nums[0],ones = nums[1];
            for (int j = 0; j <= m; j++) {
                for (int k = 0; k <=n; k++) {
                    // 因为是动态规划，所以直接从上一个状态开始计算
                    dp[i][j][k] = dp[i-1][j][k];
                    if(zeros<= j&&ones<=k){
                        dp[i][j][k] = Math.max(dp[i][j][k],dp[i-1][j-zeros][k-ones]+1);
                    }
                }
            }
        }


        return dp[len][m][n];
    }

    private static int[] getZero(String str){
        int[] nums = new int[2];
        for (int i = 0; i < str.length(); i++) {
            nums[str.charAt(i)-'0']++;
        }
        return nums;

    }

}
