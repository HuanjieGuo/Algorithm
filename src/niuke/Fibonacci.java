package niuke;

public class Fibonacci {
    public int Fibonacci(int n) {
        if(n<=1) return n;
        int first = 0;
        int second = 1;
        for(int i=2;i<=n;i++){
            int tep = second;
            second += first;
            first = tep;
        }
        return second;
    }
}
