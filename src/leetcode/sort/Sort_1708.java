package leetcode.sort;

/**
 * @Author: czf
 * @Description: 马戏团人塔
 *
 *有个马戏团正在设计叠罗汉的表演节目，一个人要站在另一人的肩膀上。出于实际和美观的考虑，在上面的人要比下面的人矮一点且轻一点。已知马戏团每个人的身高和体重，请编写代码计算叠罗汉最多能叠几个人。
 *示例：
 *
 * 输入：height = [65,70,56,75,60,68] weight = [100,150,90,190,95,110]
 * 输出：6
 * 解释：从上往下数，叠罗汉最多能叠 6 层：(56,90), (60,95), (65,100), (68,110), (70,150), (75,190)
 * 提示：height.length == weight.length <= 10000
 *
 * 思路： 题目核心应该是多条件排序
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/circus-tower-lcci
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Date: 2021-06-01 19:07
 * @Version: 1.0
 **/
public class Sort_1708 {

    public static void main(String[] args) {
        int[] height =new int[] {65,70,56,75,60,68} ;
        int[] weight =new int[] {100,150,90,190,95,110};
        int[] height_1 =new int[]{2868,5485,1356,1306,6017,8941,7535,4941,6331,6181};
        int[] weight_1 = new int[]{5042,3995,7985,1651,5991,7036,9391,428,7561,8594};

        System.out.println(bestSeqAtIndex(height_1,weight_1));

    }


    public static int bestSeqAtIndex(int[] height, int[] weight) {
        quickSort(height, weight,0,height.length-1);
        int index =0;
        int num =1;
        // 这里不能这么搞，体重A,B,C,D 有可能是B>A>C>D 按逻辑能叠3层，但是这么搞只能叠两层
        for (int i = 1; i < weight.length; i++) {
            if(weight[index]<weight[i]&&height[index]!=height[i]){
                num++;
                index = i;
            }
        }
        return num;
    }

    /**
     * 快排
     *
     * @param a
     * @param b
     */
    public static void quickSort(final int[] a, final int[] b, int left, int right) {
        if (left >= right) {
            return;
        }
        int head = left;
        int tail = right;
        //取得基准点
        int pivot = a[head];
        int pivotB = b[head];

        while (head < tail) {
            // 从后看看有没有连续大于基准点的数据
            while (head < tail && a[tail] >= pivot) {
                --tail;
            }
            if (head < tail) {
                a[head] = a[tail];
                b[head] = b[tail];
                ++head;
            }

            //看看是不是有连续小于基准点的数
            while (head < tail && a[head] <= pivot) {
                ++head;
            }
            if (head < tail) {
                a[tail] = a[head];
                b[tail] = b[head];
                --tail;
            }
        }
        a[head] = pivot;
        b[head] = pivotB;
        quickSort(a, b, left, head);
        quickSort(a, b, head+1, right);

    }
}
