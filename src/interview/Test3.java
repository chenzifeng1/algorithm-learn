package interview;

import java.util.HashMap;
import java.util.Map;

/**
 * @ProjectName:
 * @ClassName: Test3
 * @Author: czf
 * @Description: [3，45, 9，1，3，4，2，3，7，2]
 * <p>
 * 取出这个数组中按照频次排序TOP N元素
 * @Date: 2021/7/27 19:40
 * @Version: 1.0
 **/

public class Test3 {

    public static void main(String[] args) {
        int[] array = new int[]{
                3, 45, 9, 1, 3, 4, 2, 3, 7, 2
        };
        int[] count = count(array, 2);
        for (int i : count) {
            System.out.println(i);
        }

    }

    private static int[] count(int[] array, int n) {
        int[] result = new int[n];

        HashMap<Integer, Integer> countMap = new HashMap<>();
        for (int i : array) {
            if (countMap.containsKey(i)) {
                Integer num = countMap.get(i);
                countMap.put(i, num + 1);
            } else {
                countMap.put(i, 1);
            }
        }
        for (int i = 0; i < n; i++) {
            int max = 0;
            int temp = 0;
            // map统计之后进行变量，获取前n个
            for (Map.Entry<Integer, Integer> entry : countMap.entrySet()) {
                if (max < entry.getValue()) {
                    max = entry.getValue();
                    temp = entry.getKey();
                }
            }
            result[i] =temp;
            countMap.remove(temp);
        }
      return result;

    }
}
