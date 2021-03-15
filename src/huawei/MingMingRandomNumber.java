package huawei;

import java.util.PriorityQueue;
import java.util.Scanner;

public class MingMingRandomNumber {
    public static void main(String[] args) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        Scanner scanner = new Scanner(System.in);
        int count = 0;
        while (scanner.hasNext()){
            int num = scanner.nextInt();
            if(count==0) {
                count = num;
                while (priorityQueue.size() != 0) System.out.println(priorityQueue.poll());
            } else {
                if (!priorityQueue.contains(num)) priorityQueue.offer(num);
                count --;
            }
        }
        while (priorityQueue.size() != 0) System.out.println(priorityQueue.poll());
    }

}
