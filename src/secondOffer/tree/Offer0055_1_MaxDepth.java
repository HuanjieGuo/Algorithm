package secondOffer.tree;

import dataStructure.TreeNode;

public class Offer0055_1_MaxDepth {
    public int maxDepth(TreeNode root) {
        if(root==null) return 0;
        return Math.max(maxDepth(root.left),maxDepth(root.right))+1;
    }

}
