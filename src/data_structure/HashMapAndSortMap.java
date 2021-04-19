package data_structure;

import javax.crypto.spec.PSource;
import java.util.HashMap;
import java.util.TreeMap;

/**
 * @ProjectName: spring-security
 * @ClassName: HashMapAndSortMap
 * @Author: czf
 * @Description: 学习HashMap和SortMap两个集合的底层数据结构的实现
 * Hash表元素的增删改查 在使用时一律认为其时间复杂度为 O(1)
 *
 * 关于Integer类型 当值在 -128~127之间时 是按照值传递 超过这个范围则是按照引用传递
 * 但是在Hash表中 一律按照值传递 即Integer哪怕不在 -128~127的范围内，也按照值传递
 * 但是非基础类型包装类的key 按照引用传递
 *
 * 有序表 ：所有的方法(增删改查)的时间复杂度为O(logN)
 * @Date: 2021/3/11 20:19
 * @Version: 1.0
 **/

public class HashMapAndSortMap  {

    public static void main(String[] args) {
        //哈希表
        HashMap<String,String> hashMap = new HashMap<>();
        //有序表
        TreeMap<Integer,String> sortedMap = new TreeMap<>();
        sortedMap.put(5,"5");
        sortedMap.put(7,"7");
        sortedMap.put(6,"6");
        sortedMap.put(51,"51");
        sortedMap.put(15,"15");
        sortedMap.put(9,"9");

        sortedMap.entrySet().forEach((key)->{
            System.out.println(key);
        });

        System.out.println(sortedMap.firstKey());
        System.out.println(sortedMap.lastKey());
        // <= 8
        System.out.println(sortedMap.floorKey(8));
        // >= 8
        System.out.println(sortedMap.ceilingKey(8));
    }
}
