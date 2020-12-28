package offerAlgorithm;

/**
 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？

  

 示例 1:

 输入:
 [
   [1,3,1],
   [1,5,1],
   [4,2,1]
 ]
 输出: 12
 解释: 路径 1→3→5→2→1 可以拿到最多价值的礼物
  

 提示：

 0 < grid.length <= 200
 0 < grid[0].length <= 200

 */
public class A_Offer_47_MaxValue {
    public int maxValue(int[][] grid) {
        int column = grid[0].length;
        int row = grid.length;
        // 直接原方阵上累积
        for(int m=0;m<row;m++)
            for(int n=0;n<column;n++)
                if(m==0&&n!=0) grid[m][n] += grid[m][n-1];
                else if(m!=0&&n==0) grid[m][n] += grid[m-1][n];
                else if(m!=0&&n!=0) grid[m][n] += Math.max(grid[m][n-1],grid[m-1][n]);
        return grid[row-1][column-1];
    }
}
