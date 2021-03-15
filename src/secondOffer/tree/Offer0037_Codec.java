package secondOffer.tree;

import dataStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Offer0037_Codec {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root==null) return null;
        //
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node!=null){
                list.add(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }else list.add(null);
        }
        int count =  0;
        for(int i=list.size()-1;i>=0;i--)
            if(list.get(i)==null)count++;
            else break;
        list = list.subList(0,list.size()-count);
        return list.toString();
    }

    /**
     借助队列实现反序列化
     为何一个count 遇到null就+1什么也不干
     */
    static public TreeNode deserialize(String data) {
        if(data==null)return null;
        String[] strs = data.substring(1,data.length()-1).split(", ");
        TreeNode root = new TreeNode(Integer.parseInt(strs[0]));
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int index = 1;
        while (!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(index< strs.length&&!strs[index].equals("null")){
                node.left = new TreeNode(Integer.parseInt(strs[index]));
                queue.offer(node.left);
            }
            index++;
            if(index< strs.length&&!strs[index].equals("null")){
                node.right = new TreeNode(Integer.parseInt(strs[index]));
                queue.offer(node.right);
            }
            index++;
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(3);
        TreeNode node7 = new TreeNode(1);
        node1.left = node2;
        node1.right = node3;
        node3.left = node4;
        node3.right = node5;
        node4.left = node6;
        node4.right = node7;
        String string = new Offer0037_Codec().serialize(node1);
        System.out.println(string);
    }

}
