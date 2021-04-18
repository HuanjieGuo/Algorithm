import hardForMe.Lc_25_ReverseKGroup;
import leetcode.structure.ListNode;

import java.util.*;

public class Main {
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
        ListNode node = new Main().reverseKgroups(listNode1,3);
        while (node!=null){
            System.out.println(node.val);
            node=node.next;
        }
    }

    ListNode reverseKgroups(ListNode head,int k){
        if(head==null||head.next==null) return head;
        ListNode dummy =  new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        while (end!=null){
            for(int i=0;i<k&&end!=null;i++){
                end=end.next;
            }
            if(end==null) break;
            ListNode next =  end.next;
            ListNode start = pre.next;
            end.next = null;
            pre.next = reverse(start);
            start.next = next;
            end = start;
            pre = start;
        }
        return dummy.next;
    }
    ListNode reverse(ListNode node){
        ListNode pre = null;
        ListNode next;
        while (node!=null){
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }

}
