package secondOffer.recursion;

public class Offer0010_1_NumWays {
    /**
     递归
     */
    public int numWays(int n) {
        if(n<=1) return 1;
        return (int)((numWays(n-1)+numWays(n-2))%(1e9+7));
    }
    public int numWays_dp(int n){
        if(n<=1) return 1;
        int twoStepAgo = 1;
        int oneStepAgo = 1;
        for(int i=2;i<=n;i++){
            int sum = (int)((oneStepAgo+twoStepAgo)%(1e9+7));
            twoStepAgo = oneStepAgo;
            oneStepAgo = sum;
        }
        return oneStepAgo;
    }

}
