package niuke;

public class LeastCommonMultiple {
    //  LeastCommonMultiple = a*b/gcd
    // 最小公倍数 =  乘积/最大公约数

    // 辗转相除法 求最大公约数
    static int gcd(int a,int b){
        int temp = a % b;
        if(temp==0) return b;
        return gcd(b,temp);
    }

    static int lcm(int a,int b){
        return a*b/gcd(a,b);
    }

    public static void main(String[] args) {
        System.out.println(lcm(21,15));
    }
}
