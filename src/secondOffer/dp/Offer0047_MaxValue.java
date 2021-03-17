package secondOffer.dp;

public class Offer0047_MaxValue {
    public int maxValue(int[][] grid) {
        if(grid.length==0) return 0;
        int height = grid.length+1;
        int width  = grid[0].length+1;
        int[][] dp = new int[height][width];
        for(int i=1;i<height;i++)
            for(int j=1;j<width;j++)
                dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1])+grid[i-1][j-1];
        return dp[height-1][width-1];
    }
}
