package secondOffer.tree;

import java.util.Stack;

/**
 一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。

 */
public class Offer0033_VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        return check(postorder,0,postorder.length-1);
    }
    boolean check(int[] postorder,int start,int end){
        if(start>=end) return true;
        int p = start;
        while (p<end&&postorder[p]<postorder[end])p++;
        int leftEnd = p-1;
        while (p<end&&postorder[p]>postorder[end])p++;
        return p==end
                &&check(postorder,start,leftEnd)
                &&check(postorder,leftEnd+1,end-1);
    }


    static boolean  verifyPostorder_stack(int []postorder){
        Stack<Integer> stack = new Stack<>();
        int root = Integer.MAX_VALUE;
        for(int i=postorder.length-1;i>=0;i--){
            while (postorder[i]>root) return false;
            while (!stack.empty()&&stack.peek()>postorder[i])
                root = stack.pop();
            stack.add(postorder[i]);
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(verifyPostorder_stack(new int[]{3,6,5,9,8,11,13,12,10}));
    }
}
