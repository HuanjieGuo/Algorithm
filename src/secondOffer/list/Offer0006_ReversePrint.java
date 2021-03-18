package secondOffer.list;

import leetcode.structure.ListNode;

public class Offer0006_ReversePrint {
    public int[] reversePrint(ListNode head) {
        if(head == null) return new int[0];
        int count = 0;
        ListNode p = head;
        while (p!=null){
            count++;
            p = p.next;
        }
        int[] array = new int[count];
        p = head;
        int idx = 0;
        while (p!=null){
            array[count-1-idx] = p.val;
            p = p.next;
            idx++;
        }
        return array;
    }
}
