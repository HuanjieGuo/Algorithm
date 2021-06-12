package hot100;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class A0102_LeverOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root==null) return new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        Queue<TreeNode> father = new LinkedList<>();
        father.add(root);
        while (!father.isEmpty()){
            List<Integer> current = new ArrayList<>();
            Queue<TreeNode> child = new LinkedList<>();
            current.clear();
            while (!father.isEmpty()){
                TreeNode node = father.poll();
                current.add(node.val);
                if(node.left!=null) child.add(node.left);
                if(node.right!=null) child.add(node.right);
            }
            father = child;
            result.add(current);
        }
        return result;
    }
}
