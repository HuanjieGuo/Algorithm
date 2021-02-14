package niuke;

import dataStructure.TreeNode;

public class A_IsSymmetric {
    public boolean isSymmetric (TreeNode root) {
        // write code here
        if(root==null) return true;
        return check(root.left, root.right);
    }

    boolean check(TreeNode left,TreeNode right){
        if(left==null&&right==null) return true;
        if(left==null||right==null) return false;
        return left.val==right.val
                &&check(left.left,right.right)
                &&check(left.right,right.left);
    }
}
