package niuke;

import java.util.ArrayList;

public class SpiralOrder {
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        int height = matrix.length;
        ArrayList<Integer> res = new ArrayList<>();
        if(height<=0) return res;
        int width = matrix[0].length;
        int totoalRowCount = 0;
        int count  = 0;
        while (count<width*height){
            int round = totoalRowCount/4;
            int direction = totoalRowCount%4;// 0 1 2 3
            // 左
            if(direction==0)
                for(int i=round;i<width-round;i++,count++)
                    res.add(matrix[round][i]);
                //下
            else if(direction==1)
                for(int i=round+1;i<height-round-1;i++,count++)
                    res.add(matrix[i][width-1-round]);
                //右
            else if(direction==2)
                for(int i=width-1-round;i>=round;i--,count++)
                    res.add(matrix[height-1-round][i]);
            // 上
            else
                for(int i=height-2-round;i>round;i--,count++)
                    res.add(matrix[i][round]);
            totoalRowCount++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(spiralOrder(new int[][]{{1}}));

    }
}
