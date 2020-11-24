package offerAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class A_Offer_29_SpiralOrder {
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0)
            return new int[0];
        List<Integer> list = new ArrayList<>();
        int matrix_width = matrix[0].length;
        int matrix_height = matrix.length;
        int i = 0;
        try {
            while (i<((Math.min(matrix_height,matrix_width)+1)/2)) {
                //左边输出
                for (int k = i; k < matrix_width - i; k++) {list.add(matrix[i][k]); }
                //向下输出
                for (int k = i + 1; k < matrix_height - 1 - i; k++) {list.add(matrix[k][matrix_width- 1 - i]);}
                //向右边输出
                for (int k = i; k < matrix_width - i; k++)
                {
                    if(i>=matrix_height/2&&matrix_height%2==1)
                        break;
                    list.add(matrix[matrix_height - 1 - i][matrix_width - 1 - k]);
                }
                //向上输出
                for (int k = i + 1; k < matrix_height - 1 - i; k++) {
                    if(i>=matrix_width/2&&matrix_width%2==1)
                        break;
                    list.add(matrix[matrix_height - 1 - k][i]);
                }
                i++;
            }
        }catch (Exception e){
        }
        int[] result =  new int[matrix_width*matrix_height];
        for(int k=0;k<list.size();k++) result[k] = list.get(k);
        return result;
    }

    public static void main(String[] args) {
        spiralOrder(new int[][]{{2,5,8},{4,0,-1}});
    }
}
