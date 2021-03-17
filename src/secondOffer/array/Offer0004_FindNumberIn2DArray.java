package secondOffer.array;

/**
 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 [
 [1,   4,  7, 11, 15],
 [2,   5,  8, 12, 19],
 [3,   6,  9, 16, 22],
 [10, 13, 14, 17, 24],
 [18, 21, 23, 26, 30]
 ]


 */
public class Offer0004_FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length==0) return false;
        int i = 0;
        int j = matrix[0].length-1;
        while (i<matrix.length&&j>=0){
            if(target==matrix[i][j]) return true;
            else if(target>matrix[i][j]) i++;
            else if(target<matrix[i][j]) j--;
        }
        return false;
    }
}
