package hot100;

public class A0062_UniquePaths {
    int total = 0;
    int m;
    int n;

    public int uniquePaths_recursion(int m, int n) {
        this.m = m;
        this.n = n;
        move(0,0);
        return total;
    }
    void move(int currentM,int currentN){
        if(currentM>=m) return;
        if(currentN>=n) return;
        if(currentM==m-1&&currentN==n-1){
            total++;
            return;
        }
        move(currentM+1,currentN);
        move(currentM,currentN+1);
    }

    /**
     机器人一定走m+n-2格
     从里面随机挑m-1向下走
     C(m+n-2,m-1)
     */
    public static int uniquePaths_permutation(int m,int n){
        if(n<m){
            int tmp = n;
            n=m;
            m=tmp;
        }
        long result = 1;
        int count = m-1;
        int initial = m+n-2;
        while (count>0){
            result *= initial;
            count--;
            initial--;
        }
        count = m-1;
        while (count>0){
            result/=count;
            count--;
        }
        return (int) result;
    }

    /**
     dp 算法
     dp[i][j] = dp[i-1][j]+dp[i,j-1]
     */
    public static int uniquePaths_dp(int m,int n){
        int[][] dp = new int[m][n];
        for(int i=0;i<m;i++)
            dp[i][0] = 1;
        for(int i=0;i<n;i++)
            dp[0][i] = 1;
        for(int i=1;i<m;i++)
            for (int j=1;j<n;j++){
                dp[i][j] = dp[i-1][j]+dp[i][j-1];
            }
        return dp[m-1][n-1];
    }

    public static void main(String[] args) {
        System.out.println(uniquePaths_permutation(7, 3));
    }
}
