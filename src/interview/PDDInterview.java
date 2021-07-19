package interview;

import java.util.Stack;

/**
 * @ProjectName:
 * @ClassName: PDDInterview
 * @Author: czf
 * @Description: 给你一个只包含 '(' 和 ')' 的字符串，找出最长有效（格式正确且连续）括号子串的长度。
 * 拼多多面试题
 * @Date: 2021/7/15 21:24
 * @Version: 1.0
 **/

public class PDDInterview {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        int max = 0;
        String s = "";

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i + 1);
            } else {

                if (stack.isEmpty()) {
                    stack.push(i + 1);
                } else {
                    max = Math.max(max, i - stack.pop());
                }

            }
        }

    }


    public static int dealByDP(String str) {

        int max = 0;
        int[] dp = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            dp[i] = 0;
        }

        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == ')') {
                if (str.charAt(i - 1) == '(') {
                    dp[i] = (i - 2) < 0 ? 2 : dp[i - 2] + 2;
                } else {
                    if (i - dp[i - 1] - 1 >= 0 && str.charAt(i - dp[i - 1] - 1) == '(') {
                        dp[i] = dp[i - 1] + ((i - dp[i - 1] - 2) >= 0 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                    }
                }
            }
            max = Math.max(max,dp[i]);

        }
        return max;
    }

}
