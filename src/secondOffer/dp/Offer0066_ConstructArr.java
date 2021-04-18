package secondOffer.dp;

public class Offer0066_ConstructArr {
    public static void main(String[] args) {
        constructArr(new int[]{2,3,4,5});
    }

    public static int[] constructArr(int[] a) {
        int len = a.length;
        int[] dp_forward = new int[len];
        int[] dp_backward = new int[len];
        dp_forward[0] = 1;
        dp_backward[0] = 1;
        for(int i=1;i<len;i++) {
            dp_forward[i] = dp_forward[i - 1] * a[i-1];
            dp_backward[i] = dp_backward[i - 1] * a[len-i];
        }
        int[] res = new int[len];
        for(int i=0;i<len;i++) {
            res[i] = dp_forward[i] * dp_backward[len - 1 - i];
            System.out.println(res[i]);
        }
        return res;
    }
}
