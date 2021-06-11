package hot100;

import java.util.Arrays;
import java.util.Deque;
import java.util.Stack;

public class A0084_LargestRectangleArea {
//    int max;
//    int[] heights;
//    public int largestRectangleArea_binary(int[] heights) {
//        this.heights = heights;
//        search(0,heights.length-1);
//        return max;
//    }
//    public void search(int start,int end){
//        if(start>end)return;
//        // 找最小的柱子idx
//        Integer minIdx = null;
//        Integer minHeight  = null;
//        for(int i=start;i<=end;i++){
//            if(minHeight==null){
//                minHeight = heights[i];
//                minIdx = i;
//            }else if(minHeight>heights[i]){
//                minHeight = heights[i];
//                minIdx = i;
//            }
//        }
//        // 找到了
//        max = Math.max(max,minHeight*(end-start+1));
//        search(start,minIdx-1);
//        search(minIdx+1,end);
//    }

    /**
     https://blog.csdn.net/Zolewit/article/details/88863970
     */
    public static int largestRectangleArea_stack(int[] heights) {
        heights = Arrays.copyOf(heights,heights.length+1);
        Stack<Integer> stack = new Stack<>();
        int maxArea = 0;
        for(int i=0;i<heights.length;i++){
            while (!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
                int top = stack.pop();
                maxArea = Math.max(maxArea,heights[top]*(stack.isEmpty()?i:(i-stack.peek()-1)));
            }
            stack.push(i);
        }
        return maxArea;
    }

    public static void main(String[] args) {
        System.out.println(largestRectangleArea_stack(new int[]{2, 1, 5, 6, 2, 3}));
    }

}
