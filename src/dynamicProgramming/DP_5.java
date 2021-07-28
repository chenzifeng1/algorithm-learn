package dynamicProgramming;

/**
 * @ProjectName:
 * @ClassName: DP_5
 * @Author: czf
 * @Description: 贴纸问题 ： 给定一个字符串 只包含小写字母，另外一个字符串数组，包含多张贴纸，如果我可以贴纸剪碎（最小为一个字符），然后用剪碎的贴纸去拼接给定字符串
 * 求最少使用多少张贴纸，可以拼接出来给定字符串
 * 注：每种贴纸数量不限
 * String ababc
 * 贴纸： ab, c abdc
 * 答案 2  ab+ abdc / abdc+abdc
 * @Date: 2021/7/26 21:52
 * @Version: 1.0
 **/

public class DP_5 {

    public static void main(String[] args) {

    }


    public static int minStickers(String[] stickers, String targets) {
        int min = process1(stickers, targets);
        return min == Integer.MAX_VALUE ? -1 : min;
    }

    /**
     * @param stickers 贴纸
     * @param target   目标字符串 没有被拼接的剩余字符
     * @return
     */
    public static int process1(String[] stickers, String target) {
        // 边界条件 如果目标字符串都被拼完了， 那么就结束了
        if (target.length() == 0) {
            return 0;
        }

        int min = Integer.MAX_VALUE;
        // 每次抽出一个作为第一张贴纸
        for (String first : stickers) {
            // 用第一张贴纸进行拼接
            String rest = minus(target, first);
            if (rest.length() != target.length()) {
                // 这里有个求最少的过程，因为我们求得是最少使用张数
                min = Math.min(min, process1(stickers, rest));
            }
        }
        return min + (min == Integer.MAX_VALUE ? 0 : 1);
    }


    /**
     * 从target中减去这个贴纸中包含的字符
     *
     * @param target
     * @param cut
     * @return
     */
    public static String minus(String target, String cut) {
        char[] targetChars = target.toCharArray();
        char[] cutChars = cut.toCharArray();
        int[] counts = new int[26];
        for (char c : targetChars) {
            counts[c - 'a']++;
        }
        for (char c : cutChars) {
            counts[c - 'a']--;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > 0) {
                for (int j = 0; j < counts[i]; j++) {
                    sb.append('a' + j);
                }
            }
        }
        return sb.toString();
    }

//    --------------------------------*--------------------------------*--------------------------------*--------------------------------*--------------------------------

    



}

