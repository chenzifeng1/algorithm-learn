package leetcode.match;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName:
 * @ClassName: Match_5784
 * @Author: czf
 * @Description:
 * @Date: 2021/6/13 11:01
 * @Version: 1.0
 **/

public class Match_5784 {


    public static void main(String[] args) {
        String[] strs = new String[] {"abc","aabc","bc"};
        String[] strs1 = new String[] {"ab","a"};
        String[] strs2 = new String[] {"b","a"};

        System.out.println(makeEqual(strs1));
    }


        public static boolean makeEqual(String[] words) {
            Map<Character,Integer> chars = new HashMap<>();

            if(words.length <= 1){
                return true;
            }

            for (String word : words) {
                for (int i = 0; i < word.length(); i++) {
                    char c = word.charAt(i);
                    if(chars.containsKey(c)){
                        chars.put(c,chars.get(c)+1);
                    }else {
                        chars.put(c,1);
                    }
                }
            }
            int num = chars.get(words[0].charAt(0));
            for (Map.Entry<Character, Integer> entry : chars.entrySet()) {
                if(num != entry.getValue()){
                    return false;
                }
            }

            return num==words.length;



        }

}
