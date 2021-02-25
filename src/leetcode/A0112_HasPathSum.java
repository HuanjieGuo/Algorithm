package leetcode;

import dataStructure.TreeNode;

public class A0112_HasPathSum {
    int currentSum = 0;
    int targetSum;
    boolean gotIt = false;
    public boolean hasPathSum(TreeNode root, int targetSum) {
        this.targetSum = targetSum;
        depth(root);
        return gotIt;
    }

    void depth(TreeNode node){
        if(node==null||gotIt) return;
        currentSum += node.val;
        if(currentSum==targetSum
                &&node.left==null
                &&node.right==null){
            gotIt= true;
            return;
        }else {
            depth(node.left);
            depth(node.right);
        }
        currentSum -= node.val;
    }
}
