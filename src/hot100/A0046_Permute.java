package hot100;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class A0046_Permute {
    List<List<Integer>> result;
    ArrayList<Integer> restNum;
    ArrayList<Integer> currentList;
    int restCount;

    public List<List<Integer>> permute(int[] nums) {
        result = new ArrayList<>();
        restNum = new ArrayList<>();
        for(int num:nums) restNum.add(num);
        restCount = restNum.size();
        currentList = new ArrayList<>();
        recur();
        return result;
    }

    void recur(){
        if(restCount==0) {
            result.add(new ArrayList<>(currentList));
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        for(int i=0;i<restNum.size();i++){
            int num = restNum.get(i);
            if(set.contains(num)) continue;
            currentList.add(num);
            restNum.remove(i);
            restCount--;
            set.add(num);
            recur();
            currentList.remove(currentList.size()-1);
            restNum.add(i,num);
            restCount++;
        }
    }

    public static void main(String[] args) {
        int nums[] = new int[]{1,2,3};
        System.out.println(new A0046_Permute().permute(nums));
    }
}
