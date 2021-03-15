package secondOffer.tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer0032_2_LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new LinkedList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        Queue<TreeNode> fatherQueue = new LinkedList<>();
        Queue<TreeNode> childQueue = new LinkedList<>();
        fatherQueue.offer(root);

        ArrayList<Integer> list = new ArrayList<>();
        while (fatherQueue.size()!=0){
            TreeNode node = fatherQueue.poll();
            list.add(node.val);
            if(node.left!=null) childQueue.offer(node.left);
            if(node.right!=null) childQueue.offer(node.right);
            if(fatherQueue.size()==0){
                fatherQueue = childQueue;
                childQueue = new LinkedList<>();
                finalList.add((ArrayList<Integer>)list.clone());
                list.clear();
            }
        }
        return finalList;
    }
}
