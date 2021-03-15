package secondOffer.tree;

import dataStructure.TreeNode;

import java.util.*;

public class Offer0032_3_LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new LinkedList<>();
        List<List<Integer>> finalList = new ArrayList<>();
        Queue<TreeNode> fatherQueue = new LinkedList<>();
        Queue<TreeNode> childQueue = new LinkedList<>();
        fatherQueue.offer(root);

        ArrayList<Integer> list = new ArrayList<>();
        boolean leftSide = true;
        while (fatherQueue.size()!=0){
            TreeNode node = fatherQueue.poll();
            list.add(node.val);
            if(node.left!=null) childQueue.offer(node.left);
            if(node.right!=null) childQueue.offer(node.right);
            if(fatherQueue.size()==0){
                fatherQueue = childQueue;
                childQueue = new LinkedList<>();
                if(!leftSide)Collections.reverse(list);
                finalList.add((ArrayList<Integer>)list.clone());
                leftSide = !leftSide;
                list.clear();
            }
        }
        return finalList;
    }
}
