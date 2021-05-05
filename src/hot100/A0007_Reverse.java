package hot100;

public class A0007_Reverse {
    public static int reverse(int x) {
        if(x==Integer.MIN_VALUE) return 0;
        boolean isNegative = x<0;
        x = Math.abs(x);
        StringBuilder str = new StringBuilder(String.valueOf(x));
        str.reverse();
        try{
            int num = Integer.parseInt(str.toString());
            return isNegative?-num:num;
        }catch (Exception e){
            return 0;
        }
    }

    public static void main(String[] args) {
        reverse(0);
    }
}
