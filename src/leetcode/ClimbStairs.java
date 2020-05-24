package leetcode;

public class ClimbStairs {
    public static int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int fort = 1;
        int back = 2;
        for(int i=2;i<n;i++){
            int temp = back;
            back = back + fort;
            fort = temp;
        }
        return back;
    }



    public static void main(String[] args) {
        long time1 = System.currentTimeMillis();
        System.out.println(ClimbStairs.climbStairs(45));
        System.out.println(System.currentTimeMillis()-time1);
    }
}
