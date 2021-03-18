package secondOffer.list;

import leetcode.structure.ListNode;

/**
 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。

 返回删除后的链表的头节点。

 注意：此题对比原题有改动

 示例 1:

 输入: head = [4,5,1,9], val = 5
 输出: [4,1,9]
 解释: 给定你链表中值为 5 的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
 */
public class Offer0018_DeleteNode {
    public static ListNode deleteNode(ListNode head, int val) {
        if(head==null) return null;
        if(head.val==val) return head;
        ListNode p_front = head.next;
        ListNode p_behind = head;
        while (p_front!=null) {
            if (p_front.val == val) {
                p_behind.next = p_front.next;
                break;
            }
            p_behind = p_front;
            p_front = p_front.next;
        }
        return head;
    }
}
