package xor;


import utils.RandomList;

import java.util.Arrays;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenzifeng
 * @Package xor
 * @Description: *
 * <p>
 * 一个数组中有一种数出现了K数次，其他数出现了M数次，求这个数
 * M>1,K<M
 * 找到出现K次的数，要求额外空间复杂度为O(1)
 * </p>
 * <p>
 * 解题思路：int型变量长度为32位（4字节），那我们可以建一个长度为32的int数组array
 * 对给定数组中的每个数进行以下操作：
 * 将元素换成32位的二进制形式，然后将每一位都在array上做加操作，为1则+1，为0则+0
 * 最后获得了一个长度为32的数组，之后每一位对M进行取模，如果不为0，则说明所求的数在该位上
 * 为1，这样就可以将这个数的二进制表示出来，在转成十进制即可
 * </p>
 * @date 2021/1/1123:03
 */
public class KOddNum {

    public static int getKOddNum(int[] array, int k, int m) {
        if (k >= m) {
            System.out.println("参数错误");
        }
        int[] binArray = new int[32];
        //统计二进制数组
        for (int i : array) {
            setBinCount_1(binArray, i);
        }
        int temp = 0;
        for (int i = 0; i < binArray.length; i++) {
            if (binArray[i] % m != 0) {
                //这里相当于在i位置上把1设置上去
                temp |= (1 << i);
            }
        }
        return temp;
    }

    public static void setBinCount(int[] array, int num) {
        String binStr = Integer.toBinaryString(num);
        for (int i = 0; i < binStr.length(); i++) {
            array[i] += Integer.valueOf(binStr.charAt(binStr.length() - 1 - i) - '0');
        }
    }

    /**
     * 将累计num各位上的值到array
     *
     * @param array
     * @param num
     */
    public static void setBinCount_1(int[] array, int num) {
        for (int i = 0; i <= 31; i++) {
            //判断num第i位是否是1
            array[i] += (num >> i) & 1;
        }
    }

    /**
     * 使用hash表来解决问题
     *
     * @param array
     * @param k
     * @param m
     * @return
     */
    private static int test(int[] array, int k, int m) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int num : array) {
            hashMap.put(num, hashMap.containsKey(num) ?  hashMap.get(num) +1 : 1);
        }
        for (Integer integer : hashMap.keySet()) {
            if(hashMap.get(integer)==k){
                return integer;
            }
        }
        return Integer.MAX_VALUE;
    }

    /**
     * 对数器
     * @param args
     */
    public static void main(String[] args) {
        //元素种类个数的最大值
        int maxSize = 30;
        //元素值的最大值
        int maxValue = 100;
        //测试次数
        int testTimes = 100000;
        System.out.println("测试开始！");
        for (int i = 0; i < testTimes; i++) {
            int a = (int) (Math.random()*maxValue)+1;
            int b = (int) (Math.random()*maxValue)+1;
            int k = Math.min(a,b);
            int m = Math.max(a,b);
            m = m==k?m+1:m;
            int[] testArr = RandomList.generateRandomIntArray(maxSize,maxValue,k,m);
            if(test(testArr,k,m)!=getKOddNum(testArr,k,m)){
                System.out.println("出问题的测试用例为：");
                System.out.println("k:"+k+"  m:"+m);
                for (int i1 : testArr) {
                    System.out.print(i1+" ");
                }
                System.out.println();
                break;
            }
        }
        System.out.println("测试结束！");


    }


}
