package secondOffer.queue;

import java.util.Deque;
import java.util.LinkedList;

public class Offer0059_I_MaxSlidingWindow {
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(k==0) return new int[0];
        Deque<Integer> queue = new LinkedList<>();
        int[] maxList = new int[nums.length-k+1];
        for(int i=0;i<nums.length;i++){
            if(i>=k) if(nums[i-k]==queue.getFirst()) queue.removeFirst();
            while (queue.size()!=0&&nums[i]> queue.getLast()) queue.removeLast();
            queue.addLast(nums[i]);
            if(i>=k-1) maxList[i+1-k] = queue.getFirst();
        }
        return maxList;
    }
}
