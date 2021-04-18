package secondOffer.array;

import java.util.ArrayList;

public class Offer0057_II_FindContinuousSequence {
    public int[][] findContinuousSequence(int target) {
        ArrayList<int[]> result = new ArrayList<>();
        ArrayList<Integer> current = new ArrayList<>();
        int sum = 0;
        int maxLength = 0;
        for(int i=1;i<=(target+1)/2;i++) {
            current.add(i);
            sum+=i;
            while (sum>target)
                sum -= current.remove(0);
            if(sum==0) break;
            if(sum==target) {
                int[] sub = new int[current.size()];
                for (int j = 0; j < current.size(); j++) sub[i] = current.get(j);
                result.add(sub);
                maxLength = Math.max(current.size(),maxLength);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
