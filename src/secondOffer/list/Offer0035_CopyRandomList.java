package secondOffer.list;

import dataStructure.node1.Node;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向链表中的任意节点或者 null。
 */
public class Offer0035_CopyRandomList {
    public Node copyRandomList(Node head) {
        if(head==null) return null;
        Map<Node,Node> map = new HashMap<>();
        Node p = head;
        while (p!=null){
            Node newNode = new Node(p.val);
            map.put(p,newNode);
            p = p.next;
        }
        p = head;
        while (p!=null){
            map.get(p).next = map.get(p.next);
            map.get(p).random = map.get(p.random);
            p=p.next;
        }
        return map.get(head);
    }
}
