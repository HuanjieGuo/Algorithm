package niuke;

import dataStructure.node2.Node;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LRU {
    private Map<Integer, Node> map = new HashMap<>();
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);
    private int k;

    public int[] LRU (int[][] operators, int k) {
        // write code here
        this.k = k;
        head.next = tail;
        tail.prev = head;
        int len = (int) Arrays.stream(operators).filter(x->x[0]==2).count();
        int[] res = new int[len];
        for(int i=0,j=0;i<operators.length;i++) {
            if (operators[i][0] == 1) {
                set(operators[i][1],operators[i][2]);
            }else {
                res[j++] = get(operators[i][1]);
            }
        }
        return res;
    }

    private void set(int key,int val){
        if(get(key)>-1){
            map.get(k).val = val;
        }else {
            if(map.size()==k){
                int rk = tail.prev.key;
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                map.remove(rk);
            }
            Node node = new Node(key,val);
            map.put(key,node);
            moveToHead(node);
        }
    }
    private int get(int key){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.prev.next = node.next;
            node.next.prev = node.prev;
            moveToHead(node);
            return node.val;
        }
        return -1;
    }

    private void moveToHead(Node node){
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }
    class Node{
        int key,val;
        Node prev,next;
        public Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }

    public static void main(String[] args) {
        LRU lru = new LRU();
        lru.LRU(new int[][]{{1,1,1},{1,2,2},{1,3,2},{2,1},{1,4,4},{2,2}},3);

    }
}
