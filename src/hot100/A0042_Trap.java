package hot100;

public class A0042_Trap {
    public static int trap(int[] height) {
        int left = 0;
        int right = height.length-1;
        int maxLeft = 0;
        int maxRight = 0;
        int sum = 0;
        while (left<=right){
            maxLeft = Math.max(maxLeft,height[left]);
            maxRight = Math.max(maxRight,height[right]);
            if(height[left]<height[right]){
                sum+=maxLeft-height[left];
                left++;
            }else {
                sum+=maxRight-height[right];
                right--;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int[] heights = new int[]{4,2,0,3,2,5};
        System.out.println(trap(heights));
    }
}
