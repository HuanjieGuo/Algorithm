package huawei;

import java.util.List;
import java.util.Scanner;
class ListNode{
    ListNode next;
    int val;
    public ListNode(){};
    public ListNode(int val){
        this.val = val;
    }
}
public class DeleteNumber {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int size = scanner.nextInt();
            ListNode dimmy = new ListNode();
            ListNode current = dimmy;
            for (int i = 0; i < size; i++) {
                current.next = new ListNode(i);
                current = current.next;
            }
            current.next = dimmy.next;
            // start
            ListNode start = dimmy.next;
            int count = 1;
            while (start.next != start) {
                start = start.next;
                count++;
                if (count == 2) {
                    start.next = start.next.next;
                    count = 0;
                }
            }
            System.out.println(start.val);
        }

    }
}
