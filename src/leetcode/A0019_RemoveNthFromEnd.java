package leetcode;

import leetcode.structure.ListNode;

/**
 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。

 示例：

 给定一个链表: 1->2->3->4->5, 和 n = 2.

 当删除了倒数第二个节点后，链表变为 1->2->3->5.
 说明：

 给定的 n 保证是有效的。

 进阶：

 你能尝试使用一趟扫描实现吗？

 */
public class A0019_RemoveNthFromEnd {
    /**
     * 双指针，另外一个一直指向倒数(N+1)个
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null){
            return null;
        }
        int count = 0;
        ListNode cur = head;
        ListNode nEnd = null;
        while (cur.next!=null){
            cur = cur.next;
            // 原本需要的位置是倒数（n+1)
            if(count>n-2){
                if(nEnd==null){
                    nEnd = head;
                }else {
                    nEnd = nEnd.next;
                }
            }
            count++;
        }
        if(nEnd==null){
            return head.next;
        }else {
            nEnd.next = nEnd.next.next;
            return head;
        }
    }
}
