package niuke;

import leetcode.structure.ListNode;

import java.util.List;

public class A_DetectCycleEnterPoint {
    /**
     设置进入入口前长度a
     圈内交点距离入口长度x
     圆的周长为c

     慢指针  s = a+x
     快指针 2s = a+x+kc

     a + x = kc
     a = kc -x
     a = (k-1)c + (c-x)
     c - x是交点再走n步回到入口点

     人物1从起始点出发，人物2从c-x点出发，相遇点就是入口
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if (head==null) return null;
        // 先求相遇点
        ListNode slow = head;
        ListNode fast = head;
        ListNode meet;
        while (true){
            if(slow==null||fast==null||fast.next==null) return null;
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast){
                meet = slow;
                break;
            }
        }
        while (head!=meet){
            head = head.next;
            meet = meet.next;
        }
        return head;
    }
}
