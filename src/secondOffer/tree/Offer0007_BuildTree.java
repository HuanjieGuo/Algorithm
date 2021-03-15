package secondOffer.tree;

import dataStructure.TreeNode;
import leetcode.structure.ListNode;

import java.util.HashMap;
import java.util.Map;

/**
 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。

  

 例如，给出

 前序遍历 preorder = [3,9,20,15,7]
 中序遍历 inorder = [9,3,15,20,7]

 */
public class Offer0007_BuildTree {
    int[] preorder;
    Map<Integer,Integer> inMap;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        inMap = new HashMap<>();
        this.preorder = preorder;
        for(int i=0;i<inorder.length;i++)
            inMap.put(inorder[i],i);
        return recur(0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode recur(int pre_start,int pre_end,int in_start,int in_end){
        if(pre_start>pre_end||in_start>in_end) return null;
//        if(pre_start == pre_end) return new TreeNode(preorder[pre_start]);
        int pivot = inMap.get(preorder[pre_start]);
        TreeNode node = new TreeNode(preorder[pre_start]);
        node.left = recur(pre_start+1,pivot-in_start+pre_start,in_start,pivot-1);
        node.right = recur(pivot-in_start+pre_start+1,pre_end,pivot+1,in_end);
        return node;
    }

    public static void main(String[] args) {

    }
}
