package dynamicProgramming;

/**
 * @ProjectName:
 * @ClassName: DP_4
 * @Author: czf
 * @Description: 给定映射 1-A,2-B,3-C,4-D....26-Z, 然后随机给定数字字符串，求有多少种字母序列对应该数字字符串
 * @Date: 2021/7/26 21:08
 * @Version: 1.0
 **/

public class DP_4 {

    /**
     *
     * @param chars
     * @param index 前0 到 i-1个字符已经完成了组合
     * @return
     */
    public static int process(char[] chars,int index){
        if(index==chars.length){
            // 到达了最后一个位置，说明之前的组合有效的
            return 1;
        }
        if(chars[index]=='0'){
            // 如果到达了index这个位置，这个下标下的数字是0，说明出问题了，之前的组合是错误的，因为0没有对应的字母可以转换
            return 0;
        }
        // 如果没有特殊情况，那当前下标的数字必然会有chars[index] 可以转成对应的字母
        int ways = process(chars,index+1);
        if(index+1<chars.length&&(chars[index]-'0')*10+(chars[index + 1] - '0')<27){
            // 如果当前的数字可以和下一个数字组合成一个小于27的数，那么说明可能存在两个数字对应字母的方法
            ways+=process(chars,index+2);
        }
        return ways;
    }


    public static int processByDP(char[] chars){
        int length = chars.length;
        int[] dp = new int[length+1];
        // 在暴力递归中，i位置依赖i+1和i+2的位置，也就是说左边依赖右边，应该从右边往左边推
        dp[length]=1;
        for (int i = length-1; i >=0; i--) {
            // 关于解决 chars[i]=='0'的问题，可以转换成 如果 chars[i]!='0'的时候，才进行dp[i]的计算，否则跳过
            if(chars[i] !='0'){
                int ways = dp[i+1];
                if(i+1<chars.length&&(chars[i]-'0')*10+(chars[i + 1] - '0')<27){
                    ways +=dp[i+2];
                }
                dp[i]=ways;
            }
        }

        return dp[0];
    }

}
