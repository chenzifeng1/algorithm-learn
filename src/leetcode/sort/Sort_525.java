package leetcode.sort;

/**
 * @ProjectName:
 * @ClassName: Sort_525
 * @Author: czf
 * @Description: 元素相等的最长连续子数组
 * 给定一个二进制数组 nums , 找到含有相同数量的 0 和 1 的最长连续子数组，并返回该子数组的长度。
 *
 * 示例 1:
 *
 * 输入: nums = [0,1]
 * 输出: 2
 * 说明: [0, 1] 是具有相同数量0和1的最长连续子数组。
 * 示例 2:
 *
 * 输入: nums = [0,1,0]
 * 输出: 2
 * 说明: [0, 1] (或 [1, 0]) 是具有相同数量0和1的最长连续子数组。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/contiguous-array
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2021/6/3 21:14
 * @Version: 1.0
 **/

public class Sort_525 {

    public static void main(String[] args) {
        int[] array = new int[]{0,1,0,1,1,1,1,0};
        int[] array1 = new int[]{0,0,1,0,0,0,1,1};
        System.out.println(findMaxLength(array));
    }


    public static int findMaxLength(int[] nums) {
        if(nums.length<2){
            return 0;
        }
        int suffixCount = 0;
        int len = nums.length;
        int lastIndex = 0;
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            suffixCount+=nums[i]==0?-1:1;
            if(suffixCount==0){
                max = Math.max((i - lastIndex), max);
            }
            if(Math.abs(suffixCount)>len-i){
                //这里本次迭代就到这里 回溯到
                i = lastIndex+Math.abs(suffixCount)-(len-i);
                lastIndex = i;
                suffixCount=0;
            }
            //可能还缺个边界条件

        }
        return max;
    }
}
