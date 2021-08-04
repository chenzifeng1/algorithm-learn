package leetcode.match;

/**
 * @ProjectName:
 * @ClassName: Match_5788
 * @Author: czf
 * @Description: 字符串中的最大奇数
 * 给你一个字符串 num ，表示一个大整数。请你在字符串 num 的所有 非空子字符串 中找出 值最大的奇数 ，并以字符串形式返回。如果不存在奇数，则返回一个空字符串 "" 。
 * @Date: 2021/6/20 10:31
 * @Version: 1.0
 **/

public class Match_5788 {

    public static void main(String[] args) {
        String num1 = "52";
        String num2 = "4206";
        String num3 = "4206723112";
        System.out.println(largestOddNumber(num3));
    }


    public static String largestOddNumber(String num) {
        char[] chars = num.toCharArray();
        int max=0;
        for (int i = 0; i < chars.length; i++) {
            if ((chars[i]-'0') % 2 == 1) {
                max = i+1;
            }
        }

        return max==0?"":num.substring(0,max);
    }


}
