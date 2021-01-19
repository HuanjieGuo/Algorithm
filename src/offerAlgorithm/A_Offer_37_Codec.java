package offerAlgorithm;

import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 请实现两个函数，分别用来序列化和反序列化二叉树。

 示例: 

 你可以将以下二叉树：

 1
 / \
 2   3
 / \
 4   5

 序列化为 "[1,2,3,null,null,4,5]"
 */
public class A_Offer_37_Codec {
    // Encodes a tree to a single string.
    public  String serialize(TreeNode root) {
        if (root==null) return "[]";
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node==null) list.add(null);
            else {
                list.add(node.val);
                queue.add(node.left);
                queue.add(node.right);
            }
        }
        // 存
        return list.toString();
    }


        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {
            if(data.equals("[]")) return null;
            String[] vals = data.substring(1,data.length()-1).split(",");
            for(int i =0;i<vals.length;i++)
                vals[i] = vals[i].trim();
            TreeNode root = new TreeNode((Integer.parseInt(vals[0])));

            Queue<TreeNode> queue = new LinkedList<>();
            queue.add(root);
            int i=1;
            while (!queue.isEmpty()){
                TreeNode node = queue.poll();
                if(!vals[i].equals("null")){
                    node.left = new TreeNode(Integer.valueOf(vals[i]));
                    queue.add(node.left);
                }
                i++;
                if(!vals[i].equals("null")){
                    node.right = new TreeNode(Integer.valueOf(vals[i]));
                    queue.add(node.right);
                }
                i++;
            }
            return root;
        }
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public static void main(String[] args) {

    }
}
