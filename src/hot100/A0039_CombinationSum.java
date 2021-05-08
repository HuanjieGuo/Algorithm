package hot100;

import java.util.ArrayList;
import java.util.List;

public class A0039_CombinationSum {
    int[] candidates;
    int target;
    List<Integer> currentList;
    List<List<Integer>> finalLists;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.candidates = candidates;
        this.target = target;
        currentList = new ArrayList<>();
        finalLists = new ArrayList<>();
        search();
        return finalLists;
    }

    void search(){
        if(target<0) return;
        if(target==0){
            finalLists.add(new ArrayList<>(currentList));
            return;
        }
        for(int i=0;i<candidates.length;i++){
            // 跳过重复出现的情况
            if(currentList.size()!=0&&currentList.get(currentList.size()-1)>candidates[i]) continue;

            if(target>=candidates[i]){
                currentList.add(candidates[i]);
                target -= candidates[i];
                search();
                target += candidates[i];
                currentList.remove(currentList.size()-1);
            }
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,3,5};
        System.out.println(new A0039_CombinationSum().combinationSum(nums, 8));
    }
}
