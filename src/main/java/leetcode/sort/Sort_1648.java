package leetcode.sort;


import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Date;

/**
 * @Author: czf
 * @Description:
 * @Date: 2021-06-09 13:51
 * 你有一些球的库存inventory，里面包含着不同颜色的球。一个顾客想要任意颜色 总数为orders的球。
 * <p>
 * 这位顾客有一种特殊的方式衡量球的价值：每个球的价值是目前剩下的同色球的数目。比方说还剩下6个黄球，那么顾客买第一个黄球的时候该黄球的价值为6。这笔交易以后，只剩下5个黄球了，所以下一个黄球的价值为5（也就是球的价值随着顾客购买同色球是递减的）
 * <p>
 * 给你整数数组inventory，其中inventory[i]表示第i种颜色球一开始的数目。同时给你整数orders，表示顾客总共想买的球数目。你可以按照 任意顺序卖球。
 * <p>
 * 请你返回卖了 orders个球以后 最大总价值之和。由于答案可能会很大，请你返回答案对 10^9+ 7取余数的结果。
 * <p>
 * 示例1
 * 输入：inventory = [2,5], orders = 4
 * 输出：14
 * 解释：卖 1 个第一种颜色的球（价值为 2 )，卖 3 个第二种颜色的球（价值为 5 + 4 + 3）。
 * 最大总和为 2 + 5 + 4 + 3 = 14 。
 * <p>
 * 示例2
 * 输入：inventory = [3,5], orders = 6
 * 输出：19
 * 解释：卖 2 个第一种颜色的球（价值为 3 + 2），卖 4 个第二种颜色的球（价值为 5 + 4 + 3 + 2）。
 * 最大总和为 3 + 2 + 5 + 4 + 3 + 2 = 19 。
 * <p>
 * 示例3
 * <p>
 * 输入：inventory = [2,8,4,10,6], orders = 20
 * 输出：110
 * <p>
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sell-diminishing-valued-colored-balls
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * <p>
 * 解题思路: 其实就是不断找最大值的过程，但是由于测试用例给的数据
 * @Version: 1.0
 **/
public class Sort_1648 {

    // FIXME 这里无法处理大数
    public static void main(String[] args) {
        int[] array = new int[]{3, 5};

        int[] array1 = new int[]{1000000000};
        int[] array2 = new int[]  {497978859,167261111,483575207,591815159};

        int time2= 836556809;

        int[] array3 = new int[]{3,5};
        int[] array4 = new int[]{2,5};
        int[] array5 =new int[]{81,86,43,41,37,51,93,23,15,22,26,89,37};
        int time3=6;
        int time4=4;
        int time5=256;

        System.out.println(maxProfit(array5,time5));

    }


    public static int maxProfit(int[] inventory, int orders) {
        long mod = 1000000007;
        if(inventory.length==1){
            long res =0;
            res+=sum(inventory[0],inventory[0]-orders);
            return (int)(res%mod);
        }
        Arrays.sort(inventory);
        int len = inventory.length;
        //t从最大值开始减少
        int t = inventory[len - 1];
        // 求临界值T，在本次求解中，只有大于等于T的元素才有资格参与运算，小于的T不会参与运算
        int m;
        do {
             m = 0;
            int res = 0;
            for (int i = len - 1; i >= 0; --i) {
                if (inventory[i] < t) {
                    break;
                }
                res += inventory[i] - t;
                m++;
            }
            if (res <= orders && res + m >= orders) {
                break;
            }
            t--;
        } while (t > 0);
        System.out.println("t: " + t);
        int index = len-1;
        long sum = 0;
        while (orders>0){
            if(orders<m){
                if (index>=0&&inventory[index] > t) {
                    sum+=sum(inventory[index],inventory[index]-t);
                    orders-=inventory[index]-t;
                    inventory[index]-=inventory[index]-t;
                }

                int temp = len - 1;
                for (int i = 0; i < orders; i++) {
                    sum+=inventory[temp-i];
                }
                break;
            }
            int time = Math.min(inventory[index]-t,orders);
            sum+=sum(inventory[index], inventory[index]-time);
            inventory[index]-=time;
            orders-=time;
            index--;

        }

        return (int) (sum%mod);
    }

    private static int getSum(long baseNum, int time) {
        BigInteger sum = new BigInteger("0");
        for (int i = 0; i < time; i++) {
            sum=sum.add(new BigInteger(String.valueOf(baseNum--)));
        }
        return sum.intValue();
    }

    //------------------------------------------------------------------------------------------------------------------

    /**
     * 等差数列求和，差值为1
      * @param max
     * @param min
     * @return
     */
    public static long sum(int max, int min){
        long n = max-min;
        return n*min+n*(n+1)/2;
    }



}
