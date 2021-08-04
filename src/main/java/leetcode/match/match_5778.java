package leetcode.match;

/**
 * @ProjectName:
 * @ClassName: match_5778
 * @Author: czf
 * @Description:
 * @Date: 2021/6/6 11:54
 * @Version: 1.0
 **/

public class match_5778 {
    public static void main(String[] args) {
        String str = "111100110";
        String str1 = "111000";
        String str2 = "01001001101";
        System.out.println(minFlips(str1));
    }


    public static int minFlips(String s) {
        if(s.length()<=1){
            return 0;
        }else if(s.length()==2){
            return s.charAt(1)==s.charAt(0)?0:1;
        }
        char[] chars = s.toCharArray();
        char first = chars[0];
        char second = chars[1];
        char last = chars[0];
        String newStr;
        if(first==second&&first!=last){
             newStr = (s+first).substring(1);
        }else {
            newStr =s;
        }
        chars = newStr.toCharArray();
        first = chars[0];
        int count = 0;
        for (int i = 0; i < chars.length; i++) {
            if(i%2==0){
                if(chars[i]!=first){
                    count++;
                }
            }else {
                if(chars[i] == first){
                    count++;
                }
            }
        }
        return count;
    }


}
