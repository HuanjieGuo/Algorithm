package hot100;

import java.util.Stack;

public class A0085_MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length==0) return 0;
        int[] heights = new int[matrix[0].length+1];
        int maxArea = 0;
        for(int row=0;row<matrix.length;row++){
            for(int i=0;i<heights.length-1;i++)
                heights[i] = matrix[row][i]=='1'?heights[i]+1:0;
            maxArea = Math.max(maxArea,calculateMaxArea(heights));
        }
        return maxArea;
    }
    public int calculateMaxArea(int[] heights){
        int maxArea = 0;
        Stack<Integer> stack = new Stack<>();
        for(int i=0;i<heights.length;i++){
            while (!stack.isEmpty()&&heights[stack.peek()]>heights[i]){
                int top = stack.pop();
                maxArea = Math.max(maxArea,heights[top]*(stack.isEmpty()?i:i-stack.peek()-1));
            }
            stack.push(i);
        }
        return maxArea;
    }
}
