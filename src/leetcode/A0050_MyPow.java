package leetcode;

public class A0050_MyPow {
    public double myPow(double x, int n) {
        if(x==0) return 0;
        double record = 1;
        // 判断是不是Integer最小值，是的话+1，后面才能去-号
        if(n==Integer.MIN_VALUE){
            record = x;
            n++;
        }
        // record的值乘起来
        return record*(n>0?recur(x,n):recur(1/x,n));
    }
    double recur(double x, int n){
        if(n==0) return 1;
        // 重点：y的值计算一次，不可recur*recur,计算量爆炸
        // 以后递归时，一样的递归函数必须用变量保存
        double y = recur(x,n/2);
        return n%2==0?y*y:y*y*x;
    }

    public static void main(String[] args) {
        A0050_MyPow a0050_myPow = new A0050_MyPow();
        System.out.println(a0050_myPow.myPow(0.00001,2147483647));
    }
}
