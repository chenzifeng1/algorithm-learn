package dynamicProgramming;

import java.util.Map;
import java.util.TreeMap;

/**
 * @ProjectName:
 * @ClassName: DP_3
 * @Author: czf
 * @Description:
 * @Date: 2021/7/20 18:31
 * @Version: 1.0
 **/

public class DP_3 {
   final static Map<String,Integer> NUM_MAP = new TreeMap<>();
   final static Map<String,Integer> UNIT_MAP = new TreeMap<>();

   static {
       NUM_MAP.put("一",1);
       NUM_MAP.put("二",2);
       NUM_MAP.put("三",3);
       NUM_MAP.put("四",4);
       NUM_MAP.put("五",5);
       NUM_MAP.put("六",6);
       NUM_MAP.put("七",7);
       NUM_MAP.put("八",8);
       NUM_MAP.put("九",9);
       NUM_MAP.put("十",10);
       NUM_MAP.put("零",0);
       UNIT_MAP.put("千",1000);
       UNIT_MAP.put("百",100);
       UNIT_MAP.put("十",10);
   }

    public static void main(String[] args) {
        String param = "一千零一万一千零一";
        String param1 = "一千零一";
        String[] strs = param.split("万");
        long result =0;
        deal(param1,"千");


    }

    public static long deal(String str,String unit){
       String nxUnit="";
       if(unit.equals("千")&&str.contains("千")){
           nxUnit ="百";
       }else if(unit.equals("百")&&str.contains("百")){
           nxUnit="十";
       }
        String[] t = str.split(unit);
        int u = UNIT_MAP.getOrDefault(unit, 1);
        return (long) NUM_MAP.get(t[0].substring(t[0].length() - 1)) *u+deal(t[1],nxUnit);
    }

}
