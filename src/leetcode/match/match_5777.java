package leetcode.match;

import java.util.*;

/**
 * @ProjectName:
 * @ClassName: match_5777
 * @Author: czf
 * @Description: match
 * @Date: 2021/6/6 11:33
 * @Version: 1.0
 **/

public class match_5777 {
    public static void main(String[] args) {
        int[] arr1= {1,1,2,2,3};
        int[] arr = {7,9,10,8,6,4,1,5,2,3};
        System.out.println(reductionOperations(arr1));


    }

    public  static int reductionOperations(int[] nums) {
      Arrays.sort(nums);

      int min = nums[0];

      Map<Integer,Integer> map  = new TreeMap<>(new Comparator<Integer>() {
          @Override
          public int compare(Integer o1, Integer o2) {
              return o2-o1;
          }
      });
        for (int i = 0; i < nums.length; i++) {
            int temp = nums[i];
            if (map.containsKey(temp)){
                int count = map.get(temp)+1;
                map.put(temp,count);
            }else {
                map.put(temp,1);
            }
        }
        int result =0;
        if(map.size()<=1){
            return 0;
        }


        int change = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(entry.getKey()==min){
              break;
            }else {
                result+=change+entry.getValue();
                change+=entry.getValue();
            }
        }
        return result;
    }
}
