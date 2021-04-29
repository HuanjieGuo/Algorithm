package top100;

public class A0011_MaxArea {
    public int maxArea(int[] height) {
        int max = 0;
        int left = 0;
        int right = height.length-1;
        while (left<right){
            max = Math.max(max,Math.min(height[left],height[right])*(right-left));
            if(height[left]>height[right]) right--;
            else left++;
        }
        return max;
    }
}
