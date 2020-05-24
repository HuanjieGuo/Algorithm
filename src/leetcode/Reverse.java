package leetcode;

public class Reverse {
    public static int reverse(int x) {
        boolean isPositive = (x>=0);
        String number = new StringBuilder(String.valueOf(Math.abs(x))).reverse().toString();
        while (!number.equals("")){
            if(number.charAt(0)=='0'){
                number = number.substring(1,number.length());
            }else {
                break;
            }
        }
        if(number.equals("")){
            return 0;
        }
        try {
            int resNum = Integer.valueOf(number);
            return isPositive?resNum:-resNum;
        }catch (Exception e){
            return 0;
        }
    }
    public static void main(String[] args){
        System.out.println(reverse(1534236469));
    }

}
