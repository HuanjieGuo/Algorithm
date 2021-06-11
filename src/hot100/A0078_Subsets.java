package hot100;

import java.util.ArrayList;
import java.util.List;

public class A0078_Subsets {
    int[] nums;
    int length;
    List<Integer> current;
    List<List<Integer>> result;
    public List<List<Integer>> subsets(int[] nums) {
        this.nums = nums;
        length = nums.length;
        current = new ArrayList<>();
        result = new ArrayList<>();
        recur(0);
        return result;
    }
    public void recur(int idx){
        result.add(new ArrayList<>(current));
        for(int i=idx;i< nums.length;i++){
            current.add(nums[i]);
            recur(i+1);
            current.remove(current.size()-1);
        }
    }

    public static void main(String[] args) {
        System.out.println(new A0078_Subsets().subsets(new int[]{1, 2, 3}));
    }
}
