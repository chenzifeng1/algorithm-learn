package utils;

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
        random.setSeed(1);
        for (int i = 0; i < array.length; i++) {
            array[i]=Math.abs((int)((maxValue+1)*Math.random()-(maxValue+1)*Math.random())) ;
        }
        return array;
    }
}
