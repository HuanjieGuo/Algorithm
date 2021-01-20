package niuke;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrder {
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        // write code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if(root==null) return result;
        ArrayList<TreeNode> father = new ArrayList<>();
        father.add(root);
        while (father.size()!=0) {
            ArrayList<Integer> sub = new ArrayList<>();
            ArrayList<TreeNode> children = new ArrayList<>();
            for (TreeNode no : father) {
                sub.add(no.val);
                if(no.left!=null) children.add(no.left);
                if(no.right!=null) children.add(no.right);
            }
            father = children;
            result.add(sub);
        }
        return result;
    }

    public static void main(String[] args) {

    }
}
