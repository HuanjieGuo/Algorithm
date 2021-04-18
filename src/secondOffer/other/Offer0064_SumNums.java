package secondOffer.other;

public class Offer0064_SumNums {
    public int sumNums(int n) {
        int sum = n;
        boolean flag = n!=0&&(sum+=sumNums(n-1))>0;
        return sum;
    }
}
