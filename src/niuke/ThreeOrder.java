package niuke;

import dataStructure.TreeNode;
import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeOrder {
    ArrayList<Integer> pre;
    ArrayList<Integer> mid;
    ArrayList<Integer> post;
    public int[][] threeOrders (TreeNode root) {
        // write code here
        pre = new ArrayList<>();
        mid = new ArrayList<>();
        post = new ArrayList<>();
        preOrder(root);
        midOrder(root);
        postOrder(root);
        int[][] res = new int[3][pre.size()];
        for(int i=0;i<pre.size();i++){
            res[0][i] = pre.get(i);
            res[1][i] = mid.get(i);
            res[2][i] = post.get(i);
        }
        return res;
    }

    void preOrder(TreeNode root){
        if(root==null) return;
        pre.add(root.val);
        preOrder(root.left);
        preOrder(root.right);
    }

    void midOrder(TreeNode root){
        if(root==null) return;
        preOrder(root.left);
        mid.add(root.val);
        preOrder(root.right);
    }

    void postOrder(TreeNode root){
        if(root==null) return;
        preOrder(root.left);
        preOrder(root.right);
        post.add(root.val);
    }
}
