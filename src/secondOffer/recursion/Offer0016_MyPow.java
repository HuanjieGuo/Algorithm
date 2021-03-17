package secondOffer.recursion;

public class Offer0016_MyPow {
    public double myPow(double x, int n) {
        if(x==0) return 0;
        boolean isNegative = false;
        boolean needToMultiOne = false;
        if(n<0){
            isNegative = true;
            if(n==Integer.MIN_VALUE) {
                n = Integer.MAX_VALUE;
                needToMultiOne = true;
            }
            else n = -n;
        }
        if(isNegative) x = 1/x;
        return needToMultiOne?fastPow(x,n)*x:fastPow(x,n);
    }
    double fastPow(double x,int n){
        if(n==1) return x;
        if(n==0) return 1;
        int rest = n%2;
        // 核心，y保存！
        double y = fastPow(x,n/2);
        if(rest==0) return y*y;
        else return y*y*x;
    }
}
