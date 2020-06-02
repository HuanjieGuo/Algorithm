package leetcode;

import leetcode.structure.ListNode;

/**
 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。

 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。

  

 示例:

 给定 1->2->3->4, 你应该返回 2->1->4->3.

 */
public class A0024_SwapPairs {
    /**
     * 迭代
     * @param head
     * 两两交换
     * 1、先用NEXT指向head.next
     * 2、head的下一个是递归函数返回
     * 3、next的下一个是head
     * 4、返回next值
     * @return
     */
    public ListNode swapPairs(ListNode head)
    {
        //仅有一个节点或者没有
        if(head==null|head.next==null){
            return head;
        }
        ListNode next = head.next;
        head.next = swapPairs(next.next);
        next.next = head;
        return next;
    }
}
