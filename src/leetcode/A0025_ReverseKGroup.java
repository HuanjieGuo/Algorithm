package leetcode;

import leetcode.structure.ListNode;

import java.util.List;

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
public class A0025_ReverseKGroup {
    /**
     * 分length/k组   倒装  组合
     * @param head
     * @param k
     * @return
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = new ListNode(0);
        ListNode start_cur = start;
        //计算长度
        int count = 0;
        ListNode countNode = head;
        while (countNode!=null){
            countNode = countNode.next;
            count++;
        }
        ListNode sub_head = head;
        ListNode sub_cur = head;
        // 循环
        for(int i=0;i<count/k;i++){
            // 分割子串
            for(int j=0;j<k-1;j++){
                sub_cur = sub_cur.next;
            }
            ListNode temp = sub_cur.next;
            sub_cur.next = null;

            // 接上反转后子串并移动指针
            start_cur.next = reverse(sub_head);
            while (start_cur.next!=null){
                start_cur = start_cur.next;
            }

            //子串头设置为下一个
            sub_head = temp;
            sub_cur = temp;
        }
        // 把剩余的接上
        start_cur.next = sub_head;

        return start.next;
    }

    /**
     * 单一祖的排序
     * @param listNode
     * @return
     */
    ListNode reverse(ListNode listNode){
        ListNode pre = listNode;
        ListNode next = listNode.next;
        ListNode t;
        boolean isFirst = true;
        while (next!=null){
            t = next.next;
            next.next = pre;
            if(isFirst){
                pre.next = null;
                isFirst = false;
            }
            pre = next;
            next = t;
        }
        return pre;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
        ListNode listNode4 = new ListNode(4);
        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
        listNode3.next = listNode4;
        listNode4.next = listNode5;
        new A0025_ReverseKGroup().reverseKGroup(listNode1,3);

    }
}
