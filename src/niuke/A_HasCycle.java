package niuke;

public class A_HasCycle {
    public boolean hasCycle(ListNode head) {
        if(head==null) return false;
        ListNode ahead = head;
        ListNode behind = head.next;
        ahead = head;
        while (ahead!=null&&behind!=null){
            if(ahead==behind) return true;
            ahead = ahead.next;
            if(behind.next!=null) behind = behind.next.next;
            else return false;
        }
        return false;
    }


    class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
    }
}
