package offerAlgorithm;

import leetcode.structure.ListNode;

/**
 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

 返回删除后的链表的头节点。

 注意：此题对比原题有改动

 示例 1:

 输入: head = [4,5,1,9], val = 5
 输出: [4,1,9]
 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 示例 2:

 输入: head = [4,5,1,9], val = 1
 输出: [4,5,9]
 解释: 给定你链表中值为 1 的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
  
 */
public class Offer_18_DeleteNode {
    /**
     用pre记录前一个，headRe记录第一个
     */
    public ListNode deleteNode(ListNode head, int val) {
        // 第一个是
        if(head.val==val){
            return head.next;
        }
        // 非第一个是
        ListNode headRe = head;
        // 初始化pre为第一个
        ListNode pre = head;
        // 跳过第一个
        head = head.next;
        while (head!=null){
            if(head.val==val){
                pre.next = head.next;
                return headRe;
            }
            pre = head;
            head = head.next;
        }
        return null;
    }
}
