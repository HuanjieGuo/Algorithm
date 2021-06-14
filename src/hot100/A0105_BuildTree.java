package hot100;

import dataStructure.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class A0105_BuildTree {
    Map<Integer,Integer> inOrderIdx;
    int[] preorder;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        this.preorder = preorder;
        inOrderIdx = new HashMap<>();
        for(int i=0;i<inorder.length;i++)
            inOrderIdx.put(inorder[i],i);
        return build(0,preorder.length-1,0,inorder.length-1);
    }
    public TreeNode build(int preL,int preR,int inL,int inR){
        if(preL>preR) return null;
        TreeNode node = new TreeNode(preorder[preL]);
        int pivot = inOrderIdx.get(node.val);
        node.left = build(preL+1,preL+(pivot-inL),inL,pivot-1);
        node.right = build(preL+(pivot-inL)+1,preR,pivot+1,inR);
        return node;
    }
}
