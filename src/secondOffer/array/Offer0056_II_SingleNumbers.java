package secondOffer.array;

public class Offer0056_II_SingleNumbers {
    public static int singleNumber(int[] nums) {
        int[] bit = new int[32];
        for(int num:nums)
            for(int i=0;i<31;i++){
                if((1&num)==1) bit[31-i] = (bit[31-i]+1)%3;
                num>>>=1;
            }
        int res = 0;
        for(int i=0;i<31;i++)
            if(bit[31-i]==1) res+= Math.pow(2,i);
        return res;
    }

    public static void main(String[] args) {
        singleNumber(new int[]{10,4,10,10});
    }
}
