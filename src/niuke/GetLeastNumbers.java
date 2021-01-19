package niuke;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

public class GetLeastNumbers {
    public static ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> list = new ArrayList<>();
        if(input.length<k) return list;
        if(k==0) return list;
        // 默认最小在上头,需要改成最大在上头
        PriorityQueue<Integer> heap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        for(int item:input)
            if (heap.size() == k) {
                if (heap.peek()>item){
                    heap.poll();
                    heap.offer(item);
                }
            }else {
                heap.offer(item);
            }
        for(int item:heap){
            list.add(item);
        }
        return list;
    }

    public static void main(String[] args) {
        GetLeastNumbers_Solution(new int[]{},3);
    }
}
