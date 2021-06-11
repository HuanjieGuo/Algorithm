package hot100;

public class A0096_NumTrees {
    public static int numTrees(int n) {
        int[] dp = new int[n+1];
        dp[0] = 1;
        dp[1] = 1;
        // 几个节点
        for(int i=2;i<=n;i++)
            // 树的左边分几个
            for(int left=0;left<=i-1;left++)
                // i-1表示去除根结点，i-1-left表示右边个数
                dp[i] += dp[left]*dp[i-1-left];
        return dp[n];
    }

    public static void main(String[] args) {
        System.out.println(numTrees(4));
    }
}
