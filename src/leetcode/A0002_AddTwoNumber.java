package leetcode;
import leetcode.structure.ListNode;


/**
 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。

 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。

 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。

 示例：

 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 输出：7 -> 0 -> 8
 原因：342 + 465 = 807

 **/
public class A0002_AddTwoNumber {
    /**
     * 链表形式相加
     * tip: 判断两个数组还有无连接节点以及有无进位
     */
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
        A0002_AddTwoNumber addTwoNumber = new A0002_AddTwoNumber();
        ListNode result = addTwoNumber.addTwoNumbers(l1,l2);
        while (result!=null){
            System.out.println(result.val);
            result = result.next;
        }
    };

}



