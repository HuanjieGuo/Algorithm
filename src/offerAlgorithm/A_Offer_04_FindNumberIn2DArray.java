package offerAlgorithm;

/**
 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。

  

 示例:

 现有矩阵 matrix 如下：

 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]
 给定 target = 5，返回 true。

 给定 target = 20，返回 false。

  

 限制：

 0 <= n <= 1000

 0 <= m <= 1000

 */
public class A_Offer_04_FindNumberIn2DArray {
    /**
     *  二叉树搜索  复杂度(m+n)
     *  起点为右上角或者左下角！
     [
     [1,   4,  7, 11, 15],
     [2,   5,  8, 12, 19],
     [3,   6,  9, 16, 22],
     [10, 13, 14, 17, 24],
     [18, 21, 23, 26, 30]
     ]
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        // 左下角18起始点
        int row = matrix.length-1;
        int col = 0;
        while (col<matrix[0].length&&row>=0)
            if(matrix[row][col]==target) return true;
            else if(target>matrix[row][col]) col++;
            else row--;
        return false;
    }
}
