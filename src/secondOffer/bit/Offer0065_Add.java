package secondOffer.bit;

public class Offer0065_Add {
    public static int add(int a, int b) {
        int c = 0;
        while (b!=0){
            c = (a&b)<<1;
            a ^= b;
            b = c;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(add(5,4));
    }
}
