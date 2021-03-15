package secondOffer.tree;

import dataStructure.TreeNode;
import leetcode.structure.ListNode;

import java.util.*;

public class Offer0032_1_LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if(root==null) return new int[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        ArrayList<Integer> list = new ArrayList<>();

        while (queue.size()!=0){
            TreeNode node = queue.poll();
            list.add(node.val);
            if(node.left!=null) queue.offer(node.left);
            if(node.right!=null) queue.offer(node.right);
        }
        int[] a  = new int[list.size()];
        for(int i=0;i<a.length;i++) a[i] = list.get(i);
        return a;
    }
}
