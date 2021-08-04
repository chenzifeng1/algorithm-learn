package leetcode.match;

/**
 * @ProjectName:
 * @ClassName: match_5776
 * @Author: czf
 * @Description: 判断矩阵经轮转后是否一致
 * @Date: 2021/6/6 10:35
 * @Version: 1.0
 **/

public class match_5776 {


    public static void main(String[] args) {
        int[][] mat = {{0, 0, 0}, {0, 1, 0}, {1, 1, 1}};
        int[][] target = {{1, 1, 1}, {0, 1, 0}, {0, 0, 0}};
        int[][] mat1 ={{0,1},{1,0}};
        int[][] target1 = {{1,0},{0,1}};
        System.out.println(findRotation(mat1,target1));
    }


//    public static boolean findRotation(int[][] mat, int[][] target) {
//        //中心位置
//        int len = mat.length;
//        boolean sign = false;
//
//
//        for (int k = 0; k < 4; k++) {
//            int count = 0;
//            for (int i = 0; i < len; i++) {
//                for (int j = 0; j < len; j++) {
//                    int temp = target[i][j];
//                    int com = 0;
//                    switch (k) {
//                        case 0:
//                            com = mat[i][j];
//                            break;
//                        case 1:
//                            com = mat[j][i];
//                            break;
//                        case 2:
//                            com = mat[len - i - 1][j];
//                            break;
//                        case 3:
//                            com = mat[j][len - i - 1];
//                            break;
//                    }
//                    if (com == temp) {
//                        sign = true;
//                        count++;
//                    } else {
//                        sign = false;
//                        break;
//                    }
//                }
//                if(!sign){
//                    break;
//                }else {
//                    return true;
//                }
//
//            }
//        }
//        return sign;
//    }
public static boolean findRotation(int[][] mat, int[][] target) {
        if(isEquals(mat,target)){
            return true;
        }else  {
            mat = change(mat);
            if(isEquals(mat,target)){
                return true;
            }else {
                mat = change(mat);
                if(isEquals(mat,target)){
                    return true;
                }else {
                    mat = change(mat);
                    if(isEquals(mat,target)){
                        return true;
                    }else {
                        return false;
                    }
                }
            }

        }

}



    private static boolean isEquals(int[][] mat, int target[][]) {
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == target[i][j]) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }


    public static int[][] change(int [][]matrix){
        int [][]temp=new int[matrix[0].length][matrix.length];
        int dst=matrix.length-1;
        for(int i=0;i<matrix.length;i++,dst--){
            for(int j=0;j<matrix[0].length;j++){
                temp[j][dst]=matrix[i][j];
            }
        }
        return temp;
    }

}
