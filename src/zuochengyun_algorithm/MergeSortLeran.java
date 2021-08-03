package zuochengyun_algorithm;

/**
 * @Author: czf
 * @Description: 归并排序及其扩展问题
 * @Date: 2021-08-03 17:10
 * @Version: 1.0
 **/
public class MergeSortLeran {


    /**
     * 合并函数
     *
     * @param array
     * @param left
     * @param mid
     * @param right
     */
    public void merge(int[] array, int left, int mid, int right) {
        if (left >= right) {
            return;
        }
        // 左组下标
        int l = left;
        // 右组下标
        int r = mid + 1;
        // 辅助数组下标
        int index = 0;
        // 辅助数组
        int[] help = new int[right - left + 1];

        // 开始合并
        while (l <= mid && r <= right) {
            // 谁小放前面
            help[index++] = array[l]<array[r]?array[l++] : array[r++];
        }

        // 比较完成之后，还有一个组有剩余元素没有加进来

        while(l<=mid){
            help[index++] = array[l++];
        }
        while (r<=right){
            help[index++] = array[r++];
        }

        // 将辅助数组的值拷贝回主数组
        System.arraycopy(help, 0, array, left , help.length);

    }
    // *********************************************************************递归版**********************************************************************************************

    /**
     * 递归版
     * @param array
     * @param left
     * @param right
     * @return
     */
    public void sortByRecursion(final int[] array,int left,int right){
        if(left>=right){
            return;
        }
        int mid = left + ((right-left)>>1);
        sortByRecursion(array,left,mid);
        sortByRecursion(array,mid+1,right);
        // 当一个递归中 走到了merge这一步，则说明对应的左右两组数列已经局部有序
        merge(array,left,mid,right);
    }

    // ********************************************************************迭代版***********************************************************************************************

    /**
     * 迭代版 核心思想，使用步长解决分组问题
     * @param array
     */
    public void sortByIteration(int[] array){
        if(array==null||array.length==0){
            return;
        }
        // 步长
        int step = 1;
        int len = array.length;

        // 外层 大循环，当步长超过整个数组长度停止
        while(step<=len){
            int left = 0;
            // 同一步长下的分组 循环
            while(left<=len){

                int mid = left+step-1;
                if(mid>len){
                    // 不够一组了 即左组都不够了，直接返回
                    break;
                }
                int right = mid + step; 

            }
        }


    }

}
