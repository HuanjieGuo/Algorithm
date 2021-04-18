package hardForMe;

import leetcode.structure.ListNode;

/**
 给你一个链表，每 k 个节点一组进行翻转，请你返回翻转后的链表。

 k 是一个正整数，它的值小于或等于链表的长度。

 如果节点总数不是 k 的整数倍，那么请将最后剩余的节点保持原有顺序。

  

 示例：

 给你这个链表：1->2->3->4->5

 当 k = 2 时，应当返回: 2->1->4->3->5

 当 k = 3 时，应当返回: 3->2->1->4->5

 说明：

 你的算法只能使用常数的额外空间。
 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。

 */

public class Lc_25_ReverseKGroup {
    /**
     * https://leetcode-cn.com/problems/reverse-nodes-in-k-group/solution/tu-jie-kge-yi-zu-fan-zhuan-lian-biao-by-user7208t/
     */
    public ListNode reverseKGroup(ListNode head, int k){
        if(head==null||head.next==null)
            return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        // pre每次指向要翻转链表头结点的上一个结点
        ListNode pre = dummy;
        // end每次指向要翻转链表的尾结点
        ListNode end = dummy;

        while (end.next!=null){
            // 循环K此，找到需要翻转链表的结尾，这里每次循环要判断end是否等于空。
            // dummy->1->2->3->4->5, 若k等于2，循环2此，end指向2
            for (int i=0;i<k&&end!=null;i++){
                end = end.next;
            }
            // 如果end == null,即需要翻转的链表节点数小于k，不执行翻转。
            if(end==null){
                break;
            }
            // 先记录下end.next，方便后面连接链表。
            ListNode next  = end.next;
            // 断开链表
            end.next = null;
            // 记录下翻转链表的头节点
            ListNode start = pre.next;
            // 翻转链表， pre.next指向翻转后的链表，1->2变成2->1。dummy->2->1
            pre.next = reverse(start);
            // 翻转后头节点变到最后。通过.next把断开的链表重新连接。
            start.next = next;
            // 将pre换成下次要翻转链表的头节点的上一个节点，即start
            pre = start;
            // 翻转结束，将end置为下次要翻转的链表的头节点的上一个点，即start.
            end = start;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head){
        ListNode pre = null;
        ListNode next;
        while (head!=null){
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }



    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        ListNode listNode6 = new ListNode(6);
        ListNode listNode7 = new ListNode(7);
        ListNode listNode8 = new ListNode(8);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        listNode5.next = listNode6;
        listNode6.next = listNode7;
        listNode7.next = listNode8;
        ListNode node = new Lc_25_ReverseKGroup().reverseKGroup(listNode1,3);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }

    }
}
