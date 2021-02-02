package niuke;

import dataStructure.TreeNode;

import java.util.ArrayList;

public class ZigzagLevelOrder {
    public ArrayList<ArrayList<Integer>> zigzagLevelOrder (TreeNode root) {
        if(root==null) return null;
        boolean leftToRight = true;
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        // write code here
        ArrayList<TreeNode> father = new ArrayList<>();
        ArrayList<TreeNode> child = new ArrayList<>();
        father.add(root);
        while (father.size()!=0){
            ArrayList<Integer> list = new ArrayList<>();
            for(TreeNode treeNode:father){
                if(leftToRight)
                    list.add(treeNode.val);
                else
                    list.add(0,treeNode.val);
                if(treeNode.left!=null) child.add(treeNode.left);
                if(treeNode.right!=null) child.add(treeNode.right);
            }
            res.add(list);
            father = child;
            child = new ArrayList<>();
            leftToRight = !leftToRight;
        }
        return res;
    }
}
