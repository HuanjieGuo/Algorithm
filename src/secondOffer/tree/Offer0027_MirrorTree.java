package secondOffer.tree;

import dataStructure.TreeNode;

public class Offer0027_MirrorTree {
    public TreeNode mirrorTree(TreeNode root) {
        if(root==null) return null;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(root.left);
        return root;
    }
}
