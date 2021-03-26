package secondOffer.tree;

import dataStructure.TreeNode;

public class Offer0028_IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        if(root==null) return true;
        return helper(root.left,root.right);
    }
    boolean helper(TreeNode leftTree,TreeNode rightTree){
        if(leftTree==null&&rightTree==null) return true;
        if(leftTree==null||rightTree==null||leftTree.val!=rightTree.val) return false;
        return helper(leftTree.left,rightTree.right)&&helper(leftTree.right,rightTree.left);
    }
}
