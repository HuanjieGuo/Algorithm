package niuke;

public class JumpFloor {
    public int JumpFloor(int target) {
        if (target==0) return 0;
        int[] dp = new int[target+1];
        dp[1] = dp[0] = 1;
        for(int i=2; i<target+1;i++){
            dp[i] = dp[i-1]+dp[i-2];
        }
        return dp[target];
    }
}
