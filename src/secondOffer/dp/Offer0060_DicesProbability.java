package secondOffer.dp;

public class Offer0060_DicesProbability {
    public static double[] dicesProbability(int n) {
        int[][] dp = new int[n + 1][n * 6 + 1];
        for(int k = 1;k<=6;k++) dp[1][k] = 1;
        for(int i=2;i<=n;i++)
            for(int col=i-1;col<=(i-1)*6;col++)
                for(int dice = 1;dice<=6;dice++)
                    dp[i][col+dice] += dp[i-1][col];
        int sum = 0;
        double[] res = new double[5*n+1];
        for(int i=n;i<=n*6;i++){
            sum+=dp[n][i];
            res[i-n] = dp[n][i];
        }
        for(int i=0;i<res.length;i++) res[i] = res[i]/Double.valueOf(sum);
        for (int i = 0; i < res.length; i++) {
            System.out.println(res[i]);
        }
        return res;
    }

    public static void main(String[] args) {
        dicesProbability(2);
    }
}
