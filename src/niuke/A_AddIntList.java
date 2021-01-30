package niuke;

import leetcode.structure.ListNode;

import java.util.Stack;

public class A_AddIntList {
    // use three stack!
    public ListNode addInList (ListNode head1, ListNode head2) {
        // write code here
        if(head1==null||head2==null) return null;
        Stack<Integer> stackForList1 = new Stack<>();
        Stack<Integer> stackForList2 = new Stack<>();
        Stack<Integer> stackSum = new Stack<>();
        while (head1!=null) {
            stackForList1.push(head1.val);
            head1 = head1.next;
        }
        while (head2!=null) {
            stackForList2.push(head2.val);
            head2 = head2.next;
        }
        boolean carryBit = false;
        while (stackForList1.size()!=0
                ||stackForList2.size()!=0
                ||carryBit) {
            int sum = 0;
            if(stackForList1.size()==0&&stackForList2.size()==0)
                sum = 0;
            else if(stackForList1.size() == 0)
                sum = stackForList2.pop();
            else if(stackForList2.size() == 0)
                sum = stackForList1.pop();
            else
                sum= stackForList1.pop()+stackForList2.pop();
            if (carryBit) {
                sum += 1;
                carryBit = false;
            }
            if(sum>9){
                sum-=10;
                carryBit = true;
            }
            stackSum.push(sum);
        }
        ListNode node = null;
        ListNode lastNode = null;
        while (stackSum.size()!=0){
            if(lastNode==null){
                node = new ListNode(stackSum.pop());
                lastNode = node;
            }else {
                lastNode.next = new ListNode(stackSum.pop());
                lastNode = lastNode.next;
            }
        }
        return node;
    }
}
