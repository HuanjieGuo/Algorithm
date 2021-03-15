package secondOffer.tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Offer0034_PathSum {
    List<List<Integer>> lists;
    int rest;
    List<Integer> currentList;
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        lists = new ArrayList<>();
        currentList = new ArrayList<>();
        rest = target;
        recur(root);
        return lists;
    }
    void recur(TreeNode node){
        if(node==null) return;
        currentList.add(node.val);
        rest -= node.val;
        if(rest==0&&node.left==null&&node.right==null)
            lists.add(new ArrayList<>(currentList));
        recur(node.left);
        recur(node.right);
        rest += node.val;
        currentList.remove(currentList.size()-1);
    }
}
