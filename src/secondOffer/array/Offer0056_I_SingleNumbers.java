package secondOffer.array;

public class Offer0056_I_SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        int ret = 0;
        for(int num:nums)
            ret ^= num;
        int mask = 1;
        while ((mask&ret)==0) mask<<=1;
        int a = 0;
        int b = 0;
        for(int num:nums)
            if((num&mask)==0) a ^= num;
            else b^=num;
        return new int[]{a,b};
    }
}
