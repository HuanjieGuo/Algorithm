package leetcode;

import leetcode.structure.ListNode;

/**
 * 链表形式相加
 * tip: 判断两个数组还有无连接节点以及有无进位
 */
public class AddTwoNumber {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = new ListNode(-1);
        ListNode head_res = res;
        boolean addNext = false;
        int count = 0;
        while (l1!=null||l2!=null||addNext){
            int num = (l1==null?0:l1.val)+(l2==null?0:l2.val)+(addNext?1:0);
            count = count+1;
            if(l1!=null) {
                l1 = l1.next;
            }
            if(l2!=null) {
                l2 = l2.next;
            }
            addNext=false;
            if(num>9){
                num = num - 10;
                addNext = true;
            }
            ListNode next = new ListNode(num);
            res.next = next;
            res = res.next;
        }
        return head_res.next;
    }

    public static void main(String[] args){
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(3);
        ListNode l2 = new ListNode(9);
        l2.next = new ListNode(8);
        AddTwoNumber addTwoNumber = new AddTwoNumber();
        ListNode result = addTwoNumber.addTwoNumbers(l1,l2);
        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    };

}



