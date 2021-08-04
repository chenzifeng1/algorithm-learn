package utils;

import java.util.HashSet;
import java.util.Random;

/**
 * @author chenzifeng
 * @Package PACKAGE_NAME
 * @Description: 获取随机数组
 * @date 2021/1/621:55
 */
public class RandomList {
    private static Random random = new Random();

    /**
     * 获取一个长度随机的随机整数数组
     * @param maxSize 最大长度
     * @param maxValue 元素最大值
     * @return
     */
    public static int[] generateRandomIntArray(int maxSize,int maxValue){
        //Math.random 随机生成一个0-1的小数
        // (maxValue+1)*Math.random：随机生成一个0-maxValue+1的随机浮点数，强转之后就会变成0-maxValue的整数
        //这里让数组长度也随机
        int[] array = new int[(int) ((maxSize+1)*Math.random())];
        for (int i = 0; i < array.length; i++) {
            array[i]=Math.abs((int)((maxValue+1)*Math.random()-(maxValue+1)*Math.random())) ;
        }
        return array;
    }

    /**
     * 生成一个随机数组，其中只有一个数出现了k次，其他数出现了m次
     * @param maxKinds 元素种类
     * @param maxValue 数据中的最大值
     * @param k
     * @param m
     * @return
     */
    public static int[] generateRandomIntArray(int maxKinds,int maxValue,int k,int m){
        /**
         * 生成一个1-maxSize的随机数 +2防止只生成了一种数据
         */
        maxKinds =(int) Math.random()*maxKinds+2;
        /**
         * 数组长度其实已经固定了
         */
        int[] array = new int[k+(maxKinds-1)*m];
        //出现k次的数
        int key = (int) (Math.random()*maxValue)+1;
        int index = 0;
        for(;index<k;index++){
            array[index]=key;
        }
        //已经填了一种数进去了
        maxKinds--;
        HashSet<Integer> hashSet = new HashSet<>();
        hashSet.add(key);
        while (maxKinds>0){
            int num = 0;
            do{
                //得到一个未出现的数
                num = (int) (Math.random()*maxValue)+1;
            }while (hashSet.contains(num));
            maxKinds--;
            for(int i =0;i<m;i++){
                array[index] = num;
                index++;
            }
        }
        //上面的循环完成之后，此时array中的值的类型已经好了，不过是有序排列的，我们下面打乱顺序
        for(int i = 0; i<array.length;i++){
            int in = (int) (Math.random()*array.length);
            int temp = array[i];
            array[i] = array[in];
            array[in] = temp;
        }

        return array;
    }


    /**
     * 打印数组  方便查看测试用例
     * @param array
     */
    public static void printArray(int[] array){
        StringBuilder sb = new StringBuilder(array.length*2+1);
        sb.append('[');
        for (int i : array) {
        sb.append(i).append(',');
        }
         sb.deleteCharAt(sb.length() - 1);
        sb.append(']');
        System.out.println(sb.toString());
    }
}
