package xor;

import utils.RandomList;

/**
 * @author chenzifeng
 * @Package java.xor
 * @Description: 异或运算学习
 * 0^N=N
 * N^N=0
 * 异或满足结合律和交换律
 * @date 2021/1/621:39
 */

public class XorTest {


    public static void main(String[] args) {
       int[] a = RandomList.generateRandomIntArray(10,10);
       int[] b = new int[]{1,1,2,3,3,4,5,5,6,6};
       int[] c = new int[]{11,11,11,28917,33,33,33,444,444,444,555,555,555,666,666,666};
       KOddNum.getKOddNum(c,1,3);
    }

    /**
     * 两个数交换
     * 注意，这里不能传两个引用相同的参数
     * @param a
     * @param i
     * @param j
     */
    public static void exchange(int[] a,int i,int j){
        if(i<0||j<0||i>a.length||j>a.length||i==j){
            throw new IllegalArgumentException("参数错误");
        }
        a[i]=a[i]^a[j];
        a[j]=a[i]^a[j];
        a[i]=a[i]^a[j];
    }

    /**
     * 给定一系列数，这些数可能重复，但有且仅有一个数出现了奇数次，求这个数
     * @param a
     * @return
     */
    public static int lookingForOddNumber(int[] a){
        //N^0=N
        int temp =0;
        for (int i : a) {
            temp=i^temp;
        }
        return temp;
    }

    /**
     * 获取一个数的2进制形式下最右侧的1的位置
     * @param num
     * @return
     */
    public static String getRightest1(int num){
        //两个方式的效果相同
        int temp = num&(~num+1);
        int temp1 = num&(-num);
        System.out.println(temp==temp1);
        System.out.println(Integer.toBinaryString(temp));
        return Integer.toBinaryString(temp);
    }

    /**
     * 一个数组中有2种数出现了奇数次，其他数出现了2数次，求这两个数
     * 找到出现2次的数，要求额外空间复杂度为O(1)
     * @param array
     * @return
     */
    public static void getTwoOddNum(int[] array){
        //所求的两个奇数次的数为a,b
        int eor = 0;
        //循环结束之后，eor=a^b
        for (int i : array) {
            eor = eor^i;
        }
        //获取二进制a,b最右侧的1的位置n（获取哪一个位上的1不重要，这里只要获取一个1的位置即可）
        //目的是把数组分成两组:一组是位置n为1的，一组是位置n为0的
        int temp = eor&(-eor);
        int eor1=0;
        for (int i : array) {
            if((i&temp)==0){
               // 获取位置n为1的数
               eor1 = eor1^i;
            }
        }
        //循环结束得到的eor1就是a，b中的位置n为1的那个
        //假设eor1为a,那这里相当于是eor=a^a^b 求得是b
        eor=eor^eor1;
        System.out.println(String.format("a:%d,b:%d",eor,eor1));
    }




}
