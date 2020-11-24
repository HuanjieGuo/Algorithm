package offerAlgorithm.Offer_32_LevelOrder;
/**
 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。

  

 例如:
 给定二叉树: [3,9,20,null,null,15,7],

 3
 / \
 9  20
 /  \
 15   7
 返回：

 [3,9,20,15,7]
  

 提示：

 节点总数 <= 1000

 */

import dataStructure.TreeNode;
import leetcode.structure.ListNode;
import java.util.*;

public class Offer_32_1_LevelOrder {
    public int[] levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        // 空值判断
        if(root==null){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        queue.add(root);
        while (queue.size()!=0){
            int size = queue.size();
            for(int i=0;i<size;i++){
                TreeNode treeNode = queue.poll();
                list.add(treeNode.val);
                if(treeNode.left!=null) queue.offer(treeNode.left);
                if(treeNode.right!=null)queue.offer(treeNode.right);
            }
        }
        int[] reArray = new int[list.size()];
        for(int i=0;i<list.size();i++) reArray[i] = list.get(i);
        return reArray;
    }
}
