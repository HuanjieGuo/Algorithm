package leetcode;

public class MaxArea {
    /**
     * 求盛水最大面积
     * 暴力破解法 复杂度 o(n2)
     * @param height
     * @return
     */
    public static int maxArea1(int[] height) {
        int max = 0;
        for(int i=0;i<height.length-1;i++){
            for(int j=i+1;j<height.length;j++){
                max = Math.max(max,Math.min(height[i],height[j])*(j-i));
            }
        }
        return max;
    }

    /**
     * 双指针移动法  时间复杂度o(n)
     * @param height
     * @return
     */
    public static int maxArea2(int[] height) {
        int max = 0;
        int i=0;
        int j=height.length-1;
        while(i<j){
            max = Math.max(max,Math.min(height[i],height[j])*(j-i));
            if(height[i]>height[j]){
                j--;
            }else {
                i++;
            }
        }
        return max;
    }
}
