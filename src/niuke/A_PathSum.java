package niuke;

import dataStructure.TreeNode;

import java.util.ArrayList;

public class A_PathSum {
    int sum;
    ArrayList<ArrayList<Integer>> paths;
    int currentSum;
    ArrayList<Integer> currentPath;
    public ArrayList<ArrayList<Integer>> pathSum (TreeNode root, int sum) {
        // write code here
        this.sum = sum;
        paths = new ArrayList<>();
        currentPath = new ArrayList<>();
        currentSum = 0;
        nextDeep(root);
        return paths;
    }

    public void nextDeep(TreeNode node){
        if(node==null){
            return;
        }else {
            currentPath.add(node.val);
            currentSum += node.val;
            if(currentSum==sum
                    &&node.left==null
                    &node.right==null)
                // 本处注意，直接add(currentPath)的话，后面删除会导致paths里面也删除。
                // 所以需要clone方法在内存重新分配一部分空间
                paths.add((ArrayList<Integer>) currentPath.clone());
            else {
                nextDeep(node.left);
                nextDeep(node.right);
            }
            currentPath.remove(currentPath.size()-1);
            currentSum -= node.val;
        }
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        System.out.println(new A_PathSum().pathSum(node1,1));
    }


}
