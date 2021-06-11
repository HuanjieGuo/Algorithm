package hot100;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class A0094_InorderTraversal {
    List<Integer> inOrderList;
    public List<Integer> inorderTraversal(TreeNode root) {
        inOrderList = new ArrayList<>();
        inSearch(root);
        return inOrderList;
    }

    void inSearch(TreeNode node){
        if(node==null) return;
        inSearch(node.left);
        inOrderList.add(node.val);
        inSearch(node.right);
    }
}
