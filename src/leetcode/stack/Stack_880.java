package leetcode.stack;

import java.net.StandardProtocolFamily;
import java.nio.channels.InterruptibleChannel;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @Author: czf
 * @Description:
 *
 *
给定一个编码字符串 S。请你找出 解码字符串 并将其写入磁带。解码时，从编码字符串中 每次读取一个字符 ，并采取以下步骤：

如果所读的字符是字母，则将该字母写在磁带上。
如果所读的字符是数字（例如 d），则整个当前磁带总共会被重复写 d-1 次。
现在，对于给定的编码字符串 S 和索引 K，查找并返回解码字符串中的第 K 个字母。
示例 1：

输入：S = "leet2code3", K = 10
输出："o"
解释：
解码后的字符串为 "leetleetcodeleetleetcodeleetleetcode"。
字符串中的第 10 个字母是 "o"。
示例 2：

输入：S = "ha22", K = 5
输出："h"
解释：
解码后的字符串为 "hahahaha"。第 5 个字母是 "h"。
示例 3：

输入：S = "a2345678999999999999999", K = 1
输出："a"
解释：
解码后的字符串为 "a" 重复 8301530446056247680 次。第 1 个字母是 "a"。
 

提示：

2 <= S.length <= 100
S只包含小写字母与数字 2 到 9 。
S以字母开头。
1 <= K <= 10^9
题目保证 K 小于或等于解码字符串的长度。
解码后的字符串保证少于2^63个字母。

解体思路：逆向还原，如果是真的把字符串评出来，在给定字符串数字较多的情况下，可能会得到一个巨大无比的字符串，即使通过某个判定条件来提前终止，
但是K的范围是0-10^9的，所以依然可能耗费巨大内存。
逆向思路： 由于返回的字符一定来自与给定字符串内的非数字字符，且扩展之后的字符串一定是由给定字符串在规则上进行扩展得到的，因此我们可以先算出扩展后字符串的长度，在逆向求解k在原字符串中的位置
假设得到的扩展后的字符串长度为N（非数字），原字符串长度为n（包含数字），指定位置k
我们在做逆向拆解的时候注意，需要从原字符串的尾元素开始遍历，因为我们是从头元素开始生成的，到尾元素截至。那么拆解的时候就需要反着来。
1. 如果尾元素是数字d：那么说明最后一次操作是某字符串复制了d-1次，那么我们找k就相当于在size/d内的元素中查找
2. 如果尾元素是字母，说明最后一次操作是append了一个字母。 size--





来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/decoded-string-at-index
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @Date: 2021-05-29 15:32
 * @Version: 1.0
 **/
public class Stack_880 {

    public static void main(String[] args) {
        String test0 =  "leet2code3";
        String test1 =  "a23456";
        String test2 =  "ha22";
        String ixm5xmgo78 = "ixm5xmgo78";


        System.out.println(decodeAtIndex(ixm5xmgo78,711));


    }

    private static String decodeAtIndex(String s, int k) {
        int oldNum = s.length();
        long size = 0;
        for (int i = 0; i < oldNum; i++) {
            if (Character.isLetter(s.charAt(i))){
                ++size;
            }else {
                size*=Character.getNumericValue(s.charAt(i));
            }
        }

        for (int i = oldNum-1; i >= 0; --i) {
            char c = s.charAt(i);
            // 总体长度变化之后，所求的k的位置也要跟着遍
            k %=  size;
            if((k == 0) && Character.isLetter(c)){
                return String.valueOf(c);
            }
            if(Character.isDigit(c)){
                size/=(Character.getNumericValue(c));
            }else {
                size--;
            }
        }
        throw new IllegalArgumentException();
    }

    /**
     * 原思路：拼接字符串，大于等于K时终止
     * @param s
     * @param k
     * @return
     */
    @Deprecated
    public static String decodeAtIndexOld(String s, int k) {

        StringBuilder str = new StringBuilder();
        char[] chars = s.toCharArray();
        if(chars.length==1){
            return s;
        }
        int index = 0;
        while (str.length()<k){
            if(1<chars[index]-48&& chars[index]-48<10){
                // 如果是数字
                String temp = str.toString();
                for (int i = 0; i < (Integer.valueOf(String.valueOf(chars[index])) - 1); i++) {
                    str.append(temp);
                }
                ++index;
            }else {
                str.append(chars[index++]);
            }

        }
        return String.valueOf(str.charAt(k-1));

    }
}
