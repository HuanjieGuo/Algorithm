package secondOffer.tree;

import dataStructure.TreeNode;

public class Offer0055_2_IsBalanced {
    Boolean balanced = true;
    public boolean isBalanced(TreeNode root) {
        depth(root);
        return balanced;
    }

    int depth(TreeNode root){
        if (!balanced||root==null) return 0;
        int leftD = depth(root.left);
        int rightD = depth(root.right);
        if(Math.abs(leftD-rightD)>1) balanced = false;
        return Math.max(leftD,rightD)+1;
    }
}
