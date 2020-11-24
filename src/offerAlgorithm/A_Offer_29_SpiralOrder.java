package offerAlgorithm;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。

  

 示例 1：

 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 输出：[1,2,3,6,9,8,7,4,5]
 示例 2：

 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
  

 限制：

 0 <= matrix.length <= 100
 0 <= matrix[i].length <= 100

 */
public class A_Offer_29_SpiralOrder {
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0)
            return new int[0];
        int height = matrix.length;
        int width = matrix[0].length;
        int size = height*width;
        int count = 0;
        int circle = 0;
        int [] reArray = new int[size];
        while (count<size){
            for(int i=circle;i<width-circle&&count<size;i++,count++)
                reArray[count] = matrix[circle][i];
            for(int i=circle+1;i<height-1-circle&&count<size;i++,count++)
                reArray[count] = matrix[i][width-1-circle];
            for(int i=width-1-circle;i>=circle&&count<size;i--,count++)
                reArray[count] = matrix[height-1-circle][i];
            for(int i=height-2-circle;i>circle&&count<size;i--,count++)
                reArray[count] = matrix[i][circle];
            circle++;
        }
        return reArray;
    }

    public static void main(String[] args) {
        spiralOrder(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
    }
}
