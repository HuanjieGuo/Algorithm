package secondOffer.recursion;

public class Offer0010_1_Fibonacci {
    /**
     递归算法
     */
    public static int fib(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        return (int)((fib(n-1)+fib(n-2))%(1e9+7));
    }

    /**
     dp
     */
    public static int fib_dp(int n) {
        if(n==0) return 0;
        if(n==1) return 1;
        int last_two=0;
        int last_one=1;
        for(int i=2;i<=n;i++){
            int sum = (int)((last_one+last_two)%(1e9+7));
            last_two = last_one;
            last_one = sum;
        }
        return last_one;
    }

    public static void main(String[] args) {
        System.out.println(fib(10));
    }
}
