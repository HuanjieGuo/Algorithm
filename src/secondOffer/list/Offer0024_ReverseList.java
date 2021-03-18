package secondOffer.list;

import leetcode.structure.ListNode;

/**
 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

  

 示例:

 输入: 1->2->3->4->5->NULL
 输出: 5->4->3->2->1->NULL

 */
public class Offer0024_ReverseList {
    public ListNode reverseList(ListNode head) {
        ListNode pre = null;
        ListNode next ;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }
}
