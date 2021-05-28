package hot100;

public class A0055_CanJump {
    /**
     如果一个位置能到达
     那么它前面所以位置都能到达
     */
    public static boolean canJump(int[] nums) {
        int maxFufure = 0;
        for(int i=0;i<nums.length;i++){
            if(maxFufure<i) return false;
            maxFufure =  Math.max(maxFufure,i+nums[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 3, 1, 1, 4}));
    }
}
