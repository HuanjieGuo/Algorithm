package hot100;

public class A0064_MinPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        if(m==0)return 0;
        int n = grid[0].length;
        int[][] sumMap = new int[m][n];
        sumMap[0][0] = grid[0][0];
        for(int i=1;i<m;i++) sumMap[i][0] = sumMap[i-1][0]+grid[i][0];
        for(int i=1;i<n;i++) sumMap[0][i] = sumMap[0][i-1]+grid[0][i];
        for(int i=1;i<m;i++)
            for(int j=1;j<n;j++)
                sumMap[i][j] = Math.min(sumMap[i-1][j],sumMap[i][j-1])+grid[i][j];
        return sumMap[m-1][n-1];
    }
}
