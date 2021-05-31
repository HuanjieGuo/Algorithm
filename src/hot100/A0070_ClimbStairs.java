package hot100;

public class A0070_ClimbStairs {
    public static int climbStairs(int n) {
        if(n<=1) return n;
        int lastTwo = 1;
        int lastOne = 1;
        for(int i=2;i<=n;i++){
            int tmp = lastOne;
            lastOne += lastTwo;
            lastTwo = tmp;
        }
        return lastOne;
    }

    public static void main(String[] args) {
        System.out.println(climbStairs(4));
    }
}
